package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.BaseEntity;
import com.clothes.springbootapi.domain.dto.CartItemsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@Entity
@Table(name = "cart_items")
public class CartItems extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "producr_id",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;

    public CartItemsDTO toCartItemsDTO(){
        return new CartItemsDTO()
                .setId(id)
                .setTitle(title)
                .setPrice(price)
                .setQuantity(quantity)
                .setTotalPrice(totalPrice)
                .setProduct(product.toProductDTO())
                .setCart(cart.toCartDTO());
    }

}
