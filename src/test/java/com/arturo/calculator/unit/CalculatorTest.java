package com.arturo.calculator.unit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.arturo.calculator.model.Calculator;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
 
    @Test
    public void testSum() {
        assertEquals(5, calculator.sum(2,3));
    }
}