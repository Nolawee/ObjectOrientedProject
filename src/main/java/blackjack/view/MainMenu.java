package blackjack.view;

<<<<<<< HEAD
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class MainMenu {

	private JFrame frame;
	private JPanel panelMainmenu;
	private JPanel panelNewGame;
	private JPanel panelLoadGame;
	private JPanel panelHelp;
	private JTextField textFieldSetChip;
	private JTextField textFieldSetComp;
	private JTextField textFieldRules;
	private String rules = getRules();
	private int numCompPlayer = 0;
	private int amountStart = 100;
	
	//public tableView table;
	public playingTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 0));
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		// --- Panel Switch ----//
		
		final JPanel panelMainMenu = new JPanel();
		panelMainMenu.setBackground(new Color(0, 102, 0));
		frame.getContentPane().add(panelMainMenu, "name_98241740717447");
		panelMainMenu.setLayout(null);
		panelMainMenu.setVisible(true);
		
		final JPanel panelNewGame = new JPanel();
		panelNewGame.setBackground(new Color(0, 102, 0));
		frame.getContentPane().add(panelNewGame, "name_98335609249571");
		panelNewGame.setLayout(null);
		panelNewGame.setVisible(false);
		
		final JPanel panelLoadGame = new JPanel();
		panelLoadGame.setBackground(new Color(0, 102, 0));
		frame.getContentPane().add(panelLoadGame, "name_98257238941273");
		panelLoadGame.setLayout(null);
		panelLoadGame.setVisible(false);
		
		final JPanel panelHelp = new JPanel();
		frame.getContentPane().add(panelHelp, "name_103674355256420");
		panelHelp.setBackground(new Color(0, 102, 0));
		panelHelp.setLayout(null);
		panelHelp.setVisible(false);
		
		// ---- Main Menu ---- //
		JLabel lblBlackjackMainMenu = new JLabel("BlackJack!");
		lblBlackjackMainMenu.setForeground(new Color(255, 204, 0));
		lblBlackjackMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlackjackMainMenu.setFont(new Font("Helvetica", Font.ITALIC, 65));
		lblBlackjackMainMenu.setBounds(200, 120, 400, 80);
		panelMainMenu.add(lblBlackjackMainMenu);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNewGame.setVisible(true);
				panelMainMenu.setVisible(false);
			}
		});
		btnNewGame.setForeground(new Color(255, 204, 0));
		btnNewGame.setFont(new Font("Helvetica", Font.PLAIN, 30));
		btnNewGame.setBounds(300, 250, 200, 80);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setOpaque(false);
		btnNewGame.setBorderPainted(true);
		btnNewGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		panelMainMenu.add(btnNewGame);
		
		JButton btnLoadGameMainMenu = new JButton("Load Game");
		btnLoadGameMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLoadGame.setVisible(true);
				panelMainMenu.setVisible(false);
			}
		});
		btnLoadGameMainMenu.setForeground(new Color(255, 204, 0));
		btnLoadGameMainMenu.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnLoadGameMainMenu.setBounds(200, 360, 180, 60);
		btnLoadGameMainMenu.setContentAreaFilled(false);
		btnLoadGameMainMenu.setOpaque(false);
		btnLoadGameMainMenu.setBorderPainted(true);
		btnLoadGameMainMenu.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		panelMainMenu.add(btnLoadGameMainMenu);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHelp.setVisible(true);
				panelMainMenu.setVisible(false);
			}
		});
		btnHelp.setForeground(new Color(255, 204, 0));
		btnHelp.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnHelp.setBounds(420, 360, 180, 60);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setOpaque(false);
		btnHelp.setBorderPainted(true);
		btnHelp.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		panelMainMenu.add(btnHelp);
		
		
		// ---- New Game Panel ---- //
		
		JLabel lblBlackjackNewGame = new JLabel("BlackJack!");
		lblBlackjackNewGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlackjackNewGame.setForeground(new Color(255, 204, 0));
		lblBlackjackNewGame.setFont(new Font("Helvetica", Font.ITALIC, 65));
		lblBlackjackNewGame.setBounds(200, 120, 400, 80);
		panelNewGame.add(lblBlackjackNewGame);
		
		JLabel lblDollarSign = new JLabel("$");
		lblDollarSign.setFont(new Font("Helvetica", Font.PLAIN, 26));
		lblDollarSign.setForeground(new Color(255, 204, 0));
		lblDollarSign.setBounds(190, 250, 60, 60);
		lblDollarSign.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		panelNewGame.add(lblDollarSign);
		
		textFieldSetChip = new JTextField();
		textFieldSetChip.setBackground(new Color(0, 51, 0));
		textFieldSetChip.setForeground(new Color(255, 204, 0));
		textFieldSetChip.setFont(new Font("Helvetica", Font.PLAIN, 26));
		textFieldSetChip.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldSetChip.setText(String.valueOf(amountStart));
		textFieldSetChip.setBounds(190, 250, 200, 60);
		
		Border lined = new LineBorder(new Color(255,204,0),2);
		Border emptySetChip = new EmptyBorder(0,0,0,20);
		
		textFieldSetChip.setBorder(lined);
		
		textFieldSetChip.setBorder(BorderFactory.createCompoundBorder(lined,emptySetChip));
		panelNewGame.add(textFieldSetChip);
		textFieldSetChip.setColumns(10);
		
		
		textFieldSetComp = new JTextField();
		
		textFieldSetComp.setText(String.valueOf(numCompPlayer));
		
		JButton btnSetCompUp = new JButton("▲");
		btnSetCompUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				numCompPlayer += 1;
				if(numCompPlayer > 3){
					numCompPlayer = 3;
				} else {
					textFieldSetComp.setText(String.valueOf(numCompPlayer));
				}
			}
		});
		
		
		btnSetCompUp.setForeground(new Color(255, 204, 0));
		btnSetCompUp.setBounds(560, 255, 60, 20);
		btnSetCompUp.setContentAreaFilled(false);
		btnSetCompUp.setOpaque(false);
		btnSetCompUp.setBorderPainted(false);
		panelNewGame.add(btnSetCompUp);
		
		JButton btnSetCompDown = new JButton("▼");
		btnSetCompDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numCompPlayer -= 1;
				if(numCompPlayer < 0){
					numCompPlayer = 0;
				} else {
				textFieldSetComp.setText(String.valueOf(numCompPlayer));
				}
			}
		});
		btnSetCompDown.setOpaque(false);
		btnSetCompDown.setForeground(new Color(255, 204, 0));
		btnSetCompDown.setContentAreaFilled(false);
		btnSetCompDown.setBorderPainted(false);
		btnSetCompDown.setBounds(560, 280, 60, 30);
		panelNewGame.add(btnSetCompDown);
		
		
		
		textFieldSetComp.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldSetComp.setForeground(new Color(255, 204, 0));
		textFieldSetComp.setFont(new Font("Helvetica", Font.PLAIN, 26));
		textFieldSetComp.setColumns(10);
		textFieldSetComp.setBackground(new Color(0, 51, 0));
		textFieldSetComp.setBounds(410, 250, 200, 60);
		
		Border emptySetComp = new EmptyBorder(0,0,0,30);
		
		textFieldSetComp.setBorder(BorderFactory.createCompoundBorder(lined,emptySetComp));
		panelNewGame.add(textFieldSetComp);
		
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int chipEntered = Integer.parseInt(textFieldSetChip.getText());
				int compPlayerEntered = Integer.parseInt(textFieldSetComp.getText());
				if(chipEntered > 50 && chipEntered < 100000){
					frame.dispose();
					//tableView tableWindow;
					try {
						table = new playingTable();
						table.setCurrentChip(chipEntered);
						table.setNumCompPlayer(compPlayerEntered);
												
						table.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnStartGame.setOpaque(false);
		btnStartGame.setForeground(new Color(255, 204, 0));
		btnStartGame.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnStartGame.setContentAreaFilled(false);
		btnStartGame.setBorderPainted(true);
		btnStartGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		btnStartGame.setBounds(200, 350, 180, 60);
		panelNewGame.add(btnStartGame);
		
		JButton btnGoBackNewGame = new JButton("Main Menu");
		btnGoBackNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMainMenu.setVisible(true);
				panelNewGame.setVisible(false);
			}
		});
		btnGoBackNewGame.setOpaque(false);
		btnGoBackNewGame.setForeground(new Color(255, 204, 0));
		btnGoBackNewGame.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnGoBackNewGame.setBorderPainted(true);
		btnGoBackNewGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		btnGoBackNewGame.setBounds(420, 350, 180, 60);
		panelNewGame.add(btnGoBackNewGame);
		
		
		// ---- Load Game ---- //
		JLabel lblBlackJackLoadGame = new JLabel("BlackJack!");
		lblBlackJackLoadGame.setBounds(200, 100, 400, 80);
		lblBlackJackLoadGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlackJackLoadGame.setForeground(new Color(255, 204, 0));
		lblBlackJackLoadGame.setFont(new Font("Helvetica", Font.ITALIC, 65));
		panelLoadGame.add(lblBlackJackLoadGame);
		
		JList listSavedGame = new JList();
		listSavedGame.setForeground(new Color(255, 204, 0));
		listSavedGame.setBounds(150, 200, 500, 200);
		listSavedGame.setOpaque(false);
		listSavedGame.setFont(new Font("Helvetica", Font.PLAIN, 26));
		Border emptyListSavedGame = new EmptyBorder(10,10,10,30);
		listSavedGame.setBorder(BorderFactory.createCompoundBorder(lined,emptyListSavedGame));
		
		panelLoadGame.add(listSavedGame);
		
		JButton btnLoadLoadGame = new JButton("Load");
		btnLoadLoadGame.setOpaque(false);
		btnLoadLoadGame.setForeground(new Color(255, 204, 0));
		btnLoadLoadGame.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnLoadLoadGame.setContentAreaFilled(false);
		btnLoadLoadGame.setBorderPainted(true);
		btnLoadLoadGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		btnLoadLoadGame.setBounds(200, 450, 180, 60);
		panelLoadGame.add(btnLoadLoadGame);
		
		JButton btnMainMenuLoadGame = new JButton("Main Menu");
		btnMainMenuLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMainMenu.setVisible(true);
				panelLoadGame.setVisible(false);
			}
		});
		btnMainMenuLoadGame.setOpaque(false);
		btnMainMenuLoadGame.setForeground(new Color(255, 204, 0));
		btnMainMenuLoadGame.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnMainMenuLoadGame.setBorderPainted(true);
		btnMainMenuLoadGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		btnMainMenuLoadGame.setBounds(420, 450, 180, 60);
		panelLoadGame.add(btnMainMenuLoadGame);
		
		
		// ---- Help Panel ---- //
		
		JLabel label = new JLabel("BlackJack!");
		label.setBounds(200, 50, 400, 80);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 204, 0));
		label.setFont(new Font("Helvetica", Font.ITALIC, 65));
		panelHelp.add(label);
		
		textFieldRules = new JTextField();
		textFieldRules.setHorizontalAlignment(SwingConstants.LEFT);
		//textFieldRules.setText("This is rules.");
		textFieldRules.setText(rules);
		textFieldRules.setEditable(false);
		textFieldRules.setOpaque(false);
		textFieldRules.setFont(new Font("Helvetica",Font.PLAIN,26));
		textFieldRules.setForeground(new Color(255,204,0));
		Border emptyTextFieldRules = new EmptyBorder(10,10,10,10);
		textFieldRules.setBorder(BorderFactory.createCompoundBorder(lined,emptyTextFieldRules));
		textFieldRules.setBounds(100, 130, 600, 320);
		panelHelp.add(textFieldRules);
		textFieldRules.setColumns(10);
		
		JButton btnMainMenuHelp = new JButton("Main Menu");
		btnMainMenuHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMainMenu.setVisible(true);
				panelHelp.setVisible(false);
			}
		});
		btnMainMenuHelp.setOpaque(false);
		btnMainMenuHelp.setForeground(new Color(255, 204, 0));
		btnMainMenuHelp.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnMainMenuHelp.setBorderPainted(true);
		btnMainMenuHelp.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		btnMainMenuHelp.setBounds(310, 465, 180, 60);
		panelHelp.add(btnMainMenuHelp);
		
		
		
		
		
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	//----Helper methods--------------------------------------------------------------------------------
=======
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import javax.swing.JFrame;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.BoxLayout;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import java.awt.Color;
//
//import java.awt.Dimension;


