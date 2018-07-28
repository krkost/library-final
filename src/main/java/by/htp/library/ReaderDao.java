package by.htp.library;

import java.util.List;

import by.htp.library.entity.users.Reader;

public interface ReaderDao {
	
	Reader read(int readerTicketNumber);
	
	List <Reader> list();
	
	int add(Reader reader);
	
	void delete(int readerTicketNumber);

}
