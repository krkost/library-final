package by.htp.library.dao.impl.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.htp.library.ReaderDao;
import by.htp.library.entity.Book;
import by.htp.library.entity.user.Reader;

public class ReaderDaoImplDb implements ReaderDao{

	@Override
	public Reader read(int readerTicketNumber) {
		
		return null;
	}

	@Override
	public List<Reader> list() {
		
		return null;
	}

	@Override
	public int add(Reader reader) {
		
		return 0;
	}

	@Override
	public void delete(int readerTicketNumber) {
	}
	
	private Reader buildReader(ResultSet rs) throws SQLException {
		Reader reader = new Reader();

		return reader;
	}

}
