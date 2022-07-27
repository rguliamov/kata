package com.github.rguliamov.calc;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.github.rguliamov.calc.CommonUtils.*;

/**
 * parses a string into an operator and arguments
 *
 * @author Guliamov Rustam
 */
public class Parser {
    private String regexArabic;
    private String regexRomane;
    private Pattern patternArabic;
    private Pattern patternRomane;

    public Parser() {
        regexArabic = "^(\\d|10)\\W*([+/:*-])\\W(\\d|10)$";
        regexRomane = "^(X|IX|IV|V?I{0,3})\\W*([+/:*-])\\W*(X|IX|IV|V?I{0,3})$";
        patternArabic = Pattern.compile(regexArabic);
        patternRomane = Pattern.compile(regexRomane);
    }

    /**
     * returns a tuple consisting of an operator and list of arguments
     *
     * @param source
     * @return
     */
    public Tuple3<Operators, List<Integer>, Notation> parseStringToOperationAndArgs(String source) {
        Matcher matcherArabic = patternArabic.matcher(source);
        Matcher matcherRomane = patternRomane.matcher(source);

        if(matcherArabic.matches()) {
            List<Integer> args = List.of(Integer.parseInt(matcherArabic.group(1)),
                    Integer.parseInt(matcherArabic.group(3)));
            Operators operator = stringToOperator(matcherArabic.group(2));

            return new Tuple3<>(operator, args, Notation.ARABIC);
        }

        if(matcherRomane.matches()) {
            int oprnd1 = romanNumToDecimalNum(matcherRomane.group(1));
            int oprnd2 = romanNumToDecimalNum(matcherRomane.group(3));
            Operators operator = stringToOperator(matcherRomane.group(2));

            return new Tuple3<>(operator, List.of(oprnd1, oprnd2), Notation.ROMAN);
        }

        throw new IllegalArgumentException(source);
    }

    public String parseResultToString(Tuple2<String, Notation> result) {
        Notation notation = result._2();
        String strResult = result._1();

        return Notation.ARABIC.equals(notation) ? strResult : arabicNumToRomaneNum(Integer.parseInt(strResult));
    }
}
