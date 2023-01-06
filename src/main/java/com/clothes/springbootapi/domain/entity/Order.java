package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.BaseEntity;
import com.clothes.springbootapi.domain.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String fullName;

    private String districtName;

    private String provinceName;

    private BigDecimal grandTotal;

    private String status;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "customerifs_id", nullable = false)
    private CustomerInfo customerInfo;

    public OrderDTO toOrderDTO(){
        return new OrderDTO()
                .setCustomerInfo(customerInfo.toCustomerInfoDTO())
                .setId(id)
                .setEmail(email)
                .setFullName(fullName)
                .setDistrictName(districtName)
                .setProvinceName(provinceName)
                .setGrandTotal(grandTotal)
                .setStatus(status)
                .setDescription(description)
                .setUser(user.toUserDTO());
    }
}
