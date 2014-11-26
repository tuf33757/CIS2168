/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll6;

import java.util.*;

public class IntColl6Client {

    public static final int SENTINEL = 0;

    public static void main(String[] args) {

        IntColl6 P = new IntColl6(), N = new IntColl6();

       // for (int i = 1; i <= 10; i++) {

            
        P.insert(10);
        P.insert(9);
        P.insert(11);
        P.insert(20);
        P.insert(17);
        P.insert(21);
        P.insert(18);
        
        

        


        System.out.println("First collection:");

        P.print();

        P.OmitGreater(17);
        
        System.out.println("After omit:");
        P.print();
    }

}
