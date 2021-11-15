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
    public void landOnSquare (Player[] players, int player){
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
        // If a different player owns
        else if (this.getOwner() != player){

            // Needs if statements for same owner of both colors
            // Will set priceMultiplier = 2 in that case



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

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getOwner(){
        return owner;
    }

    public int getPrice(){
        return price;
    }
}
