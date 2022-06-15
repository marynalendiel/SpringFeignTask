package com.example.springboottask.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class Order {
    private Long id;

    private Long userId;

    private BigDecimal price;

    private LocalDateTime createTime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", price=" + price +
                ", createTime=" + createTime +
                '}';
    }
}
