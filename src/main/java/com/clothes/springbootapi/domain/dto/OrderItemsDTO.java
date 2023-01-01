package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.Order;
import com.clothes.springbootapi.domain.entity.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class OrderItemsDTO {
    private Long id;

    private String title;

    private BigDecimal price;

    private Integer quantity;

    private BigDecimal totalPrice;

    private OrderDTO order;

    public OrderItems toOrderItems(){
        return new OrderItems()
                .setId(id)
                .setTitle(title)
                .setPrice(price)
                .setQuantity(quantity)
                .setTotalPrice(totalPrice)
                .setOrder(order.toOrder());
    }
}
