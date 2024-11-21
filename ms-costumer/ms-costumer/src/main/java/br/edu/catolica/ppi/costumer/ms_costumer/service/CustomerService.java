package br.edu.catolica.ppi.costumer.ms_costumer.service;

import br.edu.catolica.ppi.costumer.ms_costumer.domain.Customer;
import br.edu.catolica.ppi.costumer.ms_costumer.dto.CustomerDTO;
import br.edu.catolica.ppi.costumer.ms_costumer.mapper.CustomerMapper;
import br.edu.catolica.ppi.costumer.ms_costumer.repository.CostumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CostumerRepository costumerRepository;
    private final CustomerMapper customerMapper;

    public Customer save(CustomerDTO customerDTO){
        return costumerRepository.save(customerMapper.dtoToModel(customerDTO));
    }
}
