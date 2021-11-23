package GUI;

import gui_main.GUI;
import GUI.FieldfactoryJunior;

public class MonopolyGUI {
    public void setUpGUI(){
        GUI gui = new GUI(FieldfactoryJunior.makeFields());
    }
}

