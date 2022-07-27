package com.github.rguliamov.calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorImplTest {
    @Test
    public void testCalcDecimalSuccess() {
        Calculator calculator = Calculator.createInstance();

        String result1 = calculator.calc("5 + 5");
        String result2 = calculator.calc("5 - 5");
        String result3 = calculator.calc("5 * 5");
        String result4 = calculator.calc("5 / 5");


        assertEquals(result1, "10");
        assertEquals(result2, "0");
        assertEquals(result3, "25");
        assertEquals(result4, "1");
    }

    @Test
    public void testCalcRomanSuccess() {
        Calculator calculator =  Calculator.createInstance();

        String result1 = calculator.calc("II + I");
        String result2 = calculator.calc("II - I");
        String result3 = calculator.calc("II / I");
        String result4 = calculator.calc("II * I");


        assertEquals(result1, "III");
        assertEquals(result2, "I");
        assertEquals(result3, "II");
        assertEquals(result4, "II");

    }

    @Test
    void testCalcArabIllegalStateException() {
        Calculator calculator = Calculator.createInstance();

        assertThrows(IllegalArgumentException.class, () -> calculator.calc("12 + 12"));
    }

    @Test
    void testCalcRomanIllegalStateException() {
        Calculator calculator = Calculator.createInstance();

        assertThrows(IllegalArgumentException.class, () -> calculator.calc("XX + X"));
    }
}