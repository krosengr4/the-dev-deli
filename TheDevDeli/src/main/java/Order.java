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

        String receipt = formatReceipt();
        System.out.println(formatReceipt());
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

                    String toastMessage = "";
                    if (((Sandwich) item).isToasted()) {
                        toastMessage = "toasted";
                    } else {
                        toastMessage = "not toasted";
                    }

                    String extraMeatMessage = "";
                    if (((Sandwich) item).isExtraMeat()) {
                        extraMeatMessage = "Extra meat";
                    }

                    String extraCheeseMessage = "";
                    if (((Sandwich) item).isExtraCheese()) {
                        extraCheeseMessage = "Extra Cheese";
                    }

                receiptFormat.append("Sandwich ")
                        .append(((Sandwich) item).getSize())
                        .append(" | ")
                        .append(toastMessage).append(" | ")
                        .append(((Sandwich) item).getBread()).append(" | ")
                        .append(((Sandwich) item).getMeat()).append(" | ")
                        .append(extraMeatMessage).append(" | ")
                        .append(((Sandwich) item).getCheese()).append(" | ")
                        .append(extraCheeseMessage).append(" | ")
                        .append(((Sandwich) item).getToppings()).append(" | ")
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
