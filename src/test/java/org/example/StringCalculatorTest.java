package org.example;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    @Test
    void emptyCheck() {
        assertEquals(0, new StringCalculator().Add(""));
    }

    @Test
    void singleNumber() {
        assertEquals(4, new StringCalculator().Add("4"));
    }

    @Test
    void twoNumbers() {
        assertEquals(3, new StringCalculator().Add("1,2"));
    }

    @Test
    void multipleNumbers() {
        assertEquals(45, new StringCalculator().Add("1,2,3,4,5,6,7,8,9"));
    }

    @Test
    void newLineSeparator() {
        assertEquals(6, new StringCalculator().Add("1\n2,3"));
    }

    @Test
    void newCustomSeparator() {
        assertEquals(3, new StringCalculator().Add("//;\n1;2"));
    }

    @Test
    void newCustomSeparatorDecider() {
        assertEquals(6, new StringCalculator().Add("//[***]\n1***2***3"));
    }

    @Test
    void newCustomSeparatorWithNegativeNumbers() {
        try
        {
            new StringCalculator().Add("//[***]\n-1***2***-3");
        }
        catch( final InvalidParameterException e )
        {
            final String msg = "error: negatives not allowed: -1 -3";
            assertEquals(msg, e.getMessage());
        }
    }

    @Test
    void doubleSeparatorDecider() {
        assertEquals(6, new StringCalculator().Add("//[*][%]\n1*2%3"));
    }

    @Test
    void andSeparator() {
        assertEquals(6, new StringCalculator().Add("//&\n1&2&3"));
    }

    @Test
    void negativesNotAllowed() {
        try
        {
            new StringCalculator().Add("1,-2,-3");
        }
        catch( final InvalidParameterException e )
        {
            final String msg = "error: negatives not allowed: -2 -3";
            assertEquals(msg, e.getMessage());
        }
    }

    @Test
    void negativeSingleNumberNotAllowed() {
        try
        {
            new StringCalculator().Add("-2");
        }
        catch( final InvalidParameterException e )
        {
            final String msg = "error: negatives not allowed: -2";
            assertEquals(msg, e.getMessage());
        }
    }

    @Test
    void numbersWithBiggerThan1000() {
        assertEquals(2, new StringCalculator().Add("1001,2"));
    }

    @Test
    void negativeNumbersAndBigNumbersNotAllowed() {
        try
        {
            new StringCalculator().Add("-2,1001,-3,100");
        }
        catch( final InvalidParameterException e )
        {
            final String msg = "error: negatives not allowed: -2 -3";
            assertEquals(msg, e.getMessage());
        }
    }
}