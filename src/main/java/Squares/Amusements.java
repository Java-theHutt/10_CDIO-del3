package Squares;

public class Amusements {

    private String squareColor;
    private int owner;
    private int price;

    public Amusements (String name, String description, String color, int price){
        super(name, description);
        this.squareColor = color;
        this.price = price;
        this.owner = -1;

    }
    public void landOnSquare (Player[] players, int player){
    }

    public void landOnSquare (Player[] players, int player, Square[] squares){
        // If both amusements in same color group is owned by the same player
        // the price multiplier is 2, if not, then it's 1.
        int priceMultiplier = 1;

        // NEEDS UPDATE

        // If no one owns the amusements, player buys it
        if (this.getOwner() ==-1){
            players[player].setScore(-this.getPrice());
            this.setOwner(player);
        }
    }
    public int getPrice(){
        return price;
    }
}
