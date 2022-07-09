package com.july.cloud.core.spel;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Method;

/**
 * ExpressionRootObject
 */
@Getter
@AllArgsConstructor
public class ExpressionRootObject {
    private final Method method;

    private final Object[] args;

    private final Object target;

    private final Class<?> targetClass;

    private final Method targetMethod;
}
