package Squares;

import ChanceCards.Card;
import Game.Player;
import ChanceCards.Cards;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChanceSquare extends Square {

    private final Scanner scan = new Scanner(System.in);
    private final Cards chancecards = new Cards();

    public ChanceSquare(){
        super("Chance", "Træk et chancekort fra bunken");
    }

    public void landOnSquare (Player player){
        chancecards.pickChanceCard();

        moveChanceCardActions(chancecards.getCurrentCard(),player);
    }
    public String getSquareName() {
        return "Chance";
    }

    /**
     * Involves any action from the chancecardss that involves moving the piece.
     * @param card
     */
    public void moveChanceCardActions(Card card,Player player){
            if(card.getCardID() <= 3){
                player.getPiece().setPiecePosition((card.getAction()));
            }else if(card.getCardID() == 4){
                moveOneToFive(player);
            }else if(card.getCardID() == 5){
                goOrThrowAction(player);
            }else if(card.getCardID() > 5 && card.getCardID() <= 8){
                singleColorAction(card,player);
            }else if (card.getCardID() > 8 && card.getCardID() <= 12){
                doubleColorAction(card,player);
            }
    }

    /**
     * Each case represents two colors from a chancecard. The paratmeters in each method is therefore the squares connected to those colors.
     * @param card
     */
    private void doubleColorAction(Card card,Player player) {
        switch (card.getCardID()) {
            case 9 -> moveToTwoColorAction(7, 8, 22, 23,player);
            case 10 -> moveToTwoColorAction(10, 11, 19, 20,player);
            case 11 -> moveToTwoColorAction(4, 5, 13, 14,player);
            case 12 -> moveToTwoColorAction(1, 2, 16, 17,player);
        }
    }

    /**
     * Each parameter represents a square, tied to one of the two colors from the chancecard. The player will select what square the player wants to move to.
     * @param square1Number
     * @param square2Number
     * @param square3Number
     * @param square4Number
     */
    public void moveToTwoColorAction(int square1Number,int square2Number,int square3Number,int square4Number,Player player){
        System.out.println("You pulled the card " + chancecards.getCurrentCard().getCardName());
        System.out.println("Therefore you may choose to go to 1 of 4 squares: - " + " enter 1 - "
               + " enter 2 - "  + " enter 3 - "  + " enter 4 -");
        int x;
        boolean bool = true;
        while(bool) {
            try {
                x = scan.nextInt();
                if (x == 1) {
                    player.getPiece().setPiecePosition(square1Number);
                    bool = false;
                } else if (x == 2) {
                    player.getPiece().setPiecePosition(square2Number);
                    bool = false;
                } else if (x == 3) {
                    player.getPiece().setPiecePosition(square3Number);
                    bool = false;
                } else if (x == 4) {
                    player.getPiece().setPiecePosition(square4Number);
                    bool = false;
                }
            } catch (InputMismatchException e){
            System.out.println("Invalid input! Enter 1, 2, 3 or 4..!");
            scan.next();
            }
        }
    }

    /**
     * Takes a chancecard as parameter. Based on the chancecard ID, the fields related to the chancecard is given.
     * @param card
     */
    private void singleColorAction(Card card,Player player) {
        switch(card.getCardID()){
            case 6:
                moveToOneColorAction(13,14, player);
                break;
            case 7:
                moveToOneColorAction(10,11,player);
                break;
            case 8:
                moveToOneColorAction(4,5,player);
                break;
        }
    }

    /**
     * Takes the 2 squarenumbers of the given color as parameter.
     * The player then gets to choose which of the 2 squares he wants to go to.
     * @param square1Number
     * @param square2Number
     */
    public void moveToOneColorAction(int square1Number,int square2Number,Player player){
        System.out.println("You pulled the card " + chancecards.getCurrentCard().getCardName());
        System.out.println("Therefore you may choose between one of the 2 colored squares, that you want to go to.");
        System.out.print("Enter 1, to go to "  + " or 2 to go to "  + ". Enter here: ");
        int x;
        boolean bool = true;
        while(bool){
            try {
                x = scan.nextInt();
                if (x == 1) {
                    player.getPiece().setPiecePosition(square1Number);
                    bool = false;
                } else if (x == 2) {
                    player.getPiece().setPiecePosition(square2Number);
                    bool = false;
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter 1 or 2..!");
                scan.next();
            }
        }
    }

    private void goOrThrowAction(Player player) {
        System.out.println("Choose between moving 1 field forward or take a new chance card");
        System.out.println("If you want to move type m, else type anything else to receive new chance card");
        String input = scan.next();
        if (input.charAt(0) == 'm'){
            player.getPiece().setPiecePosition(player.getPiece().getPiecePosition() + 1);
        }else {
            chancecards.pickChanceCard();
        }
    }


    private void moveOneToFive(Player player) {
        System.out.print("Enter a number from 0 to 5, to move forward: ");
        int num;
        while(true){
            num = scan.nextInt();
            try{
                player.getPiece().setPiecePosition(player.getPiece().getPiecePosition() + num);
                break;
            }catch(InputMismatchException e){
                    System.out.println("Input not valid. Enter a number from 0 to 5!");
                    scan.next();
                }
        }
    }
}

