public class UserInterface {


    public void displayHomeScreen() {

        boolean ifContinue = true;

        do {
            System.out.printf("""
                                         \s
                                         %s%s%sWELCOME TO DEV DELI%s%s%s
                         Serving Developers an Extensive Library of Incredible Sandwiches.\s
                                                 Have a Byte!  \s
                     ______________________________________________________________________________
                    \s
                                                   OPTIONS:
                                         ---------------------------
                                    1 - Place an Order        0 - Exit
                    
                    \s""", Utils.sandwich, Utils.sandwich, Utils.sandwich, Utils.sandwich, Utils.sandwich, Utils.sandwich);
            int userAction = Utils.messageAndResponseInt("Enter 1 or 0: ");

            switch (userAction) {
                case 1 -> displayOrderScreen();
                case 0 -> ifContinue = false;
            }

        } while (ifContinue);
        System.out.println("\n\n\t\t\t\tThanks for coming into Dev Deli!" + Utils.sandwich + Utils.fire);
        System.out.println("\t\t\t\tWe will see you soon!");
    }

    private void displayOrderScreen() {
        boolean ifContinueOrder = true;

        do {
            System.out.printf("""
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

    }

    private void processAddSandwich() {
        System.out.println("Add a sandwich");
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
