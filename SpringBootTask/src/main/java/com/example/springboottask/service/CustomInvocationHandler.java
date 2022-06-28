package com.example.springboottask.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private static final Logger LOGGER = LogManager.getLogger(CustomInvocationHandler.class);

    private final UserService userService;

    public CustomInvocationHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        if (AnnotationUtils.findAnnotation(method, Snapshot.class) != null) {
            LOGGER.info("(@ProxyBefore) Executing method: {} with input param: {}", method.getName(), args);
        }

        return method.invoke(userService, args);
    }
}