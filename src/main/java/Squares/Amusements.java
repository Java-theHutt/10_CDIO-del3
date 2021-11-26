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
            player.getbuildingColorsOwned().add(this.getSquareColor());
        }

        // if another player owns the amusement, pay rent to the player. Also checks if a player owns two of the same
        // amusement, in which the rent is doubled.
        else if (!player.equals(getOwner())){

            int colorcount = 0; // used to count if a player owns all amusements with the same color

            // Goes through each element in array that stores amusement colors for a given player
            // and checks if there are two of the same color in the array
            for (String color: this.getOwner().getbuildingColorsOwned()) {
                if (color.equals(this.getSquareColor())){
                    colorcount++;
                    // colorcount is incremented for each occurence of a given color
                    if (colorcount == 2){
                        priceMultiplier = 2;
                        System.out.println(this.getOwner().getPlayerName() + " ejer begge ejendomme. Du betaler dobbelt leje!");
                    }
                }
            }
            player.updateScore(-this.getPrice() * priceMultiplier);
            System.out.println("Du har betalt " + this.getPrice()*priceMultiplier + " i leje!");
            this.getOwner().updateScore(this.getPrice() * priceMultiplier);
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

    public Player getOwner() {
        return owner;
    }

    public int getPrice(){
        return price;
    }
}
