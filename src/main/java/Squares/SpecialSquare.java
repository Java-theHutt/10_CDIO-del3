package Squares;
import Game.Player;

public class SpecialSquare extends Square {

    // Used for "Gå i fængsel" and "Gratis parkering"
    public SpecialSquare(String squareName, String squareDescription){
        super (squareName, squareDescription);
    }

    @Override
    public void landOnSquare(Player[] players, int player) {

    }
}
