package code;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.transform.stream.StreamSource;

public class MainLibrary {

	public static void main(String[] args) {
		// Books
		Book b1 = new Book("Khalid Hosseini", "A Mountain's Echoed", "6001", Genre.DRAMA, 328);
		LibraryManagement.addItem(b1);
		LibraryManagement.addBook("Arthur Miller", "Death of a Salesman", "9780140481341", Genre.DRAMA, 144);

		LibraryManagement.addBook("George Orwell", "1984", "9780451524935", Genre.DYSTOPIAN, 268);
		LibraryManagement.addBook("Aldous Huxley", "Brave New World", "9780060850524", Genre.DYSTOPIAN, 268);

		LibraryManagement.addBook("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "9780747532699",
				Genre.FANTASY, 223);
		LibraryManagement.addBook("J.R.R. Tolkien", "The Hobbit", "9780261103344", Genre.FANTASY, 310);

		LibraryManagement.addBook("Dan Brown", "The Da Vinci Code", "9780307474278", Genre.MYSTERY, 489);
		LibraryManagement.addBook("Agatha Christie", "Murder on the Orient Express", "9780062073501", Genre.MYSTERY,
				256);

		LibraryManagement.addBook("F. Scott Fitzgerald", "The Great Gatsby", "9780743273565", Genre.CLASSIC, 180);
		LibraryManagement.addBook("Jane Austen", "Pride and Prejudice", "9780141199078", Genre.CLASSIC, 279);

		LibraryManagement.addBook("Harper Lee", "To Kill a Mockingbird", "9780060935467", Genre.HISTORICAL_FICTION,
				281);
		LibraryManagement.addBook("Markus Zusak", "The Book Thief", "9780375842207", Genre.HISTORICAL_FICTION, 552);

		// DVDs
		LibraryManagement.addDVD("Christopher Nolan", "Inception", "2010", Genre.SCI_FI, 148);
		LibraryManagement.addDVD("Ridley Scott", "Blade Runner", "1982", Genre.SCI_FI, 117);

		LibraryManagement.addDVD("Peter Jackson", "The Lord of the Rings: The Fellowship of the Ring", "2001",
				Genre.FANTASY, 178);
		LibraryManagement.addDVD("David Yates", "Harry Potter and the Deathly Hallows: Part 2", "2011", Genre.FANTASY,
				130);

		LibraryManagement.addDVD("Quentin Tarantino", "Pulp Fiction", "1994", Genre.CRIME, 154);
		LibraryManagement.addDVD("Francis Ford Coppola", "The Godfather", "1972", Genre.CRIME, 175);

		LibraryManagement.addDVD("James Cameron", "Titanic", "1997", Genre.ROMANCE, 195);
		LibraryManagement.addDVD("Joe Wright", "Pride & Prejudice", "2005", Genre.ROMANCE, 129);

		LibraryManagement.addDVD("Steven Spielberg", "Jurassic Park", "1993", Genre.ADVENTURE, 127);
		LibraryManagement.addDVD("George Lucas", "Indiana Jones and the Last Crusade", "1989", Genre.ADVENTURE, 127);

		// Journals
		LibraryManagement.addJournal("Alice Johnson", "Exploring Quantum Mechanics", "1234-5678", Genre.SCIENCE,
				"Springer", "2023-10-01");
		LibraryManagement.addJournal("Neil deGrasse Tyson", "Astrophysics for People in a Hurry", "9780393609394",
				Genre.SCIENCE, "W.W. Norton & Company", "2023-11-05");

		LibraryManagement.addJournal("Michael Brown", "Advancements in Artificial Intelligence", "9876-5432",
				Genre.TECHNOLOGY, "IEEE", "2023-09-15");
		LibraryManagement.addJournal("Shane Greenstein", "How the Internet Became Commercial", "9780691178394",
				Genre.TECHNOLOGY, "Princeton University Press", "2023-12-01");

		LibraryManagement.addJournal("Sophia Martinez", "Recent Trends in Medical Research", "1122-3344",
				Genre.MEDICINE, "Elsevier", "2023-08-05");
		LibraryManagement.addJournal("Elizabeth Blackwell", "Pioneering Women in Medicine", "9988-5544", Genre.MEDICINE,
				"Johns Hopkins Press", "2023-07-25");

		LibraryManagement.addJournal("John Doe", "Global Economic Policies Post-COVID", "4455-6677", Genre.ECONOMICS,
				"Oxford University Press", "2023-07-20");
		LibraryManagement.addJournal("Adam Smith", "The Wealth of Nations", "9988-1122", Genre.ECONOMICS,
				"Penguin Classics", "2023-06-15");

		LibraryManagement.addJournal("Emily Davis", "The Psychology of Modern Leadership", "7788-9900",
				Genre.PSYCHOLOGY, "American Psychological Association", "2023-06-12");
		LibraryManagement.addJournal("Sigmund Freud", "Dream Analysis", "1122-33444", Genre.PSYCHOLOGY, "Macmillan",
				"2023-05-10");

		LibraryManagement.addJournal("David Lee", "Climate Change and Renewable Energy", "3344-5566",
				Genre.ENVIRONMENTAL_SCIENCE, "Springer Nature", "2023-05-18");
		LibraryManagement.addJournal("Rachel Carson", "Silent Spring", "6655-4433", Genre.ENVIRONMENTAL_SCIENCE,
				"Houghton Mifflin", "2023-04-22");

		LibraryManagement.addJournal("Emma Wilson", "Innovations in Online Learning", "5566-7788", Genre.EDUCATION,
				"Routledge", "2023-04-22");
		LibraryManagement.addJournal("Paulo Freire", "Pedagogy of the Oppressed", "6655-9988", Genre.EDUCATION,
				"Bloomsbury", "2023-03-15");

		LibraryManagement.addJournal("James Anderson", "Ancient Civilizations and Their Legacy", "9988-7766",
				Genre.HISTORY, "Cambridge University Press", "2023-03-30");
		LibraryManagement.addJournal("Howard Zinn", "A People's History of the United States", "3344-2233",
				Genre.HISTORY, "Harper Perennial", "2023-02-25");

		LibraryManagement.addJournal("Olivia Taylor", "Ethics in the Age of Technology", "6655-44333", Genre.PHILOSOPHY,
				"Princeton University Press", "2023-02-10");
		LibraryManagement.addJournal("Plato", "The Republic", "7788-6677", Genre.PHILOSOPHY, "Oxford World’s Classics",
				"2023-01-15");

		LibraryManagement.addJournal("Liam Miller", "The Mysteries of Black Holes", "8877-6655", Genre.ASTRONOMY,
				"Harvard University Press", "2023-01-25");
		LibraryManagement.addJournal("Carl Sagan", "Cosmos", "6655-9999", Genre.ASTRONOMY, "Random House",
				"2023-01-10");

		/*
		 LibraryManagement.reserveLibraryItem("A Mountain's Echoed");
		 LibraryManagement.checkoutLibraryItem("A Mountain's Echoed");
		 LibraryManagement.cancelReservation("A Mountain's Echoed");
		 LibraryManagement.checkoutLibraryItem("A Mountain's Echoed");
		  
		 LibraryManagement.checkoutLibraryItem("Inception");
		 LibraryManagement.reserveLibraryItem("IEEE Transactions on Computers");
		 LibraryManagement.checkItemDueDate("Inception");
		 
		 b1.setDueDate(LocalDate.now());
		 LibraryManagement.extendItemLoanPeriod("A Mountain's Echoed");
		 LibraryManagement.removeItemByTitle("A Mountain's Echoed");
		 
		 LibraryManagement.returnLibraryItem("A Mountain's Echoed");
		 LibraryManagement.returnLibraryItem("A Mountain's Echoed");
		 */

//		LibraryManagement.displayItems();
		
//		displayMenu();
//		LambdaAndStreamPractice.findTheLongestBook();
		 LambdaAndStreamPractice.groupAndSort();
	}
	
