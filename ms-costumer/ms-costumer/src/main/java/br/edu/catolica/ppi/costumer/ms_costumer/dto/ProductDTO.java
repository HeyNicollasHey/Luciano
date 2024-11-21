package br.edu.catolica.ppi.costumer.ms_costumer.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDTO {

    private Long id;

    private String description;

    private BigDecimal price;

    private Long merchantId;

    private Boolean stock;
}
