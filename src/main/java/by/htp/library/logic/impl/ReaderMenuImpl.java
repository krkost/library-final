package by.htp.library.logic.impl;

import by.htp.library.dao.BookDao;
import by.htp.library.dao.ReaderDao;
import by.htp.library.dao.UserInput;
import by.htp.library.dao.impl.UserInputImpl;
import by.htp.library.dao.impl.db.BookDaoImplDb;
import by.htp.library.dao.impl.db.ReaderDaoImplDb;
import by.htp.library.logic.ReaderMenu;

public class ReaderMenuImpl implements ReaderMenu {

	@Override
	public void start() {
		if (login()) {
			menuCycle();
		} else {
			System.out.println("Your login and/or password incorrect. Try again:");
			start();
		}
	}

	@Override
	public boolean login() {
		UserInput userInput = new UserInputImpl();

		System.out.println("Input your reader ticket number:");
		int readerTicketNumber = userInput.inputInt();

		System.out.println("Input password:");
		String password = userInput.inputString();

		ReaderDao rD = new ReaderDaoImplDb();

		return rD.login(readerTicketNumber, password);
	}

	@Override
	public void showBooksCatalog() {
		BookDao bD = new BookDaoImplDb();
		System.out.println(bD.list());
	}

	@Override
	public void showBookInfo() {
		UserInput userInput = new UserInputImpl();
		BookDao bD = new BookDaoImplDb();
		
		System.out.println("Input book id:");
		System.out.println(bD.read(userInput.inputInt()));
	}

	private void menuCycle() {
		while (true) {
			System.out.println("\n---READER MENU---");
			System.out.println("1 - View book list\n2 - View information about book\n3 - Exit");
			System.out.println("Input number of option:");

			UserInput userInput = new UserInputImpl();
			int option = userInput.inputInt();

			switch (option) {
			case 1:
				showBooksCatalog();
				break;
			case 2:
				showBookInfo();
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

}
