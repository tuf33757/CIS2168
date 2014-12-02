/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yourmazewithpath2;

import java.util.*;
import java.io.*;





  //*********************************************************************
// FILE NAME    : IntColl6.java
// DESCRIPTION  : This file contains the class IntColl6.
//*********************************************************************

public class IntColl6
{
   private int howmany;
   private btNode c;


   public IntColl6()
   {
      c = null;
      howmany = 0;
   }

   public IntColl6(int i)
   {
      c = null;
      howmany = 0;
   }

   private btNode copytree(btNode t)
   {
      btNode root=null;
      if (t!=null)
      {
         root=new btNode();
         root.info=t.info; 
         root.left=copytree(t.left);
         root.right=copytree(t.right);
      }
      return root;
   }

   public void copy(IntColl6 obj)
   {
      if (this!=obj)
      {
          howmany=obj.howmany;
          c=copytree(obj.c);  
      }
   }

  public void insert(int i)
   {
      btNode pred=null, p=c;

      while ((p!=null)&&(p.info!=i))
      {
		  pred=p;
		  if (p.info>i)
                      p=p.left;
		  else 
                      p=p.right;
      }
      if (p==null)
      {
         howmany++;
         p=new btNode(i, null, null);
         if (pred!=null)
         {
			 if (pred.info>i) pred.left=p;
			 else pred.right=p;
		 }
		 else c=p;
      }
   }

   public void omit(int i)
   {
        btNode p = c;
        btNode predP = null;
        // Check for the int i in the tree.
        while(p!=null && p.info!=i) {
            predP = p;
            if(p.info < i)
                p = p.right;
            else
                p = p.left;
        }

        if(p!=null) {
            btNode q = p;
            if(p.right==null)
                q = p.left;
            else if(p.left==null)
                q = p.right;
            else {
                btNode j = p.left;
                if(j.right==null) {
                    q = j;
                    q.right = p.right;
                } else {
                    while(j.right.right!=null)
                        j = j.right;
                    q = j.right;
                    j.right = q.left;
                    q.right = p.right;
                    q.left = p.left;
                }
            }

            if(predP==null)
                c = q;
            else if(predP.right==p)
                predP.right = q;
            else
                predP.left = q;

            howmany--;
        }
      
   }
   public void OmitGreater(int i){
       btNode prev = null, p=c;
       if (p!=null){
           while((p!=null)&&(p.info == i)){
               prev =p;
               p = p.right;}
           if (prev==null){
               while((p!=null)&&(p.info > i)){
                   p = p.left;
               }
               if (p!=null){
                   p.right = null;
                   c=p;}else{c=null;}}
               
               else{
                   prev.right = null;}
               }
           }
       
   

   public boolean belongs(int i)
   {
      btNode p=c;
      while ((p!=null)&&(p.info!=i)) 
      {
         if (p.info>i) p=p.left;
         else p=p.right;
      }
      return (p!=null); 
   }

   public int get_howmany() {return howmany;}



   public void print()
   {
      printtree(c);
   }

   public boolean equals(IntColl6 obj)
   {
      int j = 0; boolean result  = (howmany==obj.howmany);
      if (result)
      { 
         int[] a=new int[howmany]; 
         int[] b=new int[howmany];
         toarray(c, a, 0); toarray(obj.c, b, 0);

         j=0;
         while ((result) && (j<howmany))
         {
            result=(a[j]==b[j]); j++;
         }
      }
      return result;
   }

   private void printtree(btNode t, PrintWriter outs)
   {   
	   if (t!=null)
	   {
		   printtree(t.left, outs);
		   outs.println(t.info);
		   printtree(t.right, outs);
	   }
   }

   private void printtree(btNode t)
   {
      if (t!=null)
      {
          printtree(t.left);
          System.out.println(t.info);
          if (t.left != null)
              System.out.println("left tree : " + t.left.info);
          else
              System.out.println("left null");
          if (t.right!=null)
              System.out.println("right tree  :  " + t.right.info);
          else 
              System.out.println("right null");
          printtree(t.right);
      }
   }

   private int toarray(btNode t, int[] a, int i)
   {
      int num_nodes=0;
      if (t!=null)
      {
         num_nodes=toarray(t.left, a, i);
         a[num_nodes+i]=t.info;   
         num_nodes=num_nodes+1+toarray(t.right, a, num_nodes+i+1);
      }
      return num_nodes;
   } 

   private class btNode
   {
       int info; btNode left; btNode right;

       private btNode(int s, btNode lt, btNode rt)
       {
          info=s; left=lt; right=rt;  
       }

       private btNode()
       {
          info=0; left=null; right=null;
       }
   }}


