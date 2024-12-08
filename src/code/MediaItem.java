package code;

import java.time.LocalDate;

public interface MediaItem {
	public boolean checkout();
	public boolean returnItem();
	public LocalDate getDueDate();
	public void displayDetails();
	public void setDueDate();

}
