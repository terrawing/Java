// TestValidation.class
package applications;

import useful.*;

public class TestValidation
{
   public static void main(String[] args)
   {
     if (args.length > 0)
     {
       boolean isOK = true; // assume it will be OK
       isOK = Useful.validateUnsignedInteger(args[0]);
       if(isOK)
       {
         System.out.println(args[0] + " is a valid unsigned number");
       }
       else
       {
         System.out.println(args[0] + " is NOT a valid unsigned number");
       }
     }
     else
     {
       System.err.println("Must have at least one argument");
       System.exit(-99);
     }

   } // end main

} // class
