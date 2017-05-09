package Iterator2;

import java.util.ArrayList;
import java.util.Iterator;

public class AngusGlenLibrary implements Library {
	ArrayList<LibraryBooks> books;
	
	public AngusGlenLibrary() {
		books = new ArrayList<LibraryBooks>();
		addItem("Red Queen", "0062310631", true);
		addItem("Legend of Zelda: Hyrule Historia", "1616550414", false);
		addItem("Ables", "1940262658", false);
	}
	
	public void addItem(String name, String ISBN, boolean borrowed) {
		LibraryBooks book = new LibraryBooks(name, ISBN, borrowed);
		books.add(book);
 	}
	
	public Iterator createIterator() {
		return books.iterator();
	}
}
