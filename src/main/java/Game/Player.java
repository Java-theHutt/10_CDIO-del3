package Game;

import Pieces.Piece;
import Squares.Square;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import gui_fields.GUI_Player;
import gui_main.GUI;

import static java.lang.Math.signum;

public class Player {
    private Color color;
    private GUI_Player guiPlayer;
    private String playerName;
    private Account balance;
    private Piece piece;
    private List<String> buildingColorsOwned = new ArrayList();


    public Player (String name, int startingScore, Piece piece,Color color){
        this.playerName = name;
        this.balance = new Account(startingScore);
        this.piece = new Piece();
        this.color = color;
        setGuiPlayer();
    }

    public void updateScore (int amount){
        if (signum(amount) == -1){                  //signum method, returns -1 if amount is negative.
            balance.subtractFromBalance(amount);
        }
        else {
            balance.addToBalance(amount);
        }
    }
    public void setGuiPlayer(){
        guiPlayer = new GUI_Player(this.playerName,this.balance.getBalance());
    }
    public GUI_Player getGuiPlayer(){
        return this.guiPlayer;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getBalance() {
        return balance.getBalance();
    }

    public Color getColor(){
        return this.color;
    }

    public void setBalance(int money){
        balance.setBalance(money);
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Piece getPiece() {
        return piece;
    }

    public List<String> getbuildingColorsOwned() {
        return buildingColorsOwned;
    }
}
