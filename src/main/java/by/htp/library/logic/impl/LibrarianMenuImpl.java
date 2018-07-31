package by.htp.library.logic.impl;

import by.htp.library.entity.Book;
import by.htp.library.entity.user.Reader;
import by.htp.library.logic.LibrarianMenu;

public class LibrarianMenuImpl implements LibrarianMenu {

	public void start() {
		System.out.println("Input login:");
		String login = "";

		System.out.println("Input password:");
		String password = "";

		if (login(login, password)) {

			System.out.println("Select option:");
		}
	}

	@Override
	public boolean login(String login, String password) {

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
