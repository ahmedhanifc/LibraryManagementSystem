package code;

import java.time.LocalDate;

public class Book extends LibraryItem implements Loanable, Reservable {
	private boolean isReserved = false;
	private int pages;	
	public Book(String author, String title, String iSBN, Genre genre, int pages) {
		super(author, title, iSBN, genre);
		this.pages = pages;
	}
	
	@Override
	public boolean cancelReservation() {
		if(!this.isReserved) return false; // item is not currently reserved
		
		this.isReserved = false;
		return true;
	}

	@Override
	public void displayDetails() {
		// TODO Auto-generated method stub
		System.out.println("*******Book********");
		System.out.println("Author: " + this.getAuthor());
		System.out.println("Title: " + this.getTitle());
		System.out.println("Genre: " + this.getGenre());
		System.out.println("Pages: " + this.pages);
	}
	@Override
	public void extendLoanPeriod() {
		// TODO Auto-generated method stub
		setDueDate();
	}

	public int getPages() {
		return pages;
	}
	public boolean isReserved() {
		return isReserved;
	}
	@Override
	public boolean reserveItem() {
		// TODO Auto-generated method stub
		if(this.isReserved) return false;
		if(this.isCheckedOut()) return false;
		
		this.isReserved = true;
		return true;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}


}
