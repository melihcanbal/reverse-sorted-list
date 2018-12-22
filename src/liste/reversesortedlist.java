
package liste;
import java.util.Scanner;

// https://github.com/melihcanbal 10.11.2017 - 10.12.2017 

class Item{ 
     int val;   
     Item next; 
     
// Atama işlemleri
     
// Assignment section

     Item(int val, Item next){ 
         this.val=val; 
         this.next=next; 
     }  
} 
  
 
 class List { 
   private Item firstlist,lastlist,hold;  
  

   public List() { 
     firstlist=null;
     lastlist=null;    
   } 
  
  public void insertordered(int val) {
      /*
      Burada yapılan işlem kısaca listeye daha girmeden yapılan bir sıralama işlemi.
      "major" burada geçici büyük nesnelerin tutuldugu item olarak görev yapıyorken
      "peanut" ise aynı işlemin küçük olan değerlerine tutan item
      
      Before we insterting one by one,first we are finding the place of object where it should be for sorting.When "major" representing
      bigger temporary object while "peanut" dealing for the same thing for the litte objects.
      */
     Item t=new Item(val,firstlist);
     Item temporary,major=null,peanut=null;
     temporary=firstlist;
      if (temporary==null) {
          firstlist=t;
          lastlist=t;        
      }
      else {
      
           if (t.val<lastlist.val) {
              lastlist.next=t;
              lastlist=t;
              lastlist.next=null;               
          }
           if (t.val>firstlist.val) {
              hold=t;
              hold.next=firstlist;
              firstlist=hold;
              hold=null;    
          }
           if (firstlist.val>t.val && t.val>lastlist.val) {
               while (temporary!=null) {                   
                   if (temporary.val>t.val) {
                       	major=temporary;
                       	peanut=temporary.next;          
                   }
                   temporary=temporary.next;
               }
               hold=t;
               hold.next=peanut;
               major.next=hold;
               hold=null;
          }
      }
     
   } 
  
 
   public void display() { 
//   listeyi "while" döngüsü ile okutma kısmı
       
//   Reading section with "while" loop
     Item t=firstlist; 
       while (t!=null) {           
           System.out.println(t.val+" ");
           t=t.next;
           
       }
         
     } 
   } 
 public class Liste{ 
     public static void main(String args[]){
         
//        Listeye eleman girişini durdurmak için "0" veya daha küçük bir değer girmeniz yeterli
         
//        If you want to stop inserting, all you have to do insert "0" or less than "0"
         Scanner oku=new Scanner(System.in);
         List l=new List();
         int girilen;
              do {                     
                        System.out.println("Listeye Bir Değer Girin");
                        girilen=oku.nextInt();
                        if (girilen>=0) {
                           l.insertordered(girilen);                 
                  }                              
                 } while (girilen>=0);
         l.display(); 
     } 
 } 

