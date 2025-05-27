import java.util.ArrayList;

public class Order {

    ArrayList<MenuItem> customerOrder;

    public Order (ArrayList<MenuItem> customerOrder) {
        this.customerOrder = customerOrder;
    }

    public void printItemsAndPrices () {
        System.out.println("\t\t\t---YOUR ORDER---");

        for (MenuItem item : customerOrder) {

            if (item instanceof Drink) {
                System.out.println(((Drink) item).getSize() + " Drink.");
                System.out.printf("$%.2f\n", ((Drink) item).calculateValue());
            }
        }
    }

}
