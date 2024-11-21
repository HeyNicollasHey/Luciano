package br.edu.catolica.ppi.costumer.ms_costumer.service;

import br.edu.catolica.ppi.costumer.ms_costumer.messenger.request.OrderRequestDTO;
import br.edu.catolica.ppi.costumer.ms_costumer.messenger.request.producer.OrderQueueProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderQueueProducer orderQueueProducer;

    public void sendMessage(final OrderRequestDTO orderRequestDTO){
        orderQueueProducer.sendMessage(orderRequestDTO);
    }
}
