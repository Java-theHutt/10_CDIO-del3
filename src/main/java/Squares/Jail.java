package Squares;
import Game.Player;

public class Jail extends Square {

    private String occupiedBy;

    public Jail () { super("I Fængsel", "Betal M3, eller brug dit chancekort for at komme ud igen");
    }

    @Override
    public void landOnSquare(Player player) {

        /*
        Moves the player to position 6 on the board, square 7, which is jail
        Takes 3$ from the player, and puts it on the loose change square
        */

        player.getPiece().movePieceTo(6);
        player.updateScore(-3);
        System.out.println("Du er smidt i fængsel og betaler 3kr for at komme ud igen!");
    }

    public String getOccupiedBy(){
        return occupiedBy;
    }
}
