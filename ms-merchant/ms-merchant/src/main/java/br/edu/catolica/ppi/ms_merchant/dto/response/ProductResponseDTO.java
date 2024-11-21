package br.edu.catolica.ppi.ms_merchant.dto.response;

import br.edu.catolica.ppi.ms_merchant.dto.ProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDTO {

    private Long merchantId;

    private List<ProductDTO> productDTOList;
}
