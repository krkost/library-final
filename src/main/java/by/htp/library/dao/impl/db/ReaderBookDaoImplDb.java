package by.htp.library.dao.impl.db;

import static by.htp.library.dao.util.MySqlPropertyManager.getLogin;
import static by.htp.library.dao.util.MySqlPropertyManager.getPass;
import static by.htp.library.dao.util.MySqlPropertyManager.getUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import by.htp.library.dao.ReaderBookDao;
import by.htp.library.entity.ReaderBook;

public class ReaderBookDaoImplDb implements ReaderBookDao {

	private static final String SELECT_READERBOOK_BYID = "SELECT * from readerbook WHERE id_readerbook = ?";
	private static final String SELECT_READERBOOK_LIST = "SELECT * FROM readerbook";
	private static final String ADD_READERBOOK = "INSERT INTO readerbook (id_reader, id_book, startDate, endDate) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_READERBOOK = "UPDATE readerbook SET endDate=? WHERE id_readerbook=?";

	@Override
	public ReaderBook read(int id) {

		return null;
	}

	@Override
	public List<ReaderBook> list() {

		return null;
	}

	@Override
	public int add(ReaderBook readerBook) {
		int result = 0;

		java.sql.Date startDate = new java.sql.Date(readerBook.getStartDate().getTimeInMillis());

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(ADD_READERBOOK);
			ps.setInt(1, readerBook.getReader().getId());
			ps.setInt(2, readerBook.getBook().getId());
			ps.setDate(3, startDate);
			ps.setDate(4, null);
			result = ps.executeUpdate();
			conn.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateEndDate(int idReaderBook, Calendar date) {
		int result = 0;

		java.sql.Date endDate = new java.sql.Date(date.getTimeInMillis());

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(UPDATE_READERBOOK);
			ps.setDate(1, endDate);
			ps.setInt(2, idReaderBook);
			result = ps.executeUpdate();
			conn.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}

		return result;
	}

}
