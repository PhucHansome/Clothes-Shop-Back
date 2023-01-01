package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.BaseEntity;
import com.clothes.springbootapi.domain.dto.CartDTO;
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
@Table(name = "carts")
public class Cart extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grand_total")
    private BigDecimal grandTotal;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "customer_info",nullable = false)
    private CustomerInfo customerInfo;


    public CartDTO toCartDTO(){
        return new CartDTO()
                .setId(id)
                .setGrandTotal(grandTotal)
                .setUser(user.toUserDTO())
                .setCustomerInfo(customerInfo.toCustomerInfoDTO());
    }
}
