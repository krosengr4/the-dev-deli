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

        Sandwich sandwich = createNewSandwich();
        boolean repeatConfirmation = true;

        do {
            String userSandwichConfirmation = ui.confirmSandwich(sandwich);

            if (userSandwichConfirmation.equalsIgnoreCase("y")) {
                customerOrder.add(sandwich);
                System.out.println(Utils.GREEN + "Huzzah! We have added your sandwich to the order!" + Utils.RESET);

                repeatConfirmation = false;

            } else if (userSandwichConfirmation.equalsIgnoreCase("n")){
                System.out.println("Apologies for the inconvenience. Try and place your sandwich order again.");

                repeatConfirmation = false;

            } else {
                System.err.println("ERROR! Please enter either y or n!");
            }

        } while (repeatConfirmation);

        Utils.pauseApp();
    }

    private Sandwich createNewSandwich() {

        boolean repeatSandwichCreateMenu = true;
        Sandwich sandwich = new Sandwich();

        do {
            int sandwichMenuOption = ui.displayNewSandwichMenu();

            switch (sandwichMenuOption) {
                case 1 -> {
                    sandwich = new Sandwich();
                    setSandwichSize(sandwich);
                    setSandwichBread(sandwich);
                    addSandwichMeat(sandwich);
                    addExtraMeat(sandwich);
                    addSandwichCheese(sandwich);
                    addExtraCheese(sandwich);
                    addSandwichToppings(sandwich);
                    addSandwichSauces(sandwich);
                    setToastSandwichOption(sandwich);

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

        return sandwich;
    }

    public void setSandwichSize(Sandwich sandwich) {
        boolean repeatSizeMenu = true;

        do {
            int userSizeOption = ui.displaySandwichSizeOptions();

            switch (userSizeOption) {
                case 1 -> {
                    sandwich.setSize(Size.SMALL.toString());
                    repeatSizeMenu = false;
                }
                case 2 -> {
                    sandwich.setSize(Size.MEDIUM.toString());
                    repeatSizeMenu = false;
                }
                case 3 -> {
                    sandwich.setSize(Size.LARGE.toString());
                    repeatSizeMenu = false;
                }
                default -> System.err.println("ERROR! Please enter a number between 1 and 3!");
            }
        } while (repeatSizeMenu);
    }

    public void setSandwichBread(Sandwich sandwich) {
        boolean repeatBreadMenu = true;

        do {
            int userBreadOption = ui.displaySandwichBreadOptions();

            switch (userBreadOption) {
                case 1 -> {
                    sandwich.setBread("White");
                    repeatBreadMenu = false;
                }
                case 2 -> {
                    sandwich.setBread("Wheat");
                    repeatBreadMenu = false;
                }
                case 3 -> {
                    sandwich.setBread("Rye");
                    repeatBreadMenu = false;
                }
                case 4 -> {
                    sandwich.setBread("Wrap");
                    repeatBreadMenu = false;
                }
                default -> System.err.println("ERROR! Enter a number between 1 and 4!");
            }
        } while (repeatBreadMenu);
    }

    public void addSandwichMeat(Sandwich sandwich) {
        boolean repeatMeatMenu = true;

        do {

            int userMeatOption = ui.displaySandwichMeatMenu();

            switch (userMeatOption) {
                case 1 -> {
                    sandwich.setMeat("Steak");
                    repeatMeatMenu = false;
                }
                case 2 -> {
                    sandwich.setMeat("Ham");
                    repeatMeatMenu = false;
                }
                case 3 -> {
                    sandwich.setMeat("Salami");
                    repeatMeatMenu = false;
                }
                case 4 -> {
                    sandwich.setMeat("Roast Beef");
                    repeatMeatMenu = false;
                }
                case 5 -> {
                    sandwich.setMeat("Chicken");
                    repeatMeatMenu = false;
                }
                case 6 -> {
                    sandwich.setMeat("Bacon");
                    repeatMeatMenu = false;
                }
                case 0 -> {
                    sandwich.setMeat(null);
                    repeatMeatMenu = false;
                }
                default -> System.err.println("ERROR! Please enter a number between 0 and 6!");
            }

        } while (repeatMeatMenu);
    }

    public void addExtraMeat(Sandwich sandwich) {

        if (sandwich.isHasMeat()) {

            boolean repeatExtraMeat = true;
            do {
                String userExtraMeat = ui.displayExtraMeatOption();

                //Handle extra meat request
                if (userExtraMeat.equalsIgnoreCase("y")) {
                    sandwich.setExtraMeat(true);
                    repeatExtraMeat = false;

                } else if (userExtraMeat.equalsIgnoreCase("n")) {
                    sandwich.setExtraMeat(false);
                    repeatExtraMeat = false;

                } else {
                    System.err.println("ERROR! Please enter either y or n");
                }

            } while (repeatExtraMeat);
        }
    }

    public void addSandwichCheese(Sandwich sandwich) {
        boolean repeatCheeseMenu = true;

        do {
            int userCheeseOption = ui.displaySandwichCheeseOptions();

            switch (userCheeseOption) {
                case 1 -> {
                    sandwich.setCheese("American");
                    repeatCheeseMenu = false;
                }
                case 2 -> {
                    sandwich.setCheese("Provolone");
                    repeatCheeseMenu = false;
                }
                case 3 -> {
                    sandwich.setCheese("Cheddar");
                    repeatCheeseMenu = false;
                }
                case 4 -> {
                    sandwich.setCheese("Swiss");
                    repeatCheeseMenu = false;
                }
                case 0 -> {
                    sandwich.setCheese(null);
                    repeatCheeseMenu = false;
                }
                default -> System.err.println("ERROR! Enter a number between 0 and 4!");
            }

        } while (repeatCheeseMenu);
    }

    public void addExtraCheese(Sandwich sandwich) {

        if (sandwich.isHasCheese()) {
            boolean repeatExtraCheese = true;

            do {
                String userExtraCheese = ui.displayExtraCheeseOption();

                if (userExtraCheese.equalsIgnoreCase("y")) {
                    sandwich.setExtraCheese(true);
                    repeatExtraCheese = false;
                } else if (userExtraCheese.equalsIgnoreCase("n")) {
                    sandwich.setExtraCheese(false);
                    repeatExtraCheese = false;
                } else {
                    System.err.println("ERROR! Please enter either y or n");
                }


            } while (repeatExtraCheese);
        }
    }

    public void addSandwichToppings(Sandwich sandwich) {

        boolean repeatToppingsMenu = true;
        StringBuilder toppings = new StringBuilder(); //<--- Use StringBuilder to handle request for extra toppings

        do {
            int userToppingsOption = ui.displaySandwichToppingsOptions();

            switch (userToppingsOption) {
                case 1 -> {
                    toppings.append("Lettuce ");
                    repeatToppingsMenu = false;
                }
                case 2 -> {
                    toppings.append("Peppers ");
                    repeatToppingsMenu = false;
                }
                case 3 -> {
                    toppings.append("Onions ");
                    repeatToppingsMenu = false;
                }
                case 4 -> {
                    toppings.append("Tomatoes ");
                    repeatToppingsMenu = false;
                }
                case 5 -> {
                    toppings.append("Jalapeños ");
                    repeatToppingsMenu = false;
                }
                case 6 -> {
                    toppings.append("Cucumbers ");
                    repeatToppingsMenu = false;
                }
                case 7 -> {
                    toppings.append("Pickles ");
                    repeatToppingsMenu = false;
                }
                case 8 -> {
                    toppings.append("Guacamole ");
                    repeatToppingsMenu = false;
                }
                case 9 -> {
                    toppings.append("Mushrooms ");
                    repeatToppingsMenu = false;
                }
                case 0 -> {
                    sandwich.setToppings(null);
                    repeatToppingsMenu = false;
                }
                default -> System.err.println("ERROR! Enter a number between 0 and 9!");
            }

            if (userToppingsOption != 0) {
                String userExtraToppings = Utils.promptGetUserInput("\nWould you like anymore toppings?(Y or N)");

                if (userExtraToppings.equalsIgnoreCase("n")) {
                    repeatToppingsMenu = false;
                } else if (userExtraToppings.equalsIgnoreCase("y")) {
                    repeatToppingsMenu = true;
                } else {
                    System.err.println("ERROR! Please enter either y or n!");
                    repeatToppingsMenu = true;
                }
            }

        } while (repeatToppingsMenu);

        sandwich.setToppings(toppings.toString().trim());
    }

    public void addSandwichSauces(Sandwich sandwich) {

        boolean repeatSaucesMenu = true;
        StringBuilder sauces = new StringBuilder();//<--- Use StringBuilder to handle request for extra sauces

        do {
            int userSauceOption = ui.displaySandwichSaucesOptions();

            switch (userSauceOption) {
                case 1 -> {
                    sauces.append("Mayo ");
                    repeatSaucesMenu = false;
                }
                case 2 -> {
                    sauces.append("Mustard ");
                    repeatSaucesMenu = false;
                }
                case 3 -> {
                    sauces.append("Ketchup ");
                    repeatSaucesMenu = false;
                }
                case 4 -> {
                    sauces.append("Ranch ");
                    repeatSaucesMenu = false;
                }
                case 5 -> {
                    sauces.append("Thousand Islands");
                    repeatSaucesMenu = false;
                }
                case 6 -> {
                    sauces.append("Vinaigrette");
                    repeatSaucesMenu = false;
                }
                case 7 -> {
                    sauces.append("Au Jus");
                    repeatSaucesMenu = false;
                }
                case 0 -> {
                    sandwich.setSauces(null);
                    repeatSaucesMenu = false;
                }
                default -> System.err.println("ERROR! Please Enter a number between 0 and 7!");
            }

            if (userSauceOption != 0) {
                String userAddExtraSauce = Utils.promptGetUserInput("\nWould you like to add another sauce? (Y or N): ");

                if (userAddExtraSauce.equalsIgnoreCase("n")) {
                    repeatSaucesMenu = false;
                } else if (userAddExtraSauce.equalsIgnoreCase("y")) {
                    repeatSaucesMenu = true;
                } else {
                    System.err.println("ERROR! Please enter either y or n!");
                    repeatSaucesMenu = true;
                }
            }

        } while (repeatSaucesMenu);

        sandwich.setSauces(sauces.toString());
    }

    public void setToastSandwichOption(Sandwich sandwich) {
        boolean repeatToastMenu = true;

        do {

            int userToastedOption = ui.displayToastedSandwichOptions();

            //Handle user request for toasted or not
            switch (userToastedOption) {
                case 1 -> {
                    sandwich.setToasted(true);
                    repeatToastMenu = false;
                }
                case 2 -> {
                    sandwich.setToasted(false);
                    repeatToastMenu = false;
                }
                default -> System.err.println("ERROR! Please select either 1 or 2!");
            }

        } while (repeatToastMenu);
    }

}
