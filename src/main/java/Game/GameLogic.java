package Game;

import Squares.SquareList;

import java.util.Scanner;

public class GameLogic {

    private final Scanner userinput = new Scanner(System.in);
    private Player[] players;
    private DiceCollection dice = new DiceCollection(2);
    private SquareList board = new SquareList();
    private int playeramount;

    public void run(){}

    private void setupPlayers(){
        // Sets length of player array
        players = new Player[getPlayerAmount()];


        /*
        System.out.print("Player1 enter name: ");
        this.player1 = new Player(userinput.next(),1000);
        players[0] = this.player1;

        System.out.print("Player2 enter name: ");
        this.player2 = new Player(userinput.next(),1000);
        players[1] = this.player2;
        */
    }
    private void playerTurn(Player[] player){}

    //Helper function for setupPlayers
    private int getPlayerAmount(){
        System.out.println("Spillet er tilegnet 2-4 spillere. Indtast antal spillere her: ");
        boolean x = true;
        while (x) {
            playeramount = userinput.nextInt();
            if (playeramount > 1 && playeramount < 5){
                x = false;
            }
            else {
                System.out.println("Forkert antal spillere. Indtast igen her: ");
            }
        }
        return playeramount;
    }
}