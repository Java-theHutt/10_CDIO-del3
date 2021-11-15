package Squares;

import Game.Player;
import java.util.Random;

public class ChanceSquare extends Square {

    public ChanceSquare(){
        super("?", "Træk et chancekort fra bunken");
    }

    @Override
    public void landOnSquare (Player[] players, int player){

    }

    // Skal udvides med at trække og blande chance kort.

    public static void drawChanceCard(){

    }
}
