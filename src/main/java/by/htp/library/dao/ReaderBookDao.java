package by.htp.library.dao;

import java.util.List;

import by.htp.library.entity.ReaderBook;


public interface ReaderBookDao {
	
	ReaderBook read(int id);

	List<ReaderBook> list();

	int add(ReaderBook book);

}
