// TestAddress.java
package applications;

import java.io.*;
import java.util.*;
import business.*;
import useful.*;

/**
 Purpose is to test class Address ... which involves.
 <ul>
   <li>making one or more objects of the class</li>
   <li>calling each constructor at least once
     <p>examining the data in the object concerned</p>
   </li>
   <li>calling each method at least once
     <p>with various data as parameter(s)</p>
     <p>examining the return value</p>
     <p>examining the data in the object concerned</p>
   </li>
 </ul>
<p>
  Run instructions...
  <pre>
  java TestAddress [ &lt; Address.txt ]
  </pre>
</p>

*/
public class TestAddress
{
   //=========static data===============
   //none

   //=========sinstance data===============

  private MyDataReader br;
  
  /**
   Perform initialization tasks when the program starts.
   <ul>
     <li>process the command-line options (from param list)</li>
     <li>open file(s) as necessary</li>
     <li>open network-connection(s) as necessary</li>
   </ul>
   @param args the command line arguments 
  */
  private void init(String[] args)   throws IOException
  {
  
    System.out.println("+++ TestAddress starting at: " + new Date());

    // open a suitable input stream on standard input
    br = new MyDataReader();
    // br = new ScriptRdrX();

  } // end method

  /** run()
   Do major part of processing, probably in a loop.
   <ul>
     <li>possibly call static method(s) of class</li>
     <li>make object(s) of other classes (by calling constructor(s))</li>
     <li>call instance method(s) of those classes
       <p>display return value for examination</p>
       <p>display contents of class variables or objects affected</p>
     </li>
   </ul>
  */
  private void run()    throws IOException
  {
    int counter = 0;
    StringBuffer csv = new StringBuffer(128);  // empty sstring for getData()/update()
    Address nemo;
    int returned;
    StringBuffer sb = new StringBuffer(128); // empt string for displaying

    System.out.println("\n+++++++++++++++ Test " + ++counter + "++++++++++++");

    // get first set of data
    returned = Address.getData(csv, br, "~");

    // special case -3 means prompts array in TestNoVars is empty
    if (returned == -3)
    {
      // make object of target class
      nemo = new Address();
      // there may be instance vars initialized by constructor
      nemo.formatDisplay(sb);
      System.out.println(sb);
    }
    else
    {
      while (returned == 0)
      {
        System.out.println("\n+++StringBuffer csv after getData() is :"  +  csv);
        nemo = new Address();
        System.out.println("nemo, immdiately after construction, follows");
        sb.setLength(0);
        returned = nemo.formatDisplay(sb);
        System.out.println(sb);

        nemo.update(csv);
        System.out.println("nemo, immdiately after update(), follows");
        sb.setLength(0);
        returned = nemo.formatDisplay(sb);
        System.out.println(sb);

        System.out.println("+++++++++ end of Test " + counter + "+++++++++++");
        System.out.println("\n+++++++++++++++ Test " + ++counter + "++++++++++++");

        // get next set of data
        csv.setLength(0);
        returned = Address.getData(csv, br, "~");
      } // end while()
    } // end if/else
    System.out.println(">>>> data-entry loop ended with return code: " + returned);    
  } // end method

  /**
   Do any cleanup tasks just before the program ends.
   <ul>
     <li>close file(s) used</li>
     <li>close network-connections(s) used</li>
   </ul>
  */
  private void wrap()
  {
    System.out.println("+++ TestAddress ending at: " + new Date());
  } // end method

  /** 
   Makes an object of its own class then calls instance methods
   to perform the application tasks. This is the first method called
   when the program starts.
   
   @param args the command line arguments 
  */
  public static void main(String[] args)   throws IOException
  {
    TestAddress theApp = new TestAddress();
    theApp.init(args);
    theApp.run();
    theApp.wrap();
  } // end main()
}  // end class

