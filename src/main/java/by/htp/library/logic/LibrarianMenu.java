package by.htp.library.logic;

import by.htp.library.entity.Book;
import by.htp.library.entity.user.Reader;

public interface LibrarianMenu {
	
	void login(String login, String password);
	
	void addReader(Reader reader);
	
	void showListOfReaders();
	
	void deleteReader(Reader reader);
	
	void addBook(Book book);
	
	void showListOfBooks();
	
	void deleteBook(Book book);
	
	void addRecordReaderTakesBook(Reader reader, Book book);
	
	void updRecordReaderReturnsBook(Reader reader, Book book);

}
