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
        return SquareName;
    }
    public String getSquareDescription(){
        return SquareDescription;
    }
}
