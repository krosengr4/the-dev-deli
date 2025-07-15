package logic;

import ui.UserInterface;

public abstract class LogicBase {

	static UserInterface ui;

	public LogicBase(UserInterface ui) {
		this.ui = ui;
	}

}
