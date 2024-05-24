package Task.ATM;

import java.util.ArrayList;

public class Account {

    private static  Account account;
    private Account(){

    }
    public  static  Account getInstance(){
        if(account == null){
            account = new Account();
        }
        return account;
    }


    private String accountNumber;
    private double amount;
     ArrayList<Transaction> transactions = new ArrayList<>();

    Account(String accountNumber,double amount){

        this.accountNumber = accountNumber;
        this.amount = amount;
    }


    public String getAccountNumber(){
        return accountNumber;
    }

    public double getAmount(){
        return amount;
    }




    public void withdraw(double useramount) throws  Exception{
        if(useramount <= amount){
            amount -= useramount ;
        }else {
            throw new Exception("Invalid Balance");
        }
    }


    public void addTransactions(Transaction transaction){
        transactions.add(transaction);
    }

    public Transaction transactionList(){
        Transaction t = null;
        for(Transaction transaction:  transactions){
             t = transaction;
        }
        return t;
    }


}
