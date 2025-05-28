public abstract class MenuItem {

    String name;

    public MenuItem (String name) {
        this.name = name;
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
