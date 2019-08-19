package com.arturo.calculator.model;

import org.springframework.stereotype.Service;

/**
 * Public calculator service
 */
@Service
public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }
}