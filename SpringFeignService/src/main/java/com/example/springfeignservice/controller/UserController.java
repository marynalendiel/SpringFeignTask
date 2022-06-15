package com.example.springfeignservice.controller;

import com.example.springfeignservice.client.SpringBootTaskClient;
import com.example.springfeignservice.dto.OrderDto;
import com.example.springfeignservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    private final SpringBootTaskClient springBootTaskClient;

    @GetMapping("/hello")
    public String get() {
        return "Hello, world!";
    }

    @GetMapping
    public List<UserDto> getUsers() {
        LOGGER.info("Call to get users");
        List<UserDto> userDtoList = springBootTaskClient.getUsers();

        return userDtoList.stream()
                .map(userDto -> {
                    userDto.setId(123L);
                    return userDto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        LOGGER.info("Call to get user with id = {}", userId);

        return springBootTaskClient.getUser(userId);
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        LOGGER.info("Call to add user: {}", userDto);

        return springBootTaskClient.addUser(userDto);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        LOGGER.info("Call to update user: {}", userDto);

        return springBootTaskClient.updateUser(userDto);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        LOGGER.info("Call to delete user with id = {}", userId);

        return springBootTaskClient.deleteUser(userId);
    }

    @GetMapping("/{userId}/orders")
    public List<OrderDto> getUserOrders(@PathVariable Long userId) {
        List<OrderDto> userOrders = springBootTaskClient.getUserOrders(userId);

        int orderCount = userOrders.size();
        LOGGER.info("Number of orders of userId = {} is: {}", userId, orderCount);

        return userOrders;
    }
}