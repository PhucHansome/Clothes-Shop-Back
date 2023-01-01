package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.Cart;
import com.clothes.springbootapi.domain.entity.CartItems;
import com.clothes.springbootapi.domain.entity.CustomerInfo;
import com.clothes.springbootapi.domain.entity.User;
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
@Getter
@Setter
@Accessors(chain = true)
public class CartDTO {

    private Long id;

    private BigDecimal grandTotal;

    private UserDTO user;

    private CustomerInfoDTO customerInfo;

    private CartItemsDTO cartItems;

    public Cart toCart(){
        return new Cart()
                .setId(id)
                .setGrandTotal(grandTotal)
                .setUser(user.toUser())
                .setCustomerInfo(customerInfo.toCustomerInfo())
                ;
    }
}
