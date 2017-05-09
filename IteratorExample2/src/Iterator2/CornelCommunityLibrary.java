package Iterator2;

import java.util.Hashtable;
import java.util.Iterator;

public class CornelCommunityLibrary implements Library {
	Hashtable books;
	int position = 0;
	
	public CornelCommunityLibrary() {
		books = new Hashtable();
		addItem("Into The Still Blue", "0062072099", false);
		addItem("Under The Never Sky", "006207203X", false);
	}
	
	public void addItem(String name, String ISBN, boolean borrowed) {
		LibraryBooks book = new LibraryBooks(name, ISBN, borrowed);
		books.put(position, book);
		position++;
	}
	
	public Iterator createIterator() {
		return books.values().iterator();
	}
}
