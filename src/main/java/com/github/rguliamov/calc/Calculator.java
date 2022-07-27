package com.github.rguliamov.calc;

import java.util.List;

/**
 * @author Guliamov Rustam
 *
 * simple {@link Calculator} implementstion.
 */
public class Calculator  {
    private static Calculator calculator = new Calculator();

    private Parser parser;

    private Calculator() {

    }

    public static Calculator createInstance() {
        calculator.setParser(new Parser());

        return calculator;
    }

    /**
     * Calculates simple arithmetic operations.
     * accepts arabic and romane numerals no more than 10
     *
     * @param expr
     * @return
     */
    public String calc(String expr) {
        var tuple = parser.parseStringToOperationAndArgs(expr);
        Operators operator = tuple._1();
        List<Integer> args = tuple._2();

        int result =  switch (operator) {
            case PLUS -> args.get(0) + args.get(1);
            case MINUS -> args.get(0) - args.get(1);
            case MULTIPLY -> args.get(0) * args.get(1);
            case DIVISION -> args.get(0) / args.get(1);
            default -> throw new RuntimeException();
        };

        return parser.parseResultToString(new Tuple2<>(String.valueOf(result), tuple._3()));
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }
}
