package by.htp.library.dao.impl.db;

import java.util.List;

import by.htp.library.dao.ReaderBookDao;
import by.htp.library.entity.ReaderBook;

public class ReaderBookDaoImplDb implements ReaderBookDao {

	private static final String SELECT_READERBOOK_BYID = "SELECT * from readerbook WHERE id_readerbook = ?";
	private static final String SELECT_READERBOOK_LIST = "SELECT * FROM readerbook";
	private static final String ADD_READERBOOK = "INSERT INTO readerbook (id_reader, id_book, startDate, endDate) VALUES (?, ?, ?, ?)";

	@Override
	public ReaderBook read(int id) {

		return null;
	}

	@Override
	public List<ReaderBook> list() {

		return null;
	}

	@Override
	public int add(ReaderBook book) {

		return 0;
	}

}
