package Squares;
import static java.lang.Integer.parseInt;
// import Squares.Square;

public class SquareList {
    private Square[] squareArray = new Square[24];

    public SquareList() {
        String[][] allSquares = new String[24][];
        allSquares[0] = new String[]{"Start", "Hent 2kr i banken, når du passerer start"};
        allSquares[1] = new String[]{"Burgerbaren", "M1", "grå"};
        allSquares[2] = new String[]{"Pizzahuset", "M1", "grå"};
        allSquares[3] = new String[]{"Chance", "Tag et kort"};
        allSquares[4] = new String[]{"Godtebutikken", "M1", "lyseblå"};
        allSquares[5] = new String[]{"Iskiosken", "M1", "lyseblå"};
        allSquares[6] = new String[]{"I fængsel", "På besøg"};
        allSquares[7] = new String[]{"Museet", "M2", "lilla"};
        allSquares[8] = new String[]{"Biblioteket", "M2", "lilla"};
        allSquares[9] = new String[]{"Chance", "Tag et kort"};
        allSquares[10] = new String[]{"Skaterparken", "M2", "orange"};
        allSquares[11] = new String[]{"Svømmebassinet", "M2", "orange"};
        allSquares[12] = new String[]{"Gratis", "Parkering"};
        allSquares[13] = new String[]{"Spillehallen", "M3", "Rød"};
        allSquares[14] = new String[]{"Biografen", "M3", "Rød"};
        allSquares[15] = new String[]{"Chance", "Tag et kort"};
        allSquares[16] = new String[]{"Legetøjsbutikken", "M3", "gul"};
        allSquares[17] = new String[]{"Dyrehandlen", "M3", "gul"};
        allSquares[18] = new String[]{"Gå i fængsel", "fængsel"};
        allSquares[19] = new String[]{"Bowlinghallen", "M4", "grøn"};
        allSquares[20] = new String[]{"Zoologisk have", "M4", "grøn"};
        allSquares[21] = new String[]{"Chance", "Tag et kort"};
        allSquares[22] = new String[]{"Vandlandet", "M5", "blå"};
        allSquares[23] = new String[]{"Strandpromenaden", "M5", "blå"};

    /*
    A bunch of if/else statements, which checks the first collumn of the array
    for the words "Start", "Chance", "I fængsel", "Gratis" and "Gå i fængsel" and initializes them

    Also makes all occurences of "Chance" have the same object reference
    regardless of it's array index, basically making em all copies.
     */

    for (int i = 0; i < allSquares.length; i++){
        if(allSquares[i][0].equals("Start")){
            this.squareArray[i] = new StartSquare();
        }

        else if (allSquares[i][0].equals("Chance")){
            if (i==3){
                this.squareArray[i] = new ChanceSquare();
            }
            else {squareArray[i] = squareArray[3];}
        }

        else if (allSquares[i][0].equals("I fængsel") || allSquares[i][0].equals("Gratis")){
            this.squareArray[i] = new SpecialSquare(allSquares[i][0], allSquares[i][1]);
        }

        else if (allSquares[i][0].equals("Gå i fængsel")){
            this.squareArray[i] = new Jail();

        }

        else {
            this.squareArray[i] = new Amusements(allSquares[i][0], allSquares[i][1], allSquares[i][2], parseInt(allSquares[i][1].substring(1)));
        }
      }
    }

    // Creates a toString method for the
    // specific squares name and description

    @Override
    public String toString(){
        String squareString = "";
        for (int i = 0; i < squareArray.length; i++){
            squareString += squareArray[i].getSquareName() + " - " + squareArray[i].getSquareDescription()+"\n";
        }
        return squareString;
    }

    public String getSquareName(){
        return squareArray[0].getSquareName();
    }

    public Square[] getSquareArray() {
        return this.squareArray;
    }
}
