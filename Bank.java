package Task.ATM;

import java.util.*;

public class Bank {

    ArrayList<Customer> customersList = new ArrayList<>();
    ArrayList<Account> account;
    ArrayList<Card> card;

    private  static  Bank bank;

   private Bank(){
       account = new ArrayList<>();
       card = new ArrayList<>();
        customerDetails();
    }

    public  static  Bank getInstance(){
       if(bank == null){
           bank = new Bank();
       }
       return bank;
    }


    public void customerDetails(){
        Customer venkatesh = new Customer("457","venkatesh",new Account("6512347895",5000.0));
        venkatesh.addCards(new Card("457","791535","7825"));
        customersList.add(venkatesh);

        Customer vignesh = new Customer("264","vignesh",new Account("7894678215",55280.0));
        vignesh.addCards(new Card("264","021582","5348"));
        customersList.add(vignesh);

        Customer sarath = new Customer("641","sarath",new Account("9543217889",75590.0));
        sarath.addCards(new Card("641","335179","4648"));
        customersList.add(sarath);
    }

    public boolean cardExist(String cardNumber) {
        for (Customer customer : customersList) {
            for (Card card : customer.getCustomerCards()) {
                if (cardNumber.equals(card.getCardNumber()) && customer.getId().equals(card.getCardID())) {
                    return true;
                }
            }
        }
        return false;
    }



    public boolean verify(String cardNumber, String pin) {
        for (Customer customer : customersList) {
            for (Card card : customer.getCustomerCards()) {
                if (cardNumber.equals(card.getCardNumber()) && card.getCardPIN().equals(pin)) {
                    return true;
                }
            }
        }
        return false;
    }


    public  boolean enoughAmount(String cardNumber, double amount){
        for(Customer customer : customersList){
            for(Card card : customer.getCustomerCards()) {
                if (cardNumber.equals(card.getCardNumber())) {
                    return amount <= customer.getAccount().getAmount();
                }
            }
        }
        return false;
    }

    public  double withdrawSuccessFull(String cardNumber, double amount)throws  Exception{
        for(Customer customer : customersList) {
            for(Card card : customer.getCustomerCards()){
            if (cardNumber.equals(card.getCardNumber()) && card.getCardID().equals(customer.getId())) {
                Account account = customer.getAccount();
                if (amount <= account.getAmount()) {
                    account.withdraw(amount);
                    return account.getAmount();
                } else {
                    throw new Exception("Balance Unavailable");
                }
            }
        }
        }
        throw  new Exception("Card Not Found");
    }

    public void checkBalance(String cardNumber,String pin) {
        String userName = "";
        String accNo = "";
        double balance = 0;

        for (Customer customer : customersList) {
                for (Card card : customer.getCustomerCards()) {
                    if (cardNumber.equals(card.getCardNumber()) && pin.equals(card.getCardPIN())) {
                        userName = customer.getName();
                        accNo = customer.getAccount().getAccountNumber();
                        balance = customer.getAccount().getAmount();
                        break;
                    }
                }
            }


        if (!userName.isEmpty() && !accNo.isEmpty() && balance != 0.0) {
            System.out.println("---------------------------------------------");
            System.out.println("Customer Name: " + userName );
            System.out.println("Account Number: " + accNo);
            System.out.println("Available Balance: " + balance);
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("Invalid card number, ID, or PIN.");
        }
    }


    public void addTransaction(String cardNumber, String pin, Transaction transaction) {
        for (Customer customer : customersList) {
            for (Card card : customer.getCustomerCards()) {
                if (cardNumber.equals(card.getCardNumber()) && pin.equals(card.getCardPIN())) {
                    customer.getAccount().addTransaction(transaction);
                    System.out.println(transaction);
                    return;
                }
            }
        }
    }




}


