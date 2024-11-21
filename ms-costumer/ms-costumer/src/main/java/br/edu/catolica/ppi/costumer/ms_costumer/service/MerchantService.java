package br.edu.catolica.ppi.costumer.ms_costumer.service;

import br.edu.catolica.ppi.costumer.ms_costumer.client.MerchantProductsMenu;
import br.edu.catolica.ppi.costumer.ms_costumer.dto.response.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantProductsMenu merchantProductsMenu;

    public ProductResponseDTO getProductsFromMerchant(Long merchantId){
        return merchantProductsMenu.getProductFromMerchant(merchantId);
    }
}
