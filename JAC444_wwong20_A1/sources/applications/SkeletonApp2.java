// Lab3.java - application class

package applications;

import java.io.*;
import useful.*;

/**
* Application which reads date arguments from a file and convert to another date format.
*  @version 1.0
*  @author William Wong
*/
public class SkeletonApp2
{
  //============================================static data
  // none

  //============================================instance data
  /** reference to the file object which will read the data */
  private MyDataReader mr;    // (reference to) the file object which will read the data
  /** file object which will read the data */
  //private FileReader fr;
 /** string that will print the result of the date conversions */
  private String outputResult;
  //============================================constructors
  // none defined ( :. default constructor provided by compiler )

  //============================================methods
  //=========================(alphabetic by method name)

  //--------------------------------------------init()
  /**
  * Performs one-time intialization at start of application
  * <p>This method opens the file for reading.</p>
  * <p>Opens network connections.</p>
  * <p>Catches any exception if any.</p> 
  */
  private void init()
  {
	try 
	{
		// create the file object (it is open when created)	
		mr = new MyDataReader();
		outputResult = new String();
	}
	catch (Exception ex) 
	{
		System.err.println("Error: " + ex.getMessage());
	}
  } // end of init()

  //--------------------------------------------run()
  /**
  * Controls the major part of the application (typically in 
  * a loop which reads input file(s)), it keeps reading as long it is not end of stream.
  */
  private void run() throws IOException  
  {	
	System.out.println();
	System.out.println(mr.resetMarker("$"));
	System.out.println();
	
	for(int i = 0; i < 6; i++) {
		outputResult += mr.readLine();
		outputResult += "\n";
	}
	//outputResult = mr.readLine();
	
	System.out.println();
	System.out.println(outputResult);
  }  // end of run()

  //--------------------------------------------wrap()
  /**
  * Performs one-time cleanup just before the application ends.
  * <p>Close any open files.</p>
  * <p>Tells the user the program is ending.</p> 
  */
  private int wrap() throws IOException  
  {
  	mr.close(); //close the file when all reading is done
    int retval = 0;
    System.out.println("+++program ending+++");
    return retval;
  }  // end of wrap()

  //--------------------------------------------main()
  /**
  * This is the first method called. Controls the application
  * (but the major work is done in the init(), run() and  wrap()
  * methods).
  */
  public static void main(String[] args)
    throws IOException
  {
    SkeletonApp2 theApp = new SkeletonApp2(); // make object of own class

    theApp.init();
    theApp.run();
    theApp.wrap();
  } // end of main()

} // end of class
