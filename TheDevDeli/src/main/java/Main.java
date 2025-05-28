public class Main {
    /*
    *** An application for a Sandwich Shop where customers can fully
        customize their sandwich orders. ***

    * Customers can order a sandwich in 3 sizes: 4", 8" and 12"
    *
    * When they order, they choose the type of bread (white, wheat, rye, or wrap)
    *
    * Then a customer can choose their toppings.
    * Toppings are categorized as regular or premium.
    * Premium Toppings: Meats and Cheeses.
    * Regular Toppings: most other toppings that aren't meats or cheeses.
    * A customer can request extra toppings. Premium toppings have an additional cost.
    *
    * A customer has the option for the sandwich to be toasted.
    *
    * A customer has the option to add chips and a drink to the order.
    *
    * When the customer completes their order, display the
    * order details (sandwiches ordered w/ toppings, if toasted or not, if they added
    * chips or a drink).
    * Verify with the customer that the order is correct.
    * This should also display the total cost.
    *
    * When the customer completes the order, the order details are saved to its own
    * receipt .txt file.
    * The file name is named by the date and time the order was placed.
    * Format: yyyyMMdd-hhmmss.txt (ex: 20230329-121523.txt)
    * The .txt file will then be saved and kept in a receipts' folder.
    *
    * The application must include several screens with the features listen in workbook.
     */

    public static void main(String[] args) {

        boolean ifContinue = true;

        do {
            //Create new instance of DeliStore
            DeliStore devDeli = new DeliStore();

            //Print out Main Menu
            System.out.printf("""
                                         \s
                                         %s%s%sWELCOME TO DEV DELI%s%s%s
                                     %sTake A Byte Into our Devlicous Sandwiches!%s%s%s
                    %s______________________________________________________________________________
                     \s
                     \s
                                                 OPTIONS:
                                    ----------------------------------%s
                                  %s1 - Place an Order%s        %s0 - Exit%s
                    
                    \s""", Utils.fire, Utils.sandwich, Utils.BLUE, Utils.RESET, Utils.sandwich, Utils.fire, Utils.BLUE, Utils.RESET, Utils.smileyFace, Utils.thumbsUp,
                    Utils.BLUE, Utils.RESET, Utils.GREEN, Utils.RESET, Utils.RED, Utils.RESET);
            int userAction = Utils.messageAndResponseInt("Enter 1 or 0: ");

            //Handle user main menu option
            switch (userAction) {
                case 1 -> devDeli.displayOrderScreen();
                case 0 -> ifContinue = false;
                default -> System.err.println("ERROR! Please enter a number that is listed!");
            }

        } while (ifContinue);

        //Goodbye messages for when user exits app
        System.out.println(Utils.BLUE + "\n\n\t\t\t\tThanks for coming into Dev Deli!" + Utils.RESET + Utils.sandwich + Utils.fire);
        System.out.println(Utils.BLUE + "\t\t\t\tWe will see you soon!" + Utils.RESET);
    }
}
