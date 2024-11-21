package br.edu.catolica.ppi.costumer.ms_costumer.messenger.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemRequestDTO {

    private Long productId;
    private Integer quantity;
}
