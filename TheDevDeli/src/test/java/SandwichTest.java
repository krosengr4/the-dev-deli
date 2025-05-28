import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    Sandwich sandwich = new Sandwich();

    @Test
    void getValueSmallNormalMeatAndCheese() {

        sandwich.setSize("SMALL");
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");

        double actual = sandwich.getValue();

        assertEquals(7.25, actual);
    }

    @Test
    void getValueMediumNormalMeatAndCheese() {

        sandwich.setSize("MEDIUM");
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");

        double actual = sandwich.getValue();

        assertEquals(10.5, actual);
    }

    @Test
    void getValueLargeNormalMeatAndCheese() {

        sandwich.setSize("LARGE");
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");

        double actual = sandwich.getValue();

        assertEquals(13.75, actual);
    }
}