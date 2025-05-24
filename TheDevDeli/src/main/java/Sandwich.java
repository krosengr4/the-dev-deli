public class Sandwich extends MenuItem{

    String size;
    String bread;
    String meat;
    String cheese;
    String toppings;
    String sauces;
    boolean isExtraMeat;
    boolean isExtraCheese;

    public Sandwich (String size) {
        super("Sandwich", 0.0);
        this.size = size;
    }



    public double getBasePrice() {
        double value = 0.0;

        switch (this.size) {
            case "SMALL" -> value += 5.5 + 1.00 + .75;
            case "MEDIUM" -> value += 7.00 + 2.00 + 1.50;
            case "LARGE" -> value += 8.50 + 3.00 + 2.25;
            default -> System.out.println("ERROR! Size needs to be SMALL, MEDIUM, OR LARGE!");
        }
        return value;
    }


    public double getValue() {
        return 0.0;
    }
}
