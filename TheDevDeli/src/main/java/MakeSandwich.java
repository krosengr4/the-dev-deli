public class MakeSandwich {

    static Sandwich sandwich;







//    //Method to set sandwich size
//    private static void setSandwichSize(Sandwich sandwich) {
//        boolean repeatSize = true;
//        while (repeatSize) {
//
//
//            //handle user choice for size

//        }
//    }
//
//    //Method to set the sandwich bread type
//    private static void addSandwichBread(Sandwich sandwich) {
//        boolean repeatBread = true;
//
//        //Print out options, prompt user for choice
//        while (repeatBread) {

//
//            //Handle user bread choice

//        }
//    }
//
//    //Method to set sandwich meat type and if extra meat
//    private static void addSandwichMeat(Sandwich sandwich) {
//        boolean repeatMeat = true;
//
//        //Print meat options and prompt user for choice
//        while (repeatMeat) {

//
//            //Handle user meat choice
//            switch (userMeat) {

//            }
//
//            }
//        }
//    }
//
//    //Method to set sandwich cheese type and if extra cheese
//    private static void addSandwichCheese(Sandwich sandwich) {
//        boolean repeatCheese = true;
//
//        //Print out cheese choices and prompt user for selection
//        while (repeatCheese) {

//
//            //Handle user cheese selection

//
//    //Method to add toppings to sandwich
//    private static void addExtraToppings(Sandwich sandwich) {
//        boolean repeatExtraToppings = true;
//        StringBuilder toppings = new StringBuilder(); //<--- Use StringBuilder to handle request for extra toppings
//
//        while (repeatExtraToppings) {
//
//            //Print out options for sandwich toppings and prompt user for topping to add to sandwich

//
////            //Handle user request for toppings by appending topping to toppings StringBuilder
//            switch (userToppings) {
//                case 1 -> {
//                    toppings.append("Lettuce ");
//                    repeatExtraToppings = false;
//                }
//                case 2 -> {
//                    toppings.append("Peppers ");
//                    repeatExtraToppings = false;
//                }
//                case 3 -> {
//                    toppings.append("Onions ");
//                    repeatExtraToppings = false;
//                }
//                case 4 -> {
//                    toppings.append("Tomatoes ");
//                    repeatExtraToppings = false;
//                }
//                case 5 -> {
//                    toppings.append("Jalapeños ");
//                    repeatExtraToppings = false;
//                }
//                case 6 -> {
//                    toppings.append("Cucumbers ");
//                    repeatExtraToppings = false;
//                }
//                case 7 -> {
//                    toppings.append("Pickles ");
//                    repeatExtraToppings = false;
//                }
//                case 8 -> {
//                    toppings.append("Guacamole ");
//                    repeatExtraToppings = false;
//                }
//                case 9 -> {
//                    toppings.append("Mushrooms ");
//                    repeatExtraToppings = false;
//                }
//                case 0 -> {
//                    sandwich.setToppings(null);
//                    repeatExtraToppings = false;
//                }
//                default -> System.err.println("ERROR! Enter a number between 0 and 9!");
//            }
//
//            //Ask user if they would like any more toppings and handle response
//            if (userToppings != 0) {
//                String userExtraToppings = Utils.promptGetUserInput("\nWould you like anymore toppings?(Y or N)");
//
//
//            }
//        }
//        //Set sandwich topping(s) to StringBuilder
//        sandwich.setToppings(toppings.toString().trim());
//    }
//
//    //Method to add sauces to sandwich
//    private static void addSauces(Sandwich sandwich) {
//        boolean repeatSauces = true;
//        StringBuilder sauces = new StringBuilder(); //<--- Use StringBuilder to handle request for extra sauces
//
//        while (repeatSauces) {
//            //Print out sauce options and prompt user for which sauce to add

//
//            //Handle user request for which sauce to add using StringBuilder

//
//            //Ask user if they would like any more sauces and handle response
//            if (userSauces != 0) {
//
//

//
//            }
//
//        }
//        //Set sandwich sauce(s) to StringBuilder
//        sandwich.setSauces(sauces.toString().trim());
//    }
//
//    //Method to determine if sandwich toasted or not
//    private static void toastSandwich(Sandwich sandwich) {
//        boolean repeatToastOption = true;
//
//        while (repeatToastOption) {
//            //Ask user if they want sandwich toasted

//

//
//        }
//    }
}