package Iterator2;

public class Main {

	public static void main(String[] args) {
		MillikenMillsLibrary millikenMillsLibrary = new MillikenMillsLibrary();
		CornelCommunityLibrary cornelCommunityLibrary = new CornelCommunityLibrary();
		AngusGlenLibrary angusGlenLibrary = new AngusGlenLibrary();
		
		MarkhamCentralLibrary mcl = new MarkhamCentralLibrary(millikenMillsLibrary, cornelCommunityLibrary, angusGlenLibrary);
		mcl.printMenu();
	}

}

