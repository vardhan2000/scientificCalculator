package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMain {
    private static final double DEL = 1e-8;
    Main calc;

    @Before
    public void init() {
        calc = new Main();
    }

    @Test
    public void squareRootTruePositive()
    {
        assertEquals("Square Root Test 1", 2, calc.root(4), DEL);
        assertEquals("Square Root Test 2", 1, calc.root(1), DEL);
        assertEquals("Square Root Test 3", 1.41421356237, calc.root(2), DEL);
        assertEquals("Square Root Test 4", 2.64575131106, calc.root(7), DEL);

    }
}
