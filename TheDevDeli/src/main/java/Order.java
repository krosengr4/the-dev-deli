import java.util.ArrayList;

public class Order {

    ArrayList<MenuItem> customerOrder;

    public Order(ArrayList<MenuItem> customerOrder) {
        this.customerOrder = customerOrder;
    }

    public void printItemsAndPrices() {
        System.out.println("\n\t\t\t---YOUR ORDER---");

        double totalPrice = 0.0;

        for (MenuItem item : customerOrder) {

            if (item instanceof Drink) {
                System.out.println(((Drink) item).getSize() + " " + item.getName());
                System.out.printf("$%.2f\n", item.getValue());
                totalPrice += item.getValue();
            }
            if (item instanceof Sandwich) {
                System.out.printf("%s Sandwich on %s bread with %s %s %s %s\n", ((Sandwich) item).getSize(), ((Sandwich) item).getBread(),
                        ((Sandwich) item).getMeat(), ((Sandwich) item).getCheese(), ((Sandwich) item).getToppings(), ((Sandwich) item).getSauces());
                System.out.printf("$%.2f\n", item.getValue());
                totalPrice += item.getValue();
            }
            if (item instanceof Chips) {
                System.out.println("Chips.");
                System.out.printf("$%.2f\n", item.getValue());
                totalPrice += item.getValue();
            }
        }

        System.out.printf("\nTOTAL PRICE: $%.2f\n", totalPrice);
        Utils.pauseApp();
    }

    public void saveOrder() {
        StringBuilder receiptFormat = new StringBuilder();

        for (MenuItem item : customerOrder) {
            if (item instanceof Sandwich) {
                receiptFormat.append("Sandwich ")
                        .append(((Sandwich) item).getSize())
                        .append(" ")
                        .append(((Sandwich) item).getBread())
                        .append(((Sandwich) item).getMeat())
                        .append(((Sandwich) item).getCheese())
                        .append(((Sandwich) item).getToppings())
                        .append(((Sandwich) item).getSauces())
                        .append("\n")
                        .append(item.getValue());
            } else if (item instanceof Drink) {
                receiptFormat.append(item.getName())
                        .append(((Drink) item).getSize())
                        .append("\n")
                        .append(item.getValue());
            } else if (item instanceof Chips) {
                receiptFormat.append("Chips ")
                        .append("\n")
                        .append(item.getValue());
            }
        }

        System.out.println(receiptFormat);
    }

}
