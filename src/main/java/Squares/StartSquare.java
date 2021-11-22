package Squares;

import Game.Player;

public class StartSquare extends Square {

    // Starting square of the game

    public StartSquare(){
    super("Start", "Hent 2kr i banken, når du passerer start");
    }

   public void landOnSquare (Player player){
       System.out.println("Du er landet på Start og modtager 2kr");
       player.updateScore(2);
       System.out.println("Din balance er nu: " + player.getBalance());

   }
}
