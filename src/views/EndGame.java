package views;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EndGame extends JFrame {
	private JLabel background;
	private JLabel end;
	
	public EndGame() {
		setVisible(false);
		setTitle("Avengers End Game");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Carol\\Downloads\\icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(screenSize.width, screenSize.height-40);
	    background=new JLabel();
	
	    background.setBounds(0,0,1536,824);
		background.setIcon(new ImageIcon("images/wallpaper.png"));
		setContentPane(background);
		background.setLayout(null);
		end = new JLabel("aloooooo");
		end.setBounds(500,0,600,600);
		background.add(end);
		end.setLayout(null);
		
	}
	
	public JLabel getEnd() {
		return end;
	}
	public static void main(String[] args) {
		new EndGame();
	}

}
