package com.clothes.springbootapi.controller.api;

import com.clothes.springbootapi.domain.entity.Category;
import com.clothes.springbootapi.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    private ResponseEntity<?> findAll() {
        List<Category> category = categoryService.findAll();
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
