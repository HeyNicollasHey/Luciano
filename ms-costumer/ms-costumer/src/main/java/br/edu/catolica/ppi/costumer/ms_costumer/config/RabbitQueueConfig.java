package br.edu.catolica.ppi.costumer.ms_costumer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

@RequiredArgsConstructor
public class RabbitQueueConfig {

    private final RabbitAdmin rabbitAdmin;

    private final String queue;

    private final String exchange;

    //criar fila
    public void createQueue(){
        rabbitAdmin.declareQueue(QueueBuilder
                .durable(queue)
                .build());
    }

    //criar exchange
    public void createExchange(){
        rabbitAdmin.declareExchange(ExchangeBuilder
                .directExchange(exchange)
                .build());
    }

    //vincular a fila ao exchange(canal)
    public void createQueueBinding(){
        rabbitAdmin.declareBinding(new Binding(queue, Binding.DestinationType.QUEUE, exchange, queue, null));
    }
}
