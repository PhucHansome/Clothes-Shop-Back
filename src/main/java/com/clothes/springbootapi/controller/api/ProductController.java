package com.clothes.springbootapi.controller.api;


import com.clothes.springbootapi.domain.dto.ProductDTO;
import com.clothes.springbootapi.domain.entity.Product;
import com.clothes.springbootapi.exception.DataInputException;
import com.clothes.springbootapi.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    private ResponseEntity<?> findAll() {
        try {
            List<ProductDTO> productDTOList = productService.findAllProductDTO();
            return new ResponseEntity<>(productDTOList, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new DataInputException("No content");
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findProductById(@PathVariable Long id) {
        try {
            Optional<ProductDTO> productDTO = productService.findProductById(id);
            return new ResponseEntity<>(productDTO.get(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new DataInputException("No content");
        }
    }

    @GetMapping("/slug/{slug}")
    private ResponseEntity<?> findProductById(@PathVariable String slug) {
        try {
            Optional<ProductDTO> productDTO = productService.findProductDTOBySlug(slug);
            return new ResponseEntity<>(productDTO.get(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new DataInputException("No content");
        }
    }

    @PostMapping
    private ResponseEntity<?> doCreateProduct(@RequestBody ProductDTO productDTO) {
        try {
            productDTO.setId(0L);
            Product productDTO1 = productService.save(productDTO.toProduct());
            return new ResponseEntity<>(productDTO1.toProductDTO(), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new DataInputException("No content");
        }
    }

    @PutMapping()
    private ResponseEntity<?>doEdit (@RequestBody ProductDTO productDTO){
        try{
            Product productDTO1 = productService.save(productDTO.toProduct());
            return new ResponseEntity<>(productDTO1.toProductDTO(), HttpStatus.OK);
        }catch (Exception e){
            throw new DataInputException("No content");
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?>doDelete(@PathVariable Long id){
        try {
            productService.softDelete(id);
            return new ResponseEntity<>("Oke", HttpStatus.OK);
        }catch (Exception e){
            throw new DataInputException("No content");
        }
    }
}
