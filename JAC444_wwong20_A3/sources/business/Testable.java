// Testable.java - Testable interface - business class

package business; // because it will only be used by Business Classes

import java.io.*;

/**
 * <p>Interace class that contains the public instance methods of InventoryItem in the business package.</p>
 @author William Wong
 @version 1.0
 */

public interface Testable
{
	// the public instance methods in the interface
    public int formatDisplay(StringBuffer sb) throws IOException;
	public int formatReportData_1(StringBuffer sb);
	public String createSpace(int numSpace);
	public String getPrimaryKey();
	public String decreaseStock(int decAmount);
	public String increaseStock(int incAmount);
	//public String placeReplenishmentOrder();
	public String placeSalesOrder(int qtyOrdered);
	public String receiveReplenishment(int qtyReceived);
	public String shipSalesOrder(int qtyShipped);	
	public int update(StringBuffer sb); 
}