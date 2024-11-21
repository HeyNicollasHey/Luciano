package br.edu.catolica.ppi.ms_merchant.dto;

import br.edu.catolica.ppi.ms_merchant.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    @JsonIgnore
    private Long id;

    @JsonProperty("items")
    private List<ItemOrderDTO> items;

    @NotNull
    private Long merchantId;

    @Positive
    private BigDecimal amount;

    @NotNull
    private Long customerId;

    @JsonIgnore
    private OrderStatus orderStatus;

    public List<ItemOrderDTO> getItems() {
        if(Objects.isNull(items)){
            items = new ArrayList<>();
        }
        return items;
    }
}
