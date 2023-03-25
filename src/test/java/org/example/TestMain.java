package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMain {
    private static final double DEL = 1e-6;
    Main calc;

    @Before
    public void init() {
        calc = new Main();
    }

    @Test
    public void rootTruePositive()
    {
        assertEquals("Root Test 1", 1, calc.root(1), DEL);
        assertEquals("Root Test 2", 1.41421356237, calc.root(2), DEL);
        assertEquals("Root Test 3", -1, calc.root(-4), DEL);
        assertEquals("Root Test 4", -1, calc.root(-2), DEL);

    }

    @Test
    public void rootFalsePositive()
    {
        assertNotEquals("Root Test 1", 2, calc.root(3), DEL);
        assertNotEquals("Root Test 2", 2.5, calc.root(5), DEL);
        assertNotEquals("Root Test 3", 4, calc.root(9), DEL);
        assertNotEquals("Root Test 4", 3, calc.root(16), DEL);

    }

    @Test
    public void factorialTruePositive()
    {
        assertEquals("Factorial Test 1", 6, calc.factorial(3), DEL);
        assertEquals("Factorial Test 2", Double.POSITIVE_INFINITY, calc.factorial(999), DEL);
        assertEquals("Factorial Test 3", 1, calc.factorial(0), DEL);
        assertEquals("Factorial Test 4", -1, calc.factorial(-10), DEL);

    }

    @Test
    public void factorialFalsePositive()
    {
        assertNotEquals("Factorial Test 1", 0, calc.factorial(0), DEL);
        assertNotEquals("Factorial Test 2", 7, calc.factorial(3), DEL);
        assertNotEquals("Factorial Test 3", 20, calc.factorial(4), DEL);
        assertNotEquals("Factorial Test 4", 500, calc.factorial(6), DEL);

    }

    @Test
    public void logTruePositive()
    {
        assertEquals("ln Test 1", 0, calc.ln(1), DEL);
        assertEquals("ln Test 2", 0.69314718056, calc.ln(2), DEL);
        assertEquals("ln Test 3", 1.60943791243, calc.ln(5), DEL);
        assertEquals("ln Test 4", -1, calc.ln(-10), DEL);
    }


    @Test
    public void logFalsePositive()
    {
        assertNotEquals("ln Test 1", 1.123, calc.ln(3), DEL);
        assertNotEquals("ln Test 2", 1.597, calc.ln(4), DEL);
        assertNotEquals("ln Test 3", 2, calc.ln(7), DEL);
        assertNotEquals("ln Test 4", 3, calc.ln(9), DEL);
    }

    @Test
    public void powerTruePositive()
    {
        assertEquals("power Test 1", 1, calc.power(99,0), DEL);
        assertEquals("power Test 2", 1, calc.power(1,999), DEL);
        assertEquals("power Test 3", 81, calc.power(3,4), DEL);
        assertEquals("power Test 4", 1.44, calc.power(1.2,2), DEL);
    }

    @Test
    public void powerFalsePositive()
    {
        assertNotEquals("power Test 1", 1, calc.power(0,1), DEL);
        assertNotEquals("power Test 2", 999, calc.power(1,999), DEL);
        assertNotEquals("power Test 3", 1000, calc.power(2,10), DEL);
        assertNotEquals("power Test 4", 2, calc.power(1.3,2), DEL);
    }
}
