package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

public class StartView extends JFrame  {
	
	private JPanel panel;
	private JButton b1;
	private JLabel background;
	
	public StartView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("marvel images/icon2.png"));
		setTitle("Avengers End Game");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(screenSize.width, screenSize.height-40);
	    
		
	    panel=new JPanel();
	    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
	    
	    setLayout(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		background=new JLabel();
		background.setIcon(new ImageIcon("marvel images/13453 (1).jpg"));
		background.setBounds(0, 0, 1536, 864);
		panel.add(background);

		b1 = new JButton("Start Game");
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 20));
		b1.setBounds((int)(0.43*this.getWidth()),(int) (0.58*this.getHeight()), 200, 100);
		b1.setBackground(Color.WHITE);
		b1.setUI(new StyledButtonUI());

		background.add(b1);


        setVisible(true);
        

		this.revalidate();
		this.repaint();
		
	}

	

	public JButton getB1() {
		return b1;
	}



	public JPanel getPanel() {
		return panel;
	}


	

}
