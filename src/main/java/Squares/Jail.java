package Squares;
import Game.Player;


public class Jail extends Square {

    private String occupiedBy;

    public Jail () { super("I Fængsel", "Betal M1, eller brug dit chancekort for at komme ud igen");
    }

    @Override
    public void landOnSquare(Player[] players, int player) {
        /*
        Moves the player to position 6 on the board, square 7, which is jail
        Takes 3$ from the player, and puts it on the loose change square
        */

         // players[player].SetPosition(6);
         players[player].setBalance(-3);
    }

    public String getOccupiedBy(){
        return occupiedBy;
    }
}
