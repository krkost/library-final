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

import by.htp.library.BookDao;
import by.htp.library.entity.Book;

public class BookDaoImplDb implements BookDao {

	private static final String SELECT_BOOK_BYID = "SELECT * from book WHERE id = ?";
	private static final String SELECT_BOOKS_LIST = "SELECT * FROM book";
	private static final String ADD_BOOK = "INSERT INTO book (title, author) VALUES (?, ?)";

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

		return 0;
	}

	@Override
	public void delete(int book_id) {
	}
	
	private Book buildBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt("id"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		return book;
	}

}
