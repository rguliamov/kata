package com.github.rguliamov.calc;

import com.github.rguliamov.calc.enums.Operators;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserImplTest {

    @Test
    public void testParseArabicSuccess() {
        Parser parser = new Parser();
        String expression = "10 + 2";

        var tuple = parser.parseStringToOperationAndArgs(expression);

        assertNotNull(tuple);
        assertEquals(tuple._1(), Operators.PLUS);
        assertEquals(tuple._2(), List.of(10, 2));
    }

    @Test
    public void testParseRomanSuccess() {
        Parser parser = new Parser();
        String expression = "II + I";

        var tuple = parser.parseStringToOperationAndArgs(expression);

        assertNotNull(tuple);
        assertEquals(tuple._1(), Operators.PLUS);
    }

    @Test
    public void testParseFailThrowIllegalArgException() {
        Parser parser = new Parser();
        String expression = "12 + 1";

        assertThrows(IllegalArgumentException.class, () -> parser.parseStringToOperationAndArgs(expression));
    }
}