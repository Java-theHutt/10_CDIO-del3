package Squares;

import Game.Player;

public class StartSquare extends Square {

    // Starting square of the game

    public StartSquare(){
    super("Start", "Hent 2kr i banken, når du passerer start");

    }

    @Override
    public void landOnSquare (Player[] players, int player){

    }
}
