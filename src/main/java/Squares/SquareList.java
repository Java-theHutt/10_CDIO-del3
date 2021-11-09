package Squares;
import Squares.Square;

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


    }
}
