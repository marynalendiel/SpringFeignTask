package com.example.springfeignservice.client;

import com.example.springfeignservice.dto.OrderDto;
import com.example.springfeignservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "springboottaskclient", url = "${springboottask.url}")
public interface SpringBootTaskClient {
    @GetMapping("/api/users")
    List<UserDto> getUsers();

    @GetMapping("/api/users/{userId}")
    UserDto getUser(@PathVariable(value = "userId") Long userId);

    @PostMapping("/api/users")
    UserDto addUser(@RequestBody UserDto userDto);

    @PutMapping("/api/users")
    UserDto updateUser(@RequestBody UserDto userDto);

    @DeleteMapping("/api/users/{userId}")
    String deleteUser(@PathVariable(value = "userId") Long userId);

    @GetMapping("/api/users/{userId}/orders")
    List<OrderDto> getUserOrders(@PathVariable(value = "userId") Long userId);
}
