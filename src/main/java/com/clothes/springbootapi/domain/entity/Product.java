package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.BaseEntity;
import com.clothes.springbootapi.domain.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String title;

    private BigDecimal salesPrice;

    private BigDecimal quantity;

    private String status;

    private String description;

    private String slug;

    private String image;

    private BigDecimal entryPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "productColor_id")
    private ProductColor productColor;

    @ManyToOne
    @JoinColumn(name = "productSize_id")
    private ProductSize productSize;

    public ProductDTO toProductDTO(){
        return new ProductDTO()
                .setId(id)
                .setCategory(category.toCategoryDTO())
                .setCode(code)
                .setProductColor(productColor.toProductColorDTO())
                .setProductSize(productSize.toProductSizeDTO())
                .setDescription(description)
                .setEntryPrice(entryPrice)
                .setSlug(slug)
                .setSalesPrice(salesPrice)
                .setStatus(status)
                .setTitle(title)
                .setImage(image)
                .setQuantity(quantity);
    }

}
