package Iterator2;

import java.util.Iterator;

public class MarkhamCentralLibrary {
	Library millikenMillsLibrary;
	Library angusGlenLibrary;
	Library cornelCommunityLibrary;

	public MarkhamCentralLibrary(MillikenMillsLibrary millikenMillsLibrary2, Library cornelCommunityLibrary, Library angusGlenLibrary) {
		this.millikenMillsLibrary = millikenMillsLibrary2;
		this.angusGlenLibrary = angusGlenLibrary;
		this.cornelCommunityLibrary = cornelCommunityLibrary;
	}
	
	public void printMenu() {
		Iterator millikenMillsLibraryIterator = millikenMillsLibrary.createIterator();
		Iterator angusGlenLibraryIterator = angusGlenLibrary.createIterator();
		Iterator cornelCommunityLibraryIterator = cornelCommunityLibrary.createIterator();
		
		System.out.println("Using Java Library Iterator...");
		System.out.println("From Milliken Mills Library\n");
		printMenu(millikenMillsLibraryIterator);
		System.out.println("\nFrom Angus Glen Library\n");
		printMenu(angusGlenLibraryIterator);
		System.out.println("\nFrom Cornel Community Library\n");
		printMenu(cornelCommunityLibraryIterator);
	}
	
	public void printMenu(Iterator iterator) {
		while(iterator.hasNext()) {
			String b = "Borrowed";
			LibraryBooks book = (LibraryBooks) iterator.next();
			if(!book.isBorrowed()) {
				b = "In-Stock";
			}
			
			System.out.println(book.getName() + ", ISBN: " + book.getISBN() + ", Status: " + b);
		}
	}
}
