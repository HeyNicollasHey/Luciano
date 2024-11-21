package br.edu.catolica.ppi.ms_merchant.controller;

import br.edu.catolica.ppi.ms_merchant.domain.Merchant;
import br.edu.catolica.ppi.ms_merchant.dto.MerchantDTO;
import br.edu.catolica.ppi.ms_merchant.services.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping("/save")
    public ResponseEntity<Merchant> save(@RequestBody  MerchantDTO merchantDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(merchantService.save(merchantDTO));
    }


}
