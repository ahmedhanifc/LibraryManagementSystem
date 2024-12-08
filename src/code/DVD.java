package code;

import java.time.LocalDate;

public class DVD extends LibraryItem implements Reservable {
	private boolean isReserved = false;
	int runTime;

	public DVD(String author,  String title, String iSBN,Genre genre, int runTime) {
		super(author, title, iSBN, genre);
		this.runTime = runTime;
	}
	/*
	@Override
	public boolean checkout() {
		// TODO Auto-generated method stub
		boolean canCheckOut = super.checkout();
		if(!canCheckOut) return false;
		if(isReserved) {
			isCheckedOut = false;
			return false;
		}
		setDueDate();
		return true;
	}
*/
	@Override
	public void displayDetails() {
		// TODO Auto-generated method stub
		System.out.println("*******Journal********");
		System.out.println("Director: " + this.getAuthor());
		System.out.println("Title: " + this.getTitle());
		System.out.println("Genre: " + this.getGenre());
		System.out.println("Run Time: " + this.runTime);
	}

	@Override
	public LocalDate getDueDate() {
		// TODO Auto-generated method stub
		return this.dueDate;
	}
	
	@Override
	public void setDueDate() {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		dueDate = date.plusDays(LOAN_PERIOD_IN_DAYS);
	}
	
	public double getLATEFEE() {
		return LATEFEE;
	}

	public int getLOANPERIODINWEEKS() {
		return LOAN_PERIOD_IN_DAYS;
	}

	public int getRunTime() {
		return runTime;
	}
	@Override
	public boolean reserveItem() {
		// TODO Auto-generated method stub
		if(this.isReserved) return false;
		if(this.isCheckedOut()) return false;
		
		this.isReserved = true;
		return true;
	}
	@Override
	public boolean cancelReservation() {
		if(!this.isReserved) return false; // item is not currently reserved
		
		this.isReserved = false;
		return true;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

}
