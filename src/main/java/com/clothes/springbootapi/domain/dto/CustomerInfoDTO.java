package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.CustomerInfo;
import com.clothes.springbootapi.domain.entity.LocationRegion;
import com.clothes.springbootapi.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CustomerInfoDTO {
    private Long id;

    private UserDTO user;

    private String fullName;

    private String phone;

    private BigDecimal debt;

    @OneToOne
    @JoinColumn(name = "location_region_id", nullable = false)
    private LocationRegionDTO locationRegion;

    public CustomerInfoDTO(Long id, User user, String fullName, String phone, BigDecimal debt, LocationRegion locationRegion) {
        this.id = id;
        this.user = user.toUserDTO();
        this.fullName = fullName;
        this.phone = phone;
        this.debt = debt;
        this.locationRegion = locationRegion.toLocationRegionDTO();
    }

    public CustomerInfo toCustomerInfo(){
        return new CustomerInfo()
                .setId(id)
                .setUser(user.toUser())
                .setDebt(debt)
                .setFullName(fullName)
                .setPhone(phone)
                .setLocationRegion(locationRegion.toLocationRegion())
                ;
    }
}