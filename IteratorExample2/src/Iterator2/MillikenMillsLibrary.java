package Iterator2;

import java.util.Iterator;

public class MillikenMillsLibrary implements Library {
	static final int MAX_BOOKS = 10;
	int numberOfBooks = 0;
	LibraryBooks[] books;
	
	public MillikenMillsLibrary() {
		books = new LibraryBooks[MAX_BOOKS];
		addItem("American Sniper", "0062376330", false);
		addItem("The Martian", "0804139024", true);
		addItem("Red Rising", "0345539788", true);
	}
	
	public void addItem(String name, String ISBN, boolean borrowed) {
		LibraryBooks book = new LibraryBooks(name, ISBN, borrowed);
		
		if(numberOfBooks >= MAX_BOOKS)
			System.out.println("Library is full, cannot store more books");
		else {
			books[numberOfBooks] = book;
			numberOfBooks++;
		}
 	}
	
	//Don't want the getBooks method anymore because it exposes the internal implementation
//	public LibraryBooks[] getBooks() {
//		return books;
//	}
	
	public Iterator createIterator() {
		return new MillikenMillsLibraryIterator(books);
	}
}
