public class Drink extends MenuItem {

    String size;
    double value;

    public Drink(String name, double price, String size) {
        super("drink", 0.0);
        this.size = size;
        this.value = 0.0;
    }

    //region getters and setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    //endregion

    public double calculateValue() {
        switch (this.size) {
            case "SMALL" -> this.value += 2.00;
            case "MEDIUM" -> this.value += 2.50;
            case "LARGE" -> this.value += 3.00;
            default -> System.err.println("ERROR! The Drink size is invalid!");
        }
        return this.value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
