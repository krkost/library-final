package by.htp.library.entity.user;

public class Reader extends AbstractUser {

	private int readerTicketNumber;
	private String firstName;
	private String lastName;
	private int phoneNumber;

	public Reader() {
		super();
	}

	public Reader(String password, int readerTicketNumber, String firstName, String lastName, int phoneNumber) {
		super(password);
		this.readerTicketNumber = readerTicketNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Reader(int readerTicketNumber, String firstName, String lastName, int phoneNumber) {
		super();
		this.readerTicketNumber = readerTicketNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public int getReaderTicketNumber() {
		return readerTicketNumber;
	}

	public void setReaderTicketNumber(int readerTicketNumber) {
		this.readerTicketNumber = readerTicketNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + readerTicketNumber;
		result = prime * result + phoneNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reader other = (Reader) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (readerTicketNumber != other.readerTicketNumber)
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reader [readerTicketNumber=" + readerTicketNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNumber=" + phoneNumber + "]";
	}

}