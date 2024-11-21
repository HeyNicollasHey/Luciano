package br.edu.catolica.ppi.costumer.ms_costumer.dto.response;

import br.edu.catolica.ppi.costumer.ms_costumer.dto.ProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDTO {

    private Long merchantId;

    private List<ProductDTO> productDTOList;
}
