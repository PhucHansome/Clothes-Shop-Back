package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.BaseEntity;
import com.clothes.springbootapi.domain.dto.ProductColorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Product_color")
@Accessors(chain = true)
public class ProductColor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    public ProductColorDTO toProductColorDTO(){
        return new ProductColorDTO()
                .setColor(color)
                .setId(id);
    }
}
