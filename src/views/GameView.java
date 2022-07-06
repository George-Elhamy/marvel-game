package views;

import java.awt.Toolkit;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class GameView extends JFrame {
	private JPanel contentPane;
	private ArrayList<JButton> buttons= new ArrayList<JButton>();
	private JPanel upper;
	private JPanel lower;
	private JPanel left;
	private JPanel end;
	private JPanel right;
	private JPanel center;
	
	private JLabel player1;
	private JLabel champ1;
	private JLabel champ2;
	private JLabel champ3;
	
	private JLabel player2;
	private JLabel champ4;
	private JLabel champ5;
	private JLabel champ6;
	
	private JButton ability1;
	private JButton ability2;
	private JButton ability3;
	private JButton punch;
	private JButton leaderAbility;
	
	private JLabel lAbility1;
	private JLabel lAbility2;
	private JLabel lAbility3;
	private JLabel lPunch;
	private JLabel lLeaderAbility;
	
	private JLabel effects;
	
	private JButton upbtn;
	private JButton downbtn;
	private JButton leftbtn;
	private JButton rightbtn;
	private JButton endTurn;
	private JTextArea action;
	private JLabel leader1;
	private JLabel leader2;
	
	private JButton attack;
	
	private JLabel currentText;
	private JLabel currentIcon;
	private JLabel turnOrder;
	
	
	
	
	
	public GameView() {
		setVisible(false);
		setTitle("Avengers End Game");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Carol\\Downloads\\icon2.png"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(screenSize.width, screenSize.height-40);
		
	    contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		upper = new JPanel();
		upper.setBounds(0,0,this.getWidth(),(int)(0.2*this.getHeight()));
		upper.setBackground(Color.WHITE);
		contentPane.add(upper);
		invalidate();
		repaint();
		
		action = new JTextArea("");
		action.setAlignmentX(CENTER_ALIGNMENT);
		action.setAlignmentY(CENTER_ALIGNMENT);
		action.setBounds(500,30,500,120);
		action.setEditable(false);
		action.setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 40));
		action.setForeground(Color.RED);
		upper.add(action);
		
		player1=new JLabel("alooo");
		player1.setBounds(5,5,200,50);
		upper.add(player1);
		
		upper.setLayout(null);
		
		leader1 = new JLabel("<html> Leader ability <br> not used yet");
		leader1.setBackground(Color.GREEN);
		leader1.setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 13));
		leader1.setBounds(200,5,100,50);
		upper.add(leader1);
		
		leader2 = new JLabel("<html> Leader ability <br> not used yet");
		
		leader2.setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 13));
		leader2.setBounds((int)(0.8*this.getWidth()),5,100,50);
		upper.add(leader2);
		
		
		champ1=new JLabel();
		champ1.setBackground(Color.YELLOW);
		champ1.setIcon(new ImageIcon("C:\\Users\\Carol\\Downloads\\resize-1654006107261882857iron.png"));
		champ1.setBounds(0,55,110,110);
		upper.add(champ1);
		
		
		
		JButton yellow = new JButton();
		yellow.setBounds(3,55,94,5);
	    upper.add(yellow);
		yellow.setBackground(Color.YELLOW);
		
		JButton yellow2 = new JButton();
		yellow2.setBounds((int)(0.8*this.getWidth())+3,55,94,5);
	    upper.add(yellow2);
		yellow2.setBackground(Color.YELLOW);
		
		champ2=new JLabel();
		champ2.setIcon(new ImageIcon("C:\\Users\\Carol\\Downloads\\resize-1654006107261882857iron.png"));
		champ2.setBounds(100,55,100,100);
		upper.add(champ2);
		
		champ3=new JLabel();
		champ3.setIcon(new ImageIcon("C:\\Users\\Carol\\Downloads\\resize-1654006107261882857iron.png"));
		champ3.setBounds(200,55,100,100);
		upper.add(champ3);
		
		player2=new JLabel("alooo");
		player2.setBounds(1380,5,160,50);
		upper.add(player2);
		
		upper.setLayout(null);
		
		champ4=new JLabel();
		champ4.setIcon(new ImageIcon("C:\\Users\\Carol\\Downloads\\resize-1654006107261882857iron.png"));
		champ4.setBounds((int)(0.8*this.getWidth()),55,100,100);
		upper.add(champ4);
		
		champ5=new JLabel();
		champ5.setIcon(new ImageIcon("C:\\Users\\Carol\\Downloads\\resize-1654006107261882857iron.png"));
		champ5.setBounds(100+(int)(0.8*this.getWidth()),55,100,100);
		upper.add(champ5);
		
		champ6=new JLabel();
		
		champ6.setIcon(new ImageIcon("C:\\Users\\Carol\\Downloads\\resize-1654006107261882857iron.png"));
		champ6.setBounds(200+(int)(0.8*this.getWidth()),55,100,100);
		upper.add(champ6);
		
		left=new JPanel();
		left.setBounds(50,(int)(0.2*this.getHeight())+20,150,(int)(0.5*this.getHeight())-20);
		left.setBackground(Color.WHITE);
		contentPane.add(left);
		left.setLayout(new GridLayout(0, 1, 3, 5));
		
		ability1 = new JButton("Ability1");
		ability1.setUI(new StyledButtonUI());
		
		left.add(ability1);
		
		ability2 = new JButton("Ability2");
		ability2.setUI(new StyledButtonUI());
		left.add(ability2);

		
		ability3 = new JButton("Ability3");
		ability3.setUI(new StyledButtonUI());
		left.add(ability3);

		punch = new JButton("Punch");
		punch.setUI(new StyledButtonUI());
		left.add(punch);
		
		
		leaderAbility = new JButton("Leader Ability");
		leaderAbility.setUI(new StyledButtonUI());
		left.add(leaderAbility);
		
		
		
		right = new JPanel();
		right.setBounds((int)(0.8*this.getWidth()),(int)(0.2*this.getHeight()),(int)(0.2*this.getWidth()),(int)(0.25*this.getHeight()));
		right.setBackground(Color.WHITE);
		contentPane.add(right);
		
		
		effects  = new JLabel();
		effects.setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 16));
		
		effects.setBounds(1400,400,100,100);
		right.add(effects);
		
		
		endTurn = new JButton("END TURN");
		endTurn.setBounds((int)(0.8*this.getWidth())+50,(int)(0.55*this.getHeight()),200,100);
		contentPane.add(endTurn);
		endTurn.setUI(new StyledButtonUI());
		
		
		repaint();
		
		
		lower = new JPanel();
		lower.setBounds(0,(int)(0.7*this.getHeight()),450,(int)(0.23*this.getHeight()));
		lower.setBackground(Color.WHITE);
		contentPane.add(lower);
		lower.setLayout(null);
		
		currentText = new JLabel("hereee");
		
		contentPane.add(currentText);
		
		currentIcon  = new JLabel();
		
		contentPane.add(currentIcon);
		
		turnOrder  = new JLabel("hereee");
		
		contentPane.add(turnOrder);
		JPanel champions = new JPanel();
		champions.setBounds(600,(int)(0.7*this.getHeight()),this.getWidth()-450,(int)(0.3*this.getHeight())-20);
		contentPane.add(champions);
		champions.setBackground(Color.WHITE);
		champions.setLayout(new GridLayout(0, 3, 3, 3));
		champions.add(currentText);
		champions.add(currentIcon);
		champions.add(turnOrder);
	
		
		
		
		leftbtn = new JButton("left");
		leftbtn.setBounds(10,(int)(0.4*lower.getHeight()),80,30);
		lower.add(leftbtn);
		leftbtn.setUI(new StyledButtonUI());
		leftbtn.setBackground(Color.YELLOW);
		
		rightbtn = new JButton("right");
		rightbtn.setBounds(160,(int)(0.4*lower.getHeight()),80,30);
		lower.add(rightbtn);
		rightbtn.setUI(new StyledButtonUI());
		rightbtn.setBackground(Color.YELLOW);
		
		upbtn = new JButton("up");
		upbtn.setBounds(85,(int)(0.2*lower.getHeight()),80,30);
		lower.add(upbtn);
		upbtn.setUI(new StyledButtonUI());
		upbtn.setBackground(Color.YELLOW);
		
		downbtn = new JButton("down");
		downbtn.setBounds(85,(int)(0.6*lower.getHeight()),80,30);
		lower.add(downbtn);
		downbtn.setUI(new StyledButtonUI());
		downbtn.setBackground(Color.YELLOW);
		
		
		
		attack = new JButton("attack");
		attack.setUI(new StyledButtonUI());
		attack.setBounds(270,(int)(0.5*lower.getHeight()),140,50);
		lower.add(attack);
		
		
		
		
		center = new JPanel();
		center.setBounds((int)(0.2*this.getWidth()),(int)(0.2*this.getHeight()),(int)(0.6*this.getWidth()),(int)(0.5*this.getHeight()));
		center.setBackground(Color.BLACK);
		contentPane.add(center);
		center.setLayout(new GridLayout(5, 5,1,1));
		
		
		for(int i=0;i<25;i++) {
			JButton j = new JButton("");
			j.setEnabled(true);
			j.setBorderPainted(false);
			j.setBackground(Color.WHITE);
			buttons.add(j);
			center.add(j);
			invalidate();
			repaint();
		}
	}
	public JPanel getEnd() {
		return end;
	}
	public JTextArea getAction() {
		return action;
	}
	public JLabel getLeader1() {
		return leader1;
	}
	public JLabel getLeader2() {
		return leader2;
	}
	public JButton getAbility1() {
		return ability1;
	}
	public JButton getAbility2() {
		return ability2;
	}
	public JButton getAbility3() {
		return ability3;
	}
	public JButton getPunch() {
		return punch;
	}
	public JButton getLeaderAbility() {
		return leaderAbility;
	}
	public JLabel getlAbility1() {
		return lAbility1;
	}
	public JLabel getlAbility2() {
		return lAbility2;
	}
	public JLabel getlAbility3() {
		return lAbility3;
	}
	public JLabel getlPunch() {
		return lPunch;
	}
	public JLabel getlLeaderAbility() {
		return lLeaderAbility;
	}
	public JLabel getEffects() {
		return effects;
	}
	public JButton getUpbtn() {
		return upbtn;
	}
	public JButton getDownbtn() {
		return downbtn;
	}
	public JButton getLeftbtn() {
		return leftbtn;
	}
	public JButton getRightbtn() {
		return rightbtn;
	}
	public JButton getEndTurn() {
		return endTurn;
	}
	
	public JButton getAttack() {
		return attack;
	}
	public JLabel getCurrentText() {
		return currentText;
	}
	public JLabel getCurrentIcon() {
		return currentIcon;
	}
	public JLabel getTurnOrder() {
		return turnOrder;
	}
	public JLabel getPlayer1() {
		return player1;
	}
	public JLabel getPlayer2() {
		return player2;
	}
	public JLabel getChamp1() {
		return champ1;
	}
	public JLabel getChamp2() {
		return champ2;
	}
	public JLabel getChamp3() {
		return champ3;
	}
	public JLabel getChamp4() {
		return champ4;
	}
	public JLabel getChamp5() {
		return champ5;
	}
	public JLabel getChamp6() {
		return champ6;
	}
	public static void main(String[] args) {
		new GameView();
	}


	public JPanel getContentPane() {
		return contentPane;
	}


	public ArrayList<JButton> getButtons() {
		return buttons;
	}


	public JPanel getUpper() {
		return upper;
	}


	public JPanel getLower() {
		return lower;
	}


	public JPanel getLeft() {
		return left;
	}


	public JPanel getRight() {
		return right;
	}


	public JPanel getCenter() {
		return center;
	}
}