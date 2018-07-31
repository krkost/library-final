package by.htp.library.entity;

import java.util.Calendar;

import by.htp.library.entity.user.Reader;

public class ReaderBook {

	private int id;
	private Reader reader;
	private Book book;
	private Calendar startDate;
	private Calendar endDate;

	public ReaderBook() {
		super();
	}

	public ReaderBook(int id, Reader reader, Book book, Calendar startDate, Calendar endDate) {
		super();
		this.id = id;
		this.reader = reader;
		this.book = book;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ReaderBook(int id, Reader reader, Book book, Calendar startDate) {
		super();
		this.id = id;
		this.reader = reader;
		this.book = book;
		this.startDate = startDate;
		this.endDate = null;
	}
	
	public ReaderBook(Reader reader, Book book, Calendar startDate) {
		super();
		this.reader = reader;
		this.book = book;
		this.startDate = startDate;
		this.endDate = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((reader == null) ? 0 : reader.hashCode());
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
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (reader == null) {
			if (other.reader != null)
				return false;
		} else if (!reader.equals(other.reader))
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
		return "ReaderBook [id=" + id + ", reader=" + reader + ", book=" + book + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}
