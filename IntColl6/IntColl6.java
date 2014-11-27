/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll6;

/**
 *
 * @author tuf33757
 */
import java.util.*;

public class IntColl6
{
    private static class btNode {
        public btNode l;
        public btNode r;
        public int info;
        public btNode() {
            l = null; r = null; info = 0;
        }
        public btNode(int i, btNode lt, btNode rt) {
            l = lt; r = rt; info = i;
        }
    }
    private btNode c;
    private int how_many;

    // Initializes IntColl6 instance which can hold 500 ints
    public IntColl6()
    {
        c = null;
        how_many = 0;
    }

    // Initializes IntColl6 instance which can hold i ints
    public IntColl6(int i)
    {
        c = null;
        how_many = 0;
    }

    // Copys contents of IntColl6 instance named obj to this
    public void copy(IntColl6 obj)
    {
        if (this != obj)
        {
            c = btclone(obj.c);
            how_many = obj.how_many;
        }
    }

    // Returns true if collection contains int i, false if otherwise
    public boolean belongs(int i)
    {
        btNode p = c;
        while(p!=null && p.info!=i) {
            if(p.info < i)
                p = p.r;
            else
                p = p.l;
        }
        return p!=null;
    }

    // Inserts i into collection. If collection already contains i, function returns
    //   if collection is filled to capacity, capacity is doubled
    public void insert(int i)
    {
        if(c==null) {
            c = new btNode(i, null, null);
            how_many++;
            return;
        }

        btNode p = c;
        btNode prev = p;
        while(p!=null && p.info!=i) {
            prev = p;
            if(p.info < i)
                p = p.r;
            else
                p = p.l;
        }

        if(p==null) {
            if(prev.info < i)
                prev.r = new btNode(i, null, null);
            else
                prev.l = new btNode(i, null, null);
            how_many++;
        }
    }

    // If collection contains i, i will be omitted
    public void omit(int i)
    {
        btNode p = c;
        btNode prev = null;
        while(p!=null && p.info!=i) {
            prev = p;
            if(p.info < i)
                p = p.r;
            else
                p = p.l;
        }

        if(p!=null) {
            btNode q = p;
            if(p.r==null)
                q = p.l;
            else if(p.l==null)
                q = p.r;
            else {
                btNode j = p.l;
                if(j.r==null) {
                    q = j;
                    q.r = p.r;
                } else {
                    while(j.r.r!=null)
                        j = j.r;
                    q = j.r;
                    j.r = q.l;
                    q.r = p.r;
                    q.l = p.l;
                }
            }

            if(prev==null)
                c = q;
            else if(prev.r==p)
                prev.r = q;
            else
                prev.l = q;

            how_many--;
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
                   c=p;}
               else{
                   prev.right = null;}
               }
           }
       }
   
//public void OmitGreater (int i){
       // btNode p = c;
        //btNode prev = null;
       // btNode q = c;
//        while(p!=null && p.info!=i) {
//            prev = p;
//            if(p.info < i)
//                p = p.r;
//            else
//                p = p.l;
//        }
//        if (prev == null){
//            p.r = null;
//        return;}
//         if (prev!=null){
//           
//        }
        
//	while(p!=null) {
		
        //if (i == p.info){
	//	break;}

      //  if(i < p.info){
      //      prev = p;
      //      p = p.l;
      //       if (p.info < i){
       //     	p = prev;
       //     	break;}
      //  }

      // if (i>p.info){
           	
     //      prev = p;   	
        //    p = p.r;
    //   if (p.info > i){
        //    	p = prev;
       //     	break;}}
       
       

//        if (p.info < i){
//            	p = prev;
//            	break;}

           // prev = p;
   // }
//if (prev==null){
//    p.r = null;}
//else
 /  // Returns amount of ints stored in collection
    public int get_howmany()
    {
        return how_many;
    }

    // Prints contents of collection to output
    public void print()
    {
        btprint(c);
    }

    // returns true if both IntColl6 instances contain
    //   identical int collections
    public boolean equals(IntColl6 obj)
    {
        if(how_many != obj.how_many)
            return false;
        int a1[] = new int[how_many];
        int a2[] = new int[how_many];
        int i=0;
        btToArray(c, a1, i);
        i=0;
        btToArray(obj.c, a2, i);

        boolean ret = true;
        for(i=0; ret && i<how_many; i++)
            ret = (a1[i] == a2[i]);

        return ret;
    }

    private static btNode btclone(btNode b) {
        if(b==null)
            return null;

        return new btNode(b.info, btclone(b.l), btclone(b.r));
    }

    private static int btToArray(btNode b, int[] a, int i) {
        if(b!=null) {
            i = btToArray(b.l, a, i);
            a[i++] = b.info; // i++ returns i before it adds 1, so a[i] == a[i++] != a[++i]
            i = btToArray(b.r, a, i);
        }
        return i;
    }

    private static void btprint(btNode b) {
        if(b==null)
            return;
        System.out.printf("%d; lt: %d, rt: %d\n", b.info, (b.l != null) ? b.l.info : -1, (b.r != null) ? b.r.info : -1);
        btprint(b.l);
        btprint(b.r);
    }
}

