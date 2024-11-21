package br.edu.catolica.ppi.costumer.ms_costumer.config;

import br.edu.catolica.ppi.costumer.ms_costumer.constants.RabbitConstants;
import lombok.Setter;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Setter
@ConfigurationProperties(prefix = "spring.rabbit")
public class RabbitConfig {

    private String host;
    private int port;
    private String username;
    private String password;

    @Bean
    @Primary
    public RabbitAdmin rabbitAdmin(){
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    @Primary
    public RabbitTemplate rabbitTemplate(final Jackson2JsonMessageConverter converter){
        var rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        var connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername(username);
        connectionFactory.setAddresses(host);
        connectionFactory.setPassword(password);
        connectionFactory.setPort(port);
        return connectionFactory;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJacksonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean(RabbitConstants.ORDER_LISTENER_CONTAINER_FACTORY)
    public SimpleRabbitListenerContainerFactory orderQueueListenerFactory(){
        var simpleListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleListenerContainerFactory.setConnectionFactory(connectionFactory());
        return simpleListenerContainerFactory;
    }

}
