
package intcoll5;

/**
 *IntColl5
 * @author Rob Zahorchak
 * 2168
 */


import java.util.*;

public class IntColl5 {

  //*********************************************************************
// FILE NAME    : IntColl5.java
// DESCRIPTION  : This file contains the class IntColl5.
//*********************************************************************




   private LinkedList<Integer> c;
   

// Default construct for the IntColl5 object.  This is not passed
// a parameter.  It creates the linked list.
   public IntColl5()
   {
       c = new LinkedList<Integer>();
      
   }
// Constructor method to create the Intcoll1 object with an array of a specified length,
   //which is the passed parameter. Every index is set to false.
   public IntColl5(int i)
   {
        c = new LinkedList<Integer>();
      
      
   }
// copy makes an identical copy of the obj passed to it.  It first create an
   // array of the same length as the paramter obj, and then copies each 
   //index of obj to the new array.  it also copies the howMany value for the 
   //parameter
   public void copy(IntColl5 obj)
   {
	   if (!this.equals(obj))
	   {
              c = new LinkedList<Integer>();
              ListIterator<Integer> I = obj.c.listIterator();
              
              while (I.hasNext()){
                  Integer n = I.next();
                  c.add(n);
              }
              
           }
   }
// belongs will check to see if an int i(passed into it) belongs in the collection
   // and return a boolean true value if it belongs otherwise it will return false.
   // 
   
   public boolean belongs(int i)
   {
       Integer I = new Integer (i);
       
       return (c.indexOf(I) != -1);
   }

   
   // insert will insert int i into the collection if it is not already present.
   //if the variable is already in the collection it returns.  
   public void insert(int i){
       if (i>0){
           Integer I = new Integer (i);
           if(!c.contains(I))
            c.add(i);
                  }
      }
	   
   

   // if int i is already in the collection omit will remove it.
   public void omit(int i)
   {
      if (i>0){
          Integer I = new Integer (i);
          if (c.contains(I)){
          c.remove(I);}}}

   
   // get_howmany counts the number of ints in the collectin and returns the howmany value.
   public int get_howmany()
   {
      
      return c.size();
   }

   
   // print assigns a format for printing the object to the output screen
   public void print()
   {
      ListIterator p = c.listIterator();
      System.out.println();
      while (p.hasNext()){
      
      
      System.out.println(p.next());
      }

   }

   
   // equals returns a boolean true if the object calling equals, and the one
   // passed into it have the same ints in them.
   public boolean equals(IntColl5 obj)
   {
      return c.equals(obj.c);
   }
   
   // Innerclass listnode
   public class listNode {
       private int info;
       private listNode link;
       
       public listNode(){
           info = 0;
           link = null;
       }
       public listNode (int i, listNode l){
           info = i;
           link = l;
       }
   }}



