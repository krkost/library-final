package by.htp.library.dao;

import java.util.List;

import by.htp.library.entity.user.Reader;

public interface ReaderDao {
	
	Reader read(int readerTicketNumber);
	
	List <Reader> list();
	
	int add(Reader reader);
	
	void delete(int id);

}
