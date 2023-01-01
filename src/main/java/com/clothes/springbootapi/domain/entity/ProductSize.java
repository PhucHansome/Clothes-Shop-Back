package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.BaseEntity;
import com.clothes.springbootapi.domain.dto.ProductSizeDTO;
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
@Table(name = "product_size")
@Accessors(chain = true)
public class ProductSize  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String size;
    public ProductSizeDTO toProductSizeDTO(){
        return new ProductSizeDTO()
                .setId(id)
                .setSize(size);
    }
}
