package com.clothes.springbootapi.domain.dto;
import com.clothes.springbootapi.domain.entity.ProductColor;
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
public class ProductColorDTO {
    private Long id;
    private String color;
    public ProductColor toProductColor(){
        return new ProductColor()
                .setColor(color)
                .setId(id);
    }
}
