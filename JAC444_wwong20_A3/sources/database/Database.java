// Database.java - database class

package database;

import java.io.*;
import java.util.*;
import java.text.*;
import business.*;
import useful.*;

/**
* Simulate a real SQL database
* <p>Used for data storing in a Hashtable of InventoryItem objects.</p>
* <p>Serialize or deserialize the hashtable.</p>
 @author William Wong
 @version 1.0
*/
public class Database
{
   //----static data
      
   //----instance data  
   /** Collection of Hashtable objects */
   private Hashtable theData;
   /** The InventoryItem objects */
   private InventoryItem ii;
   /** The FileInputStream object for deserializing */   
   private FileInputStream fis = null;
   /** The FileOutputStream object for serializing */      
   private FileOutputStream fos = null;
   /** The ObjectInputStream object for reading after deserializing */   
   private ObjectInputStream ois = null;
   /** The ObjectOutputStream object for writing after serializing */   
   private ObjectOutputStream oos = null;
   /** The File object used for serializing and deserializing */   
   private File serialized = null;

   //---constructors
   /**
	 * <p>Initialize the hashtable object and the location of the file.</p>
    */
   public Database()
   {
	 theData = new Hashtable();
	 /** Initialize where the file will be store after creation or for used when reading */   
	 //serialized = new File("..\\data\\InventoryItems.dat"); //have to change it to forward slash for linux, says in the instruction before handing it in
	 serialized = new File("../data/InventoryItems.dat"); //for linux
   }
   
   //---methods (in sequence by method name)
   
   //-----------------------------------------------------------------insert()
   /**
     * <p>Use the data in the parameter String to create and populate an object of class InventoryItem.  
     * You can decide the format of the parameter, but it is suggested that it might look like the following
     * ~f1~f2~f3~f4~f5~etc~</p>
	 * <p>Add the InventoryItem object to the Hashtable.</p>
	 * <p>Return a string “one record inserted for:  [inventoryId]” if successful.</p>
	 * <p>Return a string “insert failed – zero records inserted for: [inventoryId]” if unsuccessful.</p>
    */
   public String insert(String data)
   {
     String retval = new String();
	 StringBuffer csv = new StringBuffer(data);
	 ii = new InventoryItem();
	 
	 ii.update(csv); //splits it with tokenizer and store in private instance variables of the inventoryitem class
	 
	 //store inventory item object in hashtable
	 theData.put(ii.getPrimaryKey(), ii); //inventoryId is the key string and the inventoryitem object is the value
	 
	 if (theData.isEmpty())
	 {
		retval = "<p>insert failed – zero records inserted for: " + ii.getPrimaryKey() + "</p>";
	 }
	 else
	 {
		retval = "<p>one record inserted for: " + ii.getPrimaryKey() + "</p>";
	 }
	   
	 return retval;
   } //end of insert()
   
   //-----------------------------------------------------------------select()
   /**
     * <p>Use the parameter data to search the Hashtable for the existence of an InventoryItem object whose inventoryId variable 
	 * matches the parameter string.  The key for a Hashtable record is a String with the equivalent value of the inventoryId variable.  
	 * Do this by calling the retrieveData(...) method of class InventoryItem.</p>
	 * <p>Return the array which is returned from the retrieveData() method.</p>
    */
   public String[] select(String id)
   {
     String[] retval = new String[3];
	 
	 retval = InventoryItem.retrieveData(theData, id);
	   
	 return retval;
   } //end of select()
   
   //-----------------------------------------------------------------connect()
   /**
	 * <p>This makes the database available for processing.</p>
	 * <p>De-serialize the hashtable at the start of the second run and on.</p>
    */
   public String connect() throws IOException, ClassNotFoundException
   {
		if (serialized.exists()) //if file exists de-serialize it
		{
		   	System.out.println("Importing data...");
			fis = new FileInputStream(serialized);
			ois = new ObjectInputStream(fis);
			theData = (Hashtable)ois.readObject();
			ois.close();
			return "<p>Connect</p>";
		}
		else
		{
			return "<p>Not connected</p>";
		}

   } //end of connect()
   
   //-----------------------------------------------------------------disconnect()
   /**
	 * <p>Make the database unavailable for further processing.</p>
	 * <p>Serialize the hashtable before ending the run.</p>
    */
   public String disconnect() throws IOException, ClassNotFoundException
   {
      	System.out.println("Saving data...");
		fos = new FileOutputStream(serialized);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(theData); //saves the latest hashtable with the most recent object insert to it
		oos.flush();
		oos.close();
		return "<p>Disconnect</p>";
   } //end of disconnect()
  
} // end class

