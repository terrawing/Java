package Iterator2;

public class LibraryBooks {
	String name;
	String ISBN;
	boolean borrowed;
	
	public LibraryBooks(String name, String ISBN, boolean borrowed) {
		this.name = name;
		this.ISBN = ISBN;
		this.borrowed = borrowed;
	}
	
	public String getName() {
		return name;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public boolean isBorrowed() {
		return borrowed;
	}
}
