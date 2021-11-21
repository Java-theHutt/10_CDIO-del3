package Game;

import Pieces.Piece;
import Squares.SquareList;

import java.util.Scanner;

public class GameLogic {

    private final Scanner userinput = new Scanner(System.in);
    private Player[] players;
    private DiceCollection dice = new DiceCollection(2);
    private SquareList squares = new SquareList();
    private Piece[] pieces;
    private int playeramount;
    private int startingscore = 35;
    private String playername;
    private boolean gameDone = false;
    private String winner;

    public void run(){
        setupGame();
        while (!gameDone) {
            for (int i = 0; i<players.length; i++) {
                playerTurn(players[i], pieces[i]);
            }
        }
        System.out.println("Spilleren: " + getWinner(players) + " har vundet!!");
    }

    private void setupGame(){
        players = new Player[getPlayerAmount()]; // Sets length of player array
        pieces = new Piece[getPlayerAmount()]; // Sets length of player array
        setupPlayerNameAndPiece(); // Sets player name and piece and adds it to player array and piece array
    }
    private void playerTurn(Player player, Piece piece){
        playerRollDice(player, piece);
        updatePlayerBalance(player, piece);
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

    private void playerRollDice (Player player, Piece piece){
        System.out.println(player.getPlayerName() + ", rul terningerne! Tryk på vilkårlig tast for at rulle.");
        userinput.next();
        dice.roll();
        piece.setPiecePosition(dice.getRollSum());
        System.out.println(player.getPlayerName() + " lander på " + squares.getSquareArray()[piece.getPiecePosition()].getSquareName());
    }

    // Buys or pays rent to owner of current square. (Current state of method, just buys a place)
    private void updatePlayerBalance(Player player, Piece piece){
        int price = squares.getSquareArray()[piece.getPiecePosition()].getPrice();
        player.updateScore(-price);
    }

    // Checks if the current square is owned by other player. Returns true if it is owned.
    private boolean checkForOwner(Piece piece){return true;}
    private void buySquare(Player player, Piece piece){}
    private void payRent(Player player, Piece piece){}

    //Sets player names, a player piece and adds them to a player array and a piece array
    private void setupPlayerNameAndPiece(){
        for (int i = 0; i<playeramount;i++){
            System.out.println("Spiller " + i + ", indtast dit navn her: ");
            playername = userinput.next();
            Player player = new Player(playername, startingscore);
            Piece piece = new Piece();
            players[i] = player;
            pieces[i] = piece;
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