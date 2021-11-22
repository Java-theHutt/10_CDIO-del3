package Game;

import Pieces.Piece;
import Squares.SquareList;

import java.util.Scanner;

public class GameLogic {

    private final Scanner userinput = new Scanner(System.in);
    private Player[] players;
    private DiceCollection dice = new DiceCollection(2);
    private SquareList squares = new SquareList();
    private int playeramount;
    private int startingscore = 35;
    private boolean gameDone = false;
    private String winner;

    public void run(){
        setupGame();
        while (!gameDone) {
            for (Player player: players) {
                playerTurn(player);
            }
        }
        System.out.println("Spilleren: " + getWinner(players) + " har vundet!!");
    }

    private void setupGame(){
        players = new Player[getPlayerAmount()]; // Sets length of player array
        setupPlayer(); // Sets player name and piece and adds it to player array and piece array
    }
    private void playerTurn(Player player){
            playerPassesStart(player);
            playerRollDice(player);
            updatePlayerBalance(player);
            checkForLoss(player);
    }
    // Finds a winner after a loser is found and assigns player name to a winner variable
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
    private void playerPassesStart(Player player){
        if (player.getPiece().getLastPiecePosition() > player.getPiece().getPiecePosition()){
            System.out.println("Du har passeret start, modtag 2kr af banken.");
            player.updateScore(2);
            System.out.println("Din balance er nu: " + player.getBalance());
        }
    }
    private void playerRollDice (Player player){
        System.out.println(player.getPlayerName() + ", rul terningerne! Tryk på vilkårlig tast for at rulle.");
        userinput.next();
        dice.roll();
        player.getPiece().setLastPiecePosition();
        player.getPiece().setPiecePosition(dice.getRollSum());
        System.out.println();
        System.out.println(player.getPlayerName() + " lander på " + squares.getSquareArray()[player.getPiece().getPiecePosition()].getSquareName());
    }

    // Buys or pays rent to owner of current square.
    private void updatePlayerBalance(Player player){
        squares.getSquareArray()[player.getPiece().getPiecePosition()].landOnSquare(player);
        System.out.println("Din nuværende balance er: " + player.getBalance());
        System.out.println();
    }

    //Sets player names, a player piece and adds them to a player array and a piece array
    private void setupPlayer(){
        String playername;
        for (int i = 0; i<playeramount;i++){
            System.out.println("Spiller " + i + ", indtast dit navn her: ");
            playername = userinput.next();
            System.out.println();
            Piece piece = new Piece();
            Player player = new Player(playername, startingscore, piece);
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