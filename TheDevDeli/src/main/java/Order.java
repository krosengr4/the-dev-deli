import java.util.ArrayList;

public class Order {

    ArrayList<MenuItem> customerOrder;

    public Order (ArrayList<MenuItem> customerOrder) {
        this.customerOrder = customerOrder;
    }

    public void printItemsAndPrices () {
        System.out.println("\t\t\t---YOUR ORDER---");

        double totalPrice = 0.0;

        for (MenuItem item : customerOrder) {

            if (item instanceof Drink) {
                System.out.println(((Drink) item).getSize() + " Drink.");
                System.out.printf("$%.2f\n", item.getValue());
                totalPrice += item.getValue();
            }
        }

        System.out.printf("\nTOTAL PRICE: $%.2f\n", totalPrice);
    }

}
