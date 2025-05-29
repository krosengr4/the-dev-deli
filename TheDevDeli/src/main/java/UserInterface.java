import java.util.ArrayList;

//! Class that handles all user interface of application
public class UserInterface {

    //List that will store the menu items a customer has ordered
    ArrayList<MenuItem> customerOrder = new ArrayList<>();

    //Method that will display the Main Menu of the application
    public int displayMainScreen() {
        //Create new instance of DeliStore
        UserInterface ui = new UserInterface();

        //Print out Main Menu
        System.out.printf("""
                                             \s
                                             %sMAIN MENU:
                                ----------------------------------%s
                              %s1 - Place an Order%s        %s0 - Exit%s
                
                \s""", Utils.BLUE, Utils.RESET, Utils.GREEN, Utils.RESET, Utils.RED, Utils.RESET);

        return Utils.messageAndResponseInt("Enter 1 or 0: ");
    }

    //Method that displays order screen options
    public int displayOrderScreen() {
        //Printing out order menu
        System.out.printf("""
                                                          \s
                                                          %sORDER
                                    -------------------------------------------------%s
                                    %s1 - Order a Sandwich%s%s          %s3 - Add a Drink%s%s
                                    %s2 - Add Chips%s%s                 %s4 - Checkout%s
                        
                                                  %s0 - Cancel Order%s
                                                  \s
                        """, Utils.BLUE, Utils.RESET, Utils.PURPLE, Utils.RESET, Utils.sandwich, Utils.CYAN, Utils.RESET, Utils.drink, Utils.YELLOW, Utils.RESET,
                Utils.chips, Utils.GREEN, Utils.RESET, Utils.RED, Utils.RESET);

        //Getting and returning user order menu selection
        return Utils.messageAndResponseInt("Enter Your Option: ");
    }

    //Method to display signature sandwiches and get user sandwich option
    public int displayNewSandwichMenu() {

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
        return Utils.messageAndResponseInt("Please Enter your Choice: ");
    }

    public int displaySandwichSizeOptions() {
        //print out size options
        System.out.printf("\n\t%s---SIZES---%s\n%s1 - Small (4inch) $5.50\n2 - Medium (8inch) $7.00\n3 - Large (12inch) $8.50%s",
                Utils.CYAN, Utils.RESET, Utils.YELLOW, Utils.RESET);
        return Utils.messageAndResponseInt("\nPlease enter the number next to the desired sandwich size: ");
    }

    public int displaySandwichBreadOptions() {
        System.out.printf("\n%s---%sBREAD OPTIONS%s---%s\n%s1 - White\n2 - Wheat\n3 - Rye\n4 - Wrap%s", Utils.CYAN, Utils.bread, Utils.bread,
                Utils.RESET, Utils.YELLOW, Utils.RESET);
        return Utils.messageAndResponseInt("\nPlease enter the number next to the desired bread: ");
    }

    public int displaySandwichMeatMenu() {
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
        return Utils.messageAndResponseInt("\nPlease enter the number next to the desired meat: ");
    }

    public String displayExtraMeatOption() {
        //Prompt user if they want extra meat
        System.out.printf("\n%sExtra Meat: Small: +$0.50 | Medium: +$1.00 | Large: +$1.50%s", Utils.CYAN, Utils.RESET);
        return Utils.promptGetUserInput("\nWould you like extra meat?(Y or N): ").trim();
    }

    public int displaySandwichCheeseOptions() {
        System.out.printf("""
                
                           %s---%sCHEESE OPTIONS%s---
                Small: +$0.75 | Medium: +$1.50 | Large: +$2.25%s\
                %s
                1 - American
                2 - Provolone
                3 - Cheddar
                4 - Swiss
                0 - None%s""", Utils.CYAN, Utils.cheese, Utils.cheese, Utils.RESET, Utils.YELLOW, Utils.RESET);
        return Utils.messageAndResponseInt("\nPlease enter the number next to the desired cheese: ");
    }

    public String displayExtraCheeseOption() {
        System.out.printf("\n%sExtra Cheese: Small: +$0.30 | Medium: +$0.60 | Large: +$0.90%s", Utils.CYAN, Utils.RESET);
        return Utils.promptGetUserInput("\nWould you like extra cheese? (Y or N): ").trim();
    }

