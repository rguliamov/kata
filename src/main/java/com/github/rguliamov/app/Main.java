package com.github.rguliamov.app;

import com.github.rguliamov.calc.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Guliamov Rustam
 */
public class Main {
    public static void main(String[] args) throws IOException {
        while(true) {
            Calculator calculator = Calculator.createInstance();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String string = reader.readLine();
            String result = calculator.calc(string);

            System.out.println(result);
        }
    }
}
