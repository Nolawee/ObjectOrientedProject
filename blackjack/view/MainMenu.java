package blackjack.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainMenu {
    private String rules = getRules();
    int numPlayers;
    Table table;
	//Implementation of MainMenu here
    
    
    //----Helper methods--------------------------------------------------------------------------------
    
    public static String getRules() {
        String rules = "No rules here! Was there an error?";
        try {
            rules = new String(Files.readAllBytes(Paths.get("./src/main/resources/BlackjackRules.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rules;
    }

    public void setNumPlayers(int players){
        numPlayers = players;           
    }
    
    //----Temp main method for testing------------------------------------------------------------------
    
//    public static void main(String[] args) {
//        String rulez = getRules();
//        System.out.println(rulez);
//    }
}
