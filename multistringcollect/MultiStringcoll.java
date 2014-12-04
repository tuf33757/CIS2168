
package multistringcollect;

/**
 *
 * @author Rob
 */


import java.io.*;

public class MultiStringcoll
{
  private static class btNode {  
        String info;
        btNode left;
        btNode right;
        int count;

        private btNode(String s, btNode lt, btNode rt) {
            info = s;
            left = lt;
            right = rt;
            count = 1;
        }

        private btNode() {
            info = null;
            left = null;
            right = null;
            count = 0;
        }
    }
    private btNode c;
    private int howmany;

 
    public MultiStringcoll() {
        howmany = 0;
        c = null;
    }

    
    public MultiStringcoll(int i) { 
        howmany = 0;
        c = null;
    }

    
    private static btNode copytree(btNode t) { 
        btNode root = null;
        if (t != null) {
            root = new btNode();
            root.info = t.info;
            root.left = copytree(t.left);
            root.right = copytree(t.right);
        }
        return root;
    }

  
    public void copy(MultiStringcoll obj) { 
        if (this != obj) {
            howmany = obj.howmany;
            c = copytree(obj.c);
        }
    }

     public void insert(String i)
    { int count = 1;
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
if ((p != null)) {
            p.count++;
        }

        if(p==null) {
            if(prev.info.compareTo(i) < 0)
                prev.right = new btNode(i, null, null);
            else
                prev.left = new btNode(i, null, null);
            howmany++;count++;
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
if (p.count>1){
    p.count--;
    return;
}
        if(p!=null && p.count == 1) {
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
     p.count--;
    }
    

    
    public boolean belongs(String i) { 
        btNode p = c;
        while (p != null && !p.info.equals(i)) {
            if (p.info.compareTo(i) == 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (p != null);
    }

   
    public int get_howmany() {  
        return howmany;
    }

    public void print(String outname) { 
        try {
            PrintWriter outs = new PrintWriter(new FileOutputStream(outname));
            outs.println("The number of integers is " + howmany);
            outs.println();
            printtree(c, outs);
            outs.close();
        } catch (IOException ex) {
        }
    }

    
    public void print() { 
        printtree(c);
    }

  
    public boolean equals(MultiStringcoll obj) { 
        int z = 0;
        boolean result = (howmany == obj.howmany);
        if (result) {
            String[] a = new String[howmany];
            String[] b = new String[howmany];
            toarray(c, a, z);
            toarray(obj.c, b, z);

            int j = 0;
            while ((result) && (j < howmany)) {
                result = (a[j].equals(b[j]));
                j++;
            }
        }
        return result;
    }

   
    private static void printtree(btNode t, PrintWriter outs) { 
        if (t != null) {
            printtree(t.left, outs);
            outs.println(t.info);
            printtree(t.right, outs);
        }
    }

    
    private static void printtree(btNode t) { 
        if (t != null) {
            printtree(t.left);
            System.out.println(t.info + " count: " + t.count);          
            printtree(t.right);
        }
    }

   
    private static int toarray(btNode t, String[] a, int i) { 
        int num_nodes = 0;
        if (t != null) {

            i = toarray(t.left, a, i);
            a[i++] = t.info; 
            i = toarray(t.right, a, i);
        }
        return num_nodes;
    }

  
  
}