public class MainMenu /*extends JFrame implements ActionListener*/ {
    private String rules = getRules();
	//Implementation of MainMenu here
//    private static final int WIDTH = 800, HEIGHT = 600;
//    
//    Draw draw = new Draw();
//    private JLabel mainMenu = draw.getJLabel;
//    
//    private JButton newGameButton = new JButton("New Game");
//    private JButton loadGameButton = new JButton("Load Game");
//    private JButton helpButton = new JButton("Help");
//    
//    public void mainMenu(){
//    	setTitle("Blackjack!");
//    	setResizable(false);
//    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	
//    	// new game,load game, and help
//    	JPanel buttons = new JPanel();
//    	buttons.add(newGameButton);
//    	buttons.add(loadGameButton);
//    	buttons.add(helpButton);
//    	
//    	// actionlisteners
//    	newGameButton.addActionListener(this);
//    	loadGameButton.addActionListener(this);
//    	helpButton.addActionListener(this);
//    	
//    	// add buttons
//    	getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
//    	getContentPane().add(mainMenu);
//    	getContentPane().add(buttons);
//    	
//    	draw.setCanvasSize(WIDTH,HEIGHT);
//    	draw.setXscale(0,WIDTH);
//    	draw.setYscale(0,HEIGHT);
//    	pack();
//    	setVisible(true);
//    	
//    }
    
//    //----Action Buttons ----
//    public void actionPerformed(ActionEvent e){
//    	if(e.getSource() == newGameButton){
//    		newGame();
//    	}
//    	if(e.getSource() == loadGameButton){
//    		loadGame();
//    	}
//    	if(e.getSource() == helpButton){
//    		help();
//    	}
//    }
//    
//    //----Main Menu Display-----
//    
//    public static void main(){
//    	new mainMenu();
//    }
    
    //----Helper methods--------------------------------------------------------------------------------
>>>>>>> refs/heads/master
    
    public static String getRules() {
        String rules = "No rules here! Was there an error?";
        try {
            rules = new String(Files.readAllBytes(Paths.get("./src/main/resources/BlackjackRules.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rules;
    }
}
