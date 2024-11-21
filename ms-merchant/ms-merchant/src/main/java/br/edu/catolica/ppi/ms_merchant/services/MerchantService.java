package br.edu.catolica.ppi.ms_merchant.services;

import br.edu.catolica.ppi.ms_merchant.domain.Merchant;
import br.edu.catolica.ppi.ms_merchant.dto.MerchantDTO;
import br.edu.catolica.ppi.ms_merchant.mapper.MerchantMapper;
import br.edu.catolica.ppi.ms_merchant.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public record MerchantService(MerchantRepository merchantRepository,
                              MerchantMapper merchantMapper) {
    public Merchant save(MerchantDTO merchantDTO){
        Optional.ofNullable(merchantDTO.getId()).ifPresent(ex -> {throw new IllegalArgumentException("Id deve ser nulo");});
        return merchantRepository.save(merchantMapper.dtoToEntity(merchantDTO));
    }
}
