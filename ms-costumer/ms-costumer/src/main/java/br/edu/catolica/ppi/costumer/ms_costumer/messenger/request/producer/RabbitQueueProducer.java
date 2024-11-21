package br.edu.catolica.ppi.costumer.ms_costumer.messenger.request.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
public class RabbitQueueProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(final String queue, final Object object){
        rabbitTemplate.convertAndSend(queue, object);
    }
}
