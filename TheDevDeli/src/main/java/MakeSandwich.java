public class MakeSandwich {

    static Sandwich sandwich;

    //Method to create and return new instance of Sandwich
    public static Sandwich createSandwich() {


        System.out.printf("""
               \s
                            %s---%sSIGNATURE SANDWICHES%s---
                       ___________________________________________%s
                      %sBLT ($10.50)             Philly Cheese Steak ($10.50)
                      -------------             ---------------------------%s \s
                      %s8" White Bread          8" White Bread
                      Bacon                   Steak \s
                      Cheddar                 American Cheese
                      Lettuce                 Peppers
                      Tomato                  Mayo
                      Ranch                   Toasted
                      Toasted%s
               \s""", Utils.CYAN, Utils.sandwich, Utils.sandwich, Utils.RESET, Utils.BLUE, Utils.RESET, Utils.YELLOW, Utils.RESET);

        //Prompt user to choose one of the signature sandwiches, or to create their own
        System.out.println(Utils.CYAN + "\n\t\t\t-----OPTIONS-----" + Utils.RESET);
        System.out.println(Utils.YELLOW + "1 - Create Your Own | 2 - BLT | 3 - Philly Cheese Steak" + Utils.RESET);
        int userSandwichChoice = Utils.messageAndResponseInt("Please Enter your Choice: ");

        //Handle user sandwich choice
        switch (userSandwichChoice) {
            case 1 -> {
                sandwich = new Sandwich();
                setSandwichSize(sandwich);
                addSandwichBread(sandwich);
                addSandwichMeat(sandwich);
                addSandwichCheese(sandwich);
                addExtraToppings(sandwich);
                addSauces(sandwich);
                toastSandwich(sandwich);
            }
            case 2 -> sandwich = new Sandwich("MEDIUM", "White", "Bacon", "Cheddar", "Lettuce Tomato", "Ranch", true, false, false);
            case 3 -> sandwich = new Sandwich("MEDIUM", "White", "Steak", "American", "Peppers", "Mayo", true, false ,false);
            default -> System.err.println("ERROR! Please enter a number between 1 and 3!");
        }
        //Return sandwich customer makes
        return sandwich;
    }

    //Method to set sandwich size
    private static void setSandwichSize(Sandwich sandwich) {
        boolean repeatSize = true;
        while (repeatSize) {
            //print out size options
            System.out.printf("\n\t%s---SIZES---%s\n%s1 - Small (4inch) $5.50\n2 - Medium (8inch) $7.00\n3 - Large (12inch) $8.50%s",
                    Utils.CYAN, Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userSize = Utils.messageAndResponseInt("\nPlease enter the number next to the desired sandwich size: ");

            //handle user choice for size
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
                default -> System.err.println("ERROR! Please enter a number between 1 and 3!");
            }
        }
    }

    //Method to set the sandwich bread type
    private static void addSandwichBread(Sandwich sandwich) {
        boolean repeatBread = true;

        //Print out options, prompt user for choice
        while (repeatBread) {
            System.out.printf("\n%s---%sBREAD OPTIONS%s---%s\n%s1 - White\n2 - Wheat\n3 - Rye\n4 - Wrap%s", Utils.CYAN, Utils.bread, Utils.bread,
                    Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userBread = Utils.messageAndResponseInt("\nPlease enter the number next to the desired bread: ");

            //Handle user bread choice
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
                default -> System.err.println("ERROR! Enter a number between 1 and 4!");

            }
        }
    }

    //Method to set sandwich meat type and if extra meat
    private static void addSandwichMeat(Sandwich sandwich) {
        boolean repeatMeat = true;

        //Print meat options and prompt user for choice
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

            //Handle user meat choice
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
                default -> System.err.println("ERROR! Please enter a number between 0 and 6!");
            }

            if (userMeat != 0) {
                boolean repeatExtraMeat = true;

                while (repeatExtraMeat) {
                    //Prompt user if they want extra meat
                    System.out.printf("\n%sExtra Meat: Small: +$0.50 | Medium: +$1.00 | Large: +$1.50%s", Utils.CYAN, Utils.RESET);
                    String userExtraMeat = Utils.promptGetUserInput("\nWould you like extra meat?(Y or N): ");

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
                }
            }
        }
    }

    //Method to set sandwich cheese type and if extra cheese
    private static void addSandwichCheese(Sandwich sandwich) {
        boolean repeatCheese = true;

        //Print out cheese choices and prompt user for selection
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

            //Handle user cheese selection
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
                default -> System.err.println("ERROR! Enter a number between 0 and 4!");
            }

            if (userCheese != 0) {
                boolean repeatExtraCheese = true;

                while (repeatExtraCheese) {
                    //Prompt user if they want extra cheese
                    System.out.printf("\n%sExtra Cheese: Small: +$0.30 | Medium: +$0.60 | Large: +$0.90%s", Utils.CYAN, Utils.RESET);
                    String userExtraCheese = Utils.promptGetUserInput("\nWould you like extra cheese? (Y or N): ");

                    //Handle user request for extra cheese
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

    //Method to add toppings to sandwich
    private static void addExtraToppings(Sandwich sandwich) {
        boolean repeatExtraToppings = true;
        StringBuilder toppings = new StringBuilder(); //<--- Use StringBuilder to handle request for extra toppings

        while (repeatExtraToppings) {

            //Print out options for sandwich toppings and prompt user for topping to add to sandwich
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

            //Handle user request for toppings by appending topping to toppings StringBuilder
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
                default -> System.err.println("ERROR! Enter a number between 0 and 9!");
            }

            //Ask user if they would like any more toppings and handle response
            if (userToppings != 0) {
                String userExtraToppings = Utils.promptGetUserInput("\nWould you like anymore toppings?(Y or N)");

                if (userExtraToppings.equalsIgnoreCase("n")) {
                    repeatExtraToppings = false;
                } else if (userExtraToppings.equalsIgnoreCase("y")) {
                    repeatExtraToppings = true;
                }
            }
        }
        //Set sandwich topping(s) to StringBuilder
        sandwich.setToppings(toppings.toString().trim());
    }

    //Method to add sauces to sandwich
    private static void addSauces(Sandwich sandwich) {
        boolean repeatSauces = true;
        StringBuilder sauces = new StringBuilder(); //<--- Use StringBuilder to handle request for extra sauces

        while (repeatSauces) {
            //Print out sauce options and prompt user for which sauce to add
            System.out.printf("""
                                            %s---SAUCE OPTIONS---
                                              Sauces are free%s
                                %s1 - Mayo                    5 - Thousand Islands
                                2 - Mustard                 6 - Vinaigrette
                                3 - Ketchup                 7 - Au Jus
                                4 - Ranch                   0 - None%s
                    
                    """, Utils.CYAN, Utils.RESET, Utils.YELLOW, Utils.RESET);
            int userSauces = Utils.messageAndResponseInt("\nPlease enter the number next to the desired sauce: ");

            //Handle user request for which sauce to add using StringBuilder
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
                default -> System.err.println("ERROR! Please Enter a number between 0 and 7!");
            }

            //Ask user if they would like any more sauces and handle response
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
        //Set sandwich sauce(s) to StringBuilder
        sandwich.setSauces(sauces.toString().trim());
    }

    //Method to determine if sandwich toasted or not
    private static void toastSandwich(Sandwich sandwich) {
        boolean repeatToastOption = true;

        while (repeatToastOption) {
            //Ask user if they want sandwich toasted
            System.out.printf("\n%sWould you like your sandwich toasted?%s%s%s\n%s1 - yes, toast it!\n2 - no, don't toast it.%s\n",
                    Utils.CYAN, Utils.RESET, Utils.fire, Utils.bread, Utils.YELLOW, Utils.RESET);

            int userToastOption = Utils.messageAndResponseInt("Enter your option: ");

            //Handle user request for toasted or not
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