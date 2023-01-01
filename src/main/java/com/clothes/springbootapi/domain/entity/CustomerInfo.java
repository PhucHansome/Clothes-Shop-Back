package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.BaseEntity;
import com.clothes.springbootapi.domain.dto.CustomerInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer_info")
@Accessors(chain = true)
public class CustomerInfo  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String fullName;

    private String phone;

    private BigDecimal debt;

    @OneToOne
    @JoinColumn(name = "location_region_id")
    private LocationRegion locationRegion;

    public CustomerInfoDTO toCustomerInfoDTO(){
        return new CustomerInfoDTO()
                .setId(id)
                .setUser(user.toUserDTO())
                .setDebt(debt)
                .setFullName(fullName)
                .setPhone(phone)
                .setLocationRegion(locationRegion.toLocationRegionDTO());
    }
}
