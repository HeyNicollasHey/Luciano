package br.edu.catolica.ppi.ms_merchant.consumer;

import br.edu.catolica.ppi.ms_merchant.constants.RabbitConstants;
import br.edu.catolica.ppi.ms_merchant.dto.OrderRequestDTO;
import br.edu.catolica.ppi.ms_merchant.services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.runtime.ObjectMethods;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderConsumer {

    private final ObjectMapper objectMapper;
    private final OrderService orderService;

    @RabbitListener(queues = RabbitConstants.ORDER_QUEUE)
    public void orderConsumer(final Message message) throws IOException{
        try {
            log.info("Mensagem recebida: {}", new String(message.getBody()));
            var orderRequestDTO = objectMapper.readValue(message.getBody(), OrderRequestDTO.class);
            orderService.save(orderRequestDTO);
        } catch (Exception ex){
            log.error("Erro ao converter mensagem no consumidor, mensagem = {}, erro = {} ", message.getBody(), ex.getMessage());
            throw new IOException("Erro ao converter mensagem no consumidor");
        }

    }

}
