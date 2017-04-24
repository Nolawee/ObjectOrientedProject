package blackjack.view;

import java.awt.EventQueue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

public class MainMenu1 {

	private JFrame frame;
	private String rules = getRules();
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
		frame.getContentPane().setBackground(new Color(0, 100, 0));
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel blackjackTitle = new JLabel("BLACKJACK!");
		blackjackTitle.setForeground(new Color(255, 204, 0));
		blackjackTitle.setBounds(0, 85, 800, 80);
		blackjackTitle.setHorizontalAlignment(SwingConstants.CENTER);
		blackjackTitle.setFont(new Font("Lucida Grande", Font.ITALIC, 60));
		frame.getContentPane().add(blackjackTitle);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setForeground(new Color(255, 204, 0));
		btnNewGame.setFont(new Font("Helvetica", Font.PLAIN, 30));
		btnNewGame.setBounds(300, 250, 200, 50);
		btnNewGame.setOpaque(false);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 0),2));
		frame.getContentPane().add(btnNewGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setForeground(new Color(255, 204, 0));
		btnLoadGame.setFont(new Font("Helvetica", Font.PLAIN, 30));
		btnLoadGame.setBounds(200, 350, 200, 50);
		btnLoadGame.setOpaque(false);
		btnLoadGame.setContentAreaFilled(false);
		btnLoadGame.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 0),2));
		frame.getContentPane().add(btnLoadGame);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setForeground(new Color(255, 204, 0));
		btnHelp.setFont(new Font("Helvetica", Font.PLAIN, 30));
		btnHelp.setBounds(450, 350, 200, 50);
		btnHelp.setOpaque(false);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setBorderPainted(false);
		btnHelp.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 0),2));
		frame.getContentPane().add(btnHelp);
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
}
