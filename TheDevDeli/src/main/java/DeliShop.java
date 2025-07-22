//import models.enums.Size;
//import models.Sandwich;
//import utils.Utils;
//
//import java.util.ArrayList;
//
////! Class that handles all logic of application
//public class DeliShop {
//
//    ArrayList<MenuItem> customerOrder = new ArrayList<>();
//    DeathRowClass ui = new DeathRowClass();
//
//    public void processMainMenuOption() {
//
//        boolean ifContinue = true;
//
//        do {
//            int userHomeAction = ui.displayMainScreen();
//
//            switch (userHomeAction) {
//                case 1 -> processOrderOption();
//                case 0 -> ifContinue = false;
//                default -> System.err.println("ERROR! Please enter a number that is listed!");
//            }
//
//        } while (ifContinue);
//    }
//
//    public void processOrderOption() {
//
//        boolean ifContinueOrder = true;
//
//        do {
//            int userOrderAction = ui.displayOrderScreen();
//
//            //Handling user order menu selection
//            switch (userOrderAction) {
//                case 0 -> ifContinueOrder = false;
//                case 1 -> processAddSandwich();
//                case 2 -> processAddChips();
//                case 3 -> processAddDrink();
//                case 4 -> {
//                    processCheckout();
//                    ifContinueOrder = false;
//                }
//                default -> System.err.println("ERROR! Please enter a number that is listed!");
//            }
//        } while (ifContinueOrder);
//    }
//
//    private void processAddSandwich() {
//
//        Sandwich sandwich = createNewSandwich();
//        boolean repeatConfirmation = true;
//
//        do {
//            String userSandwichConfirmation = ui.confirmSandwich(sandwich);
//
//            if (userSandwichConfirmation.equalsIgnoreCase("y")) {
//                customerOrder.add(sandwich);
//                System.out.println(Utils.GREEN + "Huzzah! We have added your sandwich to the order!" + Utils.RESET);
//                Utils.playSound("owin31.wav");
//
//                repeatConfirmation = false;
//
//            } else if (userSandwichConfirmation.equalsIgnoreCase("n")) {
//                System.out.println("Apologies for the inconvenience. Try and place your sandwich order again.");
//                Utils.playSound("womp-womp.wav");
//
//                repeatConfirmation = false;
//
//            } else {
//                System.err.println("ERROR! Please enter either y or n!");
//            }
//
//        } while (repeatConfirmation);
//
//        Utils.pauseApp();
//    }
//
//    private void processAddChips() {
//
//        boolean repeatChipMenu = true;
//        Chips chips = new Chips();
//
//        while (repeatChipMenu) {
//
//            setChipType(chips);
//
//            customerOrder.add(chips);
//            System.out.println(Utils.GREEN + "\nWe have added a bag of " + chips.getName() + " to your order!" + Utils.RESET);
//            Utils.playSound("owin31.wav");
//
//            boolean repeatAddAnotherOption = true;
//
//            while (repeatAddAnotherOption) {
//
//                String addAnotherChipOption = ui.displayAddAnotherMessage();
//
//                if (addAnotherChipOption.equalsIgnoreCase("n")) {
//                    repeatChipMenu = false;
//                    repeatAddAnotherOption = false;
//                } else if (addAnotherChipOption.equalsIgnoreCase("y")) {
//                    repeatAddAnotherOption = false;
//                } else {
//                    System.err.println("ERROR! Please enter Y or N!");
//                }
//            }
//
//        }
//    }
//
//    private void processAddDrink() {
//
//        Drink drink = new Drink();
//        boolean repeatDrinkMenu = true;
//
//        while (repeatDrinkMenu) {
//            setDrinkType(drink);
//            setDrinkSize(drink);
//
//            customerOrder.add(drink);
//            System.out.println(Utils.GREEN + "\nSuccess! A " + drink.getSize() + " " + drink.getName() + " has been added to your order!" + Utils.RESET);
//            Utils.playSound("owin31.wav");
//
//            boolean repeatAddAnotherMenu = true;
//
//            while (repeatAddAnotherMenu) {
//
//                String userAddAnotherOption = ui.displayAddAnotherMessage();
//
//                if (userAddAnotherOption.equalsIgnoreCase("n")) {
//                    repeatDrinkMenu = false;
//                    repeatAddAnotherMenu = false;
//                } else if (userAddAnotherOption.equalsIgnoreCase("y")) {
//                    repeatAddAnotherMenu = false;
//                } else {
//                    System.err.println("ERROR! Please enter either Y or N!");
//                }
//            }
//        }
//
//    }
//
//    private void processCheckout() {
//
//        String customerName = Utils.getUserInput("Enter a name for your order: ");
//        Order order = new Order(customerOrder, customerName);
//
//        boolean repeatOrderConfirmation = true;
//
//        while (repeatOrderConfirmation) {
//            String customerOrderConfirmation = ui.displayAndConfirmOrder(order);
//
//            if (customerOrderConfirmation.equalsIgnoreCase("y")) {
//                order.saveOrder();
//                repeatOrderConfirmation = false;
//            } else if (customerOrderConfirmation.equalsIgnoreCase("n")) {
//                customerOrder.clear();
//                System.out.println("Apologies for the inconvenience. Try and place your order again.");
//                Utils.playSound("womp-womp.wav");
//                repeatOrderConfirmation = false;
//            } else {
//                System.err.println("ERROR! Only enter either Y or N!");
//            }
//        }
//
//    }
//
//    public void setChipType(Chips chips) {
//
//        boolean repeatChipMenu = true;
//
//        while (repeatChipMenu) {
//
//            int userChipOption = ui.displayChipOptions();
//
//            switch (userChipOption) {
//                case 1 -> {
//                    chips.setName("Doritos Nacho Cheese");
//                    repeatChipMenu = false;
//                }
//                case 2 -> {
//                    chips.setName("Lays Classic");
//                    repeatChipMenu = false;
//                }
//                case 3 -> {
//                    chips.setName("Miss Vickies Jalapeño");
//                    repeatChipMenu = false;
//                }
//                case 4 -> {
//                    chips.setName("Ruffles Original");
//                    repeatChipMenu = false;
//                }
//                case 5 -> {
//                    chips.setName("Cheetos");
//                    repeatChipMenu = false;
//                }
//                default -> System.err.println("ERROR! Please enter a number listed on the screen!");
//            }
//        }
//    }
//
//    //Handle customer drink type request
//    public void setDrinkType(Drink drink) {
//        boolean repeatDrinkMenu = true;
//
//        while (repeatDrinkMenu) {
//
//            int userDrinkTypeChoice = ui.displayDrinkOptions();
//
//            switch (userDrinkTypeChoice) {
//                case 1 -> {
//                    drink.setName("Fountain Drink");
//                    repeatDrinkMenu = false;
//                }
//                case 2 -> {
//                    drink.setName("Lemonade");
//                    repeatDrinkMenu = false;
//                }
//                case 3 -> {
//                    drink.setName("Sweet Tea");
//                    repeatDrinkMenu = false;
//                }
//                case 4 -> {
//                    drink.setName("Unsweetened Tea");
//                    repeatDrinkMenu = false;
//                }
//                case 5 -> {
//                    drink.setName("MilkShake");
//                    repeatDrinkMenu = false;
//                }
//                default -> System.err.println("ERROR! Please enter a number that is listed on the screen!");
//            }
//        }
//    }
//
//    //Set the size of the drink
//    public void setDrinkSize(Drink drink) {
//        boolean repeatDrinkSizes = true;
//
//        while (repeatDrinkSizes) {
//
//            int userDrinkSizeChoice = ui.displayDrinkSizes();
//
//            switch (userDrinkSizeChoice) {
//                case 1 -> {
//                    drink.setSize(Size.SMALL.toString());
//                    repeatDrinkSizes = false;
//                }
//                case 2 -> {
//                    drink.setSize(Size.MEDIUM.toString());
//                    repeatDrinkSizes = false;
//                }
//                case 3 -> {
//                    drink.setSize(Size.LARGE.toString());
//                    repeatDrinkSizes = false;
//                }
//                default -> System.err.println("ERROR! Please enter a number listed on the screen!");
//            }
//        }
//    }
//
//    private Sandwich createNewSandwich() {
//
//        boolean repeatSandwichCreateMenu = true;
//        Sandwich sandwich = new Sandwich();
//
//        do {
//            int sandwichMenuOption = ui.displayNewSandwichMenu();
//
//            switch (sandwichMenuOption) {
//                case 1 -> {
//                    sandwich = new Sandwich();
//                    setSandwichSize(sandwich);
//                    setSandwichBread(sandwich);
//                    addSandwichMeat(sandwich);
//                    addExtraMeat(sandwich);
//                    addSandwichCheese(sandwich);
//                    addExtraCheese(sandwich);
//                    addSandwichToppings(sandwich);
//                    addSandwichSauces(sandwich);
//                    setToastSandwichOption(sandwich);
//
//                    repeatSandwichCreateMenu = false;
//                }
//                case 2 -> {
//                    sandwich = new Sandwich("MEDIUM", "White", "Bacon", "Cheddar", "Lettuce Tomato", "Ranch", true, false, false);
//                    repeatSandwichCreateMenu = false;
//                }
//                case 3 -> {
//                    sandwich = new Sandwich("MEDIUM", "White", "Steak", "American", "Peppers", "Mayo", true, false, false);
//                    repeatSandwichCreateMenu = false;
//                }
//                default -> System.err.println("ERROR! Please enter a number that is listed on the screen!");
//            }
//        } while (repeatSandwichCreateMenu);
//
//        return sandwich;
//    }
//
//    private void setSandwichSize(Sandwich sandwich) {
//        boolean repeatSizeMenu = true;
//
//        do {
//            int userSizeOption = ui.displaySandwichSizeOptions();
//
//            switch (userSizeOption) {
//                case 1 -> {
//                    sandwich.setSize(Size.SMALL.toString());
//                    repeatSizeMenu = false;
//                }
//                case 2 -> {
//                    sandwich.setSize(Size.MEDIUM.toString());
//                    repeatSizeMenu = false;
//                }
//                case 3 -> {
//                    sandwich.setSize(Size.LARGE.toString());
//                    repeatSizeMenu = false;
//                }
//                default -> System.err.println("ERROR! Please enter a number that is listed on the screen!");
//            }
//        } while (repeatSizeMenu);
//    }
//
//    private void setSandwichBread(Sandwich sandwich) {
//        boolean repeatBreadMenu = true;
//
//        do {
//            int userBreadOption = ui.displaySandwichBreadOptions();
//
//            switch (userBreadOption) {
//                case 1 -> {
//                    sandwich.setBread("White");
//                    repeatBreadMenu = false;
//                }
//                case 2 -> {
//                    sandwich.setBread("Wheat");
//                    repeatBreadMenu = false;
//                }
//                case 3 -> {
//                    sandwich.setBread("Rye");
//                    repeatBreadMenu = false;
//                }
//                case 4 -> {
//                    sandwich.setBread("Wrap");
//                    repeatBreadMenu = false;
//                }
//                default -> System.err.println("ERROR! Enter a number that is listed on the screen!");
//            }
//        } while (repeatBreadMenu);
//    }
//
//    private void addSandwichMeat(Sandwich sandwich) {
//        boolean repeatMeatMenu = true;
//
//        do {
//
//            int userMeatOption = ui.displaySandwichMeatMenu();
//
//            switch (userMeatOption) {
//                case 1 -> {
//                    sandwich.setMeat("Steak");
//                    repeatMeatMenu = false;
//                }
//                case 2 -> {
//                    sandwich.setMeat("Ham");
//                    repeatMeatMenu = false;
//                }
//                case 3 -> {
//                    sandwich.setMeat("Salami");
//                    repeatMeatMenu = false;
//                }
//                case 4 -> {
//                    sandwich.setMeat("Roast Beef");
//                    repeatMeatMenu = false;
//                }
//                case 5 -> {
//                    sandwich.setMeat("Chicken");
//                    repeatMeatMenu = false;
//                }
//                case 6 -> {
//                    sandwich.setMeat("Bacon");
//                    repeatMeatMenu = false;
//                }
//                case 0 -> {
//                    sandwich.setMeat(null);
//                    repeatMeatMenu = false;
//                }
//                default -> System.err.println("ERROR! Please enter a number that is listed on the screen!");
//            }
//
//        } while (repeatMeatMenu);
//    }
//
//    private void addExtraMeat(Sandwich sandwich) {
//
//        if (sandwich.isHasMeat()) {
//
//            boolean repeatExtraMeat = true;
//            do {
//                String userExtraMeat = ui.displayExtraMeatOption();
//
//                //Handle extra meat request
//                if (userExtraMeat.equalsIgnoreCase("y")) {
//                    sandwich.setExtraMeat(true);
//                    repeatExtraMeat = false;
//
//                } else if (userExtraMeat.equalsIgnoreCase("n")) {
//                    sandwich.setExtraMeat(false);
//                    repeatExtraMeat = false;
//
//                } else {
//                    System.err.println("ERROR! Please enter either y or n");
//                }
//
//            } while (repeatExtraMeat);
//        }
//    }
//
//    private void addSandwichCheese(Sandwich sandwich) {
//        boolean repeatCheeseMenu = true;
//
//        do {
//            int userCheeseOption = ui.displaySandwichCheeseOptions();
//
//            switch (userCheeseOption) {
//                case 1 -> {
//                    sandwich.setCheese("American");
//                    repeatCheeseMenu = false;
//                }
//                case 2 -> {
//                    sandwich.setCheese("Provolone");
//                    repeatCheeseMenu = false;
//                }
//                case 3 -> {
//                    sandwich.setCheese("Cheddar");
//                    repeatCheeseMenu = false;
//                }
//                case 4 -> {
//                    sandwich.setCheese("Swiss");
//                    repeatCheeseMenu = false;
//                }
//                case 0 -> {
//                    sandwich.setCheese(null);
//                    repeatCheeseMenu = false;
//                }
//                default -> System.err.println("ERROR! Enter a number that is listed on the screen!");
//            }
//
//        } while (repeatCheeseMenu);
//    }
//
//    private void addExtraCheese(Sandwich sandwich) {
//
//        if (sandwich.isHasCheese()) {
//            boolean repeatExtraCheese = true;
//
//            do {
//                String userExtraCheese = ui.displayExtraCheeseOption();
//
//                if (userExtraCheese.equalsIgnoreCase("y")) {
//                    sandwich.setExtraCheese(true);
//                    repeatExtraCheese = false;
//                } else if (userExtraCheese.equalsIgnoreCase("n")) {
//                    sandwich.setExtraCheese(false);
//                    repeatExtraCheese = false;
//                } else {
//                    System.err.println("ERROR! Please enter either y or n");
//                }
//
//
//            } while (repeatExtraCheese);
//        }
//    }
//
//    private void addSandwichToppings(Sandwich sandwich) {
//
//        boolean repeatToppingsMenu = true;
//        StringBuilder toppings = new StringBuilder(); //<--- Use StringBuilder to handle request for extra toppings
//
//        do {
//            int userToppingsOption = ui.displaySandwichToppingsOptions();
//
//            switch (userToppingsOption) {
//                case 1 -> {
//                    toppings.append("Lettuce ");
//                    repeatToppingsMenu = false;
//                }
//                case 2 -> {
//                    toppings.append("Peppers ");
//                    repeatToppingsMenu = false;
//                }
//                case 3 -> {
//                    toppings.append("Onions ");
//                    repeatToppingsMenu = false;
//                }
//                case 4 -> {
//                    toppings.append("Tomatoes ");
//                    repeatToppingsMenu = false;
//                }
//                case 5 -> {
//                    toppings.append("Jalapeños ");
//                    repeatToppingsMenu = false;
//                }
//                case 6 -> {
//                    toppings.append("Cucumbers ");
//                    repeatToppingsMenu = false;
//                }
//                case 7 -> {
//                    toppings.append("Pickles ");
//                    repeatToppingsMenu = false;
//                }
//                case 8 -> {
//                    toppings.append("Guacamole ");
//                    repeatToppingsMenu = false;
//                }
//                case 9 -> {
//                    toppings.append("Mushrooms ");
//                    repeatToppingsMenu = false;
//                }
//                case 0 -> {
//                    sandwich.setToppings(null);
//                    repeatToppingsMenu = false;
//                }
//                default -> System.err.println("ERROR! Enter a number that is listed on the screen!");
//            }
//
//            if (userToppingsOption != 0) {
//                String userExtraToppings = Utils.getUserInput("\nWould you like anymore toppings?(Y or N)");
//
//                if (userExtraToppings.equalsIgnoreCase("n")) {
//                    repeatToppingsMenu = false;
//                } else if (userExtraToppings.equalsIgnoreCase("y")) {
//                    repeatToppingsMenu = true;
//                } else {
//                    System.err.println("ERROR! Please enter either y or n!");
//                    repeatToppingsMenu = true;
//                }
//            }
//
//        } while (repeatToppingsMenu);
//
//        sandwich.setToppings(toppings.toString().trim());
//    }
//
//    private void addSandwichSauces(Sandwich sandwich) {
//
//        boolean repeatSaucesMenu = true;
//        StringBuilder sauces = new StringBuilder();//<--- Use StringBuilder to handle request for extra sauces
//
//        do {
//            int userSauceOption = ui.displaySandwichSaucesOptions();
//
//            switch (userSauceOption) {
//                case 1 -> {
//                    sauces.append("Mayo ");
//                    repeatSaucesMenu = false;
//                }
//                case 2 -> {
//                    sauces.append("Mustard ");
//                    repeatSaucesMenu = false;
//                }
//                case 3 -> {
//                    sauces.append("Ketchup ");
//                    repeatSaucesMenu = false;
//                }
//                case 4 -> {
//                    sauces.append("Ranch ");
//                    repeatSaucesMenu = false;
//                }
//                case 5 -> {
//                    sauces.append("Thousand Islands");
//                    repeatSaucesMenu = false;
//                }
//                case 6 -> {
//                    sauces.append("Vinaigrette");
//                    repeatSaucesMenu = false;
//                }
//                case 7 -> {
//                    sauces.append("Au Jus");
//                    repeatSaucesMenu = false;
//                }
//                case 0 -> {
//                    sandwich.setSauces(null);
//                    repeatSaucesMenu = false;
//                }
//                default -> System.err.println("ERROR! Please Enter a number that is listed on the screen!");
//            }
//
//            if (userSauceOption != 0) {
//                String userAddExtraSauce = Utils.getUserInput("\nWould you like to add another sauce? (Y or N): ");
//
//                if (userAddExtraSauce.equalsIgnoreCase("n")) {
//                    repeatSaucesMenu = false;
//                } else if (userAddExtraSauce.equalsIgnoreCase("y")) {
//                    repeatSaucesMenu = true;
//                } else {
//                    System.err.println("ERROR! Please enter either y or n!");
//                    repeatSaucesMenu = true;
//                }
//            }
//
//        } while (repeatSaucesMenu);
//
//        sandwich.setSauces(sauces.toString());
//    }
//
//    private void setToastSandwichOption(Sandwich sandwich) {
//        boolean repeatToastMenu = true;
//
//        do {
//
//            int userToastedOption = ui.displayToastedSandwichOptions();
//
//            //Handle user request for toasted or not
//            switch (userToastedOption) {
//                case 1 -> {
//                    sandwich.setToasted(true);
//                    repeatToastMenu = false;
//                }
//                case 2 -> {
//                    sandwich.setToasted(false);
//                    repeatToastMenu = false;
//                }
//                default -> System.err.println("ERROR! Please select either 1 or 2!");
//            }
//
//        } while (repeatToastMenu);
//    }
//
//}
