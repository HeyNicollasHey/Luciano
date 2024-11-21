package br.edu.catolica.ppi.costumer.ms_costumer.mapper;


import br.edu.catolica.ppi.costumer.ms_costumer.domain.Customer;
import br.edu.catolica.ppi.costumer.ms_costumer.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address.id", ignore = true)
    @Mapping(target = "address", source = "addressDTO")
    Customer dtoToModel(CustomerDTO customerDTO);
}
