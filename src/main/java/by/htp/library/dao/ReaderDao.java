package by.htp.library.dao;

import java.util.List;

import by.htp.library.entity.user.Reader;

public interface ReaderDao {
	
	boolean login(int readerTicketNumber, String password);
	
	Reader read(int id);
	
	Reader readByTicketNumber(int readerTicketNumber);	
	
	List <Reader> list();
	
	int add(Reader reader);
	
	void delete(int id);

}
