// TestInventoryItem.java - application class
package applications;

import java.io.*;
import java.util.*;
import business.*;
import useful.*;

/**
*  <p>Application which displays prompts for inventory item stats on standard output or redirect from a text file.</p>
*  <p>The command arguments must be redirected from the test file from the data directory. Or comment the specific part below (mentioned below) to use keyboard prompt</p>
*  <p>USAGE IS: java applications.TestInventoryItem < ../data/InventoryItem.txt</p>
*  @version 1.0
*  @author William Wong
*/
public class TestInventoryItem
{
  //============================================static data
  // none

  //============================================instance data
  /** Used to store the arguments from the command prompt if needed. */
  private String[] myArgs;      //  for instance copy of  command line args 
  /** Reference to the MyDataReader class for standard input. */
  private MyDataReader mr;  // (reference to) the file object
  /** Reference to the InventoryItem class. */
  private InventoryItem ii; // (reference to) InventoryItem file object  
  //============================================constructors
  // none defined ( :. default constructor provided by compiler )

  //============================================methods
  //=========================(alphabetic by method name)

  //--------------------------------------------init()
  /**
  * <p>Performs one-time intialization at start of application.</p>
  * <p>Opens input and/output files or database(s).</p> 
  * <p>Opens network connections.</p>
  * @param args arguments from command-line
  */
  private String init(String[] args) throws IOException
  {
    String temp = "";

    myArgs = new String[args.length];
    
    // create BufferedReader based on standard input 
    mr = new MyDataReader();
	ii = new InventoryItem();
    return temp;
  } // end of init()

  //--------------------------------------------run()
  /**
  * <p>Controls the major part of the application (typically in 
  * a loop which reads input file(s))</p>
  * <p>Reads the data from the text file and create a csv StringBuffer separated by the comment marker. It then uses the update method which uses StringTokenizer
  * to split all the values into individual values stored in the InventoryItem class and display it in a certain format.</p>
  */
  private void run()  throws IOException
  {
    String buf;  // (reference to) the String object into which the data will be read
	StringBuffer csv = new StringBuffer(128);  // empty stringbuffer for getData()/update()
	StringBuffer display = new StringBuffer(128); //empty stringbuffer for displaying;
	int returned = 0;
	int nextTestData = 0; //have it run the original 3 before changing the values of the data
	StringBuffer outputResultMsg = new StringBuffer(128); //empty stringbuffer for outputting the message when adding or subtracting inventory stocks
	
	try
	{
		returned = InventoryItem.getData(csv, mr, "#"); //appends the Stringbuffer with the csv line
		InventoryItem.formatReportHeadings_1(display);
	}
	catch (Exception ex)
	{
		System.err.println(ex.getMessage());
		ex.printStackTrace(System.out); //force and print out the stack trace
		System.exit(9999); //terminate the program
	}
	
	//System.out.println("\n" + csv); //uncomment to display the csv line
	
	System.out.println();
	while(returned == 0) //default 3
	{
		try
		{
		ii.update(csv); //split it with StringTokenizer and stored in the private instance variables

		//returned = ii.formatDisplay(display);
		// returned = ii.formatReportData_1(display);			
		// System.out.println(display); //This line prints out everything stored in the StringBuffer			
		
		returned = ii.formatReportData_1(display);
						
		csv.setLength(0); // This line gets the next set of data
		returned = InventoryItem.getData(csv, mr, "#");
		}
		catch (Exception ex)
		{
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		}
		
	}// while

	//emptyline here from the InventoryItem.txt file to force break out of the while loop above
	
	//Comment this part to bottom out to just do regular keyboard prompt----------------------------//
	
	try
	{
		//forth set of data - increase stock
		returned = InventoryItem.getData(csv, mr, "#");	
		ii.update(csv);
		outputResultMsg.append(ii.increaseStock(Integer.parseInt(mr.readLine())));
		returned = ii.formatReportData_1(display);
		csv.setLength(0);

		//fifth set of data - decrease stock
		returned = InventoryItem.getData(csv, mr, "#");	
		ii.update(csv);
		outputResultMsg.append(ii.decreaseStock(Integer.parseInt(mr.readLine())));
		returned = ii.formatReportData_1(display);
		csv.setLength(0);
		
		//sixth set of data - decrease stock with place replenishment order
		returned = InventoryItem.getData(csv, mr, "#");	
		ii.update(csv);
		outputResultMsg.append(ii.decreaseStock(Integer.parseInt(mr.readLine())));
		returned = ii.formatReportData_1(display);
		csv.setLength(0);
		
		//Seventh set of data - place sales order
		returned = InventoryItem.getData(csv, mr, "#");	
		ii.update(csv);
		outputResultMsg.append(ii.placeSalesOrder(Integer.parseInt(mr.readLine())));
		returned = ii.formatReportData_1(display);
		csv.setLength(0);
		
		//Eighth set of data - recieveReplenishment
		returned = InventoryItem.getData(csv, mr, "#");	
		ii.update(csv);
		outputResultMsg.append(ii.receiveReplenishment(Integer.parseInt(mr.readLine())));
		returned = ii.formatReportData_1(display);
		csv.setLength(0);
		
		//Nineth set of data - ship sale order
		returned = InventoryItem.getData(csv, mr, "#");	
		ii.update(csv);	
		outputResultMsg.append(ii.shipSalesOrder(Integer.parseInt(mr.readLine())));
		returned = ii.formatReportData_1(display);
		csv.setLength(0);
	}
	catch (Exception ex)
	{
		System.err.println(ex.getMessage());
		ex.printStackTrace(System.out); //force and print out the stack trace
		System.exit(9999); //terminate the program
	}	
	
	//Comment this part to above out to just do regular keyboard prompt----------------------------//
	
	System.out.println(display);
	//System.out.println("\n" + "This is the returned: " + returned);
	System.out.println("\n\n" + outputResultMsg);
    System.out.println();
  }  // end of run()

  //--------------------------------------------wrap()
  /**
  * Performs one-time cleanup just before the application ends.
  * <p>closes input and/output files or database(s)</p> 
  * <p>closes network connections</p>
  */
  private int wrap()
  {
	try
	{
		mr.close();
	}
	catch (Exception ex)
	{
		System.err.println(ex.getMessage());
		ex.printStackTrace(System.out); //force and print out the stack trace
		System.exit(9999); //terminate the program
	}
	
    int retval = 0;
    System.out.println("+++program ending+++");
    return retval;
  }  // end of wrap()

  //--------------------------------------------main()
  /**
  * This is the first method called.  Controls the application
  * (but the major work is done in the init(), run() and  wrap()
  * methods).
  */
  public static void main(String[] args)
    throws IOException
  {
    TestInventoryItem theApp = new TestInventoryItem(); // make object of own class

    theApp.init(args);
    theApp.run();
    theApp.wrap();
  } // end of main()

} // end of class
