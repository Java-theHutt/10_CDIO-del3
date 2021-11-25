package GUI;

import java.awt.Color;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_fields.GUI_Tax;

public class FieldfactoryJunior {

    public static GUI_Field[] makeFields() {
        GUI_Field[] fields = new GUI_Field[24];
        int i = 0;
        fields[i++] = new GUI_Start("Start", "Modtag: M2", "Modtag M2\nnår de passerer start", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Street("Burgerbaren", "Pris:  M1", "Burgerbaren", "Leje:  M1", new Color(128, 128, 128), Color.BLACK);
        fields[i++] = new GUI_Street("Pizzahuset", "Pris: M1", "Pizzahuset", "Leje: M1", new Color(128, 128, 128), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort", new Color(0, 0, 0), Color.YELLOW);
        fields[i++] = new GUI_Street("Godte butikken", "Pris:  M1", "Godtebutikken", "Leje:  M1", new Color(173, 216, 230), Color.BLACK);
        fields[i++] = new GUI_Street("Iskiosken", "Pris:  M1", "Iskiosken", "Leje:  M1", new Color(173, 216, 230), Color.BLACK);
        fields[i++] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street("Museet", "Pris:  M2", "Museet", "Leje:  M2", new Color(221, 160, 221), Color.BLACK);
        fields[i++] = new GUI_Street("Biblioteket", "Pris:  M2", "Biblioteket", "Leje:  M2", new Color(221, 160, 221), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort", new Color(0, 0, 0), Color.YELLOW);
        fields[i++] = new GUI_Street("Skaterparken", "Pris:  M2", "Skaterparken", "Leje:  M2", new Color(255, 165, 0), Color.BLACK);
        fields[i++] = new GUI_Street("Svømme basinet", "Pris:  M2", "Svømmebasinet", "Leje:  M2", new Color(255, 165, 0), Color.BLACK);
        fields[i++] = new GUI_Refuge("default", "Gratis parkering", "Helle", "Ta' en pause", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Spille hallen", "Pris:  M3", "Spillehallen", "Leje:  M3", new Color(255, 0, 0), Color.BLACK);
        fields[i++] = new GUI_Street("Biografen", "Pris:  M3", "Biografen", "Leje:  M3", new Color(255, 0, 0), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort", new Color(0, 0, 0), Color.YELLOW);
        fields[i++] = new GUI_Street("Legetøjs butikken", "Pris:  M3", "Legetøjsbutikken", "Leje:  M3", Color.YELLOW, Color.BLACK);
        fields[i++] = new GUI_Street("Dyrehandlen", "Pris:  M3", "Dyrehandlen", "Leje:  M3", Color.YELLOW, Color.BLACK);
        fields[i++] = new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "De fængsles\nSlå to ens for at komme ud", new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street("Bowling hallen", "Pris:  M4", "Bowlinghallen", "Leje:  M4", Color.GREEN, Color.BLACK);
        fields[i++] = new GUI_Street("Zoologisk have", "Pris:  M4", "Zoologish have", "Leje:  M4", Color.GREEN, Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort", new Color(0, 0, 0), Color.YELLOW);
        fields[i++] = new GUI_Street("Vandlandet", "Pris:  M5", "Vandlandet", "Leje:  M5", new Color(0, 0, 255), Color.BLACK);
        fields[i] = new GUI_Street("Strand promenaden", "Pris:  M5", "Strandpromenaden", "Leje:  M5", new Color(0, 0, 255), Color.BLACK);

        return fields;
    }

}
