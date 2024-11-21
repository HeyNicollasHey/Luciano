package br.edu.catolica.ppi.costumer.ms_costumer.client;


import br.edu.catolica.ppi.costumer.ms_costumer.dto.response.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "merchantProducts", url = "${feign.merchant.list-menu.url}")
public interface MerchantProductsMenu {

    @GetMapping("/{merchantId}")
    ProductResponseDTO getProductFromMerchant(@PathVariable("merchantId") Long merchantId);
}
