import java.util.ArrayList;

public class UserInterface {

    //List that will store the menu items a customer has ordered
    ArrayList<MenuItem> customerOrder = new ArrayList<>();

    //Method that will display the Main Menu of the application
    public int displayMainScreen() {
        //Create new instance of DeliStore
        UserInterface ui = new UserInterface();

        //Print out Main Menu
        System.out.printf("""
                                             \s
                                             \s
                                             %sMAIN MENU:
                                ----------------------------------%s
                              %s1 - Place an Order%s        %s0 - Exit%s
                
                \s""", Utils.BLUE, Utils.RESET, Utils.GREEN, Utils.RESET, Utils.RED, Utils.RESET);

        return Utils.messageAndResponseInt("Enter 1 or 0: ");
    }

    //Method that displays order screen options
    public int displayOrderScreen() {
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

        //Getting and returning user order menu selection
        return Utils.messageAndResponseInt("Enter Your Option: ");
    }

    //Method to display signature sandwiches and get user sandwich option
    public int displayNewSandwichMenu() {

        System.out.printf("""
               \s
                            %s---%sSIGNATURE SANDWICHES%s---
                       ___________________________________________%s
                      %sBLT ($10.50)             Philly Cheese Steak ($10.50)
                      -------------             ---------------------------%s \s
                      %s8" White Bread          8" White Bread
                      Bacon                   Steak \s
                      Cheddar                 American Cheese
                      Lettuce                 Peppers
                      Tomato                  Mayo
                      Ranch                   Toasted
                      Toasted%s
               \s""", Utils.CYAN, Utils.sandwich, Utils.sandwich, Utils.RESET, Utils.BLUE, Utils.RESET, Utils.YELLOW, Utils.RESET);

        //Prompt user to choose one of the signature sandwiches, or to create their own
        System.out.println(Utils.CYAN + "\n\t\t\t-----OPTIONS-----" + Utils.RESET);
        System.out.println(Utils.YELLOW + "1 - Create Your Own | 2 - BLT | 3 - Philly Cheese Steak" + Utils.RESET);
        return Utils.messageAndResponseInt("Please Enter your Choice: ");
    }

    public int displaySandwichSizeMenu() {
        //print out size options
        System.out.printf("\n\t%s---SIZES---%s\n%s1 - Small (4inch) $5.50\n2 - Medium (8inch) $7.00\n3 - Large (12inch) $8.50%s",
                Utils.CYAN, Utils.RESET, Utils.YELLOW, Utils.RESET);
        return Utils.messageAndResponseInt("\nPlease enter the number next to the desired sandwich size: ");
    }











    //Method to make customer sandwich, verify it is correct, and add it to orders list
//    private void processAddSandwich() {
//
//        //Call MakeSandwich class to create customer sandwich
//        Sandwich sandwich = MakeSandwich.createSandwich();
//
//        //Print out the sandwich that was just created
//        System.out.printf("\nSandwich | %s | Toasted: %b | Bread: %s | Meat: %s | ExtraMeat: %b | Cheese: %s | ExtraCheese: %b | Toppings: %s | Sauces: %s",
//                sandwich.size, sandwich.isToasted(), sandwich.getBread(), sandwich.getMeat(), sandwich.isExtraMeat(), sandwich.getCheese(), sandwich.isExtraCheese(),
//                sandwich.getToppings(), sandwich.getSauces());
//        System.out.printf("\nTotal Price: $%.2f\n", sandwich.getValue());
//
//        //Verify if the sandwich is correct
//        String userCorrectSandwich = Utils.promptGetUserInput("Is this sandwich correct?(Y or N):").trim();
//
//        //If correct -> add to order list, if no -> retry
//        if (userCorrectSandwich.equalsIgnoreCase("y")) {
//            customerOrder.add(sandwich);
//            System.out.println(Utils.GREEN + "Huzzah! We have added your sandwich to the order!" + Utils.RESET);
//        } else {
//            System.out.println("Apologies for the inconvenience. Try and place your sandwich order again.");
//        }
//
//        Utils.pauseApp();
//    }

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
