public class Drink extends MenuItem {

    String size;
    String name;

    public Drink() {
        super("drink");
    }

    //region getters and setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