	public static void displayMenu() {
		outerLoop: while (true) {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Press Enter to continue...");
			scanner.nextLine(); // Waits for the user to press Enter
			System.out.println("\nWhat action would you like to perform? ");
			System.out.println("1) Search Item By Genre ");
			System.out.println(
					"DRAMA, DYSTOPIAN, FANTASY, MYSTERY, CLASSIC, HISTORICAL_FICTION, SCI_FI, CRIME, ROMANCE, ADVENTURE, "
							+ "\n"
							+ "SCIENCE, TECHNOLOGY, MEDICINE, ECONOMICS, PSYCHOLOGY, ENVIRONMENTAL_SCIENCE, EDUCATION, HISTORY, "
							+ "PHILOSOPHY, ASTRONOMY");

			System.out.println("2) Reserve Item");
			System.out.println("3) Loan Item");
			System.out.println("4) Return Item");
			System.out.println("5) Lambda Expressions Practice");
			System.out.println("6) Exit");
			int choice = 0;
			System.out.print("Choice: ");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid Entry");
				scanner.nextLine(); // Clear buffer
				continue;
			}
			if (choice == 1) {
				// implement logic to search for a book
				System.out.print("Enter Genre: ");
				String genre = scanner.next();
				genre = genre.toUpperCase();
				LambdaAndStreamPractice.displayItemsByGenre(genre);
			} else if (choice == 2) {
				System.out.print("Enter Title of Item you wish to reserve: ");
				scanner.nextLine(); // Consume the leftover newline character
				String title = scanner.nextLine();
				LibraryManagement.reserveLibraryItem(title);
			} else if (choice == 3) {
				System.out.print("Enter Title of Item you want to Loan: ");
				scanner.nextLine(); // Consume the leftover newline character
				String title = scanner.nextLine();
				LibraryManagement.checkoutLibraryItem(title);
			} else if (choice == 4) {
				System.out.print("Enter Title of Item you want to Return: ");
				scanner.nextLine(); // Consume the leftover newline character
				String title = scanner.nextLine();
				LibraryManagement.returnLibraryItem(title);
			} else if (choice == 5) {
				while (true) {
					System.out.println("\nWhat action would you like to perform? ");
					System.out.println("1) Filter items based on their author: ");
					System.out.println("2) Count the number of items in a specific category (e.g., books, DVDs, or journals): ");
					System.out.println("3) Find the longest book: ");
					System.out.println("4) See checked out items: ");
					System.out.println("5) Filter and Group by Category and sorting alphabetically: ");
					System.out.println("6) Exit");
		            int action = 0;
					try {
						System.out.print("Action: ");
						scanner.nextLine();
		                action = scanner.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Invalid Entry");
				        scanner.nextLine(); // Clear buffer
				        continue;
					}

					if (action == 1) {
						System.out.print("Enter author name you wish to filter by: ");
						scanner.nextLine(); // Consume the leftover newline character
						String author = scanner.nextLine();
						LambdaAndStreamPractice.displayItemsByAuthor(author);
					} 
					else if(action == 2) {
						System.out.print("Enter category you want to the count the items of: ");
						scanner.nextLine(); // Consume the leftover newline character
						String input = scanner.nextLine();
						LambdaAndStreamPractice.countItemsOfCategory(input);
					}
					else if(action == 3) {
						LambdaAndStreamPractice.findTheLongestBook();
					}
					else if(action == 4) {
						LambdaAndStreamPractice.checkedOutItems();
					}
					else if (action == 6) {
		                System.out.println("Exiting to Main Menu...");
						break;
					} else {
						System.out.println("Invalid Action. Try Again");
					}
				}
			}

			else if (choice == 6) {
				break;
			} else {
				System.out.println("Invalid Action. Try Again");
			}
		}
	}

}
