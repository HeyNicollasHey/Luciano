package br.edu.catolica.ppi.ms_merchant.repository;

import br.edu.catolica.ppi.ms_merchant.domain.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
