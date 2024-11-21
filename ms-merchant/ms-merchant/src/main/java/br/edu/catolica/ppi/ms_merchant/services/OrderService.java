package br.edu.catolica.ppi.ms_merchant.services;

import br.edu.catolica.ppi.ms_merchant.domain.Order;
import br.edu.catolica.ppi.ms_merchant.domain.enums.OrderStatus;
import br.edu.catolica.ppi.ms_merchant.dto.ItemOrderDTO;
import br.edu.catolica.ppi.ms_merchant.dto.ItemRequestDTO;
import br.edu.catolica.ppi.ms_merchant.dto.OrderDTO;
import br.edu.catolica.ppi.ms_merchant.dto.OrderRequestDTO;
import br.edu.catolica.ppi.ms_merchant.mapper.OrderMapper;
import br.edu.catolica.ppi.ms_merchant.mapper.ProductMapper;
import br.edu.catolica.ppi.ms_merchant.repository.OrderRepository;
import br.edu.catolica.ppi.ms_merchant.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {

        private final OrderRepository orderRepository;

        private final ProductMapper productMapper;

        private final ProductRepository productRepository;

        private final OrderMapper orderMapper;

        public void save(OrderRequestDTO orderRequestDTO) throws ClassNotFoundException {
            var orderDTO = getOrderItems(orderRequestDTO);
            managerOrderStatus(orderDTO);
            orderRepository.save(orderMapper.dtoToOrder(orderDTO));
        }

        private OrderDTO getOrderItems(OrderRequestDTO orderRequestDTO){
            var orderDTO = new OrderDTO();
            orderRequestDTO.getItems().forEach(ord -> {
                orderDTO.getItems().add(new ItemOrderDTO(productMapper.entityToDTO(productRepository.findById(ord.getProductId()).get()),
                        ord.getQuantity(),setSubAmountItem(ord)));
            });
            orderDTO.setAmount(setAmountOrder(orderDTO));
            orderDTO.setCustomerId(orderDTO.getCustomerId());
            orderDTO.setMerchantId(orderDTO.getMerchantId());

            return orderDTO;
        }

        private BigDecimal setSubAmountItem(ItemRequestDTO itemRequestDTO){
            return itemRequestDTO.getQuantity().multiply(
                    productRepository.findById(itemRequestDTO.getProductId()).get().getPrice()
            );
        }

        private BigDecimal setAmountOrder(OrderDTO orderDTO){
            var total = BigDecimal.ZERO;
            total = orderDTO.getItems().stream().map(ItemOrderDTO::getSubAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            return total;
        }

        private void managerOrderStatus(OrderDTO orderDTO) throws ClassNotFoundException {
            if(Objects.isNull(orderDTO.getId())){
                orderDTO.setOrderStatus(OrderStatus.ANALYZE);
                return;
            } else{
                var order = orderRepository.findById(orderDTO.getId());
                if(order.isEmpty()){
                    throw new ClassNotFoundException("Pedido nao encontrado");
                } else {
                    switch (orderDTO.getOrderStatus()){
                        case ANALYZE -> orderDTO.setOrderStatus(OrderStatus.PRODUCTION);
                        case PRODUCTION -> orderDTO.setOrderStatus(OrderStatus.DONE);
                        case DONE -> orderDTO.setOrderStatus(OrderStatus.DELIVERY);
                    }
                }
            }
    }
}
