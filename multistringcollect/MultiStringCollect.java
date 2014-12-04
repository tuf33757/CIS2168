/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multistringcollect;

/**
 *
 * @author Rob
 */
import java.util.*;
public class MultiStringCollect {
 public static final String SENTINEL = "###";

   public static void main(String[] args)
   {
 String value; Scanner keyboard=new Scanner(System.in);
      MultiStringcoll P=new MultiStringcoll(),
      N=new MultiStringcoll(), L= new MultiStringcoll();

      System.out.println(
      "Enter a +string or -string to be inserted or ### to quit. Don't enter repeat strings:");
      value=keyboard.next();
      while(!value.equals(SENTINEL))
      {
         if (value.charAt(0)=='+')
         {P.insert(value.substring(1)); L.insert(value.substring(1));}
         else
         {
	     N.insert(value.substring(1));

	 }
         System.out.println(
         "Enter +string or -string to be inserted or ### to quit:");
         value=keyboard.next();
      }
      System.out.println("\nThe values in collection P are:");
      P.print();
      System.out.println("\nThe values in collection N are:");
      N.print();
      System.out.println("\nThe values in collection L are:");
      L.print();
      if (P.equals(N)) System.out.println("\nP and N are equal.");
      else System.out.println("\nP and N are NOT equal.");
      MultiStringcoll A=new MultiStringcoll(); A.copy(L);
      System.out.println("\nThe values in the copy of L are:\n");
      A.print();
 
    MultiStringcoll M = new MultiStringcoll ();
    M.insert("+abc");
    M.insert("-hello"); M.insert("-hello");M.insert("-hello");
    M.insert("+today");
    M.print();
    M.omit("-hello");
    M.print();
    M.omit("+today");
    M.print();
   }
    
}
