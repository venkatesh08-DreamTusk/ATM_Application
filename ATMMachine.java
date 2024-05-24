package Task.ATM;
import java.util.*;
public class ATMMachine {
   private final Scanner in = new Scanner(System.in);
    Bank bank = new Bank();
    Transaction transaction;

    public void start()throws Exception{

        System.out.println("Enter Your Card Number");
        String cardNumber = in.next();
        if(!bank.cardExist(cardNumber)){
            System.out.println("Enter Valid Card Number");
            start();
            return;
        }
        askservice(cardNumber);
    }

    public void askservice(String cardNumber)throws  Exception{
        System.out.println("Cash Withdraw ---> press '1' ");
        System.out.println("Check Balance ---> press '2' ");

        int userRequest = in.nextInt();
        if(userRequest == 1){
            withdraw(cardNumber);
            return;
        }
        bank.checkBalance(cardNumber);
        askservice(cardNumber);
    }

    public void withdraw(String cardNumber) throws Exception{
        System.out.println("Enter Amount ");
        double amount = in.nextDouble();
        System.out.println("Enter Your Secret PIN ");
        String pin = in.next();
        if(!bank.verify(cardNumber,pin)){
            System.out.println("Something Wrong Enter Correct PIN ");
            askservice(cardNumber);
            return;
        }

        if(!bank.enoughAmount(cardNumber,amount)){
            System.out.println("Your Account Balance is Not Enough");
            askservice(cardNumber);
            return;
        }
       System.out.println("Withdraw Success");
        double balanceAmount = bank.withdrawSuccessFull(cardNumber,amount);
      System.out.println("Balance in Your Account :-  "+balanceAmount);
      Date date = new Date();
      transaction = new Transaction(date,"Withdraw",amount,balanceAmount);
       askservice(cardNumber);
    }
}