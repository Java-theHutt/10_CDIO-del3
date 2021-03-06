package Game;

import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_main.GUI;
import GUI.FieldfactoryJunior;
import Pieces.Piece;
import Squares.SquareList;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLogic {

    private final GUI monopolyGUI = new GUI(FieldfactoryJunior.makeFields());
    private final GUI_Field[] monopolyFields = monopolyGUI.getFields();
    private final Scanner userinput = new Scanner(System.in);
    private boolean rollDiceButton;
    private GUI_Ownable ownable;
    private Color[] playerColors = new Color[4];
    private boolean startGameButton
            = monopolyGUI.getUserLeftButtonPressed("Velkommen til Monopoly Junior","Start Spillet","Regler");
    private Player[] players;
    private final DiceCollection dice = new DiceCollection(2);
    private final SquareList squares = new SquareList();
    private final Rules rules = new Rules();
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
        monopolyGUI.showMessage("Spilleren: " + getWinner(players) + " har vundet!!");
    }

    private void setupGame(){
        //startgame button is true if player picks "start spillet" and false if "Regler".
        while(!startGameButton){
            monopolyGUI.showMessage(rules.getRules()); //shows rules on gameboard
            startGameButton = monopolyGUI.getUserLeftButtonPressed("Velkommen til Monopoly Junior","Start Spillet","Regler");
        }
        players = new Player[getPlayerAmount()]; // Sets length of player array
        setupPlayer(); // Sets player name and piece and adds it to player array and piece array
        addPlayersToBoard();
        setOwnable();
        ownable.setBorder(Color.YELLOW);
    }
    private void playerTurn(Player player){
            playerRollDice(player);
            updatePlayerBalance(player);
            checkForLoss(player);
            playerPassesStart(player);
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
        //Checks if last position is greater than current, and if last position was jail.
        if (player.getPiece().getLastPiecePosition() > player.getPiece().getPiecePosition()
                && player.getPiece().getLastPiecePosition() != 18){
            System.out.println("Du har passeret start, modtag 2kr af banken.");
            player.updateScore(2);
            monopolyGUI.showMessage("Du har passeret start, modtag 2kr af banken.\nDin balance er nu: " + player.getBalance());
            System.out.println("Din balance er nu: " + player.getBalance());
            player.getGuiPlayer().setBalance(player.getBalance());
        }
    }
    private void playerRollDice (Player player){
        System.out.println(player.getPlayerName() + ", rul terningerne! Tryk p?? vilk??rlig tast for at rulle.");
        //userinput.next();
        if (isRollDiceButton(player))
            dice.roll();
        showDice(dice.getDiceFaceValue(1),dice.getDiceFaceValue(2)); //shows dice value in gui bases on roll
        player.getPiece().setLastPiecePosition();
        player.getPiece().setPiecePosition(dice.getRollSum());
        movePlayers(player);//moves the players on the board.
        System.out.println();
        System.out.println(player.getPlayerName() + " lander p?? " + squares.getSquareArray()[player.getPiece().getPiecePosition()].getSquareName());
        monopolyGUI.showMessage(player.getPlayerName() + " lander p?? " + squares.getSquareArray()[player.getPiece().getPiecePosition()].getSquareName());
        chancecardNewLandOnSquare(player);
    }

    // Buys or pays rent to owner of current square.
    private void updatePlayerBalance(Player player){
        if (!squares.getSquareArray()[player.getPiece().getPiecePosition()].getSquareName().equals("Chance"))
                squares.getSquareArray()[player.getPiece().getPiecePosition()].landOnSquare(player);
        //Makes sure field is ownable, before accessing modifyownable method.
        if (monopolyFields[player.getPiece().getPiecePosition()].getSubText().charAt(0) ==
                'P' && monopolyFields[player.getPiece().getPiecePosition()].getSubText().charAt(2) == 'i') {
            modifyOwnable(player, (GUI_Ownable) monopolyFields[player.getPiece().getPiecePosition()]);
        }
        movePlayers(player);
        System.out.println("Din nuv??rende balance er: " + player.getBalance());
        monopolyGUI.showMessage("Din nuv??rende balance er: " + player.getBalance());
        System.out.println();
        player.getGuiPlayer().setBalance(player.getBalance()); //sets playerbalance on gameboard
    }

    //Sets player names, a player piece and adds them to a player array and a piece array
    private void setupPlayer(){
        String playername;
        for (int i = 0; i<playeramount;i++){
            System.out.println("Spiller " + i + ", indtast dit navn her: ");
            playername = monopolyGUI.getUserString("Spiller " + (i + 1) + " indtast dit navn: ");
            //playername = userinput.next();
            System.out.println();
            Piece piece = new Piece();
            Player player = new Player(playername, startingscore, piece, getColor(i));
            players[i] = player;
            player.getGuiPlayer().getCar().setPrimaryColor(player.getColor());
            //player.getGuiPlayer().getCar().setSecondaryColor(player.getColor());
        }
    }

    //adds players to gui
    private void addPlayersToBoard(){
        for (Player player : players){
            monopolyGUI.addPlayer(player.getGuiPlayer());
            monopolyFields[0].setCar(player.getGuiPlayer(),true); //sets the players cars at start field
        }
    }

    //If the chancecard moves player to amusementfield makes sure landonsquare method is used for that field.
    private void chancecardNewLandOnSquare(Player player){
        if(squares.getSquareArray()[player.getPiece().getPiecePosition()].getSquareName().equals("Chance")) {
            squares.getSquareArray()[player.getPiece().getPiecePosition()].landOnSquare(player);
            movePlayers(player);//moves the players on the board.
        }
    }

    //Colors the square for a player if its not owned.
    public void modifyOwnable(Player player, GUI_Ownable field){
            if (!field.getOwnableLabel().equals("solgt")) {
                field.setOwnableLabel("solgt");
                field.setTitle(player.getPlayerName() + "'s Square");
                field.setBorder(player.getColor());
                field.setOwnerName(player.getPlayerName());
                field.setRent(field.getRent());
                field.setSubText("Pris: " + field.getRent());
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
            if (squares.getSquareArray()[player.getPiece().getPiecePosition()].getSquareName().equals("I F??ngsel")) {
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
                String input = monopolyGUI.getUserString("V??lg antal spillere : Indtast et tal fra 2 - 4");
                //playeramount = userinput.nextInt();
                playeramount = Character.getNumericValue(input.charAt(0));
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
        setupColors();
        return playeramount;
    }

    //color array for convenience
    private void setupColors(){
        playerColors[0] = Color.RED;
        playerColors[1] = Color.BLUE;
        playerColors[2] = Color.YELLOW;
        playerColors[3] = Color.WHITE;
    }

    //sets all amusementsfields to ownable. The fields can then acces additional methods including coloring field frame.
    private void setOwnable(){
        for (int i = 0 ; i < monopolyFields.length ; i++){
            if (monopolyFields[i].getSubText().charAt(0) == 'P' && monopolyFields[i].getSubText().charAt(2) == 'i') {
                ownable = (GUI_Ownable) monopolyFields[i];
            }
        }
    }

    private Color getColor(int index){
        return this.playerColors[index];
    }
    //Rolldicebutton returns true if player chooses "rul Terninger" and false for "Drik kaffe". Escapes once true.
    private boolean isRollDiceButton(Player player){
        rollDiceButton = monopolyGUI.getUserLeftButtonPressed(player.getPlayerName() + "'s tur","Rul terninger","Drik kaffe");
        while(!rollDiceButton){
            rollDiceButton = monopolyGUI.getUserLeftButtonPressed(player.getPlayerName() + "'s tur","Rul terninger","Drik kaffe");
        }
        return rollDiceButton;
    }
}