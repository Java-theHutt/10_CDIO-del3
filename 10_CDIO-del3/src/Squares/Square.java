package Squares;

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
        return this.SquareName;
    }
    public String getSquareDescription(){
        return SquareDescription;
    }

    public abstract void landOnSquare (Player[] players, int player);
}
