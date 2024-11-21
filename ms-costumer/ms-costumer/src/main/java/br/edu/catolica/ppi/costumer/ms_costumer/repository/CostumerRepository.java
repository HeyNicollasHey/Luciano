package br.edu.catolica.ppi.costumer.ms_costumer.repository;

import br.edu.catolica.ppi.costumer.ms_costumer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Customer, Long> {

}
