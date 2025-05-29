import java.util.ArrayList;

public class DeliShop {


    ArrayList<MenuItem> customerOrder = new ArrayList<>();
    UserInterface ui = new UserInterface();

    public void processMainMenuOption() {

        boolean ifContinue = true;

        do {
            int userHomeAction = ui.displayMainScreen();

            switch (userHomeAction) {
                case 1 -> processOrderOption();
                case 0 -> ifContinue = false;
                default -> System.err.println("ERROR! Please enter a number that is listed!");
            }

        } while (ifContinue);
    }

    public void processOrderOption() {

        boolean ifContinueOrder = true;

        do {

            int userOrderAction = ui.displayOrderScreen();

            //Handling user order menu selection
            switch (userOrderAction) {
                case 0 -> ifContinueOrder = false;
                case 1 -> processAddSandwich();
//                case 2 -> processAddChips();
//                case 3 -> processAddDrink();
                case 4 -> {
//                    processCheckout();
                    ifContinueOrder = false;
                }
                default -> System.err.println("ERROR! Please enter a number that is listed!");
            }
        } while (ifContinueOrder);
    }

    public void processAddSandwich() {

        boolean repeatSandwichCreateMenu = true;
        Sandwich sandwich = new Sandwich();

        do {
            int sandwichMenuOption = ui.displayNewSandwichMenu();

            switch (sandwichMenuOption) {
                case 1 -> {
                    sandwich = new Sandwich();
                    setSandwichSize(sandwich);
//                    addSandwichBread(sandwich);
//                    addSandwichMeat(sandwich);
//                    addSandwichCheese(sandwich);
//                    addExtraToppings(sandwich);
//                    addSauces(sandwich);
//                    toastSandwich(sandwich);

                    repeatSandwichCreateMenu = false;
                }
                case 2 -> {
                    sandwich = new Sandwich("MEDIUM", "White", "Bacon", "Cheddar", "Lettuce Tomato", "Ranch", true, false, false);
                    repeatSandwichCreateMenu = false;
                }
                case 3 -> {
                    sandwich = new Sandwich("MEDIUM", "White", "Steak", "American", "Peppers", "Mayo", true, false, false);
                    repeatSandwichCreateMenu = false;
                }
                default -> System.err.println("ERROR! Please enter a number between 1 and 3!");
            }
        } while (repeatSandwichCreateMenu);
    }

    public void setSandwichSize(Sandwich sandwich) {
        boolean repeatSizeMenu = true;


    }

}
