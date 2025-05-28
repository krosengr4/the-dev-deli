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
//        System.out.println("\n\t\t\t\t" + Utils.sandwich + "SANDWICH MENU" + Utils.sandwich);
//        Utils.printDivider("-", 70);
//        System.out.printf("""
//                        BREADS %s      MEATS %s      CHEESES %s     TOPPINGS         SAUCES \s
//                -----------------------------------------------------------------------------------------
//                        White          Steak         American        Lettuce          Mayo
//                        Wheat          Ham           Provolone       Peppers          Mustard
//                        Rye            Salami        Cheddar         Onions           Ketchup
//                        Wrap           Roast Beef    Swiss           Tomatoes         Ranch
//                                       Chicken                       Jalapeños        Thousand Islands
//                                       Bacon                         Cucumbers        Vinaigrette
//                                                                     Pickles          Au Jus
//                                                                     Guacamole
//                                                                     Mushrooms
//                -----------------------------------------------------------------------------------------
//                SIZES               4"                  8"                  12"
//                """, Utils.bread, Utils.meat, Utils.cheese);

        //todo display pricing somewhere around here

        Sandwich sandwich = MakeSandwich.createSandwich();
//        System.out.println("Sandwich size: " + sandwich.getSize());
//        System.out.println("Sandwich Bread: " + sandwich.getBread());
//        System.out.println("Sandwich meat: " + sandwich.getMeat());
//        System.out.println("Extra Meat?: " + sandwich.isExtraMeat());
//        System.out.println("Sandwich cheese: " + sandwich.getCheese());
//        System.out.println("Extra Cheese?: " + sandwich.isExtraCheese());
//        System.out.println("Sandwich toppings: " + sandwich.getToppings());
//        System.out.println("Sandwich sauces: " + sandwich.getSauces());
//        System.out.printf("Sandwich price: $%.2f\n", sandwich.getValue());

        System.out.printf("\nSuccess! Added %s %s and %s on %s with %s and %s to your order!\n",
                sandwich.getSize().toLowerCase(), sandwich.getMeat(), sandwich.getCheese(), sandwich.getBread(), sandwich.getToppings(), sandwich.getSauces());
        System.out.printf("Total Price: $%.2f\n", sandwich.getValue());

        customerOrder.add(sandwich);
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
