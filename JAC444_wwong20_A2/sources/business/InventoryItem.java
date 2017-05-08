// InventoryItem.java - business class

package business;

import java.io.*;
import java.util.*;
import java.text.*;
import useful.*;

/**
* Represents a real Inventory Item object
  <p>Used for storing instance items of the company's inventory status.</p>
 @author William Wong
 @version 1.0
*/
public class InventoryItem implements Testable
{
   //----static data
    /** prompts that the user will see if prompt from the keyboard */
	private static String[] prompts =
	{
		"inventoryId  : ",
		"description  : ",
		"pack  : ", 
		"quantityInStock  : ",
		"unitPrice  : ",
		"reorderPoint  : ",
		"reorderQuantity  : ",
		"totalOrdered  : ",
		"totalSalesOrders  : ",
	};
      
	 //----instance data
   
   /** unique identifier for product/package combination */
   private String inventoryId;
   /** description of product */
   private String description;
   /** description of the packaging for this product */
   private String pack;
   /** the amount currently in stock for this inventoryId */
   private int quantityInStock;
   /** the selling price of one unit of this inventoryId */
   private double unitPrice;
   /** quantity at which replenishment should be made */
   private int reorderPoint;
   /** the quantity normally ordered for replenishment */
   private int reorderQuantity;
   /** total of outstanding orders for replenishment */
   private int totalOrdered;
   /** total outstanding sales orders for this inventoryId */
   private int totalSalesOrders;
   /** date and time of previous update to this object */
   private Date lastUpdated;

   //---constructors
   
   /**
   * The only constructor to the class InventoryItem
   * Initialize all non-primitive data items to sensible values.
   */
   public InventoryItem()
   {
		inventoryId = "";
		description = "";
		pack = "";
		quantityInStock = 0;
		unitPrice = 0.00;
		reorderPoint = 0;
		reorderQuantity = 0;
		totalOrdered = 0;
		totalSalesOrders = 0;
		lastUpdated = new Date();
     // any primitives get default initialization
   }
   
   //---methods (in sequence by method name)
   
   //-----------------------------------------------------------------formatDisplay()
   /**
	 * <p>Appends the data from one object to the StringBuffer passed as parameter 1.
     * This method will be used primarily for testing/checking purposes so that 
	 * it is desirable that it be in a format that is easy for you to read, with every instance item displayed.</p>
    */
   public int formatDisplay(StringBuffer sb) throws IOException//StringBuffer temp
   {
     int retval = 0;
	 
	 try
	 {
		 sb.append("\n" + "+++++++++Inventory+++++++++");     
		 sb.append("\n" + "InvID  : " + inventoryId);
		 sb.append("\n" + "Desc  : " + description);
		 sb.append("\n" + "Pack  : " + pack);
		 sb.append("\n" + "QtyInStock  : " + quantityInStock);
		 
		 DecimalFormat decim = new DecimalFormat("#.00");
		 String decValue  =  decim.format(unitPrice);	 
		 sb.append("\n" + "unitPrice  : " + decValue); //it's a string, need to convert it back to double to do anything with it
		 sb.append("\n" + "reorderPoint  : " + reorderPoint);
		 sb.append("\n" + "reorderQuantity  : " + reorderQuantity);
		 sb.append("\n" + "totalOrdered  : " + totalOrdered);
		 sb.append("\n" + "totalSalesOrders  : " + totalSalesOrders);
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String currentDate = dateFormat.format(lastUpdated);
		 sb.append("\n" + "Last Updated  : " + currentDate);
		 sb.append("\n" + "+++++end Inventory+++++++++");     

	 }
	 catch (Exception ex)
	 {
		System.err.println(ex.getMessage());
	   	ex.printStackTrace(System.out); //force and print out the stack trace
		System.exit(9999); //terminate the program
	 }
	   
	 return retval;
   }
	
