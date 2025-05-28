public class MakeSandwich {

    static Sandwich sandwich;

    public static Sandwich createSandwich() {
        sandwich = new Sandwich();

        setSandwichSize(sandwich);
        addSandwichBread(sandwich);
        addSandwichMeat(sandwich);
        addSandwichCheese(sandwich);
        addExtraToppings(sandwich);
        addSauces(sandwich);
        toastSandwich(sandwich);

        return sandwich;
    }

    private static void setSandwichSize(Sandwich sandwich) {
        boolean repeatSize = true;
        while (repeatSize) {
            System.out.printf("\n\t%s---SIZES---%s\n%s1 - Small (4inch) $5.50\n2 - Medium (8inch) $7.00\n3 - Large (12inch) $8.50%s",
                    Utils.CYAN, Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userSize = Utils.messageAndResponseInt("\nPlease enter the number next to the desired sandwich size: ");

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
            System.out.printf("\n%s---%sBREAD OPTIONS%s---%s\n%s1 - White\n2 - Wheat\n3 - Rye\n4 - Wrap%s", Utils.CYAN, Utils.bread, Utils.bread,
                    Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userBread = Utils.messageAndResponseInt("\nPlease enter the number next to the desired bread: ");

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
            System.out.printf("""
                            
                                       %s---%sMEAT OPTIONS%s---
                            Small: +$1.00 | Medium: +$2.00 | Large: +$3.00%s\
                            
                            %s1 - Steak
                            2 - Ham
                            3 - Salami
                            4 - Roast Beef
                            5 - Chicken
                            6 - Bacon
                            0 - None%s""", Utils.CYAN, Utils.meat, Utils.meat, Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userMeat = Utils.messageAndResponseInt("\nPlease enter the number next to the desired meat: ");

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

            if (userMeat != 0) {

                boolean repeatExtraMeat = true;

                while (repeatExtraMeat) {
                    System.out.printf("\n%sExtra Meat: Small: +$0.50 | Medium: +$1.00 | Large: +$1.50%s", Utils.CYAN, Utils.RESET);
                    String userExtraMeat = Utils.promptGetUserInput("\nWould you like extra meat?(Y or N): ");
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
        }
    }

    private static void addSandwichCheese(Sandwich sandwich) {
        boolean repeatCheese = true;

        while (repeatCheese) {
            System.out.printf("""
                    
                               %s---%sCHEESE OPTIONS%s---
                    Small: +$0.75 | Medium: +$1.50 | Large: +$2.25%s\
                    %s
                    1 - American
                    2 - Provolone
                    3 - Cheddar
                    4 - Swiss
                    0 - None%s""", Utils.CYAN, Utils.cheese, Utils.cheese, Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userCheese = Utils.messageAndResponseInt("\nPlease enter the number next to the desired cheese: ");

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

            if (userCheese != 0) {
                boolean repeatExtraCheese = true;

                while (repeatExtraCheese) {
                    System.out.printf("\n%sExtra Cheese: Small: +$0.30 | Medium: +$0.60 | Large: +$0.90%s", Utils.CYAN, Utils.RESET);
                    String userExtraCheese = Utils.promptGetUserInput("\nWould you like extra cheese? (Y or N): ");
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
        }
    }

    private static void addExtraToppings(Sandwich sandwich) {
        boolean repeatExtraToppings = true;
        StringBuilder toppings = new StringBuilder();

        while (repeatExtraToppings) {
            System.out.printf("""
                                        %s---TOPPINGS OPTIONS---
                                          Toppings are free%s
                                %s1 - Lettuce                 6 - Cucumbers
                                2 - Peppers                 7 - Pickles
                                3 - Onions                  8 - Guacamole
                                4 - Tomatoes                9 - Mushrooms
                                5 - Jalapeños               0 - None%s
                    
                    """, Utils.CYAN, Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userToppings = Utils.messageAndResponseInt("\nPlease enter the number next to the desired topping: ");

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
                String userExtraToppings = Utils.promptGetUserInput("\nWould you like anymore toppings?(Y or N)");

                if (userExtraToppings.equalsIgnoreCase("n")) {
                    repeatExtraToppings = false;
                } else if (userExtraToppings.equalsIgnoreCase("y")) {
                    repeatExtraToppings = true;
                }
            }
        }

        sandwich.setToppings(toppings.toString().trim());
    }

    private static void addSauces(Sandwich sandwich) {
        boolean repeatSauces = true;
        StringBuilder sauces = new StringBuilder();

        while (repeatSauces) {
            System.out.printf("""
                                            %s---SAUCE OPTIONS---
                                              Sauces are free%s
                                %s1 - Mayo                    5 - Thousand Islands
                                2 - Mustard                 6 - Vinaigrette
                                3 - Ketchup                 7 - Au Jus
                                4 - Ranch                   0 - None%s
                    
                    """, Utils.CYAN, Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userSauces = Utils.messageAndResponseInt("\nPlease enter the number next to the desired sauce: ");

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
                String userAddExtraSauce = Utils.promptGetUserInput("\nWould you like to add another sauce? (Y or N): ");

                if (userAddExtraSauce.equalsIgnoreCase("n")) {
                    repeatSauces = false;
                } else if (userAddExtraSauce.equalsIgnoreCase("y")) {
                    repeatSauces = true;
                } else {
                    System.err.println("ERROR! Please enter either y or n!");
                }

            }

        }
        sandwich.setSauces(sauces.toString().trim());
    }

    private static void toastSandwich(Sandwich sandwich) {
        boolean repeatToastOption = true;

        while (repeatToastOption) {
            System.out.printf("\n%sWould you like your sandwich toasted?%s%s%s\n%s1 - yes, toast it!\n2 - no, don't toast it.%s\n",
                    Utils.CYAN, Utils.RESET, Utils.fire, Utils.bread, Utils.YELLOW, Utils.RESET);

            int userToastOption = Utils.messageAndResponseInt("Enter your option: ");

            switch (userToastOption) {
                case 1 -> {
                    sandwich.setToasted(true);
                    repeatToastOption = false;
                }
                case 2 -> {
                    sandwich.setToasted(false);
                    repeatToastOption = false;
                }
                default -> System.err.println("ERROR! Please select either 1 or 2!");
            }

        }
    }
}