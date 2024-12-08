package code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaAndStreamPractice {
	public static Genre validateGenre(String genre) {
		try {
			return Genre.valueOf(genre);
		}
		catch(java.lang.IllegalArgumentException e) {
			return null;
		}
	}
	public static void displayItemsByGenre(String genre){
		Genre validatedGenre = validateGenre(genre);
		if(validatedGenre == null) {
			System.out.println("Invalid Genre Entry");
			return;
		}
		System.out.println("****Library Items sorted by Genre of: " + genre + "********");
		LibraryManagement.libraryItems.stream().filter(item -> item.getGenre().equals(validatedGenre))
		.forEach(LibraryItem::displayDetails);
	}
	public static void displayItemsByAuthor(String author) {
		List<LibraryItem> items = LibraryManagement.libraryItems.stream().filter(item-> item.getAuthor().equals(author)).collect(Collectors.toList());
		if(items.isEmpty()){
			System.out.println("Author Not Found!");
			return;
		}
		items.forEach(LibraryItem::displayDetails);
	}
	public static void countItemsOfCategory(String category) {
		long count = LibraryManagement.libraryItems.stream().filter(item -> item.getClass().getSimpleName().toLowerCase().equals(category.toLowerCase())).count();
		if(count == 0) {
			System.out.println("Category not found");
		}
		else {
			System.out.println("Items found for category " + category + ": " + count);
		}
	}
	public static void findTheLongestBook() {
		 LibraryItem longestBook = LibraryManagement.libraryItems.stream().filter(item -> item instanceof Book)
			.sorted(Comparator.comparingInt(book -> ((Book) book).getPages()).reversed()).findFirst().orElse(null);
		 if(longestBook == null) {
			 System.out.println("No Book Found in the system");
			 return;
		 }
		 System.out.println("Longest Book Award Goes toooooo.....");
		 longestBook.displayDetails();
	}
	public static void checkedOutItems() {
		List<LibraryItem> items = LibraryManagement.libraryItems.stream().filter(LibraryItem::isCheckedOut).collect(Collectors.toList());
		if(items.isEmpty()) {
			System.out.println("OOpsie doopsie, no items are checked out");
			return;
		}
		 System.out.println("Checked Out Items are.....");
		 items.forEach(LibraryItem::displayDetails);
	}
	public static void groupAndSort() {
		Map<Object, List<LibraryItem>> groupedItems = LibraryManagement.libraryItems.stream().collect(Collectors.groupingBy(item -> item.getClass().getSimpleName()));
				
		System.out.println(groupedItems);
	}
}
