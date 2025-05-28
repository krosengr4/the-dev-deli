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

    @Test
    void getValueExtraMeat() {

        sandwich.setSize("MEDIUM");
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");
        sandwich.setExtraMeat(true);

        double actual = sandwich.getValue();

        assertEquals(11.50, actual);
    }

    @Test
    void getValueExtraCheese() {

        sandwich.setSize("MEDIUM");
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");
        sandwich.setExtraCheese(true);

        double actual = sandwich.getValue();

        assertEquals(11.1, actual);
    }

    @Test
    void getValueExtraMeatAndCheese() {

        sandwich.setSize("MEDIUM");
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");
        sandwich.setExtraMeat(true);
        sandwich.setExtraCheese(true);

        double actual = sandwich.getValue();

        assertEquals(12.1, actual);
    }
}