package br.edu.catolica.ppi.ms_merchant.controller;


import br.edu.catolica.ppi.ms_merchant.domain.Product;
import br.edu.catolica.ppi.ms_merchant.dto.ProductDTO;
import br.edu.catolica.ppi.ms_merchant.dto.response.ProductResponseDTO;
import br.edu.catolica.ppi.ms_merchant.repository.ProductRepository;
import br.edu.catolica.ppi.ms_merchant.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDTO));
    }

    @GetMapping("/{merchantId}")
    public ResponseEntity<ProductResponseDTO> findBySettlemenId(@PathVariable("merchantId") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductsByMerchant(id));
    }
}
