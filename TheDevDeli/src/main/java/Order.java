import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {

    ArrayList<MenuItem> customerOrder;
    String customerName;
    double totalPrice = 0.0;

    public Order(ArrayList<MenuItem> customerOrder, String customerName) {
        this.customerOrder = customerOrder;
        this.customerName = customerName;
    }

    public void printItemsAndPrices() {
        System.out.printf("\n\t\t\t---ORDER FOR %s---\n", customerName);

        for (MenuItem item : customerOrder) {

            if (item instanceof Drink) {
                System.out.println(((Drink) item).getSize() + " " + item.getName());
                System.out.printf("$%.2f\n", item.getValue());
                totalPrice += item.getValue();
            }
            if (item instanceof Sandwich) {
                System.out.printf("%s Sandwich on %s with %s %s %s %s\n", ((Sandwich) item).getSize(), ((Sandwich) item).getBread(),
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

        System.out.printf("TOTAL PRICE: $%.2f\n", totalPrice);
    }

    public void saveOrder () {
        String receipt = formatReceipt();

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter fullDateTime = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String logFile = localDateTime.format(fullDateTime);

        try {
            FileWriter writer = new FileWriter("TheDevDeli/src/main/receipts/" + logFile);
            writer.write("Order for: " + customerName + "\n");
            writer.write(receipt);
            writer.close();
            System.out.printf("\nTHANK YOU %s! Order receipt has been saved in /src/main/receipts", customerName);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public String formatReceipt() {
        StringBuilder receiptFormat = new StringBuilder();

        for (MenuItem item : customerOrder) {
            if (item instanceof Sandwich) {
                receiptFormat.append("Sandwich ")
                        .append(((Sandwich) item).getSize())
                        .append(" ")
                        .append(((Sandwich) item).getBread()).append(" ")
                        .append(((Sandwich) item).getMeat()).append(" ")
                        .append(((Sandwich) item).getCheese()).append(" ")
                        .append(((Sandwich) item).getToppings()).append(" ")
                        .append(((Sandwich) item).getSauces())
                        .append("\n")
                        .append(item.getValue())
                        .append("\n");
            } else if (item instanceof Drink) {
                receiptFormat.append(((Drink) item).getSize()).append(" ")
                        .append(item.getName())
                        .append("\n")
                        .append(item.getValue())
                        .append("\n");
            } else if (item instanceof Chips) {
                receiptFormat.append("Chips")
                        .append("\n")
                        .append(item.getValue())
                        .append("\n");
            }
        }

        receiptFormat.append("TOTAL: $").append(totalPrice);

        return receiptFormat.toString();
    }

}
