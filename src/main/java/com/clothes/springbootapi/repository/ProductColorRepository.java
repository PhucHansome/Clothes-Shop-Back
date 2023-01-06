package com.clothes.springbootapi.repository;

import com.clothes.springbootapi.domain.entity.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {
}
