package com.clothes.springbootapi.controller.api;

import com.clothes.springbootapi.domain.entity.ProductColor;
import com.clothes.springbootapi.service.productColor.ProductColorService;
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
@RequestMapping("/api/product-color")
public class ProductColorController {
    @Autowired
    private ProductColorService productColorService;

    @GetMapping()
    private ResponseEntity<?>finAll(){
        List<ProductColor> productColorList = productColorService.findAll();
        return new ResponseEntity<>(productColorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?>findProductColorById(@PathVariable Long id){
        Optional<ProductColor> productColor = productColorService.findById(id);
        return new ResponseEntity<>(productColor.get(), HttpStatus.OK);
    }
}
