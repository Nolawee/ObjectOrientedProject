package blackjack.view;

import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import blackjack.model.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

@SuppressWarnings("serial")
public class playingTable extends JFrame {
	TurnManager turnManager;
	BettingPhase bettingPhase;
	DealerHandPhase dealerHandPhase;
	PlayHandPhase playHandPhase;
	SplitHandPhase splitHandPhase;
	
	
	private Point2D humanPosition;
	private ArrayList<Point2D> compPosition = new ArrayList<Point2D>();
	private final ArrayList<Point2D> playerPosition = new ArrayList<Point2D>();
	private int humanBet;
	private int humanBetPosition;
	private int startChip;
	private int currentChip;
	private int numCompPlayers;
	private int numPlayers;
	
	private Point2D dealerPosition = new Point2D.Double(350,130);
	
	Player humanPlayer;
	ArrayList<Player> players;
	Dealer dealer;
	Table table;
	
	
	// --- Font Style --- //
	Color goldColor = new Color(255,204,0);
	Font fontHel12 = new Font("Helvetica", Font.PLAIN, 12);
	Font fontHel20 = new Font("Helvetica", Font.PLAIN, 20);
	
	// --- Swing GUI Variables --- //
	JButton btnPlaceBet1 = new JButton("BET");
	JButton btnPlaceBet2 = new JButton("BET");
	JButton btnPlaceBet3 = new JButton("BET");
	JButton btnPlaceBet4 = new JButton("BET");
	ArrayList<JButton> btnPlaceBets = new ArrayList<JButton>();


	JLabel lblCurrent = new JLabel("");
	JLabel lblDealCard = new JLabel("");
	JTextField textFieldPlaceBet = new JTextField();
	
	JLabel lblBackgroundImg = new JLabel("");
	
	ArrayList<JLabel> lblCardsOnTable = new ArrayList<JLabel>();
	ArrayList<JLabel> lblPlayingOptions = new ArrayList<JLabel>();
	
	// --- Swing GUI Variables --- //
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public playingTable() throws IOException {
		// --- init objects --- //
		setPanel();
		
		
		setRoundPlaying();
		
		setBackgroundImage(lblBackgroundImg);

	}
	
	private void setRoundPlaying(){
		setBettingPhase();
		setDealingPhase();
		setPlayingHandPhase();
		//setSplitHandPhase();
	}
	
	
	private void setPanel(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(100,100,800,600);
	}
	
