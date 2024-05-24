package Task.ATM;

public class Card {

    private String cardID;
    private String cardNumber;
    private String cardPIN;



    Card(String cardID , String number, String pin){
        this.cardID = cardID;
        this.cardNumber = number;
        this.cardPIN = pin;
    }

    public String getCardID(){
        return cardID;
    }
    public void setCardID(String id){
        this.cardID = id;
    }

    public String getCardNumber(){
        return cardNumber;
    }
    public void setCardNumber(String number){
        this.cardNumber = number;
    }


    public String getCardPIN(){
        return cardPIN;
    }
    public void setCardPIN(String pin){
        this.cardPIN = pin;
    }

}
