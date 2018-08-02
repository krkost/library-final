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

import by.htp.library.dao.ReaderDao;
import by.htp.library.entity.user.Reader;

public class ReaderDaoImplDb implements ReaderDao {

	private static final String CHECK_READER_CREDENTIALS = "SELECT * FROM reader WHERE readerTicketNumber=? AND password=?";
	private static final String SELECT_READER_BYID = "SELECT * from reader WHERE id_reader = ?";
	private static final String SELECT_READERS_LIST = "SELECT * FROM reader";
	private static final String ADD_READER = "INSERT INTO reader (readerTicketNumber, firstName, lastName, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";
	private static final String DELETE_READER_BYID = "DELETE FROM reader WHERE id_reader = ?";

	@Override
	public boolean login(int readerTicketNumber, String password) {
		Reader reader = new Reader();
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(CHECK_READER_CREDENTIALS);
			ps.setInt(1, readerTicketNumber);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				reader = buildReader(rs);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (reader.getFirstName() != null) {
			return true;
		}
		return false;
	}

	@Override
	public Reader read(int id) {
		Reader reader = null;
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(SELECT_READER_BYID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				reader = buildReader(rs);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reader;
	}

	@Override
	public List<Reader> list() {
		List<Reader> readerList = new LinkedList();
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(SELECT_READERS_LIST);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				readerList.add(buildReader(rs));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return readerList;
	}

	@Override
	public int add(Reader reader) {
		int result = 0;

		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(ADD_READER);
			ps.setInt(1, reader.getReaderTicketNumber());
			ps.setString(2, reader.getFirstName());
			ps.setString(3, reader.getLastName());
			ps.setInt(4, reader.getPhoneNumber());
			ps.setString(5, reader.getPassword());
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
			PreparedStatement ps = conn.prepareStatement(DELETE_READER_BYID);
			ps.setInt(1, id);
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Reader buildReader(ResultSet rs) throws SQLException {
		Reader reader = new Reader();
		reader.setId(rs.getInt("id_reader"));
		reader.setReaderTicketNumber(rs.getInt("readerTicketNumber"));
		reader.setFirstName(rs.getString("firstName"));
		reader.setLastName(rs.getString("lastName"));
		reader.setPhoneNumber(rs.getInt("phoneNumber"));
		return reader;
	}

}
