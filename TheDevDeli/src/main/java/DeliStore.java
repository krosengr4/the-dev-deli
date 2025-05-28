import java.util.ArrayList;

public class DeliStore {

    ArrayList<MenuItem> customerOrder = new ArrayList<>();

    public void displayOrderScreen() {
        boolean ifContinueOrder = true;

        do {
            System.out.printf("""
                                                      \s
                                                      %sORDER
                                -------------------------------------------------%s
                                %s1 - Order a Sandwich%s%s          %s3 - Add a Drink%s%s
                                %s2 - Add Chips%s%s                 %s4 - Checkout%s
                    
                                              %s0 - Cancel Order%s
                                              \s
                    """, Utils.BLUE, Utils.RESET, Utils.PURPLE, Utils.RESET, Utils.sandwich, Utils.CYAN, Utils.RESET, Utils.drink, Utils.YELLOW, Utils.RESET,
                    Utils.chips, Utils.GREEN, Utils.RESET, Utils.RED, Utils.RESET);

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

        System.out.printf("\nSandwich | %s | Toasted: %b | Bread: %s | Meat: %s | ExtraMeat: %b | Cheese: %s | ExtraCheese: %b | Toppings: %s | Sauces: %s",
                sandwich.size, sandwich.isToasted(), sandwich.getBread(), sandwich.getMeat(), sandwich.isExtraMeat(), sandwich.getCheese(), sandwich.isExtraCheese(),
                sandwich.getToppings(), sandwich.getSauces());
        System.out.printf("\nTotal Price: $%.2f\n", sandwich.getValue());

        String userCorrectSandwich = Utils.promptGetUserInput("Is this sandwich correct?(Y or N):").trim();

        if (userCorrectSandwich.equalsIgnoreCase("y")) {
            customerOrder.add(sandwich);
            System.out.println(Utils.GREEN + "Huzzah! We have added your sandwich to the order!" + Utils.RESET);
        } else {
            System.out.println("Apologies for the inconvenience. Try and place your sandwich order again.");
        }

        Utils.pauseApp();
    }

    private void processAddChips() {
        int numberOfChips = Utils.messageAndResponseInt("How many bags of chips would you like?: ");

        for (int i = 0; i < numberOfChips; i++) {
            Chips chip = new Chips();
            customerOrder.add(chip);
        }
        System.out.println(Utils.GREEN + "Success! " + numberOfChips + " bag(s) of chips has been added to your order!" + Utils.RESET);
    }

    private void processAddDrink() {
        boolean addAnotherDrink = true;

        while (addAnotherDrink) {
            Drink drink = new Drink();

            System.out.printf("\n%s----%sDRINK OPTIONS%s-----%s\n%s1 - Fountain Drink\n2 - Lemonade\n3 - Sweet Tea\n4 - Unsweetened Tea\n5 - MilkShake%s\n",
                    Utils.BLUE, Utils.drink, Utils.drink, Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userDrinkChoice = Utils.messageAndResponseInt("Select the number next to the desired drink: ");

            switch (userDrinkChoice) {
                case 1 -> drink.setName("Fountain Drink");
                case 2 -> drink.setName("Lemonade");
                case 3 -> drink.setName("Sweet Tea");
                case 4 -> drink.setName("Unsweetened Tea");
                case 5 -> drink.setName("MilkShake");
                default -> System.err.println("ERROR! Please enter a number between 1 and 5!");
            }

            System.out.println(Utils.YELLOW + "\n1 - Small $2.00\n2 - Medium $2.50\n3 - Large $3.00" + Utils.RESET);
            int userDrinkSize = Utils.messageAndResponseInt("Enter a drink size: ");

            switch (userDrinkSize) {
                case 1 -> drink.setSize("SMALL");
                case 2 -> drink.setSize("MEDIUM");
                case 3 -> drink.setSize("LARGE");
                default -> System.err.println("ERROR! Please enter a number between 1 and 3!");
            }

            customerOrder.add(drink);
            System.out.printf("\n%sSuccess! %s %s added!%s\n", Utils.GREEN, drink.getSize().toLowerCase(), drink.getName(), Utils.RESET);

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

        String correctUserOrder = Utils.promptGetUserInput("Is this order correct? (Y or N): ").trim();

        if (correctUserOrder.equalsIgnoreCase("y")) {
            newOrder.saveOrder();
        } else {
            System.out.println("Apologies for the inconvenience. Try and place your order again.");
        }

        Utils.pauseApp();
    }

}
