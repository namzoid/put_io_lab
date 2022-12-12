package put.io.testing.audiobooks;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Pytanie 5.1: typ testowania whitebox
// Pytanie 5.2: 4 możliwe ścieżki działania

class AudiobookPriceCalculatorTest extends AudiobookPriceCalculator{

    private AudiobookPriceCalculator calculator;
    private Audiobook audiobook;

    @BeforeEach
    void setUp() {
        calculator = new AudiobookPriceCalculator();
        audiobook =  new Audiobook("Book", 10);

    }

    // przypadki testowe:

    @Test
    void testIsSubscribed() {
        Customer customer = new Customer("Customer1", Customer.LoyaltyLevel.SILVER, true);
        assertEquals(0.0, calculator.calculate(customer, audiobook));
    }


    @Test
    void testLoyaltySTANDART() {
        Customer customer = new Customer("Customer2", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(audiobook.getStartingPrice(), calculator.calculate(customer, audiobook));
    }


    @Test
    void testLoyaltySILVER() {
        Customer customer = new Customer("Customer3", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(audiobook.getStartingPrice()*0.9, calculator.calculate(customer, audiobook));
    }


    @Test
    void testLoyaltyGOLD() {
        Customer customer = new Customer("Customer4", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(audiobook.getStartingPrice()*0.8, calculator.calculate(customer, audiobook));
    }

}
