package intcoll5;

/**
 *
 * @author Rob
 */
//**********************************************************
// FILE: NAME   : intcoll5client.java
// DESCRIPTION  : This is a client of class Intcoll5.
//**********************************************************

import java.util.*;

public class IntColl5Client
{
   public static final int SENTINEL = 0;

   public static void main(String[] args)
   {
       //  creates teh 3 new intcoll2 objects
      int value; Scanner keyboard=new Scanner(System.in);
      IntColl5 P=new IntColl5(), N=new IntColl5(), L= new IntColl5();

      System.out.println("Enter an integer to be inserted or 0 to quit:");
      value=keyboard.nextInt();
      
      // sentinel value is used to tell the collction of number to stop
      
      while(value != SENTINEL  )
      {
         if (value > 0) {P.insert(value); L.insert(value);}
         else {N.insert(-value); L.omit(-value);}
         System.out.println("Enter next integer to be inserted or 0 to quit:");
         value=keyboard.nextInt();
      }
      System.out.println("\nThe values in collection P are:");
      P.print();
      System.out.println("\nThe values in collection N are:");
      N.print();
      System.out.println("\nThe values in collection L are:");
      L.print();
      if (P.equals(N)) System.out.println("\nP and N are equal.");
      else System.out.println("\nP and N are NOT equal.");
      IntColl5 A=new IntColl5(); A.copy(L);
      System.out.println("\nThe values in the copy of L are:\n");
      A.print();
      
      
      
      
      
   }
}

