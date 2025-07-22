import models.Drink;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    //New instance of drink accessible to all test cases
    Drink drink = new Drink();

    //Value of small drink
    @Test
    void getValueSmallDrink() {

        drink.setSize("SMALL");

        double actual = drink.getValue();

        assertEquals(2.00, actual);
    }

    //Value of medium drink
    @Test
    void getValueMediumDrink() {

        drink.setSize("MEDIUM");

        double actual = drink.getValue();

        assertEquals(2.50, actual);
    }

    //Value of large drink
    @Test
    void getValueLargeDrink() {

        drink.setSize("LARGE");

        double actual = drink.getValue();

        assertEquals(3.00, actual);
    }

}