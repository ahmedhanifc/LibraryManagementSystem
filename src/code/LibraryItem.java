package code;

import java.time.LocalDate;
import java.util.Objects;

public class LibraryItem implements MediaItem{
	private String author;
	private Genre genre;
	private String ISBN;
	protected boolean isCheckedOut = false;
	private String title;
	protected int LOAN_PERIOD_IN_DAYS;
	protected LocalDate dueDate;
	protected double LATEFEE;

	
	public LibraryItem(String author,  String title, String ISBN, Genre genre) {
		super();
		this.author = author;
		this.genre = genre;
		this.ISBN = ISBN;
		this.title = title;
	}
	@Override
	public boolean checkout() {
		if(isCheckedOut) return false;
		//if book is already checked out, return false
		//else allow the user to checkout, and return true
		isCheckedOut = true;
		setDueDate();
		return true;
	}

	public int getLOAN_PERIOD_IN_DAYS() {
		return LOAN_PERIOD_IN_DAYS;
	}
	public void setLOAN_PERIOD_IN_DAYS(int lOAN_PERIOD_IN_DAYS) {
		LOAN_PERIOD_IN_DAYS = lOAN_PERIOD_IN_DAYS;
	}
	public double getLATEFEE() {
		return LATEFEE;
	}
	public void setLATEFEE(double lATEFEE) {
		LATEFEE = lATEFEE;
	}
	public void setDueDate(LocalDate date) {
		this.dueDate = date;
	}
	@Override
	public void setDueDate() {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		dueDate = date.plusDays(LOAN_PERIOD_IN_DAYS);
	}
	
	public LocalDate getDueDate() {
		// TODO Auto-generated method stub
		return this.dueDate;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryItem other = (LibraryItem) obj;
		return Objects.equals(ISBN, other.ISBN);
	}
	public String getAuthor() {
		return author;
	}
	
	public Genre getGenre() {
		return genre;
	}
	public String getISBN() {
		return ISBN;
	}
	public String getTitle() {
		return title;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}
	public boolean isCheckedOut() {
		return isCheckedOut;
	}
	@Override
	public boolean returnItem() {
		// TODO Auto-generated method stub
		if(!isCheckedOut) return false;
		// if book is not checkedout, return false
		isCheckedOut = false;
		return true;
		
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setCheckedOut(boolean isCheckedOut) {
		this.isCheckedOut = isCheckedOut;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "LibraryItem [author=" + author + ", genre=" + genre + ", ISBN=" + ISBN + ", isCheckedOut="
				+ isCheckedOut + ", title=" + title + ", LOAN_PERIOD_IN_DAYS=" + LOAN_PERIOD_IN_DAYS + ", dueDate="
				+ dueDate + ", LATEFEE=" + LATEFEE + "]";
	}
	@Override
	public void displayDetails() {
		// TODO Auto-generated method stub
		
	}
}
