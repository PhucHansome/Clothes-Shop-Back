package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class RoleDTO implements Validator {

    private Long id;
    private String code;
    private String name;


    public Role toRole() {
        return new Role()
                .setId(id)
                .setCode(code)
                .setName(name);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
