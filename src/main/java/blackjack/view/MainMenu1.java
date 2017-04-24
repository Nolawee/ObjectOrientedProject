package blackjack.view;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class MainMenu1 {

	private JFrame frame;
	private JTextField textFieldSetChip;
	private JTextField textFieldSetComp;
	private JTextField textFieldRules;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu1 window = new MainMenu1();
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
	public MainMenu1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 0));
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		// ---- Main Menu ---- //
		
		JPanel panelMainMenu = new JPanel();
		panelMainMenu.setBackground(new Color(0, 102, 0));
		frame.getContentPane().add(panelMainMenu, "name_98241740717447");
		panelMainMenu.setLayout(null);
		
		JLabel lblBlackjackMainMenu = new JLabel("BlackJack!");
		lblBlackjackMainMenu.setForeground(new Color(255, 204, 0));
		lblBlackjackMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlackjackMainMenu.setFont(new Font("Helvetica", Font.ITALIC, 65));
		lblBlackjackMainMenu.setBounds(200, 120, 400, 80);
		panelMainMenu.add(lblBlackjackMainMenu);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setForeground(new Color(255, 204, 0));
		btnNewGame.setFont(new Font("Helvetica", Font.PLAIN, 30));
		btnNewGame.setBounds(300, 250, 200, 80);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setOpaque(false);
		btnNewGame.setBorderPainted(true);
		btnNewGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		panelMainMenu.add(btnNewGame);
		
		JButton btnLoadGameMainMenu = new JButton("Load Game");
		btnLoadGameMainMenu.setForeground(new Color(255, 204, 0));
		btnLoadGameMainMenu.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnLoadGameMainMenu.setBounds(200, 360, 180, 60);
		btnLoadGameMainMenu.setContentAreaFilled(false);
		btnLoadGameMainMenu.setOpaque(false);
		btnLoadGameMainMenu.setBorderPainted(true);
		btnLoadGameMainMenu.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		panelMainMenu.add(btnLoadGameMainMenu);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setForeground(new Color(255, 204, 0));
		btnHelp.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnHelp.setBounds(420, 360, 180, 60);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setOpaque(false);
		btnHelp.setBorderPainted(true);
		btnHelp.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		panelMainMenu.add(btnHelp);
		
		
		// ---- New Game Panel ---- //
		JPanel panelNewGame = new JPanel();
		panelNewGame.setBackground(new Color(0, 102, 0));
		frame.getContentPane().add(panelNewGame, "name_98335609249571");
		panelNewGame.setLayout(null);
		
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
		textFieldSetChip.setText("100");
		textFieldSetChip.setBounds(190, 250, 200, 60);
		
		Border rounded = new LineBorder(new Color(255,204,0),2);
		Border emptySetChip = new EmptyBorder(0,0,0,20);
		
		textFieldSetChip.setBorder(rounded);
		
		textFieldSetChip.setBorder(BorderFactory.createCompoundBorder(rounded,emptySetChip));
		panelNewGame.add(textFieldSetChip);
		textFieldSetChip.setColumns(10);
		
		JButton btnSetCompUp = new JButton("▲");
		btnSetCompUp.setForeground(new Color(255, 204, 0));
		btnSetCompUp.setBounds(560, 245, 60, 50);
		btnSetCompUp.setContentAreaFilled(false);
		btnSetCompUp.setOpaque(false);
		btnSetCompUp.setBorderPainted(false);
		panelNewGame.add(btnSetCompUp);
		
		JButton btnSetCompDown = new JButton("▼");
		btnSetCompDown.setOpaque(false);
		btnSetCompDown.setForeground(new Color(255, 204, 0));
		btnSetCompDown.setContentAreaFilled(false);
		btnSetCompDown.setBorderPainted(false);
		btnSetCompDown.setBounds(560, 265, 60, 50);
		panelNewGame.add(btnSetCompDown);
		
		textFieldSetComp = new JTextField();
		textFieldSetComp.setText("0");
		textFieldSetComp.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldSetComp.setForeground(new Color(255, 204, 0));
		textFieldSetComp.setFont(new Font("Helvetica", Font.PLAIN, 26));
		textFieldSetComp.setColumns(10);
		textFieldSetComp.setBackground(new Color(0, 51, 0));
		textFieldSetComp.setBounds(410, 250, 200, 60);
		
		Border emptySetComp = new EmptyBorder(0,0,0,30);
		
		textFieldSetComp.setBorder(BorderFactory.createCompoundBorder(rounded,emptySetComp));
		panelNewGame.add(textFieldSetComp);
		
		
		
		
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setOpaque(false);
		btnStartGame.setForeground(new Color(255, 204, 0));
		btnStartGame.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnStartGame.setContentAreaFilled(false);
		btnStartGame.setBorderPainted(true);
		btnStartGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		btnStartGame.setBounds(200, 350, 180, 60);
		panelNewGame.add(btnStartGame);
		
		JButton btnGoBackNewGame = new JButton("Main Menu");
		btnGoBackNewGame.setOpaque(false);
		btnGoBackNewGame.setForeground(new Color(255, 204, 0));
		btnGoBackNewGame.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnGoBackNewGame.setBorderPainted(true);
		btnGoBackNewGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		btnGoBackNewGame.setBounds(420, 350, 180, 60);
		panelNewGame.add(btnGoBackNewGame);
		
		
		// ---- Load Game ---- //
		JPanel panelLoadGame = new JPanel();
		panelLoadGame.setBackground(new Color(0, 102, 0));
		frame.getContentPane().add(panelLoadGame, "name_98257238941273");
		panelLoadGame.setLayout(null);
		
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
		listSavedGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		
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
		btnMainMenuLoadGame.setOpaque(false);
		btnMainMenuLoadGame.setForeground(new Color(255, 204, 0));
		btnMainMenuLoadGame.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnMainMenuLoadGame.setBorderPainted(true);
		btnMainMenuLoadGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		btnMainMenuLoadGame.setBounds(420, 450, 180, 60);
		panelLoadGame.add(btnMainMenuLoadGame);
		
		
		// ---- Help Panel ---- //
		JPanel panelHelp = new JPanel();
		frame.getContentPane().add(panelHelp, "name_103674355256420");
		panelHelp.setBackground(new Color(0, 102, 0));
		panelHelp.setLayout(null);
		
		JLabel label = new JLabel("BlackJack!");
		label.setBounds(200, 50, 400, 80);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 204, 0));
		label.setFont(new Font("Helvetica", Font.ITALIC, 65));
		panelHelp.add(label);
		
		JButton btnMainMenuHelp = new JButton("Main Menu");
		btnMainMenuHelp.setOpaque(false);
		btnMainMenuHelp.setForeground(new Color(255, 204, 0));
		btnMainMenuHelp.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnMainMenuHelp.setBorderPainted(true);
		btnMainMenuHelp.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		btnMainMenuHelp.setBounds(310, 465, 180, 60);
		panelHelp.add(btnMainMenuHelp);
		
		textFieldRules = new JTextField();
		textFieldRules.setEditable(false);
		textFieldRules.setOpaque(false);
		textFieldRules.setFont(new Font("Helvetica",Font.PLAIN,26));
		textFieldRules.setForeground(new Color(255,204,0));
		textFieldRules.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		textFieldRules.setBounds(100, 130, 600, 320);
		panelHelp.add(textFieldRules);
		textFieldRules.setColumns(10);
		
		
		
		
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
