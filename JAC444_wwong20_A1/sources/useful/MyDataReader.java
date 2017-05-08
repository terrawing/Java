// MyDataReader.java - application class

package useful;

import java.io.*;
import java.util.*;

/**
* Class which uses standard input to stored in BufferedReader to extract one line at a time and reset the comment marker.
*  @version 1.0
*  @author William Wong
*/
public class MyDataReader
{
	//Instance data
	/** Holds the comment marker text */
	private String marker; //holds the comment marker text
	/** Is the stream based on standard input */
	private BufferedReader theReader; //is the stream based on standard input
	
	//private FileReader fr;
/**
* MyDataReader Empty Constructor. Create a BufferedReader based on the standard-input and set the reference, theReader to point to it. "#" is the comment marker.
*/
	public MyDataReader()
	{
		marker = new String("#");
		theReader = new BufferedReader( new InputStreamReader(System.in));
		// try
		// {
			// fr = new FileReader("../data/out.txt");
			// theReader = new BufferedReader(fr);
		// }
		// catch (Exception ex)
		// {
			// return;
		// }
	}
	
/**
* readLine() method used to return the next data item or signals end of file.
*/
	public String readLine()
	{
		String line = new String();
		
		try //test to make sure it can read a line
		{			
			if((line = theReader.readLine()) != null) //it read the line if not eof, if it contains a comment marker it won't do anything and read on
			{
				if(line.length() == 0) //if empty line
				{
					line = "\t"; //set the line as a tab
					return line;
				}
				
				if(marker == null) //if the marker is null just return the line, no checks
				{
					return line;
				}
				
				if((line.charAt(0)) != marker.charAt(0)) //if first character is not a comment marker
				{
					for(int i = 0; i < line.length(); i++) //loop through each character
					{
						if((line.charAt(i)) == marker.charAt(0)) //if the character is a comment marker
						{
							return line.substring(0, i); //return the substring from the beginning to the marker position
						}
					}					
				}
				
				
				else //if it's a comment
				{
					while(line.charAt(0) == marker.charAt(0)) //while it's a comment keep reading 1 line after another till it can break out of this loop
					{
						line = theReader.readLine();
						
						if(line.length() == 0) //if empty line
						{
							line = "\t";
							return line;
						}
					}
										
					if((line.charAt(0)) != marker.charAt(0)) //if first character is not a comment marker
					{
						for(int i = 0; i < line.length(); i++) //loop through each character
						{
							if((line.charAt(i)) == marker.charAt(0)) //if the character is a comment marker
							{
								return line.substring(0, i); //return the substring from the beginning to the marker position
							}
						}
					}
				}
				
				return line;

			}
			
			else //if for some reason the readLine returns end of file when reading lines
			{
				return null;
			}
		}
		
		catch(Exception ex)
		{
			System.err.println("ReadLine Error: " + ex.getMessage());
		}
		
		return "";
	}
/**
* resetMarker(String mkr) method resets the marker text but return the previous setting of the marker. Note that it is possible that mkr is null,
*in which case (the reference) marker must be set to null.
*/
	public String resetMarker(String mkr)
	{
		String tempMarker = new String(marker);
		if(mkr == null) //if it's null set the marker to null
		{
			marker = null;
		}
		else
		{
			marker = mkr;
		}
		
		return tempMarker; //return the previous marker
	}
/**
* close() method is call the close() method of the BufferedReader, theReader
*/
	public void close()
	{
		try //test to close the BufferedReader
		{
			theReader.close(); //close the BufferedReader
		}
		catch(Exception ex) //If there is no line to read in the first place it will throw an exception
		{
			System.err.println("Close Error: " + ex.getMessage());
		}
	}
}
