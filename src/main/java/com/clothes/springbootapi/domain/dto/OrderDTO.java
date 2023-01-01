package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.CustomerInfo;
import com.clothes.springbootapi.domain.entity.Order;
import com.clothes.springbootapi.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class OrderDTO {
    private Long id;

    private String email;

    private String fullName;

    private String districtName;

    private String provinceName;

    private BigDecimal grandTotal;

    private String status;

    private UserDTO user;

    private CustomerInfoDTO customerInfo;

    public Order toOrder(){
        return new Order()
                .setCustomerInfo(customerInfo.toCustomerInfo())
                .setId(id)
                .setEmail(email)
                .setFullName(fullName)
                .setDistrictName(districtName)
                .setProvinceName(provinceName)
                .setGrandTotal(grandTotal)
                .setStatus(status)
                .setUser(user.toUser());
    }
}
