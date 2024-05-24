package Task.ATM;

import java.util.ArrayList;

public class Account {

    private String accountNumber;
    private double amount;
    ArrayList<Transaction> transactions =  new ArrayList<>();

    Account(){}
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


    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }




}
