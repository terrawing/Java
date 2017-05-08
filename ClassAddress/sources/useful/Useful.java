// Useful.java - class Useful which consists of mainly static methods

package useful;

public class Useful
{

  public static boolean validateUnsignedInteger(String str)
  {
	boolean retval;

	retval = true;   // Assume true (=OK) unless proven otherwise

    for (int k = 0; k < str.length() ; k++)
    {
	   if (  (str.charAt(k) < 48) || (str.charAt(k) > 57) )
	   {
		   retval = false;
	   }
	}
	return retval;
  } // end method

} // end class
