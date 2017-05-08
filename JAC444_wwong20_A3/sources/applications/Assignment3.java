// Assignment3.java - application class
package applications;

import java.io.*;
import java.util.*;
import business.*;
import useful.*;
import sqlProcessor.*;

/**
*  <p>Application which displays prompts for inventory item stats on standard output or redirect from a text file.</p>
*  <p>The command arguments must be redirected from the test file from the data directory or use keyboard prompt.</p>
*  <p>USAGE IS: java applications.Assignment3 < ../data/Assginment3.txt</p>
*  @version 1.0
*  @author William Wong
*/
public class Assignment3
{
  //============================================static data
  // none

  //============================================instance data
  /** Used to store the arguments from the command prompt if needed. */
  private String[] myArgs;      //  for instance copy of  command line args 
  /** Reference to the MyDataReader class for standard input. */
  private MyDataReader mr;  // (reference to) the file object
  /** Reference to the SQLProcessor class for recieving SQL commands. */
  private SQLProcessor sqlp;
  /** Reference to the PrintWriter class to write the html files. */
  private PrintWriter pw;
  //============================================constructors
  // none defined ( :. default constructor provided by compiler )

  //============================================methods
  //=========================(alphabetic by method name)

  //--------------------------------------------init()
  /**
  * <p>Performs one-time intialization at start of application.</p>
  * <p>Opens any (client-based) files needed.</p> 
  * <p>Opens network connections.</p>
  * @param args arguments from command-line
  */
  private String init(String[] args) throws IOException
  {
    String temp = "";

    myArgs = new String[args.length];
    
    // create BufferedReader based on standard input 
    mr = new MyDataReader();
	// create SQLProcessor  object to use the class methods 
	sqlp = new SQLProcessor();
    return temp;
  } // end of init()

  //--------------------------------------------run()
  /**
  * <p>Controls the major part of the application (typically in a loop which reads input file(s))</p>
  * <p>Get the sql command from the user and pass it directly to the SQLProcessor sqlStatement() method.</p>
  * <p>The user will normally type input in one of the 4 valid formats</p>
  */
  private void run()  throws IOException, ClassNotFoundException
  {
    //responsible for serializing and de-serializing the data (the hashtable) although it cannot do the work involved because the application
	//class cannot see the Hashtable because it is private inside class Database
	String buf = new String("");
	String temp = new String();
	String temp2 = new String();
	int i = 0;
	
	temp2 = sqlp.connect();
	
	while (buf != null) //set the number based on number of lines in the text file
	{
		System.out.print("Enter SQL: ");
		System.out.flush();
		try
		{
			buf = mr.readLine();
		}
		catch (Exception ex)
		{
			System.err.println(ex.getMessage());
			ex.printStackTrace(System.out); //force and print out the stack trace
			System.exit(9999); //terminate the program
		}
		if (buf != null)
		{
			temp = sqlp.sqlStatement(buf);
			System.out.println(temp);
			//write the html file
			try
			{
				//pw = new PrintWriter(new File("..\\data\\output" + (i+1)  + ".html")); //have to change it to forward slash for linux, says in the instruction before handing it in
				pw = new PrintWriter(new File("../data/output" + (i+1)  + ".html")); //for linux
				i++;
				pw.println(temp); //writes the line to file
				pw.close();
			}
			catch (Exception ex)
			{
				System.err.println(ex.getMessage());
				ex.printStackTrace(System.out); //force and print out the stack trace
				System.exit(9999); //terminate the program
			}
		}
		else
		{
			System.out.println("\nThis is the end of the file.");
		}
	}
	
	temp2 = sqlp.disconnect();
	
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
    System.out.println("\n+++program ending+++");
    return retval;
  }  // end of wrap()

  //--------------------------------------------main()
  /**
  * This is the first method called.  Controls the application
  * (but the major work is done in the init(), run() and  wrap()
  * methods).
  */
  public static void main(String[] args) 
    throws IOException, ClassNotFoundException
  {
    Assignment3 theApp = new Assignment3(); // make object of own class

    theApp.init(args);
    theApp.run();
    theApp.wrap();
  } // end of main()

} // end of class
