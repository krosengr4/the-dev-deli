package logic;

import models.MenuItem;
import ui.UserInterface;

import java.util.List;

public abstract class LogicBase {

	protected static UserInterface ui;
	protected static List<MenuItem> customerOrder;

	public LogicBase(UserInterface ui, List<MenuItem> customerOrder) {
		LogicBase.ui = ui;
		LogicBase.customerOrder = customerOrder;
	}

}
