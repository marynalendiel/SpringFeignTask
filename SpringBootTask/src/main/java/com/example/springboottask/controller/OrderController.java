package com.example.springboottask.controller;

import com.example.springboottask.converter.OrderDtoConverter;
import com.example.springboottask.dto.OrderDto;
import com.example.springboottask.model.Order;
import com.example.springboottask.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    private final OrderDtoConverter orderDtoConverter;

    @GetMapping
    public List<OrderDto> getOrders() {
        List<Order> orders = orderService.getOrders();
        return orderDtoConverter.toDto(orders);
    }

    @GetMapping("/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        Order order = orderService.getOrder(orderId);
        return orderDtoConverter.toDto(order);
    }

    @PostMapping
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        Order order = orderDtoConverter.toModel(orderDto);
        orderService.saveOrder(order);

        return orderDto;
    }

    @PutMapping
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        var requestOrder = orderDtoConverter.toModel(orderDto);

        var updatedOrder = orderService.updateOrder(requestOrder);
        return orderDtoConverter.toDto(updatedOrder);

    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        Order order = orderService.getOrder(orderId);

        if (order == null) {
            throw new EntityResultNotFoundException("order id not found - " + orderId);
        }

        orderService.deleteOrder(orderId);

        return "Deleted order id - " + orderId;
    }
}
