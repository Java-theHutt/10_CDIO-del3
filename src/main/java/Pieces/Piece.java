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

    public void movePieceTo(){

    }

    /**
     * Involves any action from the chancecardss that involves moving the piece.
     * @param card
     */
    public void movePieceChanceCardActions(Card card){
        if(card.getCardID() <= 12){
            if(card.getCardID() <= 3){
                moveToSquare(card.getAction());
            }else if(card.getCardID() == 4){
                moveOneToFive();
            }else if(card.getCardID() == 5){
                goOrThrowAction();
            }else if(card.getCardID() > 5 && card.getCardID() <= 8){
                singleColorAction(card);
            }else if (card.getCardID() > 8 && card.getCardID() <= 12){
                doubleColorAction(card);
            }
        }

    }

    /**
     * Each case represents two colors from a chancecard. The paratmeters in each method is therefore the squares connected to those colors.
     * @param card
     */
    private void doubleColorAction(Card card) {
        switch (card.getCardID()) {
            case 9 -> moveToTwoColorAction(7, 8, 22, 23);
            case 10 -> moveToTwoColorAction(10, 11, 19, 20);
            case 11 -> moveToTwoColorAction(4, 5, 13, 14);
            case 12 -> moveToTwoColorAction(1, 2, 16, 17);
        }
    }

    /**
     * Each parameter represents a square, tied to one of the two colors from the chancecard. The player will select what square the player wants to move to.
     * @param square1Number
     * @param square2Number
     * @param square3Number
     * @param square4Number
     */
    public void moveToTwoColorAction(int square1Number,int square2Number,int square3Number,int square4Number){
        System.out.println("You pulled the card " + cards.getCurrentCard().getCardName());
        //System.out.print("Therefore you may choose to go to 1 of 4 squares: - " + getSquareName(square1Number,0) + " enter 1 - "
        //       + getSquareName(square2Number,0) + " enter 2 - " + getSquareName(square3Number,0) + " enter 3 - " + getSquareName(square4Number) + " enter 4 -");
        int x;
        boolean bool = true;
        while(bool){
            x = scan.nextInt();
            if(x == 1) {
                moveToSquare(square1Number);
                bool = false;
            }else if(x == 2) {
                moveToSquare(square2Number);
                bool = false;
            }else if(x == 3) {
                moveToSquare(square3Number);
                bool = false;
            }else if(x == 4) {
                moveToSquare(square4Number);
                bool = false;
            }else
                System.out.println("Invalid input! Enter 1 or 2..!");
        }
    }

    /**
     * Takes a chancecard as parameter. Based on the chancecard ID, the fields related to the chancecard is given.
     * @param card
     */
    private void singleColorAction(Card card) {
        switch(card.getCardID()){
            case 6:
                moveToOneColorAction(13,14);
                break;
            case 7:
                moveToOneColorAction(10,11);
                break;
            case 8:
                moveToOneColorAction(4,5);
                break;
        }
    }

    /**
     * Takes the 2 squarenumbers of the given color as parameter.
     * The player then gets to choose which of the 2 squares he wants to go to.
     * @param square1Number
     * @param square2Number
     */
    public void moveToOneColorAction(int square1Number,int square2Number){
        System.out.println("You pulled the card " + cards.getCurrentCard().getCardName());
        System.out.println("Therefore you may choose between one of the 2 colored squares, that you want to go to.");
        //System.out.print("Enter 1, to go to " + getSquareName(square1Number,0) + " or 2 to go to " + getSquareName(square2number,0) + ". Enter here: ");
        int x;
        boolean bool = true;
        while(bool){
            x = scan.nextInt();
            if(x == 1) {
                moveToSquare(square1Number);
                bool = false;
            }else if(x == 2) {
                moveToSquare(square2Number);
                bool = false;
            }else
                System.out.println("Invalid input! Enter 1 or 2..!");
        }
    }

    private void goOrThrowAction() {
        System.out.println("Choose between moving 1 field forward or take a new chance card");
        System.out.println("If you want to move type m, else type anything else to receive new chance card");
        String input = scan.next();
        if (input.charAt(0) == 'm'){
            this.piecePosition += 1;
        }else {
            cards.pickChanceCard();
        }
    }

    private void moveToSquare(int action) {
        this.piecePosition = action;
    }

    private void moveOneToFive() {
        System.out.print("Enter a number from 0 to 5, to move forward: ");
        int num;
        while(true){
            num = scan.nextInt();
            if(num >= 0 && num <= 5){
                this.piecePosition += num;
                break;
            }else
                System.out.println("Input not valid. Enter a number from 0 to 5!");
        }
    }


}
