package com.clothes.springbootapi.controller.api;

import com.clothes.springbootapi.domain.entity.Category;
import com.clothes.springbootapi.service.category.CategoryService;
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
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    private ResponseEntity<?> findAll() {
        List<Category> category = categoryService.findAll();
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return new ResponseEntity<>(category.get(), HttpStatus.OK);
    }
}
