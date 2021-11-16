package Pieces;
import Game.Player;
import ChanceCards.*;

public class Piece {

    private final Cards cards = new Cards();
    private int squarePosition = 1;
    private Player player;

    public Piece(){

    }

    public void setSquarePosition(int roll){
        this.squarePosition += roll;
    }

    public int getSquarePosition(){
        return this.squarePosition;
    }

    public void performChanceCardAction(Card card){
        if(cards.getID(card) <= 12){

        }

    }


}
