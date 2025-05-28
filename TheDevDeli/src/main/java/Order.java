import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {

    //Order object attributes
    ArrayList<MenuItem> customerOrder;
    String customerName;

    //Constructor
    public Order(ArrayList<MenuItem> customerOrder, String customerName) {
        this.customerOrder = customerOrder;
        this.customerName = customerName;
    }

    //Method to print out a customers formatted receipt for their order
    public void printItemsAndPrices() {
        System.out.printf("\n\t\t\t%s---ORDER FOR %s %s---\n", Utils.BLUE, customerName, Utils.RESET);

        System.out.println(formatReceipt());
    }

    //Method to write a customers formatted receipt to a new .txt file
    public void saveOrder() {
        String receipt = formatReceipt();

        //Getting the name of the .txt file using LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter fullDateTime = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String logFile = localDateTime.format(fullDateTime);

        try {
            //Create FileWriter and writing customer and the formatted receipt for their order
            FileWriter writer = new FileWriter("TheDevDeli/src/main/receipts/" + logFile + ".txt");
            writer.write("ORDER FOR: " + customerName + "\n");
            writer.write(receipt);
            writer.close();
            System.out.printf("\n%sTHANK YOU %s. Your order will out shortly! \nYour receipt has been saved in /src/main/receipts%s",
                    Utils.GREEN, customerName, Utils.RESET);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Method to format the receipt
    public String formatReceipt() {
        StringBuilder receiptFormat = new StringBuilder(); //<--- Using StringBuilder to format the receipt
        double totalPrice = 0.0;

        for (MenuItem item : customerOrder) {
            if (item instanceof Sandwich) {
                receiptFormat.append("Sandwich | ")
                        .append("Size: ").append(((Sandwich) item).getSize())
                        .append(" | Toasted: ").append(((Sandwich) item).isToasted())
                        .append(" | Bread: ").append(((Sandwich) item).getBread())
                        .append(" | Meat: ").append(((Sandwich) item).getMeat())
                        .append(" | ExtraMeat: ").append(((Sandwich) item).isExtraMeat())
                        .append(" | Cheese: ").append(((Sandwich) item).getCheese())
                        .append(" | ExtraCheese: ").append(((Sandwich) item).isExtraCheese())
                        .append(" | Toppings: ").append(((Sandwich) item).getToppings())
                        .append(" | Sauces: ").append(((Sandwich) item).getSauces())
                        .append("\n")
                        .append("Price: $").append(item.getValue())
                        .append("\n\n");

                totalPrice += item.getValue();
            } else if (item instanceof Drink) {
                receiptFormat.append("Drink | ")
                        .append("Type: ").append(item.getName())
                        .append(" | Size: ").append(((Drink) item).getSize())
                        .append("\n")
                        .append("Price: $").append(item.getValue())
                        .append("\n\n");

                totalPrice += item.getValue();
            } else if (item instanceof Chips) {
                receiptFormat.append("Chips")
                        .append("\n")
                        .append("Price: $").append(item.getValue())
                        .append("\n\n");

                totalPrice += item.getValue();
            }
        }

        receiptFormat.append("\nTOTAL: $").append(totalPrice);

        return receiptFormat.toString();
    }

}
