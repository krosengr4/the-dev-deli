import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    //Create new instance of sandwich accessible to all sandwich tests
    Sandwich sandwich = new Sandwich();

    //Value of small sandwich with meat and cheese no extra
    @Test
    void getValueSmallNormalMeatAndCheese() {

        sandwich.setSize("SMALL"); //<--- Testing
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");

        double actual = sandwich.getValue();

        assertEquals(7.25, actual);
    }

    //Value of medium sandwich with meat and cheese no extra
    @Test
    void getValueMediumNormalMeatAndCheese() {

        sandwich.setSize("MEDIUM"); //<--- Testing
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");

        double actual = sandwich.getValue();

        assertEquals(10.5, actual);
    }

    //Value of large sandwich with meat and cheese no extra
    @Test
    void getValueLargeNormalMeatAndCheese() {

        sandwich.setSize("LARGE"); //<--- Testing
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");

        double actual = sandwich.getValue();

        assertEquals(13.75, actual);
    }

    //Value of medium sandwich with extra meat and normal cheese
    @Test
    void getValueExtraMeat() {

        sandwich.setSize("MEDIUM");
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");
        sandwich.setExtraMeat(true); //<--- Testing

        double actual = sandwich.getValue();

        assertEquals(11.50, actual);
    }

    //Value of medium sandwich with normal meat and extra cheese
    @Test
    void getValueExtraCheese() {

        sandwich.setSize("MEDIUM");
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");
        sandwich.setExtraCheese(true); //<--- Testing

        double actual = sandwich.getValue();

        assertEquals(11.1, actual);
    }

    //Value of medium sandwich with extra meat and extra cheese
    @Test
    void getValueExtraMeatAndCheese() {

        sandwich.setSize("MEDIUM");
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese("American");
        sandwich.setExtraMeat(true); //<--- Testing
        sandwich.setExtraCheese(true);//<--- Testing

        double actual = sandwich.getValue();

        assertEquals(12.1, actual);
    }

    //Value of medium sandwich with no meat and normal cheese
    @Test
    void getValueNoMeat() {

        sandwich.setSize("MEDIUM");
        sandwich.setBread("White");
        sandwich.setMeat(null); //<--- Testing
        sandwich.setCheese("American");

        double actual = sandwich.getValue();

        assertEquals(8.50, actual);
    }

    //Value of medium sandwich with normal meat and no cheese
    @Test
    void getValueNoCheese() {

        sandwich.setSize("MEDIUM");
        sandwich.setBread("White");
        sandwich.setMeat("Ham");
        sandwich.setCheese(null); //<--- Testing

        double actual = sandwich.getValue();

        assertEquals(9.00, actual);
    }

    //Value of medium sandwich with no meat and no cheese
    @Test
    void getValueNoMeatOrCheese() {

        sandwich.setSize("MEDIUM");
        sandwich.setBread("White");
        sandwich.setMeat(null); //<--- Testing
        sandwich.setCheese(null);//<--- Testing

        double actual = sandwich.getValue();

        assertEquals(7.00, actual);
    }
}