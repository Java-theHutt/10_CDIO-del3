package Game;

import Pieces.Piece;
import Squares.Square;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.signum;

public class Player {
    private String playerName;
    private Account balance;
    private Piece piece;
    private List<String> buildingColorsOwned = new ArrayList();

    public Player (String name, int startingScore, Piece piece){
        this.playerName = name;
        this.balance = new Account(startingScore);
        this.piece = new Piece();
    }

    public void updateScore (int amount){
        if (signum(amount) == -1){                  //signum method, returns -1 if amount is negative.
            balance.subtractFromBalance(amount);
        }
        else {
            balance.addToBalance(amount);
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getBalance() {
        return balance.getBalance();
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
