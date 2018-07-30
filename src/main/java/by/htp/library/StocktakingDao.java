package by.htp.library;

import by.htp.library.entity.Book;
import by.htp.library.entity.user.Reader;

public interface StocktakingDao {
	
	boolean checkCurrentBookIsTaken (Book book);
	
	boolean checkCurrentReaderHasNotMoreThanThreeBooks(Reader reader);
	
	/*Third check*/
	
	

}
