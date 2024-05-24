package Task.ATM;
import java.util.*;
public class ATMMachine {
   private final Scanner in = new Scanner(System.in);
    Bank bank = new Bank();


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
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Cash Withdraw            ---> press '1' ");
        System.out.println("Check Balance            ---> press '2' ");
        System.out.println("View Transaction Details ---> press '3' ");
        System.out.println("-----------------------------------------------------------------------------------");

        int userRequest = in.nextInt();

        switch (userRequest){
            case 1:
                withdraw(cardNumber);
                break;
            case 2:
                bank.checkBalance(cardNumber);
                break;
            case 3:
                if(bank.account.transactionList() != null){
                    for(Transaction transaction : bank.account.transactions){
                        System.out.println(transaction);
                    }
                }else {
                    System.out.println("Transaction Not Proceed");
                }
                break;
            default:
                System.out.println("Give Correct Option...");

        }
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
       Transaction transaction = new Transaction(date,"Withdraw",amount,balanceAmount);
      bank.account.addTransactions(transaction);

       askservice(cardNumber);
    }
}