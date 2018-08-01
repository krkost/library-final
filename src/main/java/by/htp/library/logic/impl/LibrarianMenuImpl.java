package by.htp.library.logic.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import by.htp.library.dao.BookDao;
import by.htp.library.dao.LibrarianDao;
import by.htp.library.dao.ReaderBookDao;
import by.htp.library.dao.ReaderDao;
import by.htp.library.dao.UserInput;
import by.htp.library.dao.impl.UserInputImpl;
import by.htp.library.dao.impl.db.BookDaoImplDb;
import by.htp.library.dao.impl.db.LibrarianDaoImplDb;
import by.htp.library.dao.impl.db.ReaderBookDaoImplDb;
import by.htp.library.dao.impl.db.ReaderDaoImplDb;
import by.htp.library.entity.Book;
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
		UserInput userInput = new UserInputImpl();
		Book book = new Book();

		System.out.println("Input book title:");
		book.setTitle(userInput.inputString());

		System.out.println("Input book author first and last name with space:");
		book.setAuthor(userInput.inputString());

		BookDao bD = new BookDaoImplDb();
		bD.add(book);

		System.out.println("New book is added");
	}

	@Override
	public void showListOfBooks() {
		BookDao bD = new BookDaoImplDb();
		System.out.println(bD.list());
	}

	@Override
	public void deleteBook() {
		UserInput userInput = new UserInputImpl();
		BookDao bD = new BookDaoImplDb();

		System.out.println("View the list of books and input id of book.");
		showListOfBooks();
		System.out.println("Input id:");
		bD.delete(userInput.inputInt());

		System.out.println("Book is deleted");
	}

	@Override
	public void addRecordReaderTakesBook() {
	}

	@Override
	public void updRecordReaderReturnsBook() {
		UserInput userInput = new UserInputImpl();
		ReaderBookDao rbD = new ReaderBookDaoImplDb();

		while (true) {
			System.out.println("View the list of records:");
			showRecordsReaderBook();
			
			System.out.println("If you want back to the main menu input 000");
			System.out.println("Record will be updated with current date. Input id of updating record or 000:");
			int id = userInput.inputInt();
			if(id == 000) {
				menuCycle();
			}
			if (rbD.read(id).getEndDate() != null) {
				System.out.println("There is already the end date for the record");
			} else {
				Calendar date = new GregorianCalendar();
				rbD.updateEndDate(id, date);
				System.out.println("Record is updated");
			}
		}

	}

	private void showRecordsReaderBook() {
		ReaderBookDao rbD = new ReaderBookDaoImplDb();
		System.out.println(rbD.list());
	}

	@Override
	public void getReports() {
	}

	private void menuCycle() {
		while (true) {
			System.out.println("LIBRARIAN MENU:");
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
