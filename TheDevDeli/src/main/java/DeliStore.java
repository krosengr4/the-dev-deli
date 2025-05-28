import java.util.ArrayList;

public class DeliStore {

    //List that will store the menu items a customer has ordered
    ArrayList<MenuItem> customerOrder = new ArrayList<>();

    //Method that displays order screen options and handles user selection
    public void displayOrderScreen() {
        boolean ifContinueOrder = true;

        do {
            //Printing out order menu
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

            //Getting user order menu selection
            int userAction = Utils.messageAndResponseInt("Enter Your Option: ");

            //Handling user order menu selection
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

    //Method to make customer sandwich, verify it is correct, and add it to orders list
    private void processAddSandwich() {

        //Call MakeSandwich class to create customer sandwich
        Sandwich sandwich = MakeSandwich.createSandwich();

        //Print out the sandwich that was just created
        System.out.printf("\nSandwich | %s | Toasted: %b | Bread: %s | Meat: %s | ExtraMeat: %b | Cheese: %s | ExtraCheese: %b | Toppings: %s | Sauces: %s",
                sandwich.size, sandwich.isToasted(), sandwich.getBread(), sandwich.getMeat(), sandwich.isExtraMeat(), sandwich.getCheese(), sandwich.isExtraCheese(),
                sandwich.getToppings(), sandwich.getSauces());
        System.out.printf("\nTotal Price: $%.2f\n", sandwich.getValue());

        //Verify if the sandwich is correct
        String userCorrectSandwich = Utils.promptGetUserInput("Is this sandwich correct?(Y or N):").trim();
    
        //If correct -> add to order list, if no -> retry
        if (userCorrectSandwich.equalsIgnoreCase("y")) {
            customerOrder.add(sandwich);
            System.out.println(Utils.GREEN + "Huzzah! We have added your sandwich to the order!" + Utils.RESET);
        } else {
            System.out.println("Apologies for the inconvenience. Try and place your sandwich order again.");
        }

        Utils.pauseApp();
    }

    //Method to ask user how many bags of chips customer wants, and add that many bags to orders list
    private void processAddChips() {
        int numberOfChips = Utils.messageAndResponseInt("How many bags of chips would you like?: ");

        //For how many chips a customer wants, create new chips object and add to orders list
        for (int i = 0; i < numberOfChips; i++) {
            Chips chip = new Chips();
            customerOrder.add(chip);
        }
        System.out.println(Utils.GREEN + "Success! " + numberOfChips + " bag(s) of chips has been added to your order!" + Utils.RESET);
    }

    //Method to get customer drink (type and size) and add to orders list
    private void processAddDrink() {
        boolean addAnotherDrink = true;

        while (addAnotherDrink) {
            //Create new instance of Drink object
            Drink drink = new Drink();

            //Ask customer for drink type
            System.out.printf("\n%s----%sDRINK OPTIONS%s-----%s\n%s1 - Fountain Drink\n2 - Lemonade\n3 - Sweet Tea\n4 - Unsweetened Tea\n5 - MilkShake%s\n",
                    Utils.BLUE, Utils.drink, Utils.drink, Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userDrinkChoice = Utils.messageAndResponseInt("Select the number next to the desired drink: ");

            //Handle customer drink type request
            switch (userDrinkChoice) {
                case 1 -> drink.setName("Fountain Drink");
                case 2 -> drink.setName("Lemonade");
                case 3 -> drink.setName("Sweet Tea");
                case 4 -> drink.setName("Unsweetened Tea");
                case 5 -> drink.setName("MilkShake");
                default -> System.err.println("ERROR! Please enter a number between 1 and 5!");
            }

            //Ask customer for drink size
            System.out.println(Utils.YELLOW + "\n1 - Small $2.00\n2 - Medium $2.50\n3 - Large $3.00" + Utils.RESET);
            int userDrinkSize = Utils.messageAndResponseInt("Enter a drink size: ");

            //Handle customer drink size request
            switch (userDrinkSize) {
                case 1 -> drink.setSize("SMALL");
                case 2 -> drink.setSize("MEDIUM");
                case 3 -> drink.setSize("LARGE");
                default -> System.err.println("ERROR! Please enter a number between 1 and 3!");
            }

            //Add drink with type and size to the orders list
            customerOrder.add(drink);
            System.out.printf("\n%sSuccess! %s %s added!%s\n", Utils.GREEN, drink.getSize().toLowerCase(), drink.getName(), Utils.RESET);

            //Ask customer if they would like another drink
            String anotherDrink = Utils.promptGetUserInput("\nWould you like to add another drink? (Y or N): ").trim();
            if (anotherDrink.equalsIgnoreCase("n")) {
                addAnotherDrink = false;
            } else if (!anotherDrink.equalsIgnoreCase("y")) {
                System.err.println("ERROR! Please enter y or n!");
            }
        }
    }

    //Method to create new order with customers name and their list of orders, verify and save it
    private void processCheckout() {
        String customerName = Utils.promptGetUserInput("Please enter a name for your order: ").toUpperCase();

        //Create new instance of Order with customers name and orders
        Order newOrder = new Order(customerOrder, customerName);

        //Print out order and verify order with customer
        newOrder.printItemsAndPrices();
        String correctUserOrder = Utils.promptGetUserInput("Is this order correct? (Y or N): ").trim();

        //If order correct -> Save it, if not -> try again
        if (correctUserOrder.equalsIgnoreCase("y")) {
            newOrder.saveOrder();
        } else {
            System.out.println("Apologies for the inconvenience. Try and place your order again.");
        }

        Utils.pauseApp();
    }

}
