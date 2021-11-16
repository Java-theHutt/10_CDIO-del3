package ChanceCards;

public class Card {

    private int cardID;
    private String cardName;
    private String description;
    private String[][] cardArray = new String[24][2];

    public Card(int ID, String cardName, String description){
        this.cardID = ID;
        this.cardName = cardName;
        this.description = description;
    }

    public int getCardID(){
        return cardID;
    }

    public void addCards(String[][] cardArray){



    }

}
