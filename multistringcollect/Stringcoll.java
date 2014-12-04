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
   public class Stringcoll extends MultiStringcoll{
       public Stringcoll (){
           super();
       }
       public Stringcoll (int i){
           super(i);
       }
       @Override
       public void insert (String s){
            if(belongs(s)==false){
            super.insert(s);                
            }
       }
   }
    
