package by.htp.library.logic;

import by.htp.library.entity.Book;
import by.htp.library.entity.user.Reader;

public interface StocktakingChecks {
	
	boolean checkCurrentBookIsNotTaken (int idBook);
	
	boolean checkCurrentReaderHasNoMoreThanLimitBooks(int idReader);
	
	boolean checkCurrentReaderHasNoBookIndebtedness(int idReader);

}
