public class Drink extends MenuItem {

    String size;

    public Drink(String size) {
        super("drink", 0.0);
        this.size = size;
    }

    public Drink() {
        super("drink", 0.0);
    }

    //region getters and setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    //endregion

    @Override
    public double getValue() {
        double value = 0.0;

        switch (this.size) {
            case "SMALL" -> value += 2.00;
            case "MEDIUM" -> value += 2.50;
            case "LARGE" -> value += 3.00;
            default -> System.err.println("ERROR! The Drink size is invalid!");
        }
        return value;
    }
}
