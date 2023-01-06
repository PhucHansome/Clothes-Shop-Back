package com.clothes.springbootapi.repository;

import com.clothes.springbootapi.domain.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSizeRepository  extends JpaRepository<ProductSize, Long> {
}
