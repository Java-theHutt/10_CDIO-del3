package Squares;
import Game.Player;

public class Amusements extends Square {

    private String squareColor;
    private int owner;
    private int price;

    public Amusements (String name, String description, String color, int price){
        super(name, description);
        this.squareColor = color;
        this.price = price;
        this.owner = -1;

    }
    @Override
    public void landOnSquare (Player[] players, int player) {

    }

    public void landOnSquare (Player[] players, int player, Square[] squares){
        // If both amusements in same color group is owned by the same player
        // the price multiplier is 2, if not, then it's 1.
        int priceMultiplier = 1;

        // NEEDS UPDATE

        // If no one owns the amusements, player buys it
        if (this.getOwner() ==-1){
            players[player].setBalance(-this.getPrice());
            this.setOwner(player);
        }
        // If a different player owns it, also checks if said player owns both of same color
        else if (this.getOwner() != player){
            if (squares[players[player].getPosition()-1] instanceof Amusements){
                if (((Amusements) squares[players][player].getPositon()-1]).getOwner() == this.getOwner())){
                    priceMultiplier = 2;
                }
            }
            else if(squares[players[player].getPosition()+1] instanceof Amusements){
                if(((Amusements) squares[(players[player].getPosition()+1)%24]).getOwnedBy() == this.getOwner()){
                    priceMultiplier = 2;
        }
    }
            players[player].updateScore(-this.getPrice() * priceMultiplier);
            players[this.getOwner()].updateScore(this.getPrice() * priceMultiplier);
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

    public int getOwner(){
        return owner;
    }

    public void setOwner(int owner);

    public int getPrice(){
        return price;
    }
}
