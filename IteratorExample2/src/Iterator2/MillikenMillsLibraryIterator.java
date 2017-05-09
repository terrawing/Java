package Iterator2;

import java.util.Iterator;

public class MillikenMillsLibraryIterator implements Iterator {
	LibraryBooks[] books;
	int position = 0;

	public MillikenMillsLibraryIterator(LibraryBooks[] books) {
		this.books = books;
	}
	
	@Override
	public boolean hasNext() {
		if(position >= books.length || books[position] == null)
			return false;
		else
			return true;
	}

	@Override
	public Object next() {
		LibraryBooks lb = books[position];
		position++;
		return lb;
	}

	@Override
	public void remove() { 
		//need to add a remove because the Library is using a fixed sized Array
		//Shift all the elements up one when removed is called
		if(position <= 0)
			throw new IllegalStateException("Can't remove an item till next() is run");
		
		if(books[position - 1] != null) {
			for(int i = position - 1; i < (books.length - 1); i++)
				books[i] = books[i+1];
			
			books[books.length - 1] = null;
		}
	}

}
