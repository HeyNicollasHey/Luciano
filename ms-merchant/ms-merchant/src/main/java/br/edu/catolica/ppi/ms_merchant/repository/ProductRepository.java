package br.edu.catolica.ppi.ms_merchant.repository;

import br.edu.catolica.ppi.ms_merchant.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByMerchantId(Long id);
}
