package br.edu.catolica.ppi.costumer.ms_costumer.controller;


import br.edu.catolica.ppi.costumer.ms_costumer.domain.Customer;
import br.edu.catolica.ppi.costumer.ms_costumer.dto.CustomerDTO;
import br.edu.catolica.ppi.costumer.ms_costumer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerDTO));
    }
}
