package Squares;

public class Jail extends Square {

    public Jail (String squareName, String squareDescription){
        super(squareName, squareDescription);
        this.SquareName = "Fængsel";
        this.SquareDescription = "Gå i fængsel";
    }

    public void landOnSquare(Player[] players, int player) {
        // Rykker spiller til position 6, altså felt 7, som er fængslet.
        // Samt udtrykker det som en boolean, så spillet ved at spilleren er i fængsel
        players[player].setPosition(6);
        players[player].setInJail(true);
    }
}
