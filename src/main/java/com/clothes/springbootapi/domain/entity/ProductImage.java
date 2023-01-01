package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.BaseEntity;
import com.clothes.springbootapi.domain.dto.ProductImageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_image")
@Accessors(chain = true)
public class ProductImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;

    public ProductImageDTO toProductImageDTO(){
        return new ProductImageDTO()
                .setId(id)
                .setImage(image)
                .setProduct_id(product_id.toProductDTO());
    }
}
