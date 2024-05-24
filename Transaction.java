package Task.ATM;

import java.util.Date;

public class Transaction {

  private Date date;
  private String type;
  private double amount;
  private double balance;

  public Date getDate(){
      return date;
  }
  public String getType(){
      return type;
  }
  public double getAmount(){
      return amount;
  }
  public double getBalance(){
      return balance;
  }


    Transaction(Date date,String type, double amount,double balance){
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }


    public String toString(){
      return "Date : "+ date+" "+"|"+" "+
             "Type : "+type +" "+"|"+" "+
             "Amount : "+amount+" "+"|"+" "+
             "Balance : "+balance;
    }

}
