package by.htp.library.run;

import by.htp.library.logic.MainMenu;
import by.htp.library.logic.impl.MainMenuImpl;

public class MainApp {

	public static void main(String[] args) {
		MainMenu menu = new MainMenuImpl();
		menu.start();
	}

}