package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.Cart;
import com.clothes.springbootapi.domain.entity.CartItems;
import com.clothes.springbootapi.domain.entity.Product;
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
@Accessors(chain = true)
public class CartItemsDTO {

    private Long id;

    private String title;

    private BigDecimal price;

    private int quantity;

    private BigDecimal totalPrice;

    private ProductDTO product;

    private CartDTO cart;

    public CartItems toCartItems(){
        return new CartItems()
                .setId(id)
                .setTitle(title)
                .setPrice(price)
                .setQuantity(quantity)
                .setTotalPrice(totalPrice)
                .setProduct(product.toProduct())
                .setCart(cart.toCart());
    }
}
