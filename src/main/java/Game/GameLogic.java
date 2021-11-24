package Game;

import gui_fields.GUI_Field;
import gui_main.GUI;
import GUI.FieldfactoryJunior;
import Pieces.Piece;
import Squares.SquareList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLogic {

    private final GUI monopolyGUI = new GUI(FieldfactoryJunior.makeFields());
    private final GUI_Field[] monopolyFields = monopolyGUI.getFields();
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
        addPlayersToBoard();
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
            player.getGuiPlayer().setBalance(player.getBalance());
        }
    }
    private void playerRollDice (Player player){
        System.out.println(player.getPlayerName() + ", rul terningerne! Tryk på vilkårlig tast for at rulle.");
        userinput.next();
        dice.roll();
        showDice(dice.getDiceFaceValue(1),dice.getDiceFaceValue(2)); //shows dice value in gui bases on roll
        player.getPiece().setLastPiecePosition();
        player.getPiece().setPiecePosition(dice.getRollSum());
        movePlayers(player);//moves the players on the board.
        System.out.println();
        System.out.println(player.getPlayerName() + " lander på " + squares.getSquareArray()[player.getPiece().getPiecePosition()].getSquareName());
        chancecardNewLandOnSquare(player);
    }

    // Buys or pays rent to owner of current square.
    private void updatePlayerBalance(Player player){
        if (!squares.getSquareArray()[player.getPiece().getPiecePosition()].getSquareName().equals("Chance"))
                squares.getSquareArray()[player.getPiece().getPiecePosition()].landOnSquare(player);
        movePlayers(player);
        System.out.println("Din nuværende balance er: " + player.getBalance());
        System.out.println();
        player.getGuiPlayer().setBalance(player.getBalance());
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

    //adds players to gui
    private void addPlayersToBoard(){
        for (Player player : players){
            monopolyGUI.addPlayer(player.getGuiPlayer());
            monopolyFields[0].setCar(player.getGuiPlayer(),true); //sets the players cars at start field
        }
    }

    private void chancecardNewLandOnSquare(Player player){
        if(squares.getSquareArray()[player.getPiece().getPiecePosition()].getSquareName().equals("Chance")) {
            squares.getSquareArray()[player.getPiece().getPiecePosition()].landOnSquare(player);
            movePlayers(player);//moves the players on the board.
        }
    }

    //shows dice values on board
    private void showDice(int die1Value,int die2Value){
        monopolyGUI.setDice(die1Value,die2Value);
    }
    //moves the players cars on board + delete old position
    public void movePlayers(Player player){
        if(player.getPiece().getPiecePosition() != player.getPiece().getLastPiecePosition()) {
            monopolyFields[player.getPiece().getLastPiecePosition()].setCar(player.getGuiPlayer(), false);
            monopolyFields[player.getPiece().getPiecePosition()].setCar(player.getGuiPlayer(), true);
            //throws player in jail if he lands on go to jail
            if (squares.getSquareArray()[player.getPiece().getPiecePosition()].getSquareName().equals("I Fængsel")) {
                monopolyFields[18].setCar(player.getGuiPlayer(), false);
                monopolyFields[6].setCar(player.getGuiPlayer(), true);
            }
        }
    }

    //Helper function for setupPlayers
    private int getPlayerAmount(){
        System.out.println("Spillet er tilegnet 2-4 spillere. Indtast antal spillere her: ");
        boolean x = true;
        while (x) {
            try {
                playeramount = userinput.nextInt();
                if (playeramount > 1 && playeramount < 5) {
                    x = false;
                } else {
                    System.out.println("Forkert antal spillere. Indtast igen her: ");
                }
            }catch(InputMismatchException e){
                System.out.println("Forkert input. Indtast tal fra 2 - 4!");
                userinput.next();
            }
        }
        return playeramount;
    }
}