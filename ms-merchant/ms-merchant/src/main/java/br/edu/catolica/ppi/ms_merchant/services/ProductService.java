package br.edu.catolica.ppi.ms_merchant.services;

import br.edu.catolica.ppi.ms_merchant.domain.Product;
import br.edu.catolica.ppi.ms_merchant.dto.ProductDTO;
import br.edu.catolica.ppi.ms_merchant.dto.response.ProductResponseDTO;
import br.edu.catolica.ppi.ms_merchant.mapper.ProductMapper;
import br.edu.catolica.ppi.ms_merchant.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public record ProductService(ProductRepository productRepository,
ProductMapper productMapper
){

    public Product save(ProductDTO productDTO){
        Optional.ofNullable(productDTO.getId()).ifPresent(ex -> {throw new IllegalArgumentException("Id deve ser nulo");
        });
        return productRepository.save(productMapper.dtoToEntity(productDTO));

    }

    public ProductResponseDTO findProductsByMerchant(Long id){
        var productResponseDTO = new ProductResponseDTO();
        var listProduct = productRepository.findByMerchantId(id);
        productResponseDTO.setMerchantId(id);
        productResponseDTO.setProductDTOList(productMapper.responseProductDTO(listProduct));
        return productResponseDTO;
    }
}
