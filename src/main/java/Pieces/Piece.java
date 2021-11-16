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

    public void setPiecePosition(int roll){
        this.piecePosition += roll;
    }

    public int getPiecePosition(){
        return this.piecePosition;
    }

    public void movePieceTo(){

    }

    public void performChanceCardAction(Card card){
        if(card.getCardID() <= 12){
            if(card.getCardID() <= 3){
                this.piecePosition = card.getAction();
            }else if(card.getCardID() == 4){
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
            }else if(card.getCardID() == 5){
                System.out.println("Choose between moving 1 field forward or take a new chance card");
                System.out.println("If you want to move type m, else type anything else to receive new chance card");
                String input = scan.next();
                if (input.charAt(0) == 'm'){
                    this.piecePosition += 1;
                }else {
                    cards.pickChanceCard();
                }

            }
        }

    }


}
