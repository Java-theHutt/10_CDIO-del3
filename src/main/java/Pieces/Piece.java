package Pieces;
import Game.Player;
import ChanceCards.*;
import Squares.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Piece {

    private Scanner scan = new Scanner(System.in);
    private SquareList squareList = new SquareList();
    private List<Integer> squaresOwned = new ArrayList();
    private final Cards cards = new Cards();
    private int piecePosition = 0;
    private int lastPiecePosition = 0;
    private String spiritName;
    private int spiritID;
    private boolean hasSpiritCard = false;
    private Player player;

    public Piece(){}
    public Piece(String spiritName, int spiritID){
        this.spiritName = spiritName;
        this.spiritID = spiritID;
        
    }

    /**
     * [Move to gamelogic] checks if the pulled chance card is a spiritcard.
     * Then checks if the player who pulled the card, owns the given spirit.
     * If the player doesn't own the card, he gives it to the owner with the modifySpiritCardStatus method.
     * Then the current player pulls a new card.
     * @param chanceCardID
     * @param index
     */
    /*public void checkForSpiritCard(int chanceCardID, int index){
        if(chanceCardID > 16 && chanceCardID <= 20){
            if(chanceCardID == pieces[index].getSpiritID){
                pieces[index].setSpiritCardStatus(true);
                pieces[index].performSpiritCardAction();
            }else{
                modifySpiritCardStatus(chanceCardID);
                cards.pickChanceCard();
            }
        }
    }*/

    /**
     * [Move to gamelogic] Sets the spiritcardStatus to true, for the piece that owns the pulled spirit card.
     * Is only called when a player pulls another players spiritcard.
     //* @param chanceCardID
     */
    /*public void modifySpiritCardStatus(int chanceCardID){
        for (int i = 0; i < pieces.length; i++) {
            if(pieces[i].getSpiritID() == chanceCardID){
                setSpiritCardStatus(true);
            }
        }
    }*/

    public void addSquaresOwned(int squarePositions){
        squaresOwned.add(squarePositions);
    }

    public List<Integer> getSquaresOwned() {
        return squaresOwned;
    }

    public void setSpiritCardStatus(boolean bool){
        this.hasSpiritCard = bool;
    }

    public boolean getSpiritCardStatus(){
        return hasSpiritCard;
    }

    public int getSpiritID(){
        return spiritID;
    }

    /**
     * Calculates and sets a pieces position on the board.
     * @param roll
     */
    public void setPiecePosition(int roll){
        this.piecePosition += roll;
        moveToSquare(this.piecePosition % 24);
    }

    public int getPiecePosition(){
        return this.piecePosition;
    }

    public void setLastPiecePosition(){
        this.lastPiecePosition = getPiecePosition();
    }

    public int getLastPiecePosition(){
        return this.lastPiecePosition;
    }

    public void movePieceTo(int position){
        this.piecePosition = position;
    }


    private void moveToSquare(int action) {
        this.piecePosition = action;
    }


}
