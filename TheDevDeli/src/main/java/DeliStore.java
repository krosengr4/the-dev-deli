public class DeliStore {

    public void displayOrderScreen() {
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

        //no default because error was handled in display method
        switch (userAction) {
            case 1 -> processAddSandwich();
            case 2 -> processAddChips();
            case 3 -> processAddDrink();
            case 4 -> processCheckout();
        }
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
