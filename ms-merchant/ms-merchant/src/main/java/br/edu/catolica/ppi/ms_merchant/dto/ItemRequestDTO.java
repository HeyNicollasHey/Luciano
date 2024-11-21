package br.edu.catolica.ppi.ms_merchant.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemRequestDTO {

    private Long productId;
    private BigDecimal quantity;

}
