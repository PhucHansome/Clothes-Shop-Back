package com.clothes.springbootapi.controller.api;

import com.clothes.springbootapi.domain.dto.ProductImageDTO;
import com.clothes.springbootapi.domain.entity.ProductImage;
import com.clothes.springbootapi.service.productImage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-image")
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @GetMapping("/{productId}")
    private ResponseEntity<?> getAllImageByProductId(@PathVariable Long productId){
        List<ProductImageDTO> productImageDTO = productImageService.findAllImageProduct(productId);
        return new ResponseEntity<>(productImageDTO, HttpStatus.OK);
    }
    
    @PostMapping()
    private ResponseEntity<?> doCreateProductImage(@RequestBody ProductImageDTO productImageDTO){
        productImageDTO.setId(0L);
        ProductImage productImage = productImageService.save(productImageDTO.toProductImage());
        return new ResponseEntity<>(productImage.toProductImageDTO(), HttpStatus.OK);
    }
    @DeleteMapping()
    private ResponseEntity<?> doRemoveProductImage(@RequestBody ProductImageDTO productImageDTO){
        productImageService.remove(productImageDTO.getId());
        return new ResponseEntity<>("oke", HttpStatus.OK);
    }
}
