
package stringcoll;

public class StringcollClient
{
    public static final int SENTINEL = 0;
    public static void main(String[] args)
    {
        Stringcoll P=new Stringcoll(), N=new Stringcoll();

        String[] b=new String[10];
        b[0]="hello";
        b[1]="I";
        b[2]="Hope";
        b[3]="this";
        b[4]="works";
        b[5]="correctly!";
        b[6]="this ";
        b[7]="is the";
        b[8]="first";
        b[9]="run";
        for(int i=0; i<b.length; i++){
            P.insert(b[i]);}
        System.out.println("Initial collection:");
        P.print();
        N.copy(P);
        System.out.println(" copy:");
        P.print();
        System.out.println(P.equals(N));
        System.out.println("Does hello belong : " + P.belongs("hello"));
        P.omit("hello");
        System.out.println("Does hello belong after omit: " + P.belongs("hello"));
        System.out.println( " How many :" +P.get_howmany());
    }  


}