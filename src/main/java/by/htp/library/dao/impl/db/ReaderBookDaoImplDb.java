package by.htp.library.dao.impl.db;

import static by.htp.library.dao.util.MySqlPropertyManager.getLogin;
import static by.htp.library.dao.util.MySqlPropertyManager.getPass;
import static by.htp.library.dao.util.MySqlPropertyManager.getUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
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
		ReaderBook readerBook = null;
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(SELECT_READERBOOK_BYID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				readerBook = buildReaderBook(rs);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return readerBook;
	}

	@Override
	public List<ReaderBook> list() {
		List<ReaderBook> readerBookList = new LinkedList();
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(SELECT_READERBOOK_LIST);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				readerBookList.add(buildReaderBook(rs));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return readerBookList;
	}

	@Override
	public int add(ReaderBook readerBook) {
		int result = 0;

		java.sql.Date startDate = new java.sql.Date(readerBook.getStartDate().getTimeInMillis());

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(ADD_READERBOOK);
			ps.setInt(1, readerBook.getIdReader());
			ps.setInt(2, readerBook.getIdBook());
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

	private ReaderBook buildReaderBook(ResultSet rs) throws SQLException {
		
		ReaderBook readerBook = new ReaderBook();
		Calendar startDate = GregorianCalendar.getInstance();
		startDate.setTime(rs.getDate("startDate"));
		Calendar endDate = GregorianCalendar.getInstance();
		if (rs.getDate("endDate") != null) {
			endDate.setTime(rs.getDate("endDate"));
			readerBook.setEndDate(endDate);
		}
		readerBook.setId(rs.getInt("id_readerbook"));
		readerBook.setIdReader(rs.getInt("id_reader"));
		readerBook.setIdBook(rs.getInt("id_book"));
		readerBook.setStartDate(startDate);

		return readerBook;
	}

}
