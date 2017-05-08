// SQLProcessor.java - sqlProcessor class

package sqlProcessor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import useful.*;
import database.*;

/**
* Represents a simulation of SQL commands that access the database class using database objects.
  <p>Used for simulating SQL commands to get data and returning it into html format.</p>
 @author William Wong
 @version 1.0
*/
public class SQLProcessor 
{
   //----static data
      
   //----instance data  
   /** Instance of class Database */
   private Database db;

   //---constructors
   /**
	 * <p>Initialize the database object</p>
    */
   public SQLProcessor()
   {
	 db = new Database(); 
   }
   
   //---methods (in sequence by method name)

   
   //-----------------------------------------------------------------sqlStatement()
   /**
	 * <p>The parameter String is the sql statement as typed by the user.</p>
	 * <p>Determine the kind of sql statement and call the appropriate insert() or select() method to process it.</p>
	 * <p>Return the data returned from the insert() or select() method.</p>
	 * <p>If the kind of statement is not recognized this method returns an HTML formatted String containing the error message “invalid statement”.</p>
    */
   public String sqlStatement(String str) throws IOException, ClassNotFoundException
   {
	 //calls the private insert or select statements
	 //use System.getProperty(...) for getting the name of the operating system running for h1 tags
     String retval = new String();

	 String ins = "INS";
	 String sel = "SEL";
	 String con = "CON";
	 String dis = "DIS";
	 String query = (str.substring(0,3)).toUpperCase(); //get the first 3 letters of the query
	 
	 // System.out.println("This is query: " + query);
	 // System.out.println("This is file can read: " + serialized.canRead());
	 
	 if (ins.compareTo(query) == 0) //compare the 3 letters of the query to determine if it is insert statement
	 {
		retval = insert(str);
	 }	 
	 
	 else if (sel.compareTo(query) == 0) //select
	 {
		retval = select(str);
	 }
	 
	 else if (con.compareTo(query) == 0) //connect
	 {
		retval = connect();
	 }
	 
	 else if (dis.compareTo(query) == 0) //disconnect
	 {
		retval = disconnect();
	 }
	 
	 else
	 {
		retval = "<p>invalid statement</p>";
		retval = makeInsertHtml(retval);
	 }
	 	   
	 return retval;
   } //end of sqlStatement()
   
   //-----------------------------------------------------------------insert()
   /**
	 * <p>The INSERT statement delivers no result except the key of the InventoryItem concerned, 
	 * the count of the number of database objects updated (zero in the event of a problem and one if successful) 
	 * and a success or failure message</p>
	 * <p>The parameter string is the statement (as entered by the user).</p>
	 * <p>Re-format the string into the format suitable for passing to the insert() method of class Database and call the insert() method of class Database.
	 * <p>Return the string data returned from class Database re-formatted into a String representing an HTML document.</p>
	 * <p>Creates an HTML document (by creating the text <html>.... </html>) in a String; that is the string that is returned.</p>
    */
   private String insert(String istr)
   {
     //use System.getProperty(...) for getting the name of the operating system running for h1 tags
     String retval = new String();
	 StringBuffer sb = new StringBuffer(128);
	 String newSep = "~";
	 String newStr = new String();

	 
	 newStr = istr.substring(7); //so it will be "12345, 'Widgets', 'Box of 10', 100, 10, 20, 50, 150, 242"
	 
	 newStr = newStr.replaceAll(", ", newSep); //so it will be "12345~'Widgets'~'Box of 10'~100~10~20~50~150~242"
	  
	 sb.append(newSep);
	 sb.append(newStr);
	 sb.append(newSep); //so it will be "~12345~'Widgets'~'Box of 10'~100~10~20~50~150~242~"
	 
	 retval = db.insert(sb.toString());
	 
	 retval = makeInsertHtml(retval);
	   
	 return retval;
   } //end of insert()
   
   //-----------------------------------------------------------------select()
   /**
	 * <p>The SELECT statement delivers a result similar to that delivered by a real SQL select statement</p>
	 * <p>The parameter string is the statement (as entered by the user).</p>
	 * <p>Call the select() method of class Database.</p>
	 * <p>Return the data that is returned from class Database reformatted into String representing an HTML document as indicated in the sample data below.</p>
	 * <p>Creates an HTML document (by creating the text <html>.... </html>) in a String; that is the string that is returned.</p>
    */
   private String select(String sstr)
   {
	 //use System.getProperty(...) for getting the name of the operating system running for h1 tags
     String retval = new String();
	 String[] selects = new String[3]; //will return 3 elements
	 StringBuffer sb = new StringBuffer(128);
	 String newStr = new String();
	 
	 newStr = sstr.substring(7);
	 selects = db.select(newStr); //select method in database returns a string array
	 
	 String result = selects[0];
	 String fields = selects[1];	 
	 String value = selects[2];
	 
	 retval = makeSelectHtml(result, fields, value);
	   
	 return retval;
   } //end of select()
   
   //-----------------------------------------------------------------makeSelectHtml()
   /**
	 * <p>The method forms the html tag that will return as 1 entire string for the select statement.</p>
    */
   private String makeSelectHtml(String result, String fields, String value) 
   {
		StringBuffer sb = new StringBuffer(128);
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<link rel='stylesheet' type='text/css' href='InventoryItem.css' />\n"); //css
		sb.append("<title>My Pretend " + System.getProperty("os.name") + " Database - select</title>\n");
		sb.append("</head>\n");
		sb.append("<body>\n");
		sb.append("<h1>Running on " + System.getProperty("os.name") + "</h1>\n"); 
		if(result == "0")
		{
			sb.append(fields + "\n");
		}
		else //1
		{
			StringTokenizer tkfields = new StringTokenizer(fields, "~");
			StringTokenizer tkvalue = new StringTokenizer(value, "~");
			
			for(int i = 0; i < 10; i++)
			{
				sb.append("<p>" + tkfields.nextToken() + tkvalue.nextToken() + "</p>\n");
			}				

		} //else
		sb.append("</body>\n");
		sb.append("</html>\n");
		
		return sb.toString();
   } //end of makeHtml
   
   //-----------------------------------------------------------------makeInsertHtml()
   /**
	 * <p>The method forms the html tag that will return as 1 entire string for the insert statement.</p>
    */
   private String makeInsertHtml(String insertResult) 
   {
		StringBuffer sb = new StringBuffer(128);
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<link rel='stylesheet' type='text/css' href='InventoryItem.css' />\n"); //css
		sb.append("<title>My Pretend " + System.getProperty("os.name") + " Database - insert</title>\n");
		sb.append("</head>\n");
		sb.append("<body>\n");
		sb.append("<h1>Running on " + System.getProperty("os.name") + "</h1>\n"); 
		sb.append(insertResult + "\n");
		sb.append("</body>\n");
		sb.append("</html>\n");
		
		return sb.toString();
   } //end of makeHtml
   
   //-----------------------------------------------------------------connect()
   /**
	 * <p>This makes the database available for processing.</p>
	 * <p>Calls the database connect method.</p>
    */
   public String connect() throws IOException, ClassNotFoundException
   {
		String temp = new String();
		temp = db.connect();
		return makeInsertHtml(temp);
   } //end of connect()
   
   //-----------------------------------------------------------------disconnect()
   /**
	 * <p>Make the database unavailable for further processing.</p>
	 * <p>Calls the database disconnect method.</p>
    */
   public String disconnect() throws IOException, ClassNotFoundException
   {	 
		String temp = new String();
		temp = db.disconnect();
		return makeInsertHtml(temp);
   } //end of disconnect()
  
} // end class

