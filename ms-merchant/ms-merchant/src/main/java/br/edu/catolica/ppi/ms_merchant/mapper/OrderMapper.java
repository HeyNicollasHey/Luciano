package br.edu.catolica.ppi.ms_merchant.mapper;

import br.edu.catolica.ppi.ms_merchant.domain.Order;
import br.edu.catolica.ppi.ms_merchant.dto.OrderDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
uses = {ItemOrderMapper.class})
@Component
public interface OrderMapper {


    @Mapping(target = "items", source = "orderDTO.items")
    Order dtoToOrder(OrderDTO orderDTO);
}
