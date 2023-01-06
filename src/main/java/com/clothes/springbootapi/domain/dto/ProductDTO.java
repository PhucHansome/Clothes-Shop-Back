package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.Category;
import com.clothes.springbootapi.domain.entity.Product;
import com.clothes.springbootapi.domain.entity.ProductColor;
import com.clothes.springbootapi.domain.entity.ProductSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ProductDTO {
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

    private CategoryDTO category;

    private ProductColorDTO productColor;

    private ProductSizeDTO productSize;

    public ProductDTO(Long id, String code, String title, BigDecimal salesPrice, BigDecimal quantity, String status, String description, String slug, String image, BigDecimal entryPrice, Category category, ProductColor productColor, ProductSize productSize) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.salesPrice = salesPrice;
        this.quantity = quantity;
        this.status = status;
        this.description = description;
        this.slug = slug;
        this.image = image;
        this.entryPrice = entryPrice;
        this.category = category.toCategoryDTO();
        this.productColor = productColor.toProductColorDTO();
        this.productSize = productSize.toProductSizeDTO();
    }

    public Product toProduct(){
        return new Product()
                .setId(id)
                .setCategory(category.toCategory())
                .setCode(code)
                .setProductColor(productColor.toProductColor())
                .setProductSize(productSize.toProductSize())
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
