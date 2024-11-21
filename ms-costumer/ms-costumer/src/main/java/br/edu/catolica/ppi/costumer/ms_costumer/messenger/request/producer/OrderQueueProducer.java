package br.edu.catolica.ppi.costumer.ms_costumer.messenger.request.producer;

import br.edu.catolica.ppi.costumer.ms_costumer.constants.RabbitConstants;
import br.edu.catolica.ppi.costumer.ms_costumer.messenger.request.OrderRequestDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderQueueProducer extends RabbitQueueProducer {

    public OrderQueueProducer(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate);
    }

    public void sendMessage(final OrderRequestDTO orderRequestDTO) {
        super.sendMessage(RabbitConstants.ORDER_QUEUE, orderRequestDTO);
    }
}
