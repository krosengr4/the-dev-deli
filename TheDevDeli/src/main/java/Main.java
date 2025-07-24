import logic.MainLogic;
import models.MenuItem;
import ui.UserInterface;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.printf("""
                                                         \s
                                                         \s
                                         %s%s%sWELCOME TO DEV DELI%s%s
                                     Take A Byte into our Dev-licous Sandwiches!%s%s
                    ______________________________________________________________________________%s
                """, Utils.fire, Utils.sandwich, Utils.BLUE, Utils.sandwich, Utils.fire, Utils.smileyFace, Utils.thumbsUp, Utils.RESET);

        //Create new User Interface instance, list for customers order, and Main Logic instance
		List<MenuItem> customersOrder = new ArrayList<>();
		UserInterface ui = new UserInterface();
		MainLogic mainLogic = new MainLogic(ui, customersOrder);

		//Process the Main Screen in the Main Logic class
		mainLogic.processMainScreen();

        //Goodbye messages for when user exits app
        System.out.println(Utils.BLUE + "\n\n\t\t\t\tThanks for coming into Dev Deli!" + Utils.RESET + Utils.sandwich + Utils.fire);
        System.out.println(Utils.BLUE + "\t\t\t\tWe will see you soon!" + Utils.RESET);
        Utils.playSound("winxpshutdown.wav");

		//Test for mac
    }
}
