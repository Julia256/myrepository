import org.junit.Test;

import static org.junit.Assert.*;

public class FibbonaciTest {
    @Test
    public void testfib() {
        assertEquals(0, Fibbonaci.fib(0));
        assertEquals(1, Fibbonaci.fib(1));
        assertEquals(1, Fibbonaci.fib(2));
        assertEquals(55, Fibbonaci.fib(10));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testfibNegative() {
        Fibbonaci.fib(-5);
    }

}