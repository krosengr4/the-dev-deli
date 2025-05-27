import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {


    @Test
    void getBasePrice() {

        Sandwich sandwich = new Sandwich(Size.MEDIUM.toString());

        double actual = sandwich.calculatePrice();

        assertEquals(10.50, actual);
    }

    @Test
    void getValue() {
    }
}