package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.Category;
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
public class CategoryDTO {
    private Long id;
    private String name;
    private String code;
    public Category toCategory(){
        return  new Category()
                .setId(id)
                .setCode(code)
                .setName(name);
    }
}