	private void setBackgroundImage(JLabel img){

		img.setIcon(new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/tableBackground.jpg"));
		img.setBounds(0, 0, 800, 600);
		getContentPane().add(img);
	}
	
	private void setBettingPhase(){
		setBetButtons();
		displayBetting();
	}
	
	private void setBetButtons(){
		btnPlaceBets.add(btnPlaceBet1);
		btnPlaceBets.add(btnPlaceBet2);
		btnPlaceBets.add(btnPlaceBet3);
		btnPlaceBets.add(btnPlaceBet4);
	}
	
	private void displayBetting(){
		int X = 0;
		int Y = 0;
		Point2D btnPosition= new Point2D.Double(0, 0);
		btnPosition = getSeatPosition(0);
		for(int i=0; i<4;i++){
			btnPosition = getSeatPosition(i);
			X = (int)btnPosition.getX();
			Y = (int)btnPosition.getY();
			btnPlaceBets.get(i).setForeground(goldColor);
			btnPlaceBets.get(i).setFont(fontHel20);
			btnPlaceBets.get(i).setBounds(X, Y, 80, 80);
			btnPlaceBets.get(i).setContentAreaFilled(false);
			btnPlaceBets.get(i).setOpaque(false);
			btnPlaceBets.get(i).setBorder(new EmptyBorder(0, 0, 0, 0));
			getContentPane().add(btnPlaceBets.get(i));
			// Place BET
			
			actionListenerBet(btnPlaceBets.get(i),X,Y);
		
		}
	}
	
	private void actionListenerBet(JButton btnBet,int X,int Y){
		btnBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<4; i++){
					btnPlaceBets.get(i).setVisible(false);
					if(btnPlaceBets.get(i) == btnBet){
						humanBetPosition = i;
					}
				}
				getContentPane().remove(lblBackgroundImg);
				
				textFieldPlaceBet.setForeground(goldColor);
				textFieldPlaceBet.setHorizontalAlignment(SwingConstants.CENTER);
				textFieldPlaceBet.setFont(fontHel20);
				textFieldPlaceBet.setBounds(X, Y, 80, 80);
				textFieldPlaceBet.setOpaque(false);
				textFieldPlaceBet.setBorder(new EmptyBorder(0, 0, 0, 0));
				textFieldPlaceBet.setText("5");
				textFieldPlaceBet.setEnabled(true);
				getContentPane().add(textFieldPlaceBet);
				textFieldPlaceBet.setColumns(10);
				
				lblCurrent.setFont(fontHel12);
				lblCurrent.setHorizontalAlignment(SwingConstants.LEFT);
				lblCurrent.setForeground(goldColor);
				lblCurrent.setBounds(X-5, Y-20, 115, 20);
				lblCurrent.setText("Current: $"+String.valueOf(currentChip));
				getContentPane().add(lblCurrent);
				
				
				//lblDealCard.setVisible(true);
				Point2D betPos = getSeatPosition(humanBetPosition);
				betPos.setLocation(X, Y);
				displayDealCardOption(betPos);
				getContentPane().add(lblBackgroundImg);
			}
		});
		btnBet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBet.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBet.setForeground(new Color(255, 204, 0));
			}
		});
	}
	
	private void actionListenerDeal(){
		lblDealCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//deal!
				setHumanBet(textFieldPlaceBet.getText());
				if(humanBet >= 5){
					lblDealCard.setVisible(false);
					textFieldPlaceBet.setEditable(false);
					textFieldPlaceBet.setText("$ "+String.valueOf(humanBet));
					getContentPane().remove(lblDealCard);
					lblCurrent.setVisible(false);
					getContentPane().requestFocus();
					updateChip(-humanBet);
				} else {
					JOptionPane.showMessageDialog(getContentPane(),"Betting minimum $5","Inane warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	
	
	
	private void setDealingPhase(){
		// ActionListener for Deal
		actionListenerDeal();
		displayDealCards();
		for(int i=0; i< lblCardsOnTable.size();i++){
			actionListenerRevealCard(lblCardsOnTable.get(i));
		}
		
	}
	
	private void setPlayingHandPhase(){
		if(humanPlayer.isPlaying()){
			displayPlayingOptions(); //human playing option
			actionListenerPlayingHand();
		}
	}
	
	/*
	private void setSplitHandPhase(){
		
	}*/
	
	private void setPayingPhase(){
		displayRoundResult();
	}
	
	
	
	private void displayDealCards(){
		for(int i=0; i < playerPosition.size(); i++){
			displayCardsInHand(playerPosition.get(i),players.get(i),false);
		}
		displayCardsInHand(dealerPosition,dealer,true);
	}
	
	private void actionListenerRevealCard(JLabel lblCardOnTable){
		lblCardOnTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCardOnTable.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCardOnTable.setForeground(new Color(255, 204, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e){
				revealCard();
			}
		});
		
	}
	
	private void revealCard(){
		for(int i=0; i < playerPosition.size(); i++){
			displayCardsInHand(playerPosition.get(i),players.get(i),true);
		}
		displayCardsInHand(dealerPosition,dealer,true);
	}
	
	private void actionListenerPlayingHand(){
		for(int i=0 ; i< lblPlayingOptions.size();i++){
			JLabel option = lblPlayingOptions.get(i);
			option.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					option.setForeground(new Color(0, 0, 0));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					option.setForeground(new Color(255, 204, 0));
				}
				@Override
				public void mouseClicked(MouseEvent e){
					switch(option.getName()){
					case "lblDealCard":
						//call deal card and reveal it
						revealCard();
						break;
					case "lblSplit":
						break;
					case "Stand":
						setPayingPhase();
						break;
					}
				}
			});
			
		}
	}
	
	private void displayRoundResult(){
		//just display human result
		JLabel result = new JLabel();
		
	}
	
	private void setPosition(int pos,Point2D player){
		switch(pos){
		case 0:
			player.setLocation(40,380);
			break;
		case 1:
			player.setLocation(240,470);
			break;
		case 2:
			player.setLocation(475,470);
			break;
		case 3:
			player.setLocation(685,380);
			break;
		}
	}
	
	public void setHumanPosition(int pos, Point2D player){
		setPosition(pos,humanPosition);
	}
	
	public int getSeatNum(Point2D player){
		int seat = -1;
		int playerSeatX = (int) player.getX();
		switch(playerSeatX){
		case 40:
			seat = 0;
			break;
		case 240:
			seat = 1;
			break;
		case 475:
			seat = 2;
			break;
		case 685:
			seat = 3;
			break;
		default:
			System.out.println("Player has wrong location.");
			return -1;
		}
		return seat;
	}
	
	private Point2D getSeatPosition(int pos){
		Point2D temp = new Point2D.Double(0,0);
		switch(pos){
		case 0:
			temp.setLocation(40,380);
			break;
		case 1:
			temp.setLocation(240,470);
			break;
		case 2:
			temp.setLocation(475,470);
			break;
		case 3:
			temp.setLocation(685,380);
			break;
		}
		return temp;
	}
	
	private void setCompPosition(Point2D human, ArrayList<Point2D> comp){
		int humanSeat = getSeatNum(human);
		Point2D tempLocation = new Point2D.Double(0,0);
		int comPlayers = 0;
		int seating = 0;
		while(comPlayers < numCompPlayers){
			switch(seating){
				case 0:
					if(humanSeat == 0){
						break;
					} else {
						tempLocation.setLocation(40,380);
						comp.add(tempLocation);
						comPlayers++;
					}
					break;
				case 1:
					if(humanSeat == 1){
						break;
					} else {
						tempLocation.setLocation(40,380);
						comp.add(tempLocation);
						comPlayers++;
					}
					break;
				case 2:
					if(humanSeat == 2){
						break;
					} else {
						tempLocation.setLocation(40,380);
						comp.add(tempLocation);
						comPlayers++;
					}
					break;
				case 3:
					if(humanSeat == 3){
						break;
					} else {
						tempLocation.setLocation(40,380);
						comp.add(tempLocation);
						comPlayers++;
					}
					break;
			}
			seating++;
		}		
	}
	
	public void setPlayerPosition(List<Point2D> playerPosition){
		playerPosition.add(humanPosition);
		setCompPosition(humanPosition,compPosition);
		playerPosition.addAll(compPosition);
		
	}
	
	@SuppressWarnings("null")
	public Point2D cardInHandPosition(Point2D player){
		Point2D temp = null;
		int tempX = (int) temp.getX();
		int tempY = (int) temp.getY();
		temp.setLocation(tempX-30, tempY-40);
		return temp;
	}
	
	
	
	private void displayCardsInHand(Point2D player,Player players,boolean isFaceUp){
		JLabel checkCard = new JLabel();
		Point2D cardLoc = player;
		ArrayList<Card> cardsInHand = players.getHand();
		for(int i=0; i<cardsInHand.size();i++){
			Card card = cardsInHand.get(i);
			cardLoc = cardInHandPosition(cardLoc);
			int X = (int)cardLoc.getX()+i*15;
			int Y = (int)cardLoc.getY();
			
			if(isFaceUp){ // reveal card
				String imagePath = getCardImage(card);
				ImageIcon img = new ImageIcon(imagePath);
				checkCard.setHorizontalAlignment(SwingConstants.CENTER);
				checkCard.setIcon(img);
				checkCard.setBounds(X, Y, 30, 45);
				checkCard.setVisible(true);
				//getContentPane().add(checkCard);
			} else {
				ImageIcon img = new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/backCard.png");
				checkCard.setHorizontalAlignment(SwingConstants.CENTER);
				checkCard.setIcon(img);
				checkCard.setBounds(X, Y, 30, 45);
				checkCard.setVisible(true);
				getContentPane().add(checkCard);
			}
			lblCardsOnTable.add(checkCard);
		}
	}
	
	private void displayDealCardOption(Point2D player){
		//JLabel option = new JLabel();
		int X = (int)player.getX();
		int Y = (int)player.getY();
		int seat = getSeatNum(player);
		int lblDealX = 0;
		int lblDealY = 0;
			switch(seat){
			case 0:
				lblDealX = X+80;
				lblDealY = Y+50;
				break;
			case 1:
				lblDealX = X+85;
				lblDealY = Y+35;
				break;
			case 2:
				lblDealX = X-35;
				lblDealY = Y+35;
				break;
			case 3:
				lblDealX = X-30;
				lblDealY = Y+50;
				break;
			}
			
			ImageIcon img = new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/backCard.png");
			lblDealCard.setIcon(img);
			lblDealCard.setBounds(lblDealX, lblDealY, 30, 45);
			lblDealCard.setHorizontalAlignment(SwingConstants.CENTER);
			lblDealCard.setOpaque(false);
			lblDealCard.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
			lblDealCard.setVisible(true);
			getContentPane().add(lblDealCard);
	}
	
	private void displayPlayingOptions(){
		JLabel option = new JLabel();
		int X = (int)humanPosition.getX();
		int Y = (int)humanPosition.getY();
		int seat = humanBetPosition;
		int lblDealX = 0;
		int lblDealY = 0;
		int lblSplitX = 0;
		int lblSplitY = 0;
		int lblStandX = 0;
		int lblStandY = 0;
		ImageIcon img = new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/backCard.png");
		JLabel lblDealCard = new JLabel();
		JLabel lblSplit = new JLabel();
		JLabel lblStand = new JLabel();
		
		lblPlayingOptions.add(lblDealCard);
		lblPlayingOptions.add(lblSplit);
		lblPlayingOptions.add(lblStand);
		
		for(int i=0; i< lblPlayingOptions.size();i++){
			option = lblPlayingOptions.get(i);
			switch(seat){
				case 0:
					lblDealX = X+80;
					lblDealY = Y+50;
					lblSplitX = X+80;
					lblSplitY = Y+20;
					lblStandX = X-30;
					lblStandY = Y+10;
					break;
				case 1:
					lblDealX = X+80;
					lblDealY = Y+45;
					lblSplitX = X+80;
					lblSplitY = Y+20;
					lblStandX = X-30;
					lblStandY = Y+10;
					break;
				case 2:
					lblDealX = X-30;
					lblDealY = Y+45;
					lblSplitX = X-30;
					lblSplitY = Y+20;
					lblStandX = X+80;
					lblStandY = Y+10;
					break;
				case 3:
					lblDealX = X-30;
					lblDealY = Y+50;
					lblSplitX = X-30;
					lblSplitY = Y+20;
					lblStandX = X+80;
					lblStandY = Y+10;
					break;
			}
			switch(option.getName()){
			case "lblDealCard":
				option.setForeground(new Color(255, 204, 0));
				option.setIcon(img);
				option.setBounds(lblDealX, lblDealY, 30, 45);
				option.setHorizontalAlignment(SwingConstants.CENTER);
				option.setOpaque(false);
				option.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
				option.setVisible(true);
				getContentPane().add(option);
				break;
			case "lblSplit":
				option.setForeground(new Color(255, 204, 0));
				option.setBounds(lblSplitX, lblSplitY, 40, 20);
				option.setText("SPLIT");
				option.setOpaque(false);
				option.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
				option.setVisible(true);
				getContentPane().add(option);
				break;
			case "lblStand":
				option.setForeground(new Color(255, 204, 0));
				option.setBounds(lblStandX, lblStandY, 40, 20);
				option.setText("STAND");
				option.setOpaque(false);
				option.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
				option.setVisible(true);
				getContentPane().add(option);
				break;
			}
		}
		
	}
	
	private void setHumanBet(String amount){
		humanBet = Integer.parseInt(amount);

	}
	
	public void setStartChip(int amount){
		//humanPlayer.setChip(amount);
	}
	
	// --- function for testing GUI ---//
	
	public String getCardImage(Card card){
		String image = card.getNumber()+"_of_"+card.getSuit()+"s.png";
		String root = "/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/";
		String imagePath = root+image;
		
		return imagePath;
	}
	
	public void setCurrentChip(int amount){
		currentChip = amount;
	}
	
	
	public void updateChip(int amount){
		currentChip += amount;
	}
	
	public int getNumCards(){
		int numCards = 2;
		
		return numCards;
	}

	public void setNumCompPlayer(int compPlayerEntered) {
		numCompPlayers = compPlayerEntered;
		
	}
}
