package org.example;

import org.junit.jupiter.api.Test;

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
    void andSeparator() {
        assertEquals(6, new StringCalculator().Add("//&\n1&2&3"));
    }

    @Test
    void negativesNotAllowed() {
        assertEquals(6, new StringCalculator().Add("1,-2,-3"));
    }
}