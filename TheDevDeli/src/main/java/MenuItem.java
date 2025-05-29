public abstract class MenuItem {

    String name;

    public MenuItem(String name) {
        this.name = name;
    }

    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion

    abstract double getValue();
}
