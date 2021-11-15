package Game;
import Pieces.Piece;

import static java.lang.Math.signum;

public class Player {
    private String playerName;
    private Account balance;
    private Pieces.Piece piece;

    public Player (String name, int startingScore){
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
}
