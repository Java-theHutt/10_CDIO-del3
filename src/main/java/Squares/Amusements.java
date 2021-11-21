package Squares;
import Game.Player;
import Game.GameLogic;
import Pieces.Piece;

public class Amusements extends Square {

    private String squareColor;
    private int ownerIndex;
    private int price;

    public Amusements (String name, String description, String color, int price){
        super(name, description);
        this.squareColor = color;
        this.ownerIndex = -1;
        this.price = price;

    }
    @Override
    public void landOnSquare (Player[] players, int player) {

    }

    public void landOnSquare (Player[] players, int player, Square[] squares){
        // If both amusements in same color group is owned by the same player
        // the price multiplier is 2, if not, then it's 1.
        int priceMultiplier = 1;

        int position = players[player].getPiece().getPiecePosition();

        // If no one owns the amusements, player buys it
        if (getOwnerIndex() ==-1){
            players[player].setBalance(-this.getPrice());
            ownerIndex = (player);

        }
        // If a different player owns it, also checks if said player owns both of same color
        // Needs position method from either player or piece

        else if (this.getOwnerIndex() != player){
            if (squares[position -1] instanceof Amusements){
                if (((Amusements) squares[position -1]).getOwnerIndex() == this.getOwnerIndex()){
                    priceMultiplier = 2;
                }
            }
            else if(squares[position+1] instanceof Amusements){
                if(((Amusements) squares[position +1%24]).getOwnerIndex() == this.getOwnerIndex()){
                    priceMultiplier = 2;
        }
    }
            players[player].updateScore(-this.getPrice() * priceMultiplier);
            players[this.getOwnerIndex()].updateScore(this.getPrice() * priceMultiplier);
        }
    }

    public String getSquareName() {
        return SquareName;
    }

    public String getSquareDescription(){
        return SquareDescription;
    }

    public String getSquareColor(){
        return squareColor;
    }

    public int getOwnerIndex() {
        return ownerIndex;
    }

    public int getPrice(){
        return price;
    }
}
