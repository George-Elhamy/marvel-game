package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChooseView extends JFrame  {
	
		private JPanel Champion;
		private JTextArea Prop;
		private JLabel background;
		
	public ChooseView (){

		setIconImage(Toolkit.getDefaultToolkit().getImage("marvel images/icon2.png"));
		setTitle("Avengers End Game");
		
			
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(screenSize.width, screenSize.height-40);
		Champion =new JPanel();
		
		Champion.setLayout(new GridLayout(0,5,15,15));
		this.setLayout(null);
		Champion.setBounds(318,160,900,520);
		Champion.setOpaque(false);
		
		background=new JLabel();
		background.setLayout(null);
		
		background.setIcon(new ImageIcon("images/Gaming0_generated.jpg"));
		background.setBounds(0, 0, 1536, 824);
		this.add(background);
		Champion.setBackground(Color.BLACK);
		background.add(Champion);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Prop= new JTextArea();
		
		Prop.setBounds(150,40,1300,160);
		Prop.setOpaque(false);
		
		Prop.setEditable(false);
		Prop.setText("                         Champion ");
		Prop.setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 22));
		Prop.setForeground(Color.WHITE);
		
		background.add(Prop);
				
		
	    this.invalidate();
	    this.repaint();
	    
	}



	public JPanel getChampion() {
		return Champion;
	}


	public void setChampion(JPanel champion) {
		Champion = champion;
	}


	public JTextArea getProp() {
		return Prop;
	}


	public void setProp(JTextArea prop) {
		Prop = prop;
	}

	}



