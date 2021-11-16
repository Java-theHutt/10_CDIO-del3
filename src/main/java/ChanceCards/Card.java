package ChanceCards;

public class Card {

    private final int cardID;
    private final int fieldNumber;
    private String cardName;
    private String description;

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
