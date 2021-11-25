package Game;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Rules {

    private String rules;
    private Scanner scanner;

    public String getRules(){
        loadTestFile();
        createWordList();
        return rules;
    }

    private void loadTestFile() {
        try {
            scanner = new Scanner(new File("MonopolyJuniorRegler.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void createWordList(){
        while(scanner.hasNext()){
            rules += scanner.nextLine() + "\n";
        }
        this.rules = rules;
    }

}