    public int displaySandwichToppingsOptions() {
        System.out.printf("""
                                    %s---TOPPINGS OPTIONS---
                                      Toppings are free%s
                            %s1 - Lettuce                 6 - Cucumbers
                            2 - Peppers                 7 - Pickles
                            3 - Onions                  8 - Guacamole
                            4 - Tomatoes                9 - Mushrooms
                            5 - Jalapeños               0 - None%s
                
                """, Utils.CYAN, Utils.RESET, Utils.YELLOW, Utils.RESET);
        return Utils.messageAndResponseInt("\nPlease enter the number next to the desired topping: ");
    }

    public int displaySandwichSaucesOptions() {
        System.out.printf("""
                                        %s---SAUCE OPTIONS---
                                          Sauces are free%s
                            %s1 - Mayo                    5 - Thousand Islands
                            2 - Mustard                 6 - Vinaigrette
                            3 - Ketchup                 7 - Au Jus
                            4 - Ranch                   0 - None%s
                
                """, Utils.CYAN, Utils.RESET, Utils.YELLOW, Utils.RESET);
        return Utils.messageAndResponseInt("\nPlease enter the number next to the desired sauce: ");
    }

    public int displayToastedSandwichOptions() {
        System.out.printf("\n%sWould you like your sandwich toasted?%s%s%s\n%s1 - yes, toast it!\n2 - no, don't toast it.%s\n",
                Utils.CYAN, Utils.RESET, Utils.fire, Utils.bread, Utils.YELLOW, Utils.RESET);

        return Utils.messageAndResponseInt("Enter your option: ");
    }

    public String confirmSandwich(Sandwich sandwich) {
        //Print out the sandwich that was just created
        System.out.printf("\nSandwich | %s | Toasted: %b | Bread: %s | Meat: %s | ExtraMeat: %b | Cheese: %s | ExtraCheese: %b | Toppings: %s | Sauces: %s",
                sandwich.size, sandwich.isToasted(), sandwich.getBread(), sandwich.getMeat(), sandwich.isExtraMeat(), sandwich.getCheese(), sandwich.isExtraCheese(),
                sandwich.getToppings(), sandwich.getSauces());
        System.out.printf("\nTotal Price: $%.2f\n", sandwich.getValue());

        //Verify if the sandwich is correct
        return Utils.promptGetUserInput("Is this sandwich correct?(Y or N):").trim();
    }

    public String displayAddAnotherMessage() {
        return Utils.promptGetUserInput("Would you like to add another? (Y or N): ").trim();
    }

    public int displayChipOptions() {
        System.out.printf("""
                
                        %s---%sCHIP OPTIONS%s---
                         Chips are $1.50 each%s
                   %s1 - Doritos Nacho Cheese 
                   2 - Lays Classic 
                   3 - Miss Vickies Jalapeño 
                   4 - Ruffles Original
                   5 - Cheetos%s
                """, Utils.BLUE, Utils.chips, Utils.chips, Utils.RESET, Utils.YELLOW, Utils.RESET);

        return Utils.messageAndResponseInt("Please enter your option: ");
    }

    public int displayDrinkOptions() {
        //Ask customer for drink type
        System.out.printf("""
                        
                            %s----%sDRINK OPTIONS%s-----%s
                        %s1 - Fountain Drink
                        2 - Lemonade
                        3 - Sweet Tea
                        4 - Unsweetened Tea
                        5 - MilkShake%s
                        """, Utils.BLUE, Utils.drink, Utils.drink, Utils.RESET, Utils.YELLOW, Utils.RESET);

        return Utils.messageAndResponseInt("Select the number next to the desired drink: ");
    }

    public int displayDrinkSizes() {
        //Ask customer for drink size
        System.out.printf("""
               \s
                    %s-----DRINK SIZES-----%s
                %s1 - Small $2.00
                2 - Medium $2.50
                3 - Large $3.00%s       \s
               \s""", Utils.BLUE, Utils.RESET, Utils.YELLOW, Utils.RESET);

        return Utils.messageAndResponseInt("Enter a drink size: ");
    }

    public String displayAndConfirmOrder(Order order) {

        //Print out order and verify order with customer
        order.printItemsAndPrices();
        return Utils.promptGetUserInput("Is this order correct? (Y or N): ").trim();

    }

}
