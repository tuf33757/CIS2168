/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quicksort;
import java.util.*;
/**
 *
 * @author Rob
 */
public class Quicksort {
    
     static int numcalls=0;
    static int count=0, m=0;
    

     private static void Quicksort(int[] data, int i, int j){
        m = 0;
         int p;
        if (i<j){
            p = Partition (data , i , j);
            Quicksort(data,i, p-1);
            Quicksort(data,p+1,j);
        }
    }
    
    private static int Partition (int[] data, int i, int j){
    int upper, lower, save;
 
    upper = i; lower = j; save=data[i];
    while(upper != lower)
  {
      while((upper < lower) && (save >=data[lower]))
              lower--;
      m++;
         if(upper != lower) data[upper]=data[lower];
    while((upper < lower) && (save <= data[upper]))
       upper++;
    m++;
    if(upper != lower) data[lower]=data[upper];
   }
   data[upper]=save;
   return(upper);
}

    
   
     public static void mergesort(int[] a, int top, int bottom)
   {
	  numcalls++;
      if (top!=bottom)
      {
         int middle=(top+bottom)/2;
         mergesort(a, top, middle);
         mergesort(a, middle+1, bottom);
         merge(a, top, bottom);
      }
   }
    public static void insertSort(int[]a){
        int item;
        int i;
        m = 0;
        count = 0;
        for(int j=1; j<a.length; j++){
            item = a[j];
            i = j-1;
            
            while((i > -1) && ( a[i]>item)){
                a[i+1] = a[i];
                m++; count++;
                i = i-1;
                
            }
            a[i+1] = item;
            m++;
            
        }
    }
   public static void merge(int[] a, int top, int bottom)
   {
      int t=top; int middle=(top+bottom)/2; int b=middle+1; int i=0;
      int[] s=new int[bottom-top+1];
      while ((t<=middle)&&(b<=bottom))
      {
         if (a[t]<a[b])
         {
            s[i]=a[t]; t++;
            
         }
         else
         {
            s[i]=a[b]; b++;
         }
         i++; count++; m++;
      }
      int last=middle;
      if (b<=bottom) {t=b; last=bottom;}
      while (t<=last)
      {
         s[i]=a[t]; t++; i++; m++;
      }
      for (i=0; i<s.length; i++) {a[i+top]=s[i]; m++;}
   }
    public static void main(String[] args)
   {
      Random gen=new Random(); int[] a=new int[32];
      int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
      System.out.println("Initial array:");
      for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
      System.out.println();
      int []b = a;
      int [] c = a;
      mergesort(a, 0, a.length-1);
     
      
      System.out.println("Sorted array:");
       System.out.println("Array A MergeSorted: ");
      for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
      System.out.println("Done!");
      System.out.println(" numcalls "+numcalls);
      System.out.println(" count "+count+" m "+m);
       System.out.println();
       Quicksort(b,0,b.length-1);
       System.out.println("Array A QuickSorted : ");
         for (i=0; i<b.length; i++) System.out.println(b[i] + " ");
      System.out.println("Done!");
      System.out.println(" numcalls "+numcalls);
      System.out.println(" count "+count+" m "+m);
       System.out.println();
       insertSort(c);
       System.out.println("Array A InsertSorted : ");
        for (i=0; i<c.length; i++) System.out.println(c[i] + " ");
      System.out.println("Done!");
      System.out.println(" numcalls "+numcalls);
      System.out.println(" count "+count+" m "+m);
       System.out.println();
   }
    
}
