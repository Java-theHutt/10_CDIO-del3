package Squares;

/*
The class is created as an abstract class, so the rest
of our square classes can inherit it's function for
squareName, squareDescription.
 */
public abstract class Square {

    String SquareName;
    String SquareDescription;

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

    // Abstract method used by the individual squares
    // to perform their respective actions
    public abstract void landOnSquare (Player[] players, int player);
}
