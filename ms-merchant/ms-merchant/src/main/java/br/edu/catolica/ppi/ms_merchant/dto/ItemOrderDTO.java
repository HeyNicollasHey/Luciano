package br.edu.catolica.ppi.ms_merchant.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrderDTO {

    //@JsonIgnore
    //private Long id;

    private ProductDTO productId;

    @Positive(message = "Quantidade do produto invalida")
    private BigDecimal quantity;

    private BigDecimal subAmount;

    //@ManyToOne
    //private Order order;
}
