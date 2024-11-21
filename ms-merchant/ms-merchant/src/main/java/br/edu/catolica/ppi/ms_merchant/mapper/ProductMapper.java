package br.edu.catolica.ppi.ms_merchant.mapper;

import br.edu.catolica.ppi.ms_merchant.domain.Product;
import br.edu.catolica.ppi.ms_merchant.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stock", defaultExpression = "java(true)")
    Product dtoToEntity(ProductDTO productDTO);

    ProductDTO entityToDTO(Product product);


    List<ProductDTO> responseProductDTO(List<Product> product);
}
