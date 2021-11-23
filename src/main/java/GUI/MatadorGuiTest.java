package GUI;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import Game.Player;

import java.util.ArrayList;
import java.util.List;

public class MatadorGuiTest {
    private static GUI gui;
    private static Player player;
    public static void main(String[] args) {

        GUI gui = new GUI(FieldfactoryJunior.makeFields());

        GUI_Field[] fields = gui.getFields();
        GUI_Field field = fields[0];

        // Opretter spiller med navnet Stephen og start balance på 2000
        GUI_Player player1 = new GUI_Player("Stephen", 2000);
        GUI_Player player2 = new GUI_Player("Ellis", 2000);
        GUI_Player player3 = new GUI_Player("Marc", 2000);
        GUI_Player player4 = new GUI_Player("Perkovich", 2000);

        List<GUI_Player> players = new ArrayList<>();
        players.add(player1);
        field.setCar(player1,true);
        players.add(player2);
        field.setCar(player2,true);
        players.add(player3);
        field.setCar(player3,true);
        players.add(player4);
        field.setCar(player4,true);
        field.setCar(player1,false);

        field = gui.getFields()[4];
        field.setCar(player1,true);

        GUI_Street street = (GUI_Street) field;

        gui.showMessage("Press OK to start");

        gui.setDie(6);
        gui.setDice(1,2);

        String chosenButton = gui.getUserButtonPressed("Click a button","Button 1","Button 2");

        String chosenElement = gui.getUserSelection("Choose an element", "1","2");
        for (GUI_Player player : players) {
            // Tilføjer ham til spillet
            gui.addPlayer(player);
        }
    }

    public static void movePiece(Player player,GUI_Player guiPlayer){
        GUI_Field[] fields = gui.getFields();
        GUI_Field field = fields[player.getPiece().getLastPiecePosition()];
        field.setCar(guiPlayer,false);

        field = fields[player.getPiece().getPiecePosition()];
        field.setCar(guiPlayer,true);
    }
}
