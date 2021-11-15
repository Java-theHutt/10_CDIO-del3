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
    private boolean gameDone = false;
    private String winner;

    public void run(){
        setupPlayers();
        while (!gameDone) {
            for (Player player : players) {
                playerTurn(player);
            }
        }
        getWinner(players);
    }

    private void setupPlayers(){
        // Sets length of player array
        players = new Player[getPlayerAmount()];

        // Sets player name and adds it to player array
        setupPlayerNames();

    }
    private void playerTurn(Player player){
        playerRollDice(player);

        checkForLoss(player);
    }
    // Finds a winner when a loser is found and assigns player name to a winner variable
    //Helper method for getWinner

    private void findWinner(Player[] players){
        int index = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[index].getBalance() < players[i].getBalance()){
                index = i;
            }
        winner = players[index].getPlayerName();
        }
    }

    private String getWinner(Player[] players){
        findWinner(players);
        return winner;
    }

    private void checkForLoss(Player player){
        if (player.getBalance()==0){
            gameDone = true;
        }
    }

    private void playerRollDice (Player player){
        System.out.println(player.getPlayerName() + ", rul terningerne! Tryk på vilkårlig tast for at rulle.");
        userinput.next();
        dice.roll();
        System.out.println(player.getPlayerName() + " lander på ");
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