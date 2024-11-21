package br.edu.catolica.ppi.ms_merchant.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MerchantDTO {

    private Long id;

    private String name;

    private String phoneNumber;

}
