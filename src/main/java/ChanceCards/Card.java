package ChanceCards;

public class Card {

    private final int cardID;
    private String cardName;
    private String description;
    private int action;

    public Card(int ID, String cardName, String description){
        this.cardID = ID;
        this.cardName = cardName;
        this.description = description;
    }

    public Card(int ID, String cardName, String description,int action){
        this.cardID = ID;
        this.cardName = cardName;
        this.description = description;
        this.action = action;
    }

    public int getAction(){
        return this.action;
    }

    public int getCardID(){
        return cardID;
    }

    public String getCardName(){
        return this.cardName;
    }

    /**
     * returns description for given card.
     * @return
     */
    public String getDescription(){
        return this.description;
    }

}
