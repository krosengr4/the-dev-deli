public class MakeSandwich {

    static Sandwich sandwich;

    public static Sandwich createSandwich() {
        sandwich = new Sandwich();
        setSandwichSize(sandwich);
        addSandwichBread(sandwich);
        addSandwichMeat(sandwich);
        addSandwichCheese(sandwich);
        addExtraToppings(sandwich);

        return sandwich;
    }

    private static void setSandwichSize(Sandwich sandwich) {
        boolean repeatSize = true;
        while (repeatSize) {
            System.out.println("\n\n---SIZES---\n1 - Small  |  2 - Medium  |  3 - Large");
            int userSize = Utils.messageAndResponseInt("Please enter the number next to the desired sandwich size: ");

            switch (userSize) {
                case 1 -> {
                    sandwich.setSize(Size.SMALL.toString());
                    repeatSize = false;
                }
                case 2 -> {
                    sandwich.setSize(Size.MEDIUM.toString());
                    repeatSize = false;
                }
                case 3 -> {
                    sandwich.setSize(Size.LARGE.toString());
                    repeatSize = false;
                }
                default -> System.err.println("ERROR! Invalid sandwich size!");
            }
        }
    }

    private static void addSandwichBread(Sandwich sandwich) {
        boolean repeatBread = true;

        while (repeatBread) {
            System.out.println(Utils.bread + "---BREAD OPTIONS---\n1 - White\n2 - Wheat\n3 - Rye\n4 - Wrap");
            int userBread = Utils.messageAndResponseInt("Please enter the number next to the desired bread: ");

            switch (userBread) {
                case 1 -> {
                    sandwich.setBread("White");
                    repeatBread = false;
                }
                case 2 -> {
                    sandwich.setBread("Wheat");
                    repeatBread = false;
                }
                case 3 -> {
                    sandwich.setBread("Rye");
                    repeatBread = false;
                }
                case 4 -> {
                    sandwich.setBread("Wrap");
                    repeatBread = false;
                }
                default -> System.err.println("ERROR! Invalid bread!");

            }
        }
    }

    private static void addSandwichMeat(Sandwich sandwich) {
        boolean repeatMeat = true;

        while (repeatMeat) {
            System.out.println(Utils.meat + "---MEAT OPTIONS---\n1 - Steak\n2 - Ham\n3 - Salami\n4 - Roast Beef\n5 - Chicken\n6 - Bacon\n0 - None");
            int userMeat = Utils.messageAndResponseInt("Please enter the number next to the desired meat: ");

            switch (userMeat) {
                case 1 -> {
                    sandwich.setMeat("Steak");
                    repeatMeat = false;
                }
                case 2 -> {
                    sandwich.setMeat("Ham");
                    repeatMeat = false;
                }
                case 3 -> {
                    sandwich.setMeat("Salami");
                    repeatMeat = false;
                }
                case 4 -> {
                    sandwich.setMeat("Roast Beef");
                    repeatMeat = false;
                }
                case 5 -> {
                    sandwich.setMeat("Chicken");
                    repeatMeat = false;
                }
                case 6 -> {
                    sandwich.setMeat("Bacon");
                    repeatMeat = false;
                }
                case 0 -> {
                    sandwich.setMeat(null);
                    repeatMeat = false;
                }
                default -> System.err.println("ERROR! Invalid meat!");
            }
        }

        boolean repeatExtraMeat = true;

        while (repeatExtraMeat) {
            String userExtraMeat = Utils.promptGetUserInput("Would you like extra meat?(Y or N): ");
            if (userExtraMeat.equalsIgnoreCase("y")) {
                sandwich.setExtraMeat(true);
                repeatExtraMeat = false;
            } else if (userExtraMeat.equalsIgnoreCase("n")) {
                sandwich.setExtraMeat(false);
                repeatExtraMeat = false;
            } else {
                System.err.println("ERROR! Please enter either y or n");
            }
        }
    }

    private static void addSandwichCheese(Sandwich sandwich) {
        boolean repeatCheese = true;

        while (repeatCheese) {
            System.out.println(Utils.cheese + "---CHEESE OPTIONS---\n1 - American\n2 - Provolone\n3 - Cheddar\n4 - Swiss\n0 - None");
            int userCheese = Utils.messageAndResponseInt("Please enter the number next to the desired cheese: ");

            switch (userCheese) {
                case 1 -> {
                    sandwich.setCheese("American");
                    repeatCheese = false;
                }
                case 2 -> {
                    sandwich.setCheese("Provolone");
                    repeatCheese = false;
                }
                case 3 -> {
                    sandwich.setCheese("Cheddar");
                    repeatCheese = false;
                }
                case 4 -> {
                    sandwich.setCheese("Swiss");
                    repeatCheese = false;
                }
                case 0 -> {
                    sandwich.setCheese(null);
                    repeatCheese = false;
                }
                default -> System.err.println("ERROR! Invalid Cheese!");
            }
        }

        boolean repeatExtraCheese = true;

        while (repeatExtraCheese) {
            String userExtraCheese = Utils.promptGetUserInput("Would you like extra cheese? (Y or N): ");
            if (userExtraCheese.equalsIgnoreCase("y")) {
                sandwich.setExtraCheese(true);
                repeatExtraCheese = false;
            } else if (userExtraCheese.equalsIgnoreCase("n")) {
                sandwich.setExtraCheese(false);
                repeatExtraCheese = false;
            } else {
                System.err.println("ERROR! Please enter either y or n");
            }
        }
    }

    private static void addExtraToppings(Sandwich sandwich) {
        boolean repeatExtraToppings = true;
        StringBuilder toppings = new StringBuilder();

        while (repeatExtraToppings) {
            System.out.println("""
                                        "---TOPPINGS OPTIONS---
                                1 - Lettuce                 6 - Cucumbers
                                2 - Peppers                 7 - Pickles
                                3 - Onions                  8 - Guacamole
                                4 - Tomatoes                9 - Mushrooms
                                5 - Jalapeños               0 - None
                    
                    """);
            int userToppings = Utils.messageAndResponseInt("Please enter the number next to the desired topping: ");

            switch (userToppings) {
                case 1 -> {
                    toppings.append("Lettuce ");
                    repeatExtraToppings = false;
                }
                case 2 -> {
                    toppings.append("Peppers ");
                    repeatExtraToppings = false;
                }
                case 3 -> {
                    toppings.append("Onions ");
                    repeatExtraToppings = false;
                }
                case 4 -> {
                    toppings.append("Tomatoes ");
                    repeatExtraToppings = false;
                }
                case 5 -> {
                    toppings.append("Jalapeños ");
                    repeatExtraToppings = false;
                }
                case 6 -> {
                    toppings.append("Cucumbers ");
                    repeatExtraToppings = false;
                }
                case 7 -> {
                    toppings.append("Pickles ");
                    repeatExtraToppings = false;
                }
                case 8 -> {
                    toppings.append("Guacamole ");
                    repeatExtraToppings = false;
                }
                case 9 -> {
                    toppings.append("Mushrooms ");
                    repeatExtraToppings = false;
                }
                case 0 -> {
                    sandwich.setToppings(null);
                    repeatExtraToppings = false;
                }
                default -> System.err.println("ERROR! Invalid topping!");
            }

            if (userToppings != 0) {
                String userExtraToppings = Utils.promptGetUserInput("Would you like anymore toppings?(Y or N)");

                if (userExtraToppings.equalsIgnoreCase("n")) {
                    repeatExtraToppings = false;
                } else if (!userExtraToppings.equalsIgnoreCase("y")) {
                    System.err.println("ERROR! Please enter either y or n!");
                }
            }
        }

        sandwich.setToppings(toppings.toString().trim());
    }

    private static void addSauces(Sandwich sandwich) {
        boolean repeatSauces = true;
        StringBuilder sauces = new StringBuilder();

        while (repeatSauces) {
            System.out.println("""
                                        "---SAUCE OPTIONS---
                                1 - Mayo                    5 - Thousand Islands
                                2 - Mustard                 6 - Vinaigrette
                                3 - Ketchup                 7 -  Au Jus
                                4 - Ranch                   0 - None
                    
                    """);
            int userSauces = Utils.messageAndResponseInt("Please enter the number next to the desired sauce: ");

            switch (userSauces) {
                case 1 -> {
                    sauces.append("Mayo ");
                    repeatSauces = false;
                }
                case 2 -> {
                    sauces.append("Mustard ");
                    repeatSauces = false;
                }
                case 3 -> {
                    sauces.append("Ketchup ");
                    repeatSauces = false;
                }
                case 4 -> {
                    sauces.append("Ranch ");
                    repeatSauces = false;
                }
                case 5 -> {
                    sauces.append("Thousand Islands");
                    repeatSauces = false;
                }
                case 6 -> {
                    sauces.append("Vinaigrette");
                    repeatSauces = false;
                }
                case 7 -> {
                    sauces.append("Au Jus");
                    repeatSauces = false;
                }
                case 0 -> {
                    sandwich.setSauces(null);
                    repeatSauces = false;
                }
            }
            if (userSauces != 0) {
                String userAddExtraSauce = Utils.promptGetUserInput("Would you like to add another sauce? (Y or N): ");

                if (userAddExtraSauce.equalsIgnoreCase("n")) {
                    repeatSauces = false;
                } else if (!userAddExtraSauce.equalsIgnoreCase("y")) {
                    System.err.println("ERROR! Please enter either y or n!");
                }

            }

        }
        sandwich.setSauces(sauces.toString().trim());
    }
}