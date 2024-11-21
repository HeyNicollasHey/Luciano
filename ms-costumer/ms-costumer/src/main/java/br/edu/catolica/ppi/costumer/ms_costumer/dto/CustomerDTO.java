package br.edu.catolica.ppi.costumer.ms_costumer.dto;


import br.edu.catolica.ppi.costumer.ms_costumer.domain.Address;
import lombok.Data;

@Data
public class CustomerDTO {

    private Long id;

    private String name;

    private String cpf;

    private String phoneNumber;

    private AddressDTO addressDTO;

}
