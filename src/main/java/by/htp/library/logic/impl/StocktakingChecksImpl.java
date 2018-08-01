package by.htp.library.logic.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import by.htp.library.dao.ReaderBookDao;
import by.htp.library.dao.impl.db.ReaderBookDaoImplDb;
import by.htp.library.entity.ReaderBook;
import by.htp.library.logic.StocktakingChecks;

public class StocktakingChecksImpl implements StocktakingChecks {

	private static final long DAYS_FOR_INDEBTEDNESS = 30;
	private static final int LIMIT_OF_BOOKS = 3;

	@Override
	public boolean checkCurrentBookIsNotTaken(int idBook) {

		ReaderBookDao rD = new ReaderBookDaoImplDb();
		List<ReaderBook> readerBookList = rD.list();
		for (ReaderBook readerBook : readerBookList) {
			if (idBook == readerBook.getIdBook()) {
				if (readerBook.getEndDate() == null)
					return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkCurrentReaderHasNotMoreThanLimitBooks(int idReader) {

		ReaderBookDao rD = new ReaderBookDaoImplDb();
		List<ReaderBook> readerBookList = rD.list();
		int countOfReaderBooks = 0;
		for (ReaderBook readerBook : readerBookList) {
			if (idReader == readerBook.getIdReader()) {
				if (readerBook.getEndDate() == null)
					countOfReaderBooks++;
			}
		}
		if (countOfReaderBooks >= LIMIT_OF_BOOKS)
			return false;

		return true;
	}

	@Override
	public boolean checkCurrentReaderHasNoBookIndebtedness(int idReader) {
		ReaderBookDao rD = new ReaderBookDaoImplDb();
		List<ReaderBook> readerBookList = rD.list();
		for (ReaderBook readerBook : readerBookList) {
			if (idReader == readerBook.getIdReader()) {
				if (readerBook.getEndDate() == null) {
					if (daysBetweenStartDayAndToday(readerBook.getStartDate()) > DAYS_FOR_INDEBTEDNESS)
						return false;
				}
			}
		}
		return true;
	}

	private long daysBetweenStartDayAndToday(Calendar date1) {
		Calendar date2 = GregorianCalendar.getInstance();
		long difference = date2.getTimeInMillis() - date1.getTimeInMillis();
		long days = difference / (24 * 60 * 60 * 1000);
		return days;
	}

}
