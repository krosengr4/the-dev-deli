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
            if (item instanceof Sandwich) {
                System.out.printf("%s Sandwich on %s bread with %s, %s cheese, %s, and %s\n", ((Sandwich) item).getSize(), ((Sandwich) item).getBread(),
                        ((Sandwich) item).getMeat(), ((Sandwich) item).getCheese(), ((Sandwich) item).getToppings(), ((Sandwich) item).getSauces());
                System.out.printf("$%.2f\n", item.getValue());
                totalPrice += item.getValue();
            }
        }

        System.out.printf("\nTOTAL PRICE: $%.2f\n", totalPrice);
        Utils.pauseApp();
    }

}
