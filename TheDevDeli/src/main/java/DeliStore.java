import java.util.ArrayList;

public class DeliStore {

    ArrayList<MenuItem> customerOrder = new ArrayList<>();

    public void displayOrderScreen() {
        boolean ifContinueOrder = true;

        do {
            System.out.print("""
                                                      \s
                                                      ORDER
                                -------------------------------------------------
                                1 - Order a Sandwich              3 - Add a Drink
                                2 - Add Chips                     4 - Checkout
                    
                                              0 - Cancel Order
                    """);

            int userAction = Utils.messageAndResponseInt("Enter Your Option: ");

            switch (userAction) {
                case 0 -> ifContinueOrder = false;
                case 1 -> processAddSandwich();
                case 2 -> processAddChips();
                case 3 -> processAddDrink();
                case 4 -> {
                    processCheckout();
                    ifContinueOrder = false;
                }
                default -> System.err.println("ERROR! Please enter a number that is listed!");
            }
        } while (ifContinueOrder);
    }

    private void processAddSandwich() {

        Sandwich sandwich = MakeSandwich.createSandwich();

        customerOrder.add(sandwich);

        System.out.println("\nSuccess! Sandwich Added to your order!");
        System.out.printf("Sandwich | %s | Toasted: %b | Bread: %s | Meat: %s | ExtraMeat: %b | Cheese: %s | ExtraCheese: %b | Toppings: %s | Sauces: %s",
                sandwich.size, sandwich.isToasted(), sandwich.getBread(), sandwich.getMeat(), sandwich.isExtraMeat(), sandwich.getCheese(), sandwich.isExtraCheese(),
                sandwich.getToppings(), sandwich.getSauces());

        System.out.printf("\nTotal Price: $%.2f\n", sandwich.getValue());
        Utils.pauseApp();
    }

    private void processAddChips() {
        int numberOfChips = Utils.messageAndResponseInt("How many bags of chips would you like?: ");

        for (int i = 0; i < numberOfChips; i++) {
            Chips chip = new Chips();
            customerOrder.add(chip);
        }
        System.out.println("Success! " + numberOfChips + " bag(s) of chips has been added to your order!");
    }

    private void processAddDrink() {
        boolean addAnotherDrink = true;

        while (addAnotherDrink) {
            Drink drink = new Drink();

            System.out.println("\n----DRINK OPTIONS-----\n1 - Fountain Drink\n2 - Lemonade\n3 - Sweet Tea\n4 - Unsweetened Tea\n5 - MilkShake");
            int userDrinkChoice = Utils.messageAndResponseInt("Select the number next to the desired drink: ");

            switch (userDrinkChoice) {
                case 1 -> drink.setName("Fountain Drink");
                case 2 -> drink.setName("Lemonade");
                case 3 -> drink.setName("Sweet Tea");
                case 4 -> drink.setName("Unsweetened Tea");
                case 5 -> drink.setName("MilkShake");
                default -> System.err.println("ERROR! Please enter a number between 1 and 5!");
            }

            System.out.println("\n1 - Small $2.00\n2 - Medium $2.50\n3 - Large $3.00");
            int userDrinkSize = Utils.messageAndResponseInt("Enter a drink size: ");

            switch (userDrinkSize) {
                case 1 -> drink.setSize("SMALL");
                case 2 -> drink.setSize("MEDIUM");
                case 3 -> drink.setSize("LARGE");
                default -> System.err.println("ERROR! Please enter a number between 1 and 3!");
            }

            customerOrder.add(drink);
            System.out.printf("\nSuccess! %s %s added!\n", drink.getSize().toLowerCase(), drink.getName());

            String anotherDrink = Utils.promptGetUserInput("\nWould you like to add another drink? (Y or N): ").trim();
            if (anotherDrink.equalsIgnoreCase("n")) {
                addAnotherDrink = false;
            } else if (!anotherDrink.equalsIgnoreCase("y")) {
                System.err.println("ERROR! Please enter y or n!");
            }
        }
    }

    private void processCheckout() {
        String customerName = Utils.promptGetUserInput("Please enter a name for your order: ").toUpperCase();

        Order newOrder = new Order(customerOrder, customerName);

        newOrder.printItemsAndPrices();
        newOrder.saveOrder();
        Utils.pauseApp();
    }

}
