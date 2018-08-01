package by.htp.library.entity;

import java.util.Calendar;

import by.htp.library.entity.user.Reader;

public class ReaderBook {

	private int id;
	private int idReader;
	private int idBook;
	private Calendar startDate;
	private Calendar endDate;

	public ReaderBook() {
		super();
	}

	public ReaderBook(int id, int idReader, int idBook, Calendar startDate, Calendar endDate) {
		super();
		this.id = id;
		this.idReader = idReader;
		this.idBook = idBook;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ReaderBook(int id, int idReader, int idBook, Calendar startDate) {
		super();
		this.id = id;
		this.idReader = idReader;
		this.idBook = idBook;
		this.startDate = startDate;
		this.endDate = null;
	}

	public ReaderBook(int idReader, int idBook, Calendar startDate) {
		super();
		this.idReader = idReader;
		this.idBook = idBook;
		this.startDate = startDate;
		this.endDate = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdReader() {
		return idReader;
	}

	public void setIdReader(int idReader) {
		this.idReader = idReader;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + idBook;
		result = prime * result + idReader;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReaderBook other = (ReaderBook) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (idBook != other.idBook)
			return false;
		if (idReader != other.idReader)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nReaderBook [id=" + id + ", idReader=" + idReader + ", idBook=" + idBook + ", startDate="
				+ normalDate(startDate) + ", endDate=" + normalDate(endDate) + "]";
	}

	private String normalDate(Calendar cal) {
		
		String normalDate = null;

		if (cal == null) {
			return normalDate;
		} else {
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			month++; // because of months start with 0
			int day = cal.get(Calendar.DAY_OF_MONTH);

			normalDate = year + "-" + month + "-" + day;
		}
		return normalDate;
	}

}
