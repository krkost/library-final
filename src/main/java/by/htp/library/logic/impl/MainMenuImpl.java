package by.htp.library.logic.impl;

import by.htp.library.dao.UserInput;
import by.htp.library.dao.impl.UserInputImpl;
import by.htp.library.logic.LibrarianMenu;
import by.htp.library.logic.MainMenu;
import by.htp.library.logic.ReaderMenu;

public class MainMenuImpl implements MainMenu{

	@Override
	public void start() {
		System.out.println("Select user role:");
		System.out.println("1 - Librarian,\n2 - Reader, \n3 - Exit");
		
		UserInput userInput = new UserInputImpl();
		int option = userInput.inputInt();
		
		switch(option) {
		case 1: 
			LibrarianMenu librarianMenu = new LibrarianMenuImpl();
			librarianMenu.start();
			break;
		case 2: 
			ReaderMenu readerMenu = new ReaderMenuImpl();
			readerMenu.start();
			break;
		case 3:
			System.out.println("Are you sure?  Y - yes, N - no");
			String decision = userInput.inputString();
			if (decision.equals("Y") || decision.equals("y")) {
				System.exit(0);
			}
			break;
		default:
			System.out.println("\nInput correct number, please.");
		}
	}

}
