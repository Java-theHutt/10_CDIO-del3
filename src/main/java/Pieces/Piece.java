package Pieces;
import Game.Player;
import ChanceCards.*;
import Squares.*;
import java.util.Scanner;

public class Piece {

    private Scanner scan = new Scanner(System.in);
    private SquareList squareList = new SquareList();
    private final Cards cards = new Cards();
    private int piecePosition = 0;
    private Player player;

    public Piece(){

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
    public void performChanceCardAction(Card card){
        if(card.getCardID() <= 12){
            if(card.getCardID() <= 3){
                moveToSquare(card.getAction());
            }else if(card.getCardID() == 4){
                moveOneToFive();
            }else if(card.getCardID() == 5){
                goOrThrowAction();
            }else if(card.getCardID() > 5 && card.getCardID() <= 8){
                singleColorAction(card);
            }
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
     * @param square2number
     */
    public void moveToOneColorAction(int square1Number,int square2number){
        System.out.println("You pulled the card " + cards.getCurrentCard().getCardName());
        System.out.println("Therefore you may choose between one of the 2 colored squares, that you want to go to.");
        //System.out.print("Enter 1, to go to " + getSquareName(square1Number,0) + " or 2 to go to " + getSquareName(square2number,0) + ". Enter here: ");
        int x;
        while(true){
            x = scan.nextInt();
            if(x == 1)
                moveToSquare(square1Number);
            else if(x == 2)
                moveToSquare(square2number);
            else
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
