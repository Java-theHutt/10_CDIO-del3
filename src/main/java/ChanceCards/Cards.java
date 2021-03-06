package ChanceCards;

import java.util.*;

public class Cards {

    private final Card[] cardArray = new Card[12];
    private int counter = 0;
    private Card currentCard;

    public Cards(){
        createCards();
        shuffleCards();
    }

    /**
     * Shuffles the array of chancecards.
     */
    private void shuffleCards() {
        List<Card> cardsList =  Arrays.asList(cardArray); //Copies the contest of cardArray over to a list
        Collections.shuffle(cardsList); //Uses the shufflemethod from the collections class on that list
        cardsList.toArray(cardArray); //Copies the shuffled content back into cardArray.
    }

    public Card getCurrentCard(){
        return currentCard;
    }

    /**
     * Picks a chancecard from the cardArray from index 0 to arraylength. Counter is used to control if we have been through all the cards.
     * If all the chancecards have been used, the counter will set to 0, and the cardArray will be reshuffled.
     */
    public void pickChanceCard(){
        if(counter > cardArray.length){
            shuffleCards();
            counter = 0;
        }
        currentCard = cardArray[counter];
        counter++;
    }

    /**
     * Creates all the cards with the Card constructor and adds them to the cardArray.
     */
    private void createCards(){
        cardArray[0] = new Card(1,"Ryk frem til start!","The player moves his piece to the start square",0);
        cardArray[6] = new Card(2,"Ryk frem til Strandpromenaden","The player moves to the beach",23);
        cardArray[9] = new Card(3, "Ryk frem til Skaterparken","The player moves to the skaterpark. If it's not owned gets it for free. Otherwise pay the owner!",10);
        cardArray[1] = new Card(4,"Ryk 0 - 5 felter frem","The player moves up to 5 squares forward",5);
        cardArray[3] = new Card(5,"Ryk et felt frem eller træk nyr chancekort","The player moves 1 field forward or takes another Chancecard");
        cardArray[8] = new Card(6,"Ryk frem til et af de røde felter","The player moves to a red field. If it's not yet owned, the player gets the field for free. Otherwise pay the owner!");
        cardArray[2] = new Card(7,"Ryk frem til et af de orange felter","The player moves his piece to an orange square. If it's not owned by anyone, the player gets the field for free. Otherwise pay the owner!");
        cardArray[5] = new Card(8,"Ryk frem til et lyseblåt felt","The player moves to a lightblue field. If it's not yet owned the player gets the field for free. Otherwise pay the owner!");
        cardArray[7] = new Card(9,"Ryk frem til et lilla eller mørkeblåt felt", "The player moves to a pink or darkblue field, and gets the field for free, if it's not owned. Otherwise pay the owner!");
        cardArray[4] = new Card(10,"Ryk frem til et orange eller grønt felt","The player moves to a orange or green field. If it's not owned yet the player gets it for free. Otherwise oay the owner!");
        cardArray[10] = new Card(11,"Ryk frem til et lyseblåt eller rødt felt","The player moves to a lightblue or red field. If it's not yet owned, gets it for free. Otherwise pay the owner!");
        cardArray[11] = new Card(12,"Ryk frem til et gråt eller gult felt","The player moves to a brown or yellow field. If it's not owned by anyone, gets it for free. Otherwise pay the owner!");
        //cardArray[12] = new Card(13,"candySadge","You ate to much candy. Pay M2 to the bank!");
        //cardArray[13] = new Card(14,"getOuttaJail","You are released from jail. Keep this card until you may need it.");
        //cardArray[14] = new Card(15,"birthdayPerson","It's your birthday. You receive M1 from your fellow players.");
        //cardArray[15] = new Card(16,"kekw","You have completed all of your homework. Therefore you receive M2 from the bank. Cheers!");
        /*cardArray[16] = new Card(17,"The Car","Give this card to the car and take new card. The car may move to any free field and buy it. If there is no free field, the car must buy a field from another player.");
        cardArray[17] = new Card(18,"The Cat","Give this card to the cat and take new card. The cat may move to any free field and buy it. If there is no free field, the cat must buy a field from another player.");
        cardArray[18] = new Card(19,"The Ship","Give this card to the ship and take new card. The ship may move to any free field and buy it. If there is no free field, the ship must buy a field from another player.");
        cardArray[19] = new Card(20,"The Dog","Give this card to the dog and take new card. The dog may move to any free field and buy it. If there is no free field, the dog must buy a field from another player.");
        */
    }

}
