package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.BaseEntity;
import com.clothes.springbootapi.domain.dto.UserDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Accessors(chain = true)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id", nullable = false)
    private Role role;


    public UserDTO toUserDTO() {
        return new UserDTO()
                .setId(id)
                .setUsername(username)
                .setPassword(password)
                .setRole(role.toRoleDTO());
    }

}
