package Task.ATM;
import java.util.*;
public class ATMMachine {
   private final Scanner in = new Scanner(System.in);
    Bank bank = Bank.getInstance();


   ATMMachine(){
   }


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
                System.out.println("Enter Your PIN");
                String pin = in.next();
                bank.checkBalance(cardNumber,pin);
                break;
            case 3:
                System.out.println("Enter Your PIN");
                String cardPIN = in.next();
                if(bank.verify(cardNumber,cardPIN)){
                    if(transaction != null){
                       bank.addTransaction(cardNumber,cardPIN,transaction);
                    }
                }
                break;
            default:
                System.out.println("Give Correct Option...");

        }
        askservice(cardNumber);
    }

    Date date = null;
    Transaction transaction = null;
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
      date = new Date();
    transaction = new Transaction(date,"Withdraw",amount,balanceAmount);
       askservice(cardNumber);
    }


}