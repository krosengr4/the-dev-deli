public abstract class MenuItem {

    String name;
    double price;

    public MenuItem (String name, double price) {
        this.name = name;
        this.price = price;
    }

    //region getters and setters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //endregion

    abstract double getValue();
}
