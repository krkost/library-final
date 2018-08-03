package by.htp.library.logic.impl;

import java.util.List;

import by.htp.library.dao.BookDao;
import by.htp.library.dao.ReaderBookDao;
import by.htp.library.dao.ReaderDao;
import by.htp.library.dao.impl.db.BookDaoImplDb;
import by.htp.library.dao.impl.db.ReaderBookDaoImplDb;
import by.htp.library.dao.impl.db.ReaderDaoImplDb;
import by.htp.library.entity.Book;
import by.htp.library.entity.ReaderBook;
import by.htp.library.entity.user.Reader;
import by.htp.library.logic.ReportBase;
import by.htp.library.logic.StocktakingChecks;

public class ReportGeneration implements ReportBase {

	private ReaderBookDao readerBookDao = new ReaderBookDaoImplDb();
	private ReaderDao readerDao = new ReaderDaoImplDb();
	private BookDao bookDao = new BookDaoImplDb();

	private StocktakingChecks check = new StocktakingChecksImpl();

	@Override
	public void readersWithIndebtedness() {

		List<ReaderBook> readersBooks = readerBookDao.list();
		List<Reader> readers = readerDao.list();
		List<Book> books = bookDao.list();

		for (Reader r : readers) {
			if (!check.checkCurrentReaderHasNoBookIndebtedness(r.getId())) {
				System.out.println("Name: " + r.getFirstName() + " " + r.getLastName() + "Phone: " + r.getPhoneNumber());
				ReaderBook readerBook = new ReaderBook();
				Book book = new Book();

				for (ReaderBook rB : readersBooks) {
					if (rB.getIdReader() == r.getId()) {
						readerBook = rB;
						System.out.println(readerBook.getStartDate());
					}
				}

				for (Book b : books) {
					if (readerBook.getIdBook() == b.getId()) {
						book = b;
						System.out.println(book.getTitle());
					}
				}

			}
		}

	}

	@Override
	public void booksCountRead() {
	}

	@Override
	public void readersReadAmountBooks() {
	}

}
