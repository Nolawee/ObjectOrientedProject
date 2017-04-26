package blackjack.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class tableView extends JFrame {

	private JPanel panelTable;
	private JTextField textFieldPlaceBet1;
	private JTextField textFieldPlaceBet2;
	private JTextField textFieldPlaceBet3;
	private JTextField textFieldPlaceBet4;
	private int humanPosition = -1;
	private int humanBet;
	public int startChip = 100;
	public int numCompPlayers;

	private int currentChip = 100;

	public void setStartChip(int amount){
		this.startChip = amount;
	}
	
	public void setNumCompPlayer(int amount){
		this.numCompPlayers = amount;
	}
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//tableView frame = new tableView();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	/*public playing(){
		initializeTable();
		bettingPhase();
		dealPhase();
		revealPhase();
		payPhase();
	}*/

	/**
	 * Create the frame.
	 */
	public tableView() throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		panelTable = new JPanel();
		panelTable.setBackground(new Color(0, 102, 0));
		panelTable.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelTable);
		panelTable.setLayout(null);
		
		JButton btnPlaceBet1 = new JButton("BET");
		JButton btnPlaceBet2 = new JButton("BET");
		JButton btnPlaceBet3 = new JButton("BET");
		JButton btnPlaceBet4 = new JButton("BET");
		JLabel lblCurrent1 = new JLabel("");
		JLabel lblCurrent2 = new JLabel("");
		JLabel lblCurrent3 = new JLabel("");
		JLabel lblCurrent4 = new JLabel("");
		JButton btnDeal1 = new JButton("DEAL");
		JButton btnDeal2 = new JButton("DEAL");
		JButton btnDeal3 = new JButton("DEAL");
		JButton btnDeal4 = new JButton("DEAL");
		JLabel lblDealCard1 = new JLabel("");
		JLabel lblDealCard2 = new JLabel("");
		JLabel lblDealCard3 = new JLabel("");
		JLabel lblDealCard4 = new JLabel("");
		textFieldPlaceBet1 = new JTextField();
		textFieldPlaceBet2 = new JTextField();
		textFieldPlaceBet3 = new JTextField();
		textFieldPlaceBet4 = new JTextField();
		
		// --- Focusing Bet Buttons --- //
		btnPlaceBet1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlaceBet1.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlaceBet1.setForeground(new Color(255, 204, 0));
			}
		});
		btnPlaceBet2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlaceBet2.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlaceBet2.setForeground(new Color(255, 204, 0));
			}
		});
		btnPlaceBet3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlaceBet3.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlaceBet3.setForeground(new Color(255, 204, 0));
			}
		});
		btnPlaceBet4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlaceBet4.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlaceBet4.setForeground(new Color(255, 204, 0));
			}
		});
		
		
		
		// --- Select Human Position and Place Bet --- //
		
		btnPlaceBet1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlaceBet2.setVisible(false);
				btnPlaceBet3.setVisible(false);
				btnPlaceBet4.setVisible(false);
				btnPlaceBet1.setVisible(false);
				textFieldPlaceBet2.setEnabled(false);
				textFieldPlaceBet3.setEnabled(false);
				textFieldPlaceBet4.setEnabled(false);
				lblCurrent1.setText("Current: $"+String.valueOf(currentChip));
				btnDeal1.setVisible(true);
				lblDealCard1.setVisible(true);
			}
		});
		btnPlaceBet2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlaceBet1.setVisible(false);
				btnPlaceBet3.setVisible(false);
				btnPlaceBet4.setVisible(false);
				btnPlaceBet2.setVisible(false);
				textFieldPlaceBet1.setEnabled(false);
				textFieldPlaceBet3.setEnabled(false);
				textFieldPlaceBet4.setEnabled(false);
				lblCurrent2.setText("Current: $"+String.valueOf(currentChip));
				btnDeal2.setVisible(true);
				lblDealCard2.setVisible(true);
			}
		});
		btnPlaceBet3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlaceBet2.setVisible(false);
				btnPlaceBet1.setVisible(false);
				btnPlaceBet4.setVisible(false);
				btnPlaceBet3.setVisible(false);
				textFieldPlaceBet1.setEnabled(false);
				textFieldPlaceBet2.setEnabled(false);
				textFieldPlaceBet4.setEnabled(false);
				lblCurrent3.setText("Current: $"+String.valueOf(currentChip));
				btnDeal3.setVisible(true);
				lblDealCard3.setVisible(true);
			}
		});
		btnPlaceBet4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlaceBet2.setVisible(false);
				btnPlaceBet3.setVisible(false);
				btnPlaceBet1.setVisible(false);
				btnPlaceBet4.setVisible(false);
				textFieldPlaceBet1.setEnabled(false);
				textFieldPlaceBet2.setEnabled(false);
				textFieldPlaceBet3.setEnabled(false);
				lblCurrent4.setText("Current: $"+String.valueOf(currentChip));
				btnDeal4.setVisible(true);
				lblDealCard4.setVisible(true);
			}
		});
		
		// --- DEAL ----//

		lblDealCard1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//deal!
				humanBet = Integer.parseInt(textFieldPlaceBet1.getText());
				btnDeal1.setVisible(false);
				lblDealCard1.setVisible(false);
				textFieldPlaceBet1.setText(String.valueOf(humanBet));
				textFieldPlaceBet1.setEditable(false);
				//Table.deal
			}
		});
		lblDealCard2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//deal!
				humanBet = Integer.parseInt(textFieldPlaceBet2.getText());
				btnDeal2.setVisible(false);
				lblDealCard2.setVisible(false);
				textFieldPlaceBet2.setText(String.valueOf(humanBet));
				textFieldPlaceBet2.setEditable(false);
				//Table.deal
			}
		});
		lblDealCard3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//deal!
				humanBet = Integer.parseInt(textFieldPlaceBet3.getText());
				btnDeal3.setVisible(false);
				lblDealCard3.setVisible(false);
				textFieldPlaceBet3.setText(String.valueOf(humanBet));
				textFieldPlaceBet3.setEditable(false);
				//Table.deal
			}
		});
		lblDealCard4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//deal!
				humanBet = Integer.parseInt(textFieldPlaceBet4.getText());
				btnDeal4.setVisible(false);
				lblDealCard4.setVisible(false);
				textFieldPlaceBet4.setText(String.valueOf(humanBet));
				textFieldPlaceBet4.setEditable(false);
				//Table.deal
			}
		});
		
		
		
		
		
		lblCurrent1.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lblCurrent1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrent1.setForeground(new Color(255, 204, 0));
		lblCurrent1.setBounds(35, 360, 115, 20);
		panelTable.add(lblCurrent1);
		
		
		btnDeal1.setForeground(new Color(255, 204, 0));
		btnDeal1.setBounds(120, 465, 40, 20);
		btnDeal1.setContentAreaFilled(false);
		btnDeal1.setOpaque(false);
		btnDeal1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnDeal1.setVisible(false);
		panelTable.add(btnDeal1);
		
		
		lblDealCard1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDealCard1.setIcon(new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/backCard.png"));
		lblDealCard1.setBounds(125, 420, 30, 45);
		lblDealCard1.setVisible(false);
		panelTable.add(lblDealCard1);
		
		btnPlaceBet1.setForeground(new Color(255, 204, 0));
		btnPlaceBet1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btnPlaceBet1.setBounds(40, 380, 80, 80);
		btnPlaceBet1.setContentAreaFilled(false);
		btnPlaceBet1.setOpaque(false);
		btnPlaceBet1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelTable.add(btnPlaceBet1);
		
		
		textFieldPlaceBet1.setForeground(new Color(255, 204, 0));
		textFieldPlaceBet1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlaceBet1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		textFieldPlaceBet1.setBounds(40, 380, 80, 80);
		textFieldPlaceBet1.setOpaque(false);
		textFieldPlaceBet1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelTable.add(textFieldPlaceBet1);
		textFieldPlaceBet1.setColumns(10);
		
		
		lblCurrent2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrent2.setForeground(new Color(255, 204, 0));
		lblCurrent2.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lblCurrent2.setBounds(235, 450, 115, 20);
		panelTable.add(lblCurrent2);
		
		
		btnDeal2.setOpaque(false);
		btnDeal2.setForeground(new Color(255, 204, 0));
		btnDeal2.setContentAreaFilled(false);
		btnDeal2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnDeal2.setBounds(320, 542, 40, 20);
		btnDeal2.setVisible(false);
		panelTable.add(btnDeal2);
		
		
		lblDealCard2.setIcon(new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/backCard.png"));
		lblDealCard2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDealCard2.setBounds(325, 500, 30, 45);
		lblDealCard2.setVisible(false);
		panelTable.add(lblDealCard2);
		
		
		btnPlaceBet2.setOpaque(false);
		btnPlaceBet2.setForeground(new Color(255, 204, 0));
		btnPlaceBet2.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btnPlaceBet2.setContentAreaFilled(false);
		btnPlaceBet2.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPlaceBet2.setBounds(240, 470, 80, 80);
		panelTable.add(btnPlaceBet2);
		
		textFieldPlaceBet2.setOpaque(false);
		textFieldPlaceBet2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlaceBet2.setForeground(new Color(255, 204, 0));
		textFieldPlaceBet2.setFont(new Font("Helvetica", Font.PLAIN, 20));
		textFieldPlaceBet2.setColumns(10);
		textFieldPlaceBet2.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFieldPlaceBet2.setBounds(240, 470, 80, 80);
		panelTable.add(textFieldPlaceBet2);
		
		
		lblCurrent3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrent3.setForeground(new Color(255, 204, 0));
		lblCurrent3.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lblCurrent3.setBounds(470, 450, 115, 20);
		panelTable.add(lblCurrent3);
		
		
		btnDeal3.setOpaque(false);
		btnDeal3.setForeground(new Color(255, 204, 0));
		btnDeal3.setContentAreaFilled(false);
		btnDeal3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnDeal3.setBounds(435, 542, 40, 20);
		btnDeal3.setVisible(false);
		panelTable.add(btnDeal3);
		
		
		lblDealCard3.setIcon(new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/backCard.png"));
		lblDealCard3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDealCard3.setBounds(440, 500, 30, 45);
		lblDealCard3.setVisible(false);
		panelTable.add(lblDealCard3);
		
		
		btnPlaceBet3.setOpaque(false);
		btnPlaceBet3.setForeground(new Color(255, 204, 0));
		btnPlaceBet3.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btnPlaceBet3.setContentAreaFilled(false);
		btnPlaceBet3.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPlaceBet3.setBounds(475, 470, 80, 80);
		panelTable.add(btnPlaceBet3);
		
		textFieldPlaceBet3.setOpaque(false);
		textFieldPlaceBet3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlaceBet3.setForeground(new Color(255, 204, 0));
		textFieldPlaceBet3.setFont(new Font("Helvetica", Font.PLAIN, 20));
		textFieldPlaceBet3.setColumns(10);
		textFieldPlaceBet3.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFieldPlaceBet3.setBounds(475, 470, 80, 80);
		panelTable.add(textFieldPlaceBet3);
		
		
		lblCurrent4.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrent4.setForeground(new Color(255, 204, 0));
		lblCurrent4.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lblCurrent4.setBounds(680, 360, 115, 20);
		panelTable.add(lblCurrent4);
		
		
		btnDeal4.setOpaque(false);
		btnDeal4.setForeground(new Color(255, 204, 0));
		btnDeal4.setContentAreaFilled(false);
		btnDeal4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnDeal4.setBounds(645, 465, 40, 20);
		btnDeal4.setVisible(false);
		panelTable.add(btnDeal4);
		
		
		lblDealCard4.setIcon(new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/backCard.png"));
		lblDealCard4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDealCard4.setBounds(650, 420, 30, 45);
		lblDealCard4.setVisible(false);
		panelTable.add(lblDealCard4);
		
		btnPlaceBet4.setOpaque(false);
		btnPlaceBet4.setForeground(new Color(255, 204, 0));
		btnPlaceBet4.setFont(new Font("Helvetica", Font.PLAIN, 20));
		btnPlaceBet4.setContentAreaFilled(false);
		btnPlaceBet4.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPlaceBet4.setBounds(685, 380, 80, 80);
		panelTable.add(btnPlaceBet4);

		textFieldPlaceBet4.setOpaque(false);
		textFieldPlaceBet4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlaceBet4.setForeground(new Color(255, 204, 0));
		textFieldPlaceBet4.setFont(new Font("Helvetica", Font.PLAIN, 20));
		textFieldPlaceBet4.setColumns(10);
		textFieldPlaceBet4.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFieldPlaceBet4.setBounds(685, 380, 80, 80);
		panelTable.add(textFieldPlaceBet4);
		
		JLabel lblBackgroundImg = new JLabel("");
		lblBackgroundImg.setIcon(new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/tableBG.jpg"));
		lblBackgroundImg.setBounds(0, 0, 800, 600);
		panelTable.add(lblBackgroundImg);
		
		
	}
	
	private int setHumanPosition(String buttonName){
		switch(buttonName){
		case "btnPlaceBet1":
			humanPosition = 0;
		case "btnPlaceBet2":
			humanPosition = 1;
		case "btnPlaceBet3":
			humanPosition = 2;
		case "btnPlaceBet4":
			humanPosition = 3;
		}
		
		return humanPosition;
	}
}
