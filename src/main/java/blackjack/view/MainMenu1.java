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

public class MainMenu1 {

	private JFrame frame;
	private JTextField textFieldSetChip;
	private JTextField textFieldSetComp;

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
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setForeground(new Color(255, 204, 0));
		btnLoadGame.setFont(new Font("Helvetica", Font.PLAIN, 26));
		btnLoadGame.setBounds(200, 360, 180, 60);
		btnLoadGame.setContentAreaFilled(false);
		btnLoadGame.setOpaque(false);
		btnLoadGame.setBorderPainted(true);
		btnLoadGame.setBorder(BorderFactory.createLineBorder(new Color(255,204,0), 2));
		panelMainMenu.add(btnLoadGame);
		
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
		
		
		
		JPanel panelLoadGame = new JPanel();
		panelLoadGame.setBackground(new Color(0, 102, 0));
		frame.getContentPane().add(panelLoadGame, "name_98257238941273");
		
		JPanel panelHelp = new JPanel();
		panelHelp.setBackground(new Color(0, 102, 0));
		frame.getContentPane().add(panelHelp, "name_98209967818217");
		
		
		
		
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
