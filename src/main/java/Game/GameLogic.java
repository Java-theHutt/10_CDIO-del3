package Game;

import Squares.SquareList;

import java.util.Scanner;

public class GameLogic {

    private final Scanner userinput = new Scanner(System.in);
    private Player[] players;
    private DiceCollection dice = new DiceCollection(2);
    private SquareList square = new SquareList();
    private int playeramount;
    private int startingscore = 35;
    private String playername;

    public void run(){
        setupPlayers();
    }

    private void setupPlayers(){
        // Sets length of player array
        players = new Player[getPlayerAmount()];

        // Sets player name and adds it to player array
        setupPlayerNames();

    }
    private void playerTurn(Player player){
    }

    private void playerRollDice (Player player){
        System.out.println(player.getPlayerName() + ", rul terningerne! Tryk på vilkårlig tast for at rulle.");
        userinput.nextLine();
        dice.roll();
        System.out.println(player.getPlayerName() + " lander på " + square.getSquareArray()[(dice.getRollSum())].getSquareName());
    }

    //Sets player names and adds them to the player array
    private void setupPlayerNames(){
        for (int i = 0; i<playeramount;i++){
            System.out.println("Spiller " + i + ", indtast dit navn her: ");
            playername = userinput.next();
            Player player = new Player(playername, startingscore);
            players[i] = player;
        }
    }
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