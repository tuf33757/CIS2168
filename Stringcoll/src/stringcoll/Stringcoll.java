//*********************************************************************
// FILE NAME    : Stringcoll.java test stuff out
// DESCRIPTION  : This file contains the class Stringcoll.
//*********************************************************************
package stringcoll;
import java.util.*;

public class Stringcoll
{
    private static class btNode {
        public btNode left;
        public btNode right;
        public String info;
        public btNode() {
            left = null; right = null; info = "";
        }
        public btNode(String i, btNode lt, btNode rt) {
            left = lt; right = rt; info = i;
        }
    }
    private btNode c;
    private int howmany;

    
    public Stringcoll()
    {
        c = null;
        howmany = 0;
    }

    
    public Stringcoll(int i)
    {
        c = null;
        howmany = 0;
    }

    
    public void copy(Stringcoll obj)
    {
        if (this != obj)
        { 
          howmany=obj.howmany;
          c=copytree(obj.c);  
        }
    }

    
    public boolean belongs(String i)
    {
        btNode p = c;
        while(p!=null && !p.info.equals(i)) {
            if(p.info.compareTo(i) < 0)
                p = p.right;
            else
                p = p.left;
        }
        return p!=null;
    }

    
    public void insert(String i)
    {
        if(c==null) {
            c = new btNode(i, null, null);
            howmany++;
            return;
        }

        btNode p = c;
        btNode prev = p;
        while(p!=null && !p.info.equals(i)) {
            prev = p;
            if(p.info.compareTo(i) < 0)
                p = p.right;
            else
                p = p.left;
        }

        if(p==null) {
            if(prev.info.compareTo(i) < 0)
                prev.right = new btNode(i, null, null);
            else
                prev.left = new btNode(i, null, null);
            howmany++;
        }
    }

    
    public void omit(String i)
    {
        btNode p = c;
        btNode prev = null;
        while(p!=null && !p.info.equals(i)) {
            prev = p;
            if(p.info.compareTo(i) < 0)
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

            if(prev==null)
                c = q;
            else if(prev.right==p)
                prev.right = q;
            else
                prev.left = q;

            howmany--;
        }
    }

    
    public int get_howmany()
    {
        return howmany;
    }

    
    public void print()
    {
        btprint(c);
    }

    
    public boolean equals(Stringcoll obj)
    {
        if(howmany != obj.howmany)
            return false;
        String a1[] = new String[howmany];
        String a2[] = new String[howmany];
        int i=0;
        toArray(c, a1, i);
        i=0;
        toArray(obj.c, a2, i);

        boolean ret = true;
        for(i=0; ret && i<howmany; i++)
            ret = (a1[i].equals(a2[i]));

        return ret;
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

    private static int toArray(btNode b, String[] a, int i) {
        if(b!=null) {
            i = toArray(b.left, a, i);
            a[i++] = b.info; 
            i = toArray(b.right, a, i);
        }
        return i;
    }

    private static void btprint(btNode b) {
        if(b==null)
            return;

        btprint(b.left);
        System.out.println(b.info);
        btprint(b.right);
    }
}