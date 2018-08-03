package by.htp.library.dao.impl.mem;

import java.util.List;

import by.htp.library.dao.BookDao;
import by.htp.library.entity.Book;
import by.htp.library.entity.ReaderBook;
import by.htp.library.entity.user.Reader;

public class BookDaoImplMem implements BookDao{
	
	private List <Book> books;
	private List <Reader> readers;
	private List <ReaderBook> readerbooks;
	
	

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public Book read(int id) {
		
		return null;
	}

	@Override
	public List<Book> list() {
		
		return null;
	}

	@Override
	public int add(Book book) {
		
		return 0;
	}

	@Override
	public void delete(int book_id) {
	}

}
