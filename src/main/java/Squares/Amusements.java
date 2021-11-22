package Squares;
import Game.Player;

public class Amusements extends Square {

    private String squareColor;
    private Player owner;
    private int price;

    public Amusements (String name, String description, String color, int price){
        super(name, description);
        this.squareColor = color;
        this.price = price;

    }
    @Override
    public void landOnSquare (Player player){
        // If both amusements in same color group is owned by the same player
        // the price multiplier is 2, if not, then it's 1.
        int priceMultiplier = 1;

        int position = player.getPiece().getPiecePosition();

        // If no one owns the amusements, player buys it
        if (getOwner() == null){
            player.updateScore(-this.getPrice());
            owner = player;
        }

        // if another player owns the amusement, pay rent to the player.
        else if (!player.equals(getOwner())){
            player.updateScore(-this.getPrice() * priceMultiplier);
            this.getOwner().updateScore(this.getPrice() * priceMultiplier);
        }
        // If a different player owns it, also checks if said player owns both of same color
        // Needs position method from either player or piece
        /*
        else if (this.getOwner() != player){
            if (SquareList.getSquareArray()[position -1] instanceof Amusements){
                if (((Amusements) squares[position -1]).getOwner() == this.getOwner()){
                    priceMultiplier = 2;
                }
            }
            else if(squares[position+1] instanceof Amusements){
                if(((Amusements) squares[position +1%24]).getOwner() == this.getOwner()){
                    priceMultiplier = 2;
        }
    }
            player.updateScore(-this.getPrice() * priceMultiplier);
            this.getOwner().updateScore(this.getPrice() * priceMultiplier);
        }*/
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

    public Player getOwner() {
        return owner;
    }

    public int getPrice(){
        return price;
    }
}
