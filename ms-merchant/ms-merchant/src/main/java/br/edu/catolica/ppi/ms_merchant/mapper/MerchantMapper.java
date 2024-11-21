package br.edu.catolica.ppi.ms_merchant.mapper;

import br.edu.catolica.ppi.ms_merchant.domain.Merchant;
import br.edu.catolica.ppi.ms_merchant.dto.MerchantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MerchantMapper {

    @Mapping(target = "id", ignore = true)
    Merchant dtoToEntity(MerchantDTO merchantDTO0);
}
