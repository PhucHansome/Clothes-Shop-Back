package com.clothes.springbootapi.domain.entity;

import com.clothes.springbootapi.domain.dto.OrderItemsDTO;
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
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private BigDecimal price;

    private Integer quantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    public OrderItemsDTO toOrderItemsDTO(){
        return new OrderItemsDTO()
                .setId(id)
                .setTitle(title)
                .setPrice(price)
                .setQuantity(quantity)
                .setTotalPrice(totalPrice)
                .setOrder(order.toOrderDTO());
    }
}
