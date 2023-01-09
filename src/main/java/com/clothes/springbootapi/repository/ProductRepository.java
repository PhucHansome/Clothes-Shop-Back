package com.clothes.springbootapi.repository;

import com.clothes.springbootapi.domain.dto.ProductDTO;
import com.clothes.springbootapi.domain.dto.UserDTO;
import com.clothes.springbootapi.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT NEW com.clothes.springbootapi.domain.dto.ProductDTO (" +
            "p.id" +
            ", p.code" +
            ", p.title" +
            ", p.salesPrice" +
            ", p.quantity" +
            ", p.status" +
            ", p.description" +
            ", p.slug" +
            ", p.image" +
            ", p.entryPrice" +
            ", p.category" +
            ", p.productColor" +
            ", p.productSize" +
            ") " +
            "FROM Product p " +
            "WHERE p.deleted = false "
    )
    List<ProductDTO> findAllProductDTO();

    @Query("SELECT NEW com.clothes.springbootapi.domain.dto.ProductDTO (" +
            "p.id" +
            ", p.code" +
            ", p.title" +
            ", p.salesPrice" +
            ", p.quantity" +
            ", p.status" +
            ", p.description" +
            ", p.slug" +
            ", p.image" +
            ", p.entryPrice" +
            ", p.category" +
            ", p.productColor" +
            ", p.productSize" +
            ") " +
            "FROM Product p " +
            "WHERE p.deleted = false " +
            "AND p.id = ?1"
    )
    Optional<ProductDTO> findProductDTOById(Long id);

    @Query("SELECT NEW com.clothes.springbootapi.domain.dto.ProductDTO (" +
            "p.id" +
            ", p.code" +
            ", p.title" +
            ", p.salesPrice" +
            ", p.quantity" +
            ", p.status" +
            ", p.description" +
            ", p.slug" +
            ", p.image" +
            ", p.entryPrice" +
            ", p.category" +
            ", p.productColor" +
            ", p.productSize" +
            ") " +
            "FROM Product p " +
            "WHERE p.deleted = false " +
            "AND p.slug = ?1"
    )
    Optional<ProductDTO> findProductDTOBySlug(String slug);
}
