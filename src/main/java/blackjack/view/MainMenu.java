package blackjack.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

import java.awt.Dimension;


public class MainMenu extends JFrame implements ActionListener {
    private String rules = getRules();
	//Implementation of MainMenu here
    private static final int WIDTH = 800, HEIGHT = 600;
    
    Draw draw = new Draw();
    private JLabel mainMenu = draw.getJLabel;
    
    private JButton newGameButton = new JButton("New Game");
    private JButton loadGameButton = new JButton("Load Game");
    private JButton helpButton = new JButton("Help");
    
    public void mainMenu(){
    	setTitle("Blackjack!");
    	setResizabl(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	// new game,load game, and help
    	JPanel buttons = new JPanel();
    	buttons.add(newGameButton);
    	buttons.add(loadGameButton);
    	buttons.add(helpButton);
    	
    	// actionlisteners
    	newGameButton.addActionListener(this);
    	loadGameButton.addActionListener(this);
    	helpButton.addActionListener(this);
    	
    	// add buttons
    	getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
    	getContentPane().add(mainMenu);
    	getContentPane().add(buttons);
    	
    	draw.setCanvasSize(WIDTH,HEIGHT);
    	draw.setXscale(0,WIDTH);
    	draw.setYscale(0,HEIGHT);
    	pack();
    	setVisible(true);
    	
    }
    
    //----Action Buttons ----
    public void actionPerformed(ActionEvent e){
    	if(e.getSource() == newGameButton){
    		newGame();
    	}
    	if(e.getSource() == loadGameButton){
    		loadGame();
    	}
    	if(e.getSource() == helpButton){
    		help();
    	}
    }
    
    //----Main Menu Display-----
    
    public static void main(){
    	new mainMenu();
    }
    
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
    
    //----Temp main method for testing------------------------------------------------------------------
    
//    public static void main(String[] args) {
//        String rulez = getRules();
//        System.out.println(rulez);
//    }
}
