package put.io.testing.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest extends Calculator {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }


    @Test
    public void testAdd(){
        //Calculator calculator;
        //calculator = new Calculator();
        Assertions.assertEquals(4, calculator.add(2,2));
    }

    @Test
    public void testMultiply(){
        //Calculator calculator;
        //calculator = new Calculator();
        Assertions.assertEquals(20, calculator.multiply(2,10));
    }

    @Test
    public void testPositive(){
        //Calculator calculator;
        //calculator = new Calculator();
        Throwable thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-5,2); });
        Assertions.assertEquals("The arguments must be positive", thrown.getMessage());
    }
}