package by.htp.library.dao.impl.db;

import static by.htp.library.dao.util.MySqlPropertyManager.getLogin;
import static by.htp.library.dao.util.MySqlPropertyManager.getPass;
import static by.htp.library.dao.util.MySqlPropertyManager.getUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.library.dao.LibrarianDao;

public class LibrarianDaoImplDb implements LibrarianDao{
	
	private static final String SELECT_LOGIN_BYID = "SELECT login FROM librarian WHERE id_librarian = ?";
	private static final String SELECT_PASSWORD_BYID = "SELECT password FROM librarian WHERE id_librarian = ?";
	private static final int CREDENTIALS_ID = 1;

	@Override
	public String getLibrarianLogin() {
		String login = null;
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(SELECT_LOGIN_BYID);
			ps.setInt(1, CREDENTIALS_ID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				login = rs.getString("login");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}

	@Override
	public String getLibrarianPassword() {
		String password = null;
		try (Connection conn = DriverManager.getConnection(getUrl(), getLogin(), getPass())) {
			PreparedStatement ps = conn.prepareStatement(SELECT_PASSWORD_BYID);
			ps.setInt(1, CREDENTIALS_ID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				password = rs.getString("password");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}

}
