package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
@Accessors(chain = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;

    public RoleDTO toRoleDTO() {
        return new RoleDTO()
                .setId(id)
                .setCode(code)
                .setName(name);
    }

    @OneToMany(targetEntity = com.clothes.springbootapi.domain.entity.User.class, mappedBy = "role", fetch = FetchType.EAGER)
    private Set<User> users;


}
