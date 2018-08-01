package by.htp.library.logic.impl;

import by.htp.library.dao.LibrarianDao;
import by.htp.library.dao.UserInput;
import by.htp.library.dao.impl.UserInputImpl;
import by.htp.library.dao.impl.db.LibrarianDaoImplDb;
import by.htp.library.entity.Book;
import by.htp.library.entity.user.Reader;
import by.htp.library.logic.LibrarianMenu;

public class LibrarianMenuImpl implements LibrarianMenu {
	
	@Override
	public void start() {
		UserInput userInput = new UserInputImpl();

		System.out.println("Input login:");
		String login = userInput.inputString();

		System.out.println("Input password:");
		String password = userInput.inputString();

		if (login(login, password)) {

			System.out.println("Select option:");
		}
	}

	@Override
	public boolean login(String login, String password) {
		LibrarianDao librarian = new LibrarianDaoImplDb();
		if (login.equals(librarian.getLibrarianLogin()) && password.equals(librarian.getLibrarianPassword()))
			return true;
		return false;
	}

	@Override
	public void addReader(Reader reader) {
	}

	@Override
	public void showListOfReaders() {
	}

	@Override
	public void deleteReader(Reader reader) {
	}

	@Override
	public void addBook(Book book) {
	}

	@Override
	public void showListOfBooks() {
	}

	@Override
	public void deleteBook(Book book) {
	}

	@Override
	public void addRecordReaderTakesBook(Reader reader, Book book) {
	}

	@Override
	public void updRecordReaderReturnsBook(Reader reader, Book book) {
	}

}
