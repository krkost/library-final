package by.htp.library.dao.impl.mem;

import java.util.List;

import by.htp.library.dao.ReaderDao;
import by.htp.library.entity.user.Reader;

public class ReaderDaoImplMem implements ReaderDao{

	@Override
	public boolean login(int readerTicketNumber, String password) {
		
		return false;
	}

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
	public void delete(int id) {
	}

}
