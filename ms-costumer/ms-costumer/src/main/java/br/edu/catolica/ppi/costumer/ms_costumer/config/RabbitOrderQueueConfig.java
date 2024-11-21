package br.edu.catolica.ppi.costumer.ms_costumer.config;

import br.edu.catolica.ppi.costumer.ms_costumer.constants.RabbitConstants;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitOrderQueueConfig extends RabbitQueueConfig {
    public RabbitOrderQueueConfig(RabbitAdmin rabbitAdmin) {
        super(rabbitAdmin, RabbitConstants.ORDER_QUEUE, RabbitConstants.ORDER_EXCHANGE);
    }

    @PostConstruct
    public void createRabbitComponents(){
        createQueue();
        createExchange();
        createQueueBinding();
    }
}
