package br.edu.catolica.ppi.costumer.ms_costumer.controller;

import br.edu.catolica.ppi.costumer.ms_costumer.messenger.request.OrderRequestDTO;
import br.edu.catolica.ppi.costumer.ms_costumer.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Void> createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        orderService.sendMessage(orderRequestDTO);
        return ResponseEntity.ok().build();
    }
}
