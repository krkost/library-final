package by.htp.library.logic.impl;

import by.htp.library.dao.LibrarianDao;
import by.htp.library.dao.ReaderDao;
import by.htp.library.dao.UserInput;
import by.htp.library.dao.impl.UserInputImpl;
import by.htp.library.dao.impl.db.LibrarianDaoImplDb;
import by.htp.library.dao.impl.db.ReaderBookDaoImplDb;
import by.htp.library.dao.impl.db.ReaderDaoImplDb;
import by.htp.library.entity.user.Reader;
import by.htp.library.logic.LibrarianMenu;

public class LibrarianMenuImpl implements LibrarianMenu {

	@Override
	public void start() {
		if (login()) {
			menuCycle();
		} else {
			System.out.println("Your login and/or password incorrect. Try again:");
			if (login()) {
				menuCycle();
			}
		}
	}

	private boolean login() {
		UserInput userInput = new UserInputImpl();

		System.out.println("Input login:");
		String login = userInput.inputString();

		System.out.println("Input password:");
		String password = userInput.inputString();

		LibrarianDao librarian = new LibrarianDaoImplDb();

		if (login.equals(librarian.getLibrarianLogin()) && password.equals(librarian.getLibrarianPassword()))
			return true;
		return false;
	}

	@Override
	public void addReader() {
		UserInput userInput = new UserInputImpl();
		Reader newReader = new Reader();

		System.out.println("Input reader ticket number:");
		newReader.setReaderTicketNumber(userInput.inputInt());

		System.out.println("Input first name:");
		newReader.setFirstName(userInput.inputString());

		System.out.println("Input last name:");
		newReader.setLastName(userInput.inputString());

		System.out.println("Input phone number:");
		newReader.setPhoneNumber(userInput.inputInt());

		System.out.println("Input password for reader:");
		newReader.setPassword(userInput.inputString());

		ReaderDao rD = new ReaderDaoImplDb();
		rD.add(newReader);
		
		System.out.println("New reader is added");
	}

	@Override
	public void showListOfReaders() {
		ReaderDao rD = new ReaderDaoImplDb();
		System.out.println(rD.list());
	}

	@Override
	public void deleteReader() {
		UserInput userInput = new UserInputImpl();
		ReaderDao rD = new ReaderDaoImplDb();
		
		System.out.println("View the list of users and input id of reader.");
		showListOfReaders();
		System.out.println("Input id:");
		rD.delete(userInput.inputInt());
		
		System.out.println("Reader is deleted");
	}

	@Override
	public void addBook() {
	}

	@Override
	public void showListOfBooks() {
	}

	@Override
	public void deleteBook() {
	}

	@Override
	public void addRecordReaderTakesBook() {
	}

	@Override
	public void updRecordReaderReturnsBook() {
	}

	@Override
	public void getReports() {
	}

	private void menuCycle() {
		while (true) {
			System.out.println("1 - Add new reader\n2 - View list of readers\n3 - Delete reader\n4 - Add new book"
					+ "\n5 - View list of books\n6 - Delete book\n7 - Add reader-book record\n8 - Update reader-book record"
					+ "\n9 - Get reports\n0 - Exit");
			System.out.println("Input number of option:");

			UserInput userInput = new UserInputImpl();
			int option = userInput.inputInt();

			switch (option) {
			case 1:
				addReader();
				break;
			case 2:
				showListOfReaders();
				break;
			case 3:
				deleteReader();
				break;
			case 4:
				addBook();
				break;
			case 5:
				showListOfBooks();
				break;
			case 6:
				deleteBook();
				break;
			case 7:
				addRecordReaderTakesBook();
				break;
			case 8:
				updRecordReaderReturnsBook();
				break;
			case 9:
				getReports();
				break;
			case 0:
				System.out.println("Are you sure?  Y - yes, N - no");
				String decision = userInput.inputString();
				if (decision.equals("Y") || decision.equals("y")) {
					System.exit(0);
				}
				break;
			}
		}
	}

}
