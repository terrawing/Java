// Useful.java - useful class

package useful;

import java.io.*;
import java.util.*;
import java.text.*;

/**
* Class which uses the library version of getData method to create the csv line in the StringBuffer.
*  @version 1.0
*  @author William Wong
*/
public class Useful
{
	public static int getData(String[] prompts, StringBuffer sb, MyDataReader mr, String seperator)
      throws IOException
    {
      String   buf = ""; // to read into
      int      err = 0;  // used for return value
      int      k = 0;    // loop control

      sb.append(seperator);  // start StringBuffer with separator char

      for (k = 0; k < prompts.length; k++)
      {
        System.err.print(prompts[k]);  // output prompt - leave cursor on same line
        System.err.flush();            // ensure that the data appears
        buf = mr.readLine();           // read the input/response
        if (buf == null)
        {
           // at end of file
           err = -1;
           break;
        }
        //--- data entered may not contain a separator character
        if (  buf.indexOf(seperator) >= 0  )
        {
          err = -2;                     // set return code
          break;                       // finish - break out of loop
        }
        //--- deal with empty input field 
        if ( buf.equals("") )
        {
          buf = "\t";                   // tab to indicate empty field
        }
		
		if( buf.equals("\t") )
		{
			err = -3;
			break;
		}
        //--- data item is OK so add it to StringBuffer
        sb.append(buf + seperator);          // append separator
      } // end for()

      return err;                      // return result/status code
    } // endof getData()
}