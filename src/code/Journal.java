package code;

import java.time.LocalDate;

public class Journal extends LibraryItem implements Loanable {
	private String publicationDate;
	private String publisher;

	public Journal(String author, String title, String iSBN,Genre genre, String publisher, String publicationDate) {
		super(author, title, iSBN, genre);
		this.publisher = publisher;
		this.publicationDate = publicationDate;
	}
	
	@Override
	public boolean checkout() {
		// TODO Auto-generated method stub
		boolean canCheckOut = super.checkout();
		if(!canCheckOut) return false;
		setDueDate();
		return true;
	}

	public double getLATEFEE() {
		return LATEFEE;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public void extendLoanPeriod() {
		// TODO Auto-generated method stub
		setDueDate();
	}

	@Override
	public LocalDate getDueDate() {
		// TODO Auto-generated method stub
		return this.dueDate;
	}

	@Override
	public void displayDetails() {
		// TODO Auto-generated method stub
		System.out.println("*******Journal********");
		System.out.println("Author: " + this.getAuthor());
		System.out.println("Title: " + this.getTitle());
		System.out.println("Genre: " + this.getGenre());
		System.out.println("Publisher: " + this.publisher);
		System.out.println("Publication Date: " + this.publicationDate);
	}
	@Override
	public void setDueDate() {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		dueDate = date.plusDays(LOAN_PERIOD_IN_DAYS);
	}

}
