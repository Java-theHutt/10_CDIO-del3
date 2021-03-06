package Squares;

import Game.Player;

/*
The class is created as an abstract class, so the rest
of our square classes can inherit it's function for
squareName, squareDescription.
 */
public abstract class Square {

    String SquareName;
    String SquareDescription;
    int price;

    // Constructor //

    public Square(String squareName, String squareDescription){
        this.SquareName = squareName;
        this.SquareDescription = squareDescription;
    }

    // Getters //

    public String getSquareName() {
        return SquareName;
    }
    public String getSquareDescription(){
        return SquareDescription;
    }

    public int getPrice() {
        return price;
    }

    // Abstract method used by the individual squares
    // to perform their respective actions

    public abstract void landOnSquare (Player player);

}
