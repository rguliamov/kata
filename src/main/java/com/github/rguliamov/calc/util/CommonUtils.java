package com.github.rguliamov.calc.util;

import com.github.rguliamov.calc.enums.Operators;

/**
 * @author Guliamov Rustam
 */
public class CommonUtils {
    private CommonUtils() {

    }

    public static int romanNumToDecimalNum(String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> {throw new IllegalArgumentException();}
        };
    }

    public static Operators stringToOperator(String operator) {
        return switch (operator) {
            case "+" -> Operators.PLUS;
            case "-" -> Operators.MINUS;
            case "/" -> Operators.DIVISION;
            case "*" -> Operators.MULTIPLY;
            default -> {throw new RuntimeException();}
        };
    }

    public static String arabicNumToRomaneNum(int result) {
        if(result <= 0)
            throw new IllegalArgumentException();

        StringBuilder buf = new StringBuilder();

        Numeral[] numerals = Numeral.values();

        for (int i = numerals.length - 1; i >= 0; i--) {
            while(result >= numerals[i].weight) {
                buf.append(numerals[i]);
                result -= numerals[i].weight;
            }
        }
        return buf.toString();
    }

    enum Numeral {
        I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100);
        int weight;

        Numeral(int weight) {
            this.weight = weight;
        }
    }
}
