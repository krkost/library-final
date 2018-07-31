package by.htp.library.logic;

import by.htp.library.entity.Book;
import by.htp.library.entity.user.Reader;

public interface StocktakingCheckings {
	
	boolean checkCurrentBookIsTaken (Book book);
	
	boolean checkCurrentReaderHasNotMoreThanLimitBooks(Reader reader);
	
	boolean checkCurrentReaderHasNoBookIndebtedness(Reader reader);

}
