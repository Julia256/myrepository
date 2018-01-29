import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {
    @Test
    public void testFactorial() {
        assertEquals(1, Factorial.factorial(0));
        assertEquals(1, Factorial.factorial(1));
        assertEquals(3628800, Factorial.factorial(10));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testfactorialNegative() {
        Factorial.factorial(-3);
    }

}