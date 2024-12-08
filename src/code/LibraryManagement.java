package code;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class LibraryManagement {
	static ArrayList<LibraryItem> libraryItems = new ArrayList<LibraryItem>();
	private static int countLibraryItems = 0;
	
	public static void addBook(String author, String title, String iSBN, Genre genre, int pages) {
		addItem(new Book(author, title, iSBN, genre, pages));
	}
	public static void addJournal(String author, String title, String iSBN, Genre genre, String publisher, String publicationDate) {
		addItem(new Journal(author, title, iSBN, genre, publisher, publicationDate));
	}
	public static void addDVD(String author, String title, String iSBN, Genre genre, int runTime) {
		addItem(new DVD(author, title, iSBN, genre, runTime));
	}
	public static void removeBook(String title) {
		boolean isRemoved = false;
		Book bookToRemove = null;
		if(countLibraryItems!=0) {
			for(LibraryItem item:libraryItems) {
				if(item instanceof Book && item.getTitle() == title) {
					bookToRemove = (Book)item;
					isRemoved = true;
				}
			}
			if(!isRemoved) {
				System.out.println("Title is not present in the library");
			}
			else {
				removeItem(bookToRemove);
			}
		}
	}

	public static void removeItemByTitle(String title) {
		LibraryItem item = searchLibraryItem(title);
		if(item==null) {
			System.out.printf("Item: %s not found in library\n", title);
			return;
		}
		if(item.isCheckedOut()) {
			System.out.printf("%s: %s is currently checked out. Cannot remove this right now\n", item.getClass().getSimpleName(), item.getTitle());
			return;
		}
		// How can I prevent deletion of item if the item is currently reserved?
		// Struggling with thinking of this because one of the items cannot be reserved
		libraryItems.remove(item);
		countLibraryItems--;
		System.out.printf("%s: %s is successfully removed from the library\n", item.getClass().getSimpleName(), item.getTitle());
	}
	public static void addItem(LibraryItem item) {
		if(item!=null && !libraryItems.contains(item)) {
			libraryItems.add(item);
			countLibraryItems ++;
//			System.out.printf("%s: %s has been added to the library\n", item.getClass().getSimpleName(), item.getTitle());
		}
		else {
			System.out.printf("%s: %s is already present in the library\n", item.getClass().getSimpleName(), item.getTitle());
		}
	}
	public static void removeItem(LibraryItem item) {
		if(item!=null && libraryItems.contains(item)) {
			libraryItems.remove(item);
			countLibraryItems --;
			System.out.printf("%s: %s is successfully removed from the library\n", item.getClass().getSimpleName(), item.getTitle());
		}
		else {
			System.out.printf("%s: %s is not present in the library\n", item.getClass().getSimpleName(), item.getTitle());
		}
	}
	public static void displayItems() {
		if(!libraryItems.isEmpty()) {
			for(LibraryItem item: libraryItems) {
				item.displayDetails();
			}
		}
		else {
			System.out.println("Library currently doesn't have any items");
		}
	}
	public static void checkoutLibraryItem(String title) {
		LibraryItem item = searchLibraryItem(title);
		if(item==null) {
			System.out.printf("Item: %s not found in library\n", title);
			return;
		}
		if(item.checkout()) {
			System.out.printf("Congrats, You Borrowed %s: %s\n", item.getClass().getSimpleName(),title);
			return;
		}
		else {
			System.out.printf("%s: %s is already been checked out or reserved. Please try again later\n", item.getClass().getSimpleName(),title);
		}
	}
	public static void checkItemDueDate(String title) {
		LibraryItem item = searchLibraryItem(title);
		if(item==null) {
			System.out.printf("Item: %s not found in library\n", title);
			return;
		}
		if(item.isCheckedOut) {
			int timeRemaining  = item.getDueDate().compareTo(LocalDate.now());
			System.out.printf("Due date of %s is %s\n", item.getTitle(), item.getDueDate());
			System.out.printf("You still have %d days remaining\n", timeRemaining);

			
		}
		else {
			System.out.println("Item is not currently borrowed");
		}
	}
	

	public static LibraryItem searchLibraryItem(String title) {
		if(libraryItems.isEmpty()) {
			System.out.println("The Library Doesn't have any items currently");
			return null;
		}
		for(LibraryItem item: libraryItems) {
			if(item.getTitle().equals(title)) return item;
		}
		return null;
	}
	
	public static void reserveLibraryItem(String title) {
		LibraryItem item = searchLibraryItem(title);
		if(item==null) {
			System.out.printf("Item: %s not found in library\n", title);
			return;
		}
		if(item instanceof Reservable) {
			if(((Reservable) item).reserveItem()) {
				System.out.printf("Congrats, You Reserved %s: %s\n", item.getClass().getSimpleName(),title);
				return;
			}
			else {
				System.out.printf("%s: %s is already been checked out or reserved. Please try again later\n", item.getClass().getSimpleName(),title);
			}
		}
		else {
			System.out.printf("Item: %s cannot be reserved\n", title);
			return;
		}
	}
	public static void cancelReservation(String title) {
		LibraryItem item = searchLibraryItem(title);
		if(item==null) {
			System.out.printf("Item: %s not found in library\n", title);
			return;
		}
		if(item instanceof Reservable) {
			if(((Reservable) item).cancelReservation()) {
				System.out.printf("%s: %s Reservation has successfully been cancelled\n", item.getClass().getSimpleName(),title);
				return;
			}
			else {
				System.out.printf("%s: %s is not reserved\n", item.getClass().getSimpleName(),title);
			}
		}
		else {
			System.out.printf("Item: %s cannot be reserved\n", title);
			return;
		}

	}
	public static void extendItemLoanPeriod(String title) {
		LibraryItem item = searchLibraryItem(title);
		if(item==null) {
			System.out.printf("Item: %s not found in library\n", title);
			return;
		}
		if(!(item instanceof Loanable)) {
			System.out.println("This Item cannot be Loaned");
			return;
		}
		int timeRemaining  = item.getDueDate().compareTo(LocalDate.now());
		if(timeRemaining > 5) {
			System.out.printf("You still have %d days remaining. Cannot Extend Load before 5 days are left.\n", timeRemaining);
			return;
		}
		
		((Loanable) item).extendLoanPeriod();
		System.out.printf("Loan for %s has successfully been extended. New Due date is: %s\n", item.getTitle(), item.getDueDate());
	}
	
	public static void returnLibraryItem(String title) {
		LibraryItem item = searchLibraryItem(title);
		if(item==null) {
			System.out.printf("Item: %s not found in library\n", title);
			return;
		}

		if(item.returnItem()) {
			System.out.printf("%s: %s has been returned! \n", item.getClass().getSimpleName(),title);
			return;
		}
		else {
			System.out.printf("%s: %s is not checked out\n", item.getClass().getSimpleName(),title);
			return;
		}
	}
}
