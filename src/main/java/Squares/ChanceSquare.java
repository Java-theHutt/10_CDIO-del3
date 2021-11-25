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
        player.getPiece().setLastPiecePosition();

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
                player.getPiece().movePieceTo((card.getAction()));
                chancecards.getCurrentCard().getCardName();
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
        System.out.println("Du træk chancekortet: " + chancecards.getCurrentCard().getCardName());
        System.out.println("Derfor må du nu vælge 1 af 4 felter at rykke hen på: - " + "Indtast 1, 2, 3 eller 4 for at lande på hhv. første og sidst nævnte farve.");
        int x;
        boolean bool = true;
        while(bool) {
            try {
                x = scan.nextInt();
                if(x > 0 && x <= 5){
                    if (x == 1) {
                        player.getPiece().movePieceTo(square1Number);
                        bool = false;
                    } else if (x == 2) {
                        player.getPiece().movePieceTo(square2Number);
                        bool = false;
                    } else if (x == 3) {
                        player.getPiece().movePieceTo(square3Number);
                        bool = false;
                    } else{
                        player.getPiece().movePieceTo(square4Number);
                        bool = false;
                    }
                }else
                    System.out.println("Indtast et tal fra 1 - 5!");
            } catch (InputMismatchException e){
            System.out.println("Forkert input! Indtast 1, 2, 3, 4 eller 5..!");
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
        System.out.println("Du trak chancekortet: " + chancecards.getCurrentCard().getCardName());
        System.out.println("Vælg et felt ved at taste - 1 eller 2 - 1 er det laveste og 2 er det højeste felt");
        int x;
        boolean bool = true;
        while(bool){
            try {
                x = scan.nextInt();
                if(x > 0 && x < 3) {
                    if (x == 1) {
                        player.getPiece().movePieceTo(square1Number);
                        bool = false;
                    } else if (x == 2) {
                        player.getPiece().movePieceTo(square2Number);
                        bool = false;
                    }
                }else
                    System.out.println("Indtast tal fra 1 - 2!");
            }catch (InputMismatchException e) {
                System.out.println("Forkert input! Indtast 1 or 2..!");
                scan.next();
            }
        }
    }

    private void goOrThrowAction(Player player) {
        System.out.println("Du trak chancekortet: " + chancecards.getCurrentCard().getCardName());
        System.out.println("Hvis du vil rykke et felt frem tast m, ellers trækker du et nyt chancekort.");
        String input = scan.next();
        if (input.charAt(0) == 'm'){
            player.getPiece().movePieceTo(player.getPiece().getPiecePosition() + 1);
        }else {
            chancecards.pickChanceCard();
            moveChanceCardActions(chancecards.getCurrentCard(), player);
        }
    }


    private void moveOneToFive(Player player) {
        System.out.print(chancecards.getCurrentCard().getCardName());
        int num;
        while(true){
            try{
                num = scan.nextInt();
                if(num > 0 && num < 6) {
                    player.getPiece().movePieceTo(player.getPiece().getPiecePosition() + num);
                    break;
                }else
                    System.out.println("Indtast tal fra 1 - 5!");
            }catch(InputMismatchException e){
                    System.out.println("Input ikke gyldigt. Indtast et nummer fra 1 - 5");
                    scan.next();
                }
        }
    }
}

