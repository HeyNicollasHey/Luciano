package br.edu.catolica.ppi.ms_merchant.mapper;

import br.edu.catolica.ppi.ms_merchant.domain.ItemOrder;
import br.edu.catolica.ppi.ms_merchant.dto.ItemOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ItemOrderMapper {

    @Mapping(target = "product", source = "product.id")
    ItemOrder dtoToEntity(ItemOrderDTO itemOrderDTO);
}
