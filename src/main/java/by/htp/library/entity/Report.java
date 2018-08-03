package by.htp.library.entity;

import java.util.List;

import by.htp.library.entity.user.Reader;
import by.htp.library.entity.Book;

public class Report {

	private List<Reader> readers;
	private List<Book> books;

	public Report() {
		super();
	}

	public Report(List<Reader> readers, List<Book> books) {
		super();
		this.readers = readers;
		this.books = books;
	}

	public Report(List<Reader> readers) {
		this.readers = readers;
	}

	public List<Reader> getReaders() {
		return readers;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
