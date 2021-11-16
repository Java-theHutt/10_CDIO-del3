package ChanceCards;

import java.util.*;

public class Cards {

    private Card card;
    private Card[] cardArray = new Card[24];

    public Cards(){
        createCards();
        shuffleCards();
    }

    private void shuffleCards() {
        List<Card> cardsList =  Arrays.asList(cardArray);
        Collections.shuffle(cardsList);
        cardsList.toArray(cardArray);
    }

    private void createCards(){
        cardArray[0] = new Card(1,"moveToStart","The player moves his piece to the start square");
        cardArray[1] = new Card(2,"Move5","The player moves up to 5 squares forward");
        cardArray[2] = new Card(3,"moveToOrange","The player moves his piece to an orange square. If it's not owned by anyone, the player gets the field for free. Otherwise pay the owner!");
        cardArray[3] = new Card(12,"goOrThrow","The player moves 1 field forward or takes another Chancecard");
        cardArray[4] = new Card(5,"moveOrangeOrGreen","The player moves to a orange or green field. If it's not owned yet the player gets it for free. Otherwise oay the owner!");
        cardArray[5] = new Card(6,"moveLightblue","The player moves to a lightblue field. If it's not yet owned the player gets the field for free. Otherwise pay the owner!");
        cardArray[6] = new Card(7,"moveBeach","The player moves to the beach");
        cardArray[7] = new Card(8,"movePinkOrDarkblue", "The player moves to a pink or darkblue field, and gets the field for free, if it's not owned. Otherwise pay the owner!");
        cardArray[8] = new Card(9,"moveRed","The player moves to a red field. If it's not yet owned, the player gets the field for free. Otherwise pay the owner!");
        cardArray[9] = new Card(10, "moveToSkaterpark","The player moves to the skaterpark. If it's not owned gets it for free. Otherwise pay the owner!");
        cardArray[10] = new Card(11,"moveLightblueOrRed","The player moves to a lightblue or red field. If it's not yet owned, gets it for free. Otherwise pay the owner!");
        cardArray[11] = new Card(4,"moveBrownOrYellow","The player moves to a brown or yellow field. If it's not owned by anyone, gets it for free. Otherwise pay the owner!");
        cardArray[12] =

    }

    public Card[] getCards(){
        return cardArray;
    }

    public int getID(Card card){
        return card.getCardID();
    }

}
