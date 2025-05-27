public class Sandwich extends MenuItem{

    String size;
    String bread;
    String meat;
    String cheese;
    String toppings;
    String sauces;
    boolean isExtraMeat;
    boolean isExtraCheese;

    double value = 0.0;

    public Sandwich (String size) {
        super("Sandwich", 0.0);
        this.size = size;
    }

    //region setters and getters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String getSauces() {
        return sauces;
    }

    public void setSauces(String sauces) {
        this.sauces = sauces;
    }

    public boolean isExtraMeat() {
        return isExtraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        isExtraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return isExtraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        isExtraCheese = extraCheese;
    }
    //endregion

    public double getBasePrice() {
//        value = 0.0;

        switch (this.size) {
            case "SMALL" -> value += 5.5 + 1.00 + .75;
            case "MEDIUM" -> value += 7.00 + 2.00 + 1.50;
            case "LARGE" -> value += 8.50 + 3.00 + 2.25;
            default -> System.out.println("ERROR! Size needs to be SMALL, MEDIUM, OR LARGE!");
        }
        return value;
    }


    @Override
    public double getValue() {
        return value;
    }
}
