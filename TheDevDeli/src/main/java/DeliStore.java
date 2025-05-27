import java.util.ArrayList;

public class DeliStore {

    ArrayList<MenuItem> customerOrder = new ArrayList<>();

    public void displayOrderScreen() {
        boolean ifContinueOrder = true;

        do {
            System.out.print("""
                                                      ORDER
                                               ---------------------
                                1 - Order a Sandwich              3 - Add a Drink
                                2 - Add Chips                     4 - Checkout
                    
                                              0 - Cancel Order
                    """);

            int userAction = Utils.messageAndResponseInt("Enter Your Option: ");

            switch (userAction) {
                case 0 -> ifContinueOrder = false;
                case 1 -> displaySandwichMenu();
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


    private void displaySandwichMenu() {
        System.out.println("\n\t\t\t\t" + Utils.sandwich + "SANDWICH MENU" + Utils.sandwich);
        Utils.printDivider("-", 70);
        System.out.printf("""
                        BREADS %s      MEATS %s      CHEESES %s     TOPPINGS         SAUCES \s
                -----------------------------------------------------------------------------------------
                        White          Steak         American        Lettuce          Mayo
                        Wheat          Ham           Provolone       Peppers          Mustard
                        Rye            Salami        Cheddar         Onions           Ketchup
                        Wrap           Roast Beef    Swiss           Tomatoes         Ranch
                                       Chicken                       Jalapeños        Thousand Islands
                                       Bacon                         Cucumbers        Vinaigrette
                                                                     Pickles          Au Jus
                                                                     Guacamole
                                                                     Mushrooms
                -----------------------------------------------------------------------------------------
                SIZES               4"                  8"                  12"
                """, Utils.bread, Utils.meat, Utils.cheese);
        //todo display pricing somewhere around here

        Sandwich sandwich = MakeSandwich.createSandwich();
        System.out.println(sandwich.getMeat());
        System.out.println(sandwich.getToppings());
        System.out.println(sandwich.getValue());

//        processAddSandwich();
    }

    private void processAddSandwich() {
        Sandwich sandwich = new Sandwich();






        boolean repeatMeat = true;
        System.out.println("MEAT-OPTIONS");

        String userMeat = Utils.promptGetUserInput("Enter the kind of meat you would like: ").trim();
        String userExtraMeat = Utils.promptGetUserInput("Would you like extra meat? (Y or N): ").trim();

        String userCheese = Utils.promptGetUserInput("Would you like extra cheese? (Y or N): ").trim();
        String userExtraCheese = Utils.promptGetUserInput("Would you like extra cheese? (Y or N): ");


        int ifUserToppings = Utils.messageAndResponseInt("Would you like any other toppings?\n1 - Yes 2 - No: ");
        if (ifUserToppings == 1) {

            boolean ifMoreToppings = true;

            while (ifMoreToppings) {
                String userToppings = Utils.promptGetUserInput("Enter 1 topping you would like: ");

                int extraUserToppings = Utils.messageAndResponseInt("Would you like any more toppings?\n1 - Yes 2 - No: ");
                if (extraUserToppings > 2 || extraUserToppings < 1) {
                    System.err.println("ERROR! Please enter a number between 1 and 2!");
                } else if (extraUserToppings == 2) {
                    ifMoreToppings = false;
                }
            }
        }

    }

    private void processAddChips() {
        System.out.println("Add chips");
    }

    private void processAddDrink() {
        boolean addAnotherDrink = true;

        while (addAnotherDrink) {
            Drink drink = new Drink();

            System.out.println("\n1 - Small\n2 - Medium\n3 - Large");
            int userDrinkSize = Utils.messageAndResponseInt("Enter a drink size: ");

            switch (userDrinkSize) {
                case 1 -> {
                    drink.setSize("SMALL");
                    System.out.println("Success! Small drink added!");
                }
                case 2 -> {
                    drink.setSize("MEDIUM");
                    System.out.println("Success! Medium drink added!");
                }
                case 3 -> {
                    drink.setSize("LARGE");
                    System.out.println("Success! Large drink added!");
                }
                default -> System.err.println("ERROR! Please enter a number between 1 and 3!");
            }

            customerOrder.add(drink);
            Utils.pauseApp();

            String anotherDrink = Utils.promptGetUserInput("Would you like to add another drink? (Y or N): ").trim();
            if (anotherDrink.equalsIgnoreCase("n")) {
                addAnotherDrink = false;
            } else if (!anotherDrink.equalsIgnoreCase("y")) {
                System.err.println("ERROR! Please enter y or n!");
            }
        }
    }

    private void processCheckout() {
        Order newOrder = new Order(customerOrder);

        newOrder.printItemsAndPrices();


    }

}
