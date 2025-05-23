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

    }

}
