/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package intcoll4;

/**
 *Intcoll4
 * @author Rob Zahorchak
 * 2168
 */


import java.util.*;

public class Intcoll4 {

  //*********************************************************************
// FILE NAME    : Intcoll4.java
// DESCRIPTION  : This file contains the class Intcoll4.
//*********************************************************************




   private listNode c;
   private int howMany;

// Default construct for the Intcoll4 object.  This is not passed
// a parameter.  It creates the linked list.
   public Intcoll4()
   {
       c = null;
      howMany = 0;
   }
// Constructor method to create the Intcoll1 object with an array of a specified length,
   //which is the passed parameter. Every index is set to false.
   public Intcoll4(int i)
   {
      c = null;
      howMany = 0;
      
   }
// copy makes an identical copy of the obj passed to it.  
   public void copy(Intcoll4 obj)
   {
	   if (this != obj)
	   {
             c = null;
             listNode f = obj.c;
             listNode d = new listNode();
             listNode e = null;
             
             while (f!=null){    
             d.info = f.info;
             if (e != null){
                 e.link = d;}
             else{ 
             c= d;}
             e = d;
             d = new listNode();
             f = f.link;
             }
             howMany = obj.howMany;
	   }
   }
// belongs will check to see if an int i(passed into it) belongs in the collection
   // and return a boolean true value if it belongs otherwise it will return false.
   // 
   
   public boolean belongs(int i)
   {
       listNode p = c;
       while((p !=null) && (p.info != i))
           p = p.link;
       return (p !=null);
   }

   
   // insert will insert int i into the collection if it is not already present.
   //if the variable is already in the collection it returns.  
   public void insert(int i){
       if (i>0){
          listNode p = c;
          
          while((p!=null)&&(p.info!=i))
                 p = p.link;
              if (p==null){
                  p = new listNode();
                  p.info = i;
                  p.link = c;
                  c = p;
                  howMany++;}
                 
                  
              }
                      
		   
		 }
	   
   

   // Omit is passed int i if it is already in the collection omit will remove it.
   public void omit(int i)
   {
      if (i>0){
          listNode p = c; listNode pred = null;
          while((p !=null)&&(p.info!=i)){
              pred = p;
              p = p.link;
          }
      
      if (p !=null){
          howMany--;
          if (pred!=null){
              pred.link = p.link;
          }
          else{
              c = p.link;
          }    
      }
   }}

   
   // get_howmany counts the number of ints in the collectin and returns the howmany value.
   public int get_howmany()
   {
      
      return howMany;
   }

   
   // print assigns a format for printing the object to the output screen
   public void print()
   {
      listNode p = c;
      System.out.println();
      
      while (p != null){
          System.out.println(p.info);
          p = p.link;

      }

   }

   
   // equals returns a boolean true if the object calling equals, and the one
   // passed into it have the same ints in them.
   public boolean equals(Intcoll4 obj)
   {
      listNode p = c;
      boolean result = howMany == obj.howMany;
      while((p!=null)&& result){
          result = obj.belongs(p.info);
          p = p.link;
      }
      return result;
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



