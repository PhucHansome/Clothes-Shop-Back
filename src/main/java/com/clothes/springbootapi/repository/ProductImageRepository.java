package com.clothes.springbootapi.repository;

import com.clothes.springbootapi.domain.dto.ProductDTO;
import com.clothes.springbootapi.domain.dto.ProductImageDTO;
import com.clothes.springbootapi.domain.entity.Product;
import com.clothes.springbootapi.domain.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    @Query("SELECT NEW com.clothes.springbootapi.domain.dto.ProductImageDTO (" +
            "p.id" +
            ", p.image" +
            ", p.product_id" +
            ") " +
            "FROM ProductImage p " +
            "WHERE p.deleted = false " +
            "AND p.product_id.id = ?1"
    )
    List<ProductImageDTO> findAllImageProduct(Long id);
}
