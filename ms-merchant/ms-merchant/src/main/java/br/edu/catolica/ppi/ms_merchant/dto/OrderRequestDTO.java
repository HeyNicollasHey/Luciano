package br.edu.catolica.ppi.ms_merchant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderRequestDTO {

    private Long merchantId;
    private Long customerId;
    @JsonProperty("items")
    private List<ItemRequestDTO> items;
}
