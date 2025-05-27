public class DeliStore {

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

            if (userAction < 0 || userAction > 4) {
                System.err.println("ERROR! Please enter a number that is listed!");
            } else if (userAction == 0) {
                ifContinueOrder = false;
            } else {
                processOrder(userAction);
            }

        } while (ifContinueOrder);
    }

    private void processOrder(int userAction) {

        //no default because error was handled in display method
        switch (userAction) {
            case 1 -> displaySandwichMenu();
            case 2 -> processAddChips();
            case 3 -> processAddDrink();
            case 4 -> processCheckout();
        }
    }

    private void displaySandwichMenu() {
        System.out.println("\n\t\t\t\t" + Utils.sandwich + "SANDWICH MENU" + Utils.sandwich);
        Utils.printDivider("-" , 70);
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

        processAddSandwich();
    }

    private void processAddSandwich() {
        System.out.println("1 - Small  |  2 - Medium  |  3 - Large");
        int userSize = Utils.messageAndResponseInt("Please enter sandwich size: ");


        String userBread = Utils.promptGetUserInput("Enter the type of bread you would like: ").trim();

        String userMeat = Utils.promptGetUserInput("Enter the kind of meat you would like: ").trim();
        String userExtraMeat = Utils.promptGetUserInput("Would you like extra meat? Y or N: ").trim();


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
        System.out.println("Add a drink");
    }

    private void processCheckout() {
        System.out.println("Checkout");
    }

}
