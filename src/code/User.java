package code;

import java.util.ArrayList;
import java.util.Objects;

public class User {
	private String firstName;
	private String lastName;
	
	private ArrayList<LibraryItem> itemsLoaned = new ArrayList<LibraryItem>();
	private ArrayList<LibraryItem> itemsReserved = new ArrayList<LibraryItem>();
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", itemsLoaned=" + itemsLoaned
				+ ", itemsReserved=" + itemsReserved + "]";
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
	public ArrayList<LibraryItem> getItemsLoaned() {
		return itemsLoaned;
	}
	public void setItemsLoaned(ArrayList<LibraryItem> itemsLoaned) {
		this.itemsLoaned = itemsLoaned;
	}
	public ArrayList<LibraryItem> getItemsReserved() {
		return itemsReserved;
	}
	public void setItemsReserved(ArrayList<LibraryItem> itemsReserved) {
		this.itemsReserved = itemsReserved;
	}
	
	

}
