package Task.ATM;

import java.util.ArrayList;

public class Customer {

     private String id;
     private String name;
      Account account;
     ArrayList<Card> customerCards;

     Customer(){}


     Customer(String id ,String name, Account account){
         this.id = id;
         this.name = name;
         this.account = account;
         this.customerCards = new ArrayList<>();
     }

     public  ArrayList<Card> getCustomerCards(){
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


     public  void addCards(Card card){
         customerCards.add(card);
     }

     public  Account getAccount(){
         return account;
     }


}