   //---------------------------------------------------------------------formatReportData_1()
   /**
     * <p>Appends the data from one object, formatted for Report 1, to the StringBuffer passed as parameter 1.  
	 * The format of Report 1 is described in an accompanying document.
     * </p>
    */
	public int formatReportData_1(StringBuffer sb) //format the data like the text file provided
	{
		int retval = 0;
		
		try
		{
			int numSpace = 0;
			String space = new String();
			String temp = new String();
			
			//InventoryId
			sb.append(getPrimaryKey());
			
			//Description
			numSpace = (getPrimaryKey()).length();
			numSpace = 9 - numSpace;
			space = createSpace(numSpace);
			
			sb.append(space + description);
			space = "";
			numSpace = 0;
			
			//Package
			numSpace = description.length();
			numSpace = 21 - numSpace;
			space = createSpace(numSpace);
			
			sb.append(space + pack);
			space = "";
			numSpace = 0;
			
			//ReorderPoint
			numSpace = pack.length();
			numSpace = 22 - numSpace;
			
			temp = Integer.toString(reorderPoint);
			numSpace = numSpace - (temp.length());
			space = createSpace(numSpace);
			
			sb.append(space + reorderPoint);
			space = "";
			numSpace = 0;
			temp = "";
			
			//ReorderQuantity
			temp = Integer.toString(reorderQuantity);
			numSpace = 7 - (temp.length());
			space = createSpace(numSpace);
			
			sb.append(space + reorderQuantity);
			space = "";
			numSpace = 0;
			temp = "";
			
			//UnitPrice
			DecimalFormat decim = new DecimalFormat("#.00");
			temp  =  decim.format(unitPrice);
			numSpace = 8 - (temp.length());
			space = createSpace(numSpace);
			
			sb.append(space + temp + "\n");
			space = "";
			numSpace = 0;
			temp = "";
			
			//LastUpdated
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = dateFormat.format(lastUpdated);
			sb.append("                              " + currentDate);
			
			//TotalOrdered
			numSpace = 12;
			temp = Integer.toString(totalOrdered);
			numSpace = numSpace - (temp.length());
			space = createSpace(numSpace);
			
			sb.append(space + totalOrdered);
			space = "";
			numSpace = 0;
			temp = "";
			
			//QuantityInStock
			temp = Integer.toString(quantityInStock);
			numSpace = 7 - (temp.length());
			space = createSpace(numSpace);
			
			sb.append(space + quantityInStock);
			space = "";
			numSpace = 0;
			temp = "";
			
			//TotalSalesOrders
			temp = Integer.toString(totalSalesOrders);
			numSpace = 5 - (temp.length());
			space = createSpace(numSpace);
			
			sb.append(space + totalSalesOrders + "\n\n");
			space = "";
			numSpace = 0;
			temp = "";
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
		
		return retval;
	}
	
   //---------------------------------------------------------------------createSpace()
   /**
	 *<p>Gets the number required between data fields and return a single line string filled with space between the fields.</p>
	*/
	public String createSpace(int numSpace)
	{
		String space = new String("");
		
		try 
		{
			for(int i = 0; i < numSpace; i++)
			{
				space += " ";
			}
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
		
		return space;
	}

   //---------------------------------------------------------------------formatReportHeadings_1()
   /**
     * <p>Appends the headings, formatted for Report 1, to the StringBuffer passed as parameter 1.  
	 * The format of Report 1 is described on an accompanying document.
     * </p>
    */	
	public static int formatReportHeadings_1(StringBuffer sb)
	{
		int retval = 0;
		
		try
		{
			//sb.append("\n" + "         1         2         3         4         5         6         7     ");
			//sb.append("\n" + "123456789012345678901234567890123456789012345678901234567890123456789012345");
			sb.append("\n");
			sb.append("\n" + "---------------------------------------------------------------------------");
			sb.append("\n" + "Inv Id   Description          Package          Ro-Pt Ro-Qty U-Price        ");
			sb.append("\n" + "                              Last-Upd        RepOrd In Stk  SalOrd        ");
			sb.append("\n" + "---------------------------------------------------------------------------");
			sb.append("\n");
			sb.append("\n");
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
		return retval;
	}

   //---------------------------------------------------------------------getPrimaryKey()
   /**
     * <p>Returns the value of inventoryId (to be used as the key for a possible Hashtable or database primary key or similar purpose). 
     * </p>
    */	
	public String getPrimaryKey()
	{
		try
		{
			return inventoryId;
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
			
		return "";
	}

   
   //---------------------------------------------------------------------decreaseStock()
   /**
     * <p>Decreases the quantityInStock by the amount passed as parameter 1.  
	 * Returns the message “Decreased stock of [inventoryId] by [decAmount].”.  
	 * Substitutes data values for [decAmount] and [inventoryId].
     * </p>
    */
	public String decreaseStock(int decAmount)
	{
		StringBuffer msg = new StringBuffer();
		String returnMsg = new String();
	
		try
		{
			quantityInStock -= decAmount;
			
			while(((quantityInStock + totalOrdered) - totalSalesOrders) < reorderPoint)
			{
				returnMsg = placeReplenishmentOrder();
				msg.append(returnMsg);
			}
			lastUpdated = new Date();
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
		
		return "Decreased stock of " + inventoryId + " by " + decAmount + ". " + msg.toString() + "\n";
	}	
	
   //---------------------------------------------------------------------increaseStock()
   /**
     * <p>Increases the quantityInStock by the amount passed as parameter 1.
	 * Returns the message “Increased stock of [inventoryId] by [incAmount].”  
	 * (substitutes data values for [incAmount] and [inventoryId]). 
	 * Stores the current date and time in lastUpdated.
     * </p>
    */	
	public String increaseStock(int incAmount)
	{
		try
		{
			quantityInStock += incAmount;
			lastUpdated = new Date();
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
		
		return "Increased stock of " + inventoryId + " by " + incAmount + ".\n";
	}

   //---------------------------------------------------------------------placeReplenishmentOrder()
   /**
     * <p>Adds the reorderQuantity to the totalOrdered and returns the message “Replenishment [reorderQuantity] ordered for [inventoryId].”  
	 * (substitutes data values for [reorderQuantity] and [inventoryId]).  
	 * Stores the current date and time in lastUpdated.  
	 * (Note: to test this method, at first you must make it public, but you should then change it to private, 
	 * and recompile your code before you submit your work.  This method should definitely NOT be callable from code in other classes!).
     * </p>
    */		
	private String placeReplenishmentOrder()
	{
		try
		{
			totalOrdered += reorderQuantity;
			lastUpdated = new Date();
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
		
		return "Replenishment " + reorderQuantity + " ordered for " + inventoryId + ". ";
	}

   //---------------------------------------------------------------------placeSalesOrder()
   /**
     * <p>Adds the qtyOrdered to totalSalesOrders and returns the message “Sales Order of [qtyOrdered] for [inventoryId].”  
	 * (substitutes data values for [qtyOdered] and [inventoryId]).  
	 * Stores the current date and time in lastUpdated. 
     * </p>
    */		
	public String placeSalesOrder(int qtyOrdered)
	{
		try
		{
			totalSalesOrders += qtyOrdered;
			lastUpdated = new Date();
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
		
		return "Sales Order of " + qtyOrdered + " for " + inventoryId + ".\n";
	}

   //---------------------------------------------------------------------receiveReplenishment()
   /**
     * <p>Reduces the totalOrdered  by the qtyReceived  then call increaseStock(qtyReceived). 
	 * Return the message “Replenishment received of [qtyReceived] for [inventoryId].” followed by the messages returned 
	 * by the call to the increaseStock() method.  
	 * (substitutes data values for [qtyReceived] and [inventoryId]).  
	 * Stores the current date and time in lastUpdated.
     * </p>
    */		
	public String receiveReplenishment(int qtyReceived)
	{
		String returnMsg = new String();
		
		try
		{
			totalOrdered -= qtyReceived;
			returnMsg = increaseStock(qtyReceived); //increaseStock(int incAmount)
			lastUpdated = new Date();
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }	
		
		return "Replenishment received of " + qtyReceived + " for " + inventoryId + ". " + returnMsg;
	}

   //---------------------------------------------------------------------shipSalesOrder()
   /**
     * <p>Reduces totalSalesOrders by the qtyShipped then calls decreaseStock(qtyShipped).  
	 * Returns the message “Goods [qtyShipped] items shipped for [inventoryId].” followed 
	 * by the message(s) returned by  the call to the decreaseStock() method. 
	 * (substitutes data values for [qtyShipped] and [inventoryId]).  
	 * Stores the current date and time in lastUpdated.
     * </p>
    */	
	public String shipSalesOrder(int qtyShipped)
	{
		String returnMsg = new String();
		
		try
		{
			totalSalesOrders -= qtyShipped;
			returnMsg = decreaseStock(qtyShipped); //decreaseStock(int decAmount)
			lastUpdated = new Date();
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
		
		return "Goods " + qtyShipped + " items shipped for " + inventoryId + ". " + returnMsg;
	}	

   //---------------------------------------------------------------------getData()
   /**
     * <p>Displays prompts and gets data for each instance data item using the MyDataReader object passed as parameter 2.  
	 * It stores (in CSV format)  the data items input in the StringBuffer passed as parameter 1.  
	 * The first character stored in the StringBuffer must be the separator character passed as parameter 3 
	 * then each data item followed by a separator character.   
	 * This method uses the library method getData(...)  in package useful to do this work (which will be covered in the classroom).
     * </p>
    */
    public static int getData(StringBuffer sb, MyDataReader mr, String seperator)
      throws IOException
    {
		int retval = 0;
		
		try
		{
			retval = Useful.getData(prompts, sb, mr, seperator); //calls the library version in class Useful in package useful
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
		
		return retval;
    } // endof getData()
  
  //----------------------------------------------------------------------update()
  /**
   * The StringBuffer passed as parameter 1 is in CSV format and was produced by getData() above.  
   * Creates a StringTokenizer using the first character of the StringBuffer as the separator.  
   * Extracts each token and uses the data to update the instance data items, converting the data as necessary.  
   * Stores the current date and time in lastUpdated.
   */
  public int update(StringBuffer sb)
  {
		int err = 0;  // used to indicate status (0 = normal)
		
		try
		{
			String seperator;      // separator value used by CSV format data
			StringTokenizer tk;       // to extract data
			String temp;    // for extracted data
			
			//--- get separator (value is first character of StringBuffer)
			seperator = String.valueOf(sb.charAt(0));
			//--- create tokenizer (to extract data items)
			tk = new StringTokenizer(sb.toString(), seperator);

			//--- now get tokens and update instance variables
			//    only make change if data is not equal to a single tab 

			temp = tk.nextToken();                   
			if (! temp.equals("\t"))                 
			{                                        
			  // is String - no conversion needed    
			  inventoryId = new String(temp);           
			}                                        
													 
			temp = tk.nextToken();                   
			if (! temp.equals("\t"))                 
			{                                        
			  // is String - no conversion needed    
			  description = new String(temp);           
			}                                        
													 
			temp = tk.nextToken();                   
			if (! temp.equals("\t"))                 
			{                                        
			  // is String - no conversion needed    
			  pack = new String(temp);           
			}                                        
													 
			temp = tk.nextToken();                   
			if (! temp.equals("\t"))                 
			{                                        
			  // is int - conversion needed 
			  quantityInStock = Integer.parseInt(temp);           
			}                                        
													 
			temp = tk.nextToken();                   
			if (! temp.equals("\t"))                 
			{                                        
			  // is double - conversion needed
			  unitPrice = Double.parseDouble(temp);   
			}                                        
													 
			temp = tk.nextToken();                   
			if (! temp.equals("\t"))                 
			{                                        
			  // is int - conversion needed    
			  reorderPoint = Integer.parseInt(temp);           
			}                                        
													 
			temp = tk.nextToken();                   
			if (! temp.equals("\t"))                 
			{                                        
			  // is int - conversion needed    
			  reorderQuantity = Integer.parseInt(temp);           
			}

			temp = tk.nextToken();                   
			if (! temp.equals("\t"))                 
			{                                        
			  // is int - conversion needed    
			  totalOrdered = Integer.parseInt(temp);           
			}
			
			temp = tk.nextToken();                   
			if (! temp.equals("\t"))                 
			{                                        
			  // is int - conversion needed    
			  totalSalesOrders = Integer.parseInt(temp);           
			}
			
			lastUpdated = new Date();
		}
		 catch (Exception ex)
		 {
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		 }
	
    return err; // indicate OK (i.e. no error)
  } // end of update
  
} // end class

