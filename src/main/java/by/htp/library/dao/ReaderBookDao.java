package by.htp.library.dao;

import java.util.Calendar;
import java.util.List;

import by.htp.library.entity.ReaderBook;


public interface ReaderBookDao {
	
	ReaderBook read(int id);

	List<ReaderBook> list();

	int add(ReaderBook readerBook);
	
	int updateEndDate (int idReaderBook, Calendar endDate);

}
