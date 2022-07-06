package views;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class NameView extends JFrame  {

	private JButton next;
	private JTextArea Player1;
	private JTextArea SubTitle1;
	private JTextArea Player2;
	private JTextArea SubTitle2;
	private JLabel background;

	
	
	
	
	public NameView() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("marvel images/icon2.png"));
		setTitle("Avengers End Game");
			
		
		
		Player1 = new JTextArea("Enter Player's 1 Name...");
		//Player1.setText("Enter Player's 1 Name...");
		Player1.setEditable(true);
		Player2 = new JTextArea("Enter Player's 2 Name...");
		Player1.setOpaque(false);
		Player2.setOpaque(false);
		//Player2.setText("Enter Player's 2 Name...");
		Player1.setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 20));
		Player2.setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 20));
//		Player1.setVerticalAlignment(SwingConstants.CENTER);
//		Player2.setVerticalAlignment(SwingConstants.CENTER);
		Player1.setBounds(600, 555, 250, 40);
		Player2.setBounds(600, 655, 250, 40);
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.YELLOW);
		SubTitle1 = new JTextArea("Player One:");
		SubTitle1.setFont(new Font("HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 30));
		
		SubTitle2 = new JTextArea("Player Two:");
		SubTitle2.setFont(new Font("HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 30));
		SubTitle1.setEnabled(false);
		SubTitle2.setEnabled(false);
		SubTitle1.setBounds(400, 550, 180, 80);
		SubTitle2.setBounds(400, 650, 180, 80);
		SubTitle1.setOpaque(false);
		SubTitle2.setOpaque(false);
		SubTitle1.setSelectedTextColor(Color.BLACK);
		//SubTitle1.setBackground(Color.MAGENTA);
		//SubTitle2.setBackground(Color.MAGENTA);
		
//		
//		next = new JButton("Start Game");
//		next.setHorizontalAlignment(SwingConstants.CENTER);
//		next.setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 20));
//		next.setBounds((int)(0.43*this.getWidth()),(int) (0.58*this.getHeight()), 200, 100);
//		next.setBackground(Color.WHITE);
//		next.setUI(new StyledButtonUI());
		
		background=new JLabel();
		background.setIcon(new ImageIcon("marvel images/avengers.jpg"));
		background.setBounds(0, 0, 1536, 824);
		this.add(background);

		next = new JButton("Next");
		next.setFont(new Font("AVENGEANCE HEROIC AVENGER", Font.BOLD , 30));
		next.setBounds(1300, 670, 200, 80);
		next.setBackground(Color.WHITE);
		next.setUI(new StyledButtonUI());
		
		background.add(Player1, BorderLayout.EAST);
		background.add(SubTitle1, BorderLayout.EAST);
		background.add(SubTitle2, BorderLayout.EAST);
		background.add(Player2, BorderLayout.EAST);
		background.add(next, BorderLayout.EAST);

		panel2.setBackground(Color.GRAY);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height-40);
//        System.out.println(this.getWidth() + "  " +this.getHeight());
		add(panel2, BorderLayout.CENTER);
		setBackground(Color.CYAN);

		//this.setSize(1550,875);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public JButton getNext() {
		return next;
	}

	public JTextArea getPlayer1() {
		return Player1;
	}

	public JTextArea getSubTitle1() {
		return SubTitle1;
	}

	public JTextArea getPlayer2() {
		return Player2;
	}

	public JTextArea getSubTitle2() {
		return SubTitle2;
	}
	


}
