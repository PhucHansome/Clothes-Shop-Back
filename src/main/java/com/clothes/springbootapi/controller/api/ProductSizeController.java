package com.clothes.springbootapi.controller.api;

import com.clothes.springbootapi.domain.entity.ProductSize;
import com.clothes.springbootapi.service.product.ProductService;
import com.clothes.springbootapi.service.productSize.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-size")
public class ProductSizeController {
    @Autowired
    private ProductSizeService productSizeService;

    @GetMapping
    private ResponseEntity<?> findAll(){
        List<ProductSize> productSizeList = productSizeService.findAll();
        return new ResponseEntity<>(productSizeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findProductSizeById(@PathVariable Long id){
        Optional<ProductSize> productSizeList = productSizeService.findById(id);
        return new ResponseEntity<>(productSizeList, HttpStatus.OK);
    }
}
