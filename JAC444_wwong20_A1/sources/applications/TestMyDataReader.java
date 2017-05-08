// TestMyDataReader.java - application class
package applications;

import java.io.*;
import useful.*;

/**
* Application which uses redirect standard input from a file and display the lines.
* <p>The command arguments must be redirected from the test files from the data directory.</p>
* <p>USAGE IS: java applications.TestMyDataReader < ../data/MyDataReader?.txt where ? = 1, 2 or 3.</p>
*  @version 1.0
*  @author William Wong
*/
public class TestMyDataReader
{
  //============================================static data
  // none

  //============================================instance data
  /** Used to store command line arguments */
  private String[] myArgs;      //  for instance copy of  command line args 
  /** Instantiate or create and object of the MyDataReader class for use */
  private   MyDataReader mr;  // (reference to) the file object   
  //============================================constructors
  // none defined ( :. default constructor provided by compiler )

  //============================================methods
  //=========================(alphabetic by method name)

  //--------------------------------------------init()
  /**
  * Performs one-time intialization at start of application
  * <p>This method sets the size of the string array based on the number of arguments</p>
  * <p>opens input and/output files or database(s)</p> 
  * <p>opens network connections from the myDataReader class</p>
  * @param args arguments from command-line
  */
  private String init(String[] args) throws IOException
  {
    String temp = "";

    myArgs = new String[args.length];

    mr = new MyDataReader();
    return temp;
  } // end of init()

  //--------------------------------------------run()
  /**
  * <p>Controls the major part of the application (typically in 
  * a loop which reads input file(s)).</p>
  * <p>It calls the readLine method in the MyDataReader class and checks the first character of the redirected input file to determined 
  * which character will be used as the comment marker. (The characters are stored as numbers or nothing)</p>
  * <p>The first line is only meant for reading and it will not be display on the standard output, only the second line and on will be display.</p>
  * <p>All new test data files must have a 1 or 2 as first character otherwise it will set the comment marker to null and read everything (excluding the first line).</p>
  */
  private void run()  throws IOException
  {
    String buf;  // (reference to) the String object into which the data will be read
	String tempMarker; //just store the return string for use later
	
    buf = mr.readLine(); // read (next) record from standard input
						 // this first line number determines the marker comment and is only meant for reading and setting the marker not displaying
   
    //checks the first character for 1 or 2 or anything to determine the comment marker
    //default is 1 and it is using the "#" marker
	
	if(buf.charAt(0) == '2') //"!" marker 
	{
		tempMarker = mr.resetMarker("!");
	}
	
	if((buf.charAt(0) != '1') && (buf.charAt(0) != '2')) //using the null marker
	{
		tempMarker = mr.resetMarker(null);
	}	
	
	while (buf != null)
	{
	  //  reads everything from second line and on
	  buf = mr.readLine(); // read (next) record from standard input
	  if(buf == null) 
		{
			System.out.println("**This line is the end of file**");
		}
		else
		{
			System.out.println(buf); //data just read was
		}
	}
		
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
	mr.close();
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
    TestMyDataReader theApp = new TestMyDataReader(); // make object of own class

    theApp.init(args);
    theApp.run();
    theApp.wrap();
  } // end of main()

} // end of class
