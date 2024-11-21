package br.edu.catolica.ppi.costumer.ms_costumer.controller;

import br.edu.catolica.ppi.costumer.ms_costumer.dto.response.ProductResponseDTO;
import br.edu.catolica.ppi.costumer.ms_costumer.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/{merchantId}")
    public ResponseEntity<ProductResponseDTO> findProductFromMerchant(@PathVariable("merchantId") Long merchantId){
        return ResponseEntity.ok(merchantService.getProductsFromMerchant(merchantId));
    }
}
