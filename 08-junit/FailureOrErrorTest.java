package put.io.testing.junit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class FailureOrErrorTest {

    @Test
    public void test1(){ // Pytanie 4.1: failure 
        Assertions.assertEquals(4, 2);
    }

    @Test
    public void test2() throws Exception{ // error 
        throw new Exception("Exception");

    }

    // Pytanie 4.2: oczekuję na klasę AssertionFailedError 
    @Test
    public void test3() {
        try{
            Assertions.assertEquals(4, 2);
        } catch  (Throwable e) {
            e.printStackTrace();

        }


    }

}
