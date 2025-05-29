public class Chips extends MenuItem{

    String name;

    //constructor
    public Chips() {
        super("Chips");
    }

    //region getter and setter
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    //Override getValue method
    @Override
    double getValue() {
        return 1.50;
    }
}
