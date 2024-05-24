package Task.ATM;

import java.util.Date;

public class Transaction {

  private Date date;
  private String type;
  private double amount;
  private double balance;

  Transaction(){}

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

  public  void setDate(Date date){
      this.date =date;
  }
  public void setType (String type){
      this.type = type;
  }
  public  void setAmount(double amount){
      this.amount =amount;
  }
  public  void setBalance(double balance){
      this.balance =balance;
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
