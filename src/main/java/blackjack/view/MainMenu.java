Last login: Fri Apr 28 10:50:01 on ttys000
engr2-1-8-189-edu:~ trsteve$ cd Dropbox/SPR2017/CSCI4448/
engr2-1-8-189-edu:CSCI4448 trsteve$ ls
012317.txt		ObjectOrientedProject
012717.txt		project-desc.pdf
engr2-1-8-189-edu:CSCI4448 trsteve$ cd OB
-bash: cd: OB: No such file or directory
engr2-1-8-189-edu:CSCI4448 trsteve$ cd ObjectOrientedProject/
engr2-1-8-189-edu:ObjectOrientedProject trsteve$ ls
03_Blackjack!_Part1.pdf			03_Polson_Shawn_Part2.pdf
03_Blackjack!_Part2.pdf			03_Tubnonghee_Theerarun_Part2.pdf
03_Blackjack!_Part3.pdf			README.md
03_Escobar_Jose_Part2.pdf		src
03_Mengist_Nolawee_Part2.pdf
engr2-1-8-189-edu:ObjectOrientedProject trsteve$ cd src/
engr2-1-8-189-edu:src trsteve$ ls
bin	main	test
engr2-1-8-189-edu:src trsteve$ cd main/java/
engr2-1-8-189-edu:java trsteve$ ls
blackjack
engr2-1-8-189-edu:java trsteve$ cd blackjack/
engr2-1-8-189-edu:blackjack trsteve$ ls
controller	model		view
engr2-1-8-189-edu:blackjack trsteve$ cd view
engr2-1-8-189-edu:view trsteve$ ls
Displayer.java		images			tableView.java
MainMenu.java		playingTable.java
engr2-1-8-189-edu:view trsteve$ vim MainMenu.java 

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

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
-- INSERT --
