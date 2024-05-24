package Task.ATM;

import java.util.ArrayList;

public class Customer {

     private String id;
     private String name;
     private Account account;
     private ArrayList<Cards> customerCards;


     Customer(String id ,String name, Account account){
         this.id = id;
         this.name = name;
         this.account = account;
         this.customerCards = new ArrayList<>();
     }

     public  ArrayList<Cards> getCustomerCards(){
         return  customerCards;
     }
     public String getId(){
         return id;
     }

     public void setId(String id){
         this.id = id;
     }

     public  String getName(){
         return name;
     }


     public  void addCards(Cards cards){
         customerCards.add(cards);
     }

     public  Account getAccount(){
         return account;
     }


}
