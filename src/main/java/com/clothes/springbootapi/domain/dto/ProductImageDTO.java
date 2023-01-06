package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.Product;
import com.clothes.springbootapi.domain.entity.ProductColor;
import com.clothes.springbootapi.domain.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ProductImageDTO {
    private Long id;
    private String image;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDTO product_id;

    public ProductImageDTO(Long id, String image, Product product_id) {
        this.id = id;
        this.image = image;
        this.product_id = product_id.toProductDTO();
    }

    public ProductImage toProductImage(){
        return new ProductImage()
                .setId(id)
                .setImage(image)
                .setProduct_id(product_id.toProduct());
    }
}
