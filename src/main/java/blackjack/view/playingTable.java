package blackjack.view;

import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import blackjack.model.*;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.geom.Point2D;

@SuppressWarnings("serial")
public class playingTable extends JPanel {
	private HumanPlayer humanPlayer;
	private ComputerPlayer computerPlayer;
	private Dealer dealer;
	private Deck deck;
	private Card[] cards;
	private Chips chips;
	private Table table;
	private State state;
	private TurnManager turnManager;
	private BettingPhase bettingPhase;
	private DealerHandPhase dealerHandPhase;
	private PlayHandPhase playHandPhase;
	private SplitHandPhase splitHandPhase;
	
	
	private Point2D humanPosition;
	private ArrayList<Point2D> compPosition = new ArrayList<Point2D>();
	private final ArrayList<Point2D> playerPosition = new ArrayList<Point2D>();
	private int humanBet;
	private int startChip;
	private int currentChip;
	private int numCompPlayers;
	private int numPlayers;
	
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public playingTable() throws IOException {
		// --- init objects --- //
		JLabel lblBackgroundImg = new JLabel("");
		setPanel();
		setBackgroundImage(lblBackgroundImg);
		
		setRoundPlaying();
		

	}
	
	private void setRoundPlaying(){
		setBettingPhase();
		setDealingPhase();
		setPlayingHandPhase();
		setSplitHandPhase();
		setPayingPhase();
	}
	
	
	private void setPanel(){
		setLayout(null);
		setBounds(100,100,800,600);
	}
	
	private void setBackgroundImage(JLabel img){
		img.setIcon(new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/tableBG.jpg"));
		img.setBounds(0, 0, 800, 600);
		add(img);
	}
	
	private void setBettingPhase(){
		displayBetting();
	}
	
	private void setDealingPhase(){
		/* Display Dealed Cards faceDown for All Players
		*
		*displayCardsInHands();
		*
		*/
		//displayDealCards();
	}
	
	private void setPlayingHandPhase(){
		// due to actionlisteners
		// if user hit reveal cars,
		revealCard(humanPlayer);
		//revealCard()
	}
	
	private void setSplitHandPhase(){
		
	}
	
	private void setPayingPhase(){
		
	}
	
	private void displayBetting(){
		// display BET buttons
		
		// place BET
		
		// hit deal
	}
	
	
	private void displayDealCards(ArrayList<Player> player){
		//displayCardsInHand(player,false);
	}
	
	private void revealCard(Player player){
		//displayCardsInHand(player,true);
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
	
	@SuppressWarnings("null")
	private void setCompPosition(Point2D human, ArrayList<Point2D> comp){
		int humanSeat = getSeatNum(human);
		Point2D tempLocation = null;
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
	
	
	
	private void displayCardsInHand(Point2D player,ArrayList<Card> hand,ArrayList<JLabel> cardsInHand,boolean isFaceUp){
		JLabel checkCard = new JLabel();
		Point2D cardLoc = player;
		for(int i=0; i<cardsInHand.size();i++){
			checkCard = cardsInHand.get(i);
			Card card = hand.get(i);
			cardLoc = cardInHandPosition(cardLoc);
			int X = (int)cardLoc.getX()+i*15;
			int Y = (int)cardLoc.getY();
			
			if(isFaceUp){ // reveal card
				String imagePath = getCardImage(card);
				ImageIcon img = new ImageIcon(imagePath);
				checkCard.setHorizontalAlignment(SwingConstants.CENTER);
				checkCard.setIcon(img);
				checkCard.setBounds(X, Y, 30, 45);
				checkCard.setVisible(false);
				add(checkCard);
			} else {
				ImageIcon img = new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/backCard.png");
				checkCard.setHorizontalAlignment(SwingConstants.CENTER);
				checkCard.setIcon(img);
				checkCard.setBounds(X, Y, 30, 45);
				checkCard.setVisible(false);
				add(checkCard);
			}
		}
	}
	
	private void displayDealCardOption(Point2D player){
		JLabel option = new JLabel();
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
				lblDealX = X+80;
				lblDealY = Y+45;
				break;
			case 2:
				lblDealX = X-30;
				lblDealY = Y+45;
				break;
			case 3:
				lblDealX = X-30;
				lblDealY = Y+50;
				break;
			}
			ImageIcon img = new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/backCard.png");
			option.setIcon(img);
			option.setBounds(lblDealX, lblDealY, 30, 45);
			option.setHorizontalAlignment(SwingConstants.CENTER);
			option.setOpaque(false);
			option.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
			option.setVisible(true);
			add(option);
	}
	
	private void displayPlayingOptions(ArrayList<JLabel> playingOption,Point2D player){
		JLabel option = new JLabel();
		int X = (int)player.getX();
		int Y = (int)player.getY();
		int seat = getSeatNum(player);
		int lblDealX = 0;
		int lblDealY = 0;
		int lblSplitX = 0;
		int lblSplitY = 0;
		int lblStandX = 0;
		int lblStandY = 0;
		ImageIcon img = new ImageIcon("/Users/trsteve/Dropbox/SPR2017/CSCI4448/ObjectOrientedProject/src/main/java/blackjack/view/images/cards/backCard.png");
		
		for(int i=0; i< playingOption.size();i++){
			option = playingOption.get(i);
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
				add(option);
				break;
			case "lblSplit":
				option.setForeground(new Color(255, 204, 0));
				option.setBounds(lblSplitX, lblSplitY, 40, 20);
				option.setText("SPLIT");
				option.setOpaque(false);
				option.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
				option.setVisible(true);
				add(option);
				break;
			case "lblStand":
				option.setForeground(new Color(255, 204, 0));
				option.setBounds(lblStandX, lblStandY, 40, 20);
				option.setText("STAND");
				option.setOpaque(false);
				option.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
				option.setVisible(true);
				add(option);
				break;
			}
		}
		
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
}
