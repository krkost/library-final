package by.htp.library.dao.impl.db;

import static by.htp.library.dao.util.MySqlPropertyManager.getLogin;
import static by.htp.library.dao.util.MySqlPropertyManager.getPass;
import static by.htp.library.dao.util.MySqlPropertyManager.getUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import by.htp.library.dao.BookDao;
import by.htp.library.entity.Book;

public class BookDaoImplDb implements BookDao {

	private static final String SELECT_BOOK_BYID = "SELECT * FROM book WHERE id_book = ?";
	private static final String SELECT_BOOKS_LIST = "SELECT * FROM book";
	private static final String ADD_BOOK = "INSERT INTO book (title, author) VALUES (?, ?)";
	private static final String DELETE_BOOK_BYID = "DELETE FROM book WHERE id_book = ?";

	@Override
	public Book read(int id) {
		Book book = null;
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(SELECT_BOOK_BYID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book = buildBook(rs);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> list() {
		List<Book> bookList = new LinkedList<>();
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(SELECT_BOOKS_LIST);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bookList.add(buildBook(rs));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return bookList;
	}

	@Override
	public int add(Book book) {
		int result = 0;

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(ADD_BOOK);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			result = ps.executeUpdate();
			conn.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return result;
	}

	@Override
	public void delete(int id) {
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(DELETE_BOOK_BYID);
			ps.setInt(1, id);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Book buildBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt("id_book"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		return book;
	}

}
