package Squares;
import Game.Player;

public class Jail extends Square {

    private String occupiedBy;

    public Jail (String occupiedBy){
        super("Fængsel", "Gå i fængsel");
    }

    public void landOnSquare(Player[] players, int player) {
        /*
        Moves the player to position 6 on the board, square 7, which is jail
        Takes 3$ from the player, and puts it on the loose change square
        */
        //players[player].setPosition(6);
        // players[player].setScore(-3);
    }
}
