// SkeletonApp.java - application class
package applications;

import java.io.*;
import useful.*;

/**
* Application which displays a welcome message on standard output.
* <p>A name or names may be included in the greeting.  The names are 
* supplied as command-line arguments.</p>
* <p>USAGE IS: java SkeletonApp name1 [name2 etc] # people to greet</p>
*  @version 5.0
*  @author Brian Perry
*/
public class SkeletonApp
{
  //============================================static data
  // none

  //============================================instance data
  /** Used to store the names of people to greet */
  private String[] myArgs;      //  for instance copy of  command line args 
  private   MyDataReader mr;  // (reference to) the file object   
  //============================================constructors
  // none defined ( :. default constructor provided by compiler )

  //============================================methods
  //=========================(alphabetic by method name)

  //--------------------------------------------init()
  /**
  * Performs one-time intialization at start of application
  * <p>This method processes the command-line arguments.</p>
  * @param args arguments from command-line
  * <p>opens input and/output files or database(s)</p> 
  * <p>opens network connections</p>
  */
  private String init(String[] args) throws IOException
  {
    String temp = "";

    myArgs = new String[args.length];

    /* **** uncomment this block to check for the number of args
    if (args.length > 0)
    {
      for (int k = 0; k < args.length; k++)
      {
        myArgs[k] = args[k];    
      }
      System.out.println();
    }
    else
    {
      usage();      // display usage message (run instructions)
      System.err.println("Program terminating abnormally");
      System.exit(9999);  // kills the Java Virtual Machine (JVM)
    }
    */ // ******** end of check for args
    
    // create BufferedReader based on standard input 
    mr = new MyDataReader();
    return temp;
  } // end of init()

  //--------------------------------------------run()
  /**
  * Controls the major part of the application (typically in 
  * a loop which reads input file(s)) but in this case
  * processes the items stored in array names from the array args
  */
  private void run()  throws IOException
  {
    String buf;  // (reference to) the String object into which the data will be read
    
    System.err.print(" enter data: ");
    System.err.flush();
    buf = mr.readLine(); // read (next) record from standard input
    
    while (buf != null)
    {
      //  ********* deal with  input just read  ***********
      System.out.println("data just read was: " + buf + " " );
      // ********** end of deal with input just read ******
      
      // prompt and read next input 
      System.err.flush();
      System.err.print(" enter data: ");
      buf = mr.readLine(); // read (next) record from standard input
    }
    System.out.println();
  }  // end of run()
  

  //--------------------------------------------usage()
  /**
  * Displays a help message for how to use this application
  */
  private void usage()
  {
  System.err.println("USAGE IS: " +
                     "java SkeletonApp name1 [name2 etc] # people to greet");
  } // end of usage()

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
    SkeletonApp theApp = new SkeletonApp(); // make object of own class

    theApp.init(args);
    theApp.run();
    theApp.wrap();
  } // end of main()

} // end of class
