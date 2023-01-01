package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.ProductSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ProductSizeDTO {
    private Long id;
    private String size;
    public ProductSize toProductSize(){
        return new ProductSize()
                .setId(id)
                .setSize(size);
    }
}
