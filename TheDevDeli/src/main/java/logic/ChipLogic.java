package logic;

import models.Chip;
import models.MenuItem;
import models.enums.ChipType;
import ui.UserInterface;
import utils.Utils;

import java.util.List;

public class ChipLogic extends LogicBase{

	public ChipLogic(UserInterface ui, List<MenuItem> customerOrder) {
		super(ui, customerOrder);
	}

	public static void processChipOption() {
		int userChoice = ui.displayChips();
		Chip chip = new Chip();

		switch(userChoice) {
			case 1 -> chip.setChipType(ChipType.FRENCHFRIES);
			case 2 -> chip.setChipType(ChipType.DORITOS);
			case 3 -> chip.setChipType(ChipType.MISS_VICKIES_JALAPENO);
			case 4 -> chip.setChipType(ChipType.LAYS_ORIGINAL);
			case 5 -> chip.setChipType(ChipType.CHEETOS);
			case 6 -> chip.setChipType(ChipType.TAKIS);
			case 7 -> chip.setChipType(ChipType.CHEEZITS);
		}

		if(userChoice != 0) {
			addToOrder(chip);
		}
	}

	private static void addToOrder(Chip chip) {
		customerOrder.add(chip);
		System.out.println("Success! The chips were added to the order!");
		chip.print();
		Utils.playSound("owin31.wav");

	}

}
