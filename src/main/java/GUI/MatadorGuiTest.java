package GUI;

import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.ArrayList;
import java.util.List;

public class MatadorGuiTest {
    public static void main(String[] args) {

        GUI gui = new GUI(FieldfactoryJunior.makeFields());

        // Opretter spiller med navnet Stephen og start balance på 2000
        GUI_Player player1 = new GUI_Player("Stephen", 2000);
        GUI_Player player2 = new GUI_Player("Ellis", 2000);
        GUI_Player player3 = new GUI_Player("Marc", 2000);
        GUI_Player player4 = new GUI_Player("Perkovich", 2000);

        List<GUI_Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        for (GUI_Player player : players) {
            // Tilføjer ham til spillet
            gui.addPlayer(player);
        }

    }
}
