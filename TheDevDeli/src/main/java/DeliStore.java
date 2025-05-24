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
                        White           Steak        American        Lettuce          Mayo
                        Wheat           Ham          Provolone       Peppers          Mustard
                        Rye             Salami       Cheddar         Onions           Ketchup
                        Wrap            Roast Beef   Swiss           Tomatoes         Ranch
                                        Chicken                      Jalapeños        Thousand Islands
                                        Bacon                        Cucumbers        Vinaigrette
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
        System.out.println("Hot hot sammich comin' ur way sir");
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
