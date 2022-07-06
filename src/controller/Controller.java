package controller;


import javax.sound.sampled.*;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;
import views.ChooseView;
import views.EndGame;
import views.GameView;
import views.NameView;
import views.StartView;
import views.StyledButtonUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.JOptionPane;

public class Controller implements ActionListener,MouseMotionListener {
	private Game model;
	private GameView view4;
	private StartView view1;
	private NameView view2;
	private ChooseView view3;
	private EndGame view5;
	private ArrayList<JButton> Buttons;
	private Ability abilityTemp;
	private boolean attack;
	private boolean choose=false;
	private Champion[]  champs= new Champion[6] ;
	
	
	@SuppressWarnings({ "static-access" })
	public Controller()  throws Exception {
		File font_file = new File("marvel images/AVENGEANCE HEROIC AVENGER.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
		Font sizedFont = font.deriveFont(40f);
		//Font sizedFont = font.deriveFont(12f);
		view1 = new StartView();
		view1.getB1().setFont(sizedFont);
		
		File file = new File("marvel images/The-Avengers-Theme-Song.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		clip.loop(clip.LOOP_CONTINUOUSLY);
	
		
		abilityTemp =null;
		attack =false;
		view1.getB1().addActionListener(this);
		view2= new NameView();
		view2.getNext().addActionListener(this);
		view3 =new ChooseView();
		Player one =new  Player((String)view2.getPlayer1().getText());
		Player two =new Player((String)view2.getPlayer2().getText());
		
		view5 = new EndGame();
		model=new Game(one,two);
		model.loadAbilities("src/Abilities.csv");
		model.loadChampions("src/Champions.csv");
		Buttons= new ArrayList<JButton>();
		placeChooseIcons();
		view4= new GameView();
	   view4.getChamp1().addMouseMotionListener(this);
	   view4.getAbility1().addMouseMotionListener(this);
	   view4.getAbility2().addMouseMotionListener(this);
	   view4.getAbility3().addMouseMotionListener(this);
	   
	   view4.getChamp1().addMouseMotionListener(this);
	   view4.getChamp2().addMouseMotionListener(this);
	   view4.getChamp3().addMouseMotionListener(this);
	   view4.getChamp4().addMouseMotionListener(this);
	   view4.getChamp5().addMouseMotionListener(this);
	   view4.getChamp6().addMouseMotionListener(this);
	   
	   
	   view4.getUpbtn().addActionListener(this);
	   view4.getLeftbtn().addActionListener(this);
	   view4.getRightbtn().addActionListener(this);
	   view4.getDownbtn().addActionListener(this);
	   view4.getAttack().addActionListener(this);
	   view4.getAbility1().addActionListener(this);
	   view4.getAbility2().addActionListener(this);
	   view4.getAbility3().addActionListener(this);
	   view4.getLeaderAbility().addActionListener(this);
	   view4.getPunch().addActionListener(this);
	   view4.getEndTurn().addActionListener(this);
	   for(int i=0; i<model.getAvailableChampions().size();i++){
			Buttons.get(i).addMouseMotionListener(this);}
	   for(int i=0;i<view4.getButtons().size();i++) {
		   view4.getButtons().get(i).addMouseMotionListener(this);
		   view4.getButtons().get(i).addActionListener(this);
		   
	   }
	}
	@SuppressWarnings("static-access")
	public void placeChooseIcons() {
		for(int i=0;i<model.getAvailableChampions().size();i++) {
			switch(model.getAvailableChampions().get(i).getName()) {
			case "Captain America" :
			   JButton b =new JButton();
				b.addActionListener(this);
				Buttons.add(b);
				b.setIcon(new ImageIcon("images/captain.png"));
				b.setBackground(Color.WHITE);
				b.setUI(new StyledButtonUI());
				view3.getChampion().add(b);
		        break;
			case "Deadpool":
				JButton c =new JButton();
				c.addActionListener(this);
				Buttons.add(c);
				c.setIcon(new ImageIcon("images/deadpool.png"));
				view3.getChampion().add(c);
				c.setBackground(Color.WHITE);
				c.setUI(new StyledButtonUI());
		        break;
			case "Dr Strange":
				JButton d =new JButton();
				d.addActionListener(this);
				Buttons.add(d);
				d.setIcon(new ImageIcon("images/strange.png"));
				view3.getChampion().add(d);
				d.setBackground(Color.WHITE);
				d.setUI(new StyledButtonUI());
		        break;
			case "Electro":
				JButton e =new JButton();
				e.addActionListener(this);
				Buttons.add(e);
				e.setIcon(new ImageIcon("images/electro.png"));
				view3.getChampion().add(e);
				
				e.setBackground(Color.WHITE);
				e.setUI(new StyledButtonUI());
		        break;
			case "Ghost Rider":
				JButton f =new JButton();
				f.addActionListener(this);
				Buttons.add(f);
				f.setIcon(new ImageIcon("images/ghost.png"));
				view3.getChampion().add(f);
				f.setBackground(Color.WHITE);
				f.setUI(new StyledButtonUI());
		        break;
			case "Hela":
				JButton g =new JButton();
				g.addActionListener(this);
				Buttons.add(g);
				g.setIcon(new ImageIcon("images/hela.png"));
				view3.getChampion().add(g);
				g.setBackground(Color.WHITE);
				g.setUI(new StyledButtonUI());
		        break;
			case "Hulk":
				JButton h =new JButton();
				h.addActionListener(this);
				Buttons.add(h);
				h.setIcon(new ImageIcon("images/hulk.png"));
				view3.getChampion().add(h);
				h.setBackground(Color.WHITE);
				h.setUI(new StyledButtonUI());
		        break;
			case "Iceman":
				JButton j =new JButton();
				j.addActionListener(this);
				Buttons.add(j);
				j.setIcon(new ImageIcon("images/iceman.png"));
				view3.getChampion().add(j);
				j.setBackground(Color.WHITE);
				j.setUI(new StyledButtonUI());
		        break;
			case "Ironman":
				JButton k =new JButton();
				k.addActionListener(this);
				Buttons.add(k);
				k.setIcon(new ImageIcon("images/iron.png"));
				view3.getChampion().add(k);
				k.setBackground(Color.WHITE);
				k.setUI(new StyledButtonUI());
		        break;
			case "Loki":
				JButton l =new JButton();
				l.addActionListener(this);
				Buttons.add(l);
				l.setIcon(new ImageIcon("images/loki.png"));
				view3.getChampion().add(l);
				l.setBackground(Color.WHITE);
				l.setUI(new StyledButtonUI());
		        break;
			case "Quicksilver":
				JButton m =new JButton();
				m.addActionListener(this);
				Buttons.add(m);
				m.setIcon(new ImageIcon("images/quick.png"));
				view3.getChampion().add(m);
				m.setBackground(Color.WHITE);
				m.setUI(new StyledButtonUI());
		        break;
			case "Spiderman":
				JButton n =new JButton();
				n.addActionListener(this);
				Buttons.add(n);
				n.setIcon(new ImageIcon("images/spider.png"));
				view3.getChampion().add(n);
				n.setBackground(Color.WHITE);
				n.setUI(new StyledButtonUI());
		        break;
			case "Thor":
				JButton p =new JButton();
				p.addActionListener(this);
				Buttons.add(p);
				p.setIcon(new ImageIcon("images/thor.png"));
				view3.getChampion().add(p);
				p.setBackground(Color.WHITE);
				p.setUI(new StyledButtonUI());
		        break;
			case "Venom":
				JButton q =new JButton();
				q.addActionListener(this);
				Buttons.add(q);
				q.setIcon(new ImageIcon("images/venom.png"));
				view3.getChampion().add(q);
				q.setBackground(Color.WHITE);
				q.setUI(new StyledButtonUI());
				q.setUI(new StyledButtonUI());
		        break;
			case "Yellow Jacket":
				JButton z =new JButton();
				z.addActionListener(this);
				Buttons.add(z);
				z.setIcon(new ImageIcon("images/yellow.png"));
				view3.getChampion().add(z);
				z.setBackground(Color.WHITE);
				z.setUI(new StyledButtonUI());
				z.setUI(new StyledButtonUI());
		        break;
		 	}
			//b.setUI(new StyledButtonUI());
			
			
			}
			
	}
	public static void main(String[] args) throws Exception {
		 new Controller();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton j = (JButton) e.getSource();
		
		if (abilityTemp!=null && abilityTemp.getCastArea()==AreaOfEffect.SINGLETARGET) {
			int r=view4.getButtons().indexOf(j);
			int c=0;
			int i=0;
			int k = 0;
			for(  i=4 ; i>=0;i--) {
				for( k=0;k<5;k++) {
					if(c==r) {
						break;
					}
					c++;
				}
				if(c==r) {
					break;
				}
			}
			
			try {
				model.castAbility(abilityTemp, i, k );
				view4.getAction().setText("Ability casted!");
				
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				
			}
			abilityTemp = null;
			
		}
		if(view4 !=null &&j==view4.getUpbtn()) {
			model.getCurrentChampion();
			if(this.abilityTemp==null) {
			if(attack) {
				try {
					model.attack(Direction.UP);
					view4.getAction().setText("Successful attack!");
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (ChampionDisarmedException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				attack=false;
			}
			else {
			
				try {
					model.move(Direction.UP);
					view4.getAction().setText(null);
				} catch (NotEnoughResourcesException e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				catch (UnallowedMovementException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
			}
			else {
				try {
					model.castAbility(abilityTemp, Direction.UP);
					view4.getAction().setText("Ability casted!");
				} catch (NotEnoughResourcesException e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (AbilityUseException e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (CloneNotSupportedException e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				abilityTemp=null;
			}
	      refresh();
			
		}
		if(view4!= null &&j==view4.getLeftbtn()) {
			model.getCurrentChampion();
			
			if(this.abilityTemp==null) {
				if(attack) {
					try {
						model.attack(Direction.LEFT);
						view4.getAction().setText("Successful attack!");
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ChampionDisarmedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					attack=false;
				}
				else {
				
					try {
						model.move(Direction.LEFT);
						view4.getAction().setText(null);
					} catch (NotEnoughResourcesException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					catch (UnallowedMovementException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				}
				else {
					try {
						model.castAbility(abilityTemp, Direction.LEFT);
						view4.getAction().setText("Ability casted!");
					} catch (NotEnoughResourcesException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (AbilityUseException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (CloneNotSupportedException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					abilityTemp=null;
				}
		      refresh();
				
			
		}
		if(view4 !=null &&j==view4.getRightbtn()) {
			model.getCurrentChampion();
			
			if(this.abilityTemp==null) {
				if(attack) {
					try {
						model.attack(Direction.RIGHT);
						view4.getAction().setText("Successful attack!");
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ChampionDisarmedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					attack=false;
				}
				else {
				
					try {
						model.move(Direction.RIGHT);
						view4.getAction().setText(null);
					} catch (NotEnoughResourcesException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					catch (UnallowedMovementException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				}
				else {
					try {
						model.castAbility(abilityTemp, Direction.RIGHT);
						view4.getAction().setText("Ability casted!");
					} catch (NotEnoughResourcesException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (AbilityUseException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (CloneNotSupportedException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					abilityTemp=null;
				}
		      refresh();
				
			
		}
		if(view4 !=null &&j==view4.getDownbtn()) {
			model.getCurrentChampion();
			
			if(this.abilityTemp==null) {
				if(attack) {
					try {
						model.attack(Direction.DOWN);
						view4.getAction().setText("Successful attack");
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ChampionDisarmedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					attack=false;
				}
				else {
				
					try {
						model.move(Direction.DOWN);
						view4.getAction().setText(null);
					} catch (NotEnoughResourcesException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					catch (UnallowedMovementException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				}
				else {
					try {
						model.castAbility(abilityTemp, Direction.DOWN);
						view4.getAction().setText("Ability casted!");
					} catch (NotEnoughResourcesException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (AbilityUseException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (CloneNotSupportedException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					abilityTemp=null;
				}
		      refresh();
				
		}
		if(view4 !=null &&j==view4.getAttack()) {
			attack=true;
			JOptionPane.showMessageDialog(null, "Please choose a direction");
			refresh();
			}
		
		if(view4 !=null &&j==view4.getEndTurn()) {
			model.endTurn();
			view4.getAction().setText(null);
			refresh();
			}
		
		if(view4 !=null &&j==view4.getPunch()) {
			int z=-20;
			for(int i=0;i<model.getCurrentChampion().getAbilities().size();i++) {
				if(model.getCurrentChampion().getAbilities().get(i).getName().equals("Punch")) {
						z=i;
					}
				}
				if(z==-20) {
					JOptionPane.showMessageDialog(null, "champion does not have punch");
					}
					else {
						abilityTemp=model.getCurrentChampion().getAbilities().get(z);
					}
				      refresh();
				}

		if(view4 !=null &&j==view4.getAbility1()) {
			Ability temp=model.getCurrentChampion().getAbilities().get(0);
			if(temp.getCastArea()==AreaOfEffect.SINGLETARGET) {
				abilityTemp=temp;
				JOptionPane.showMessageDialog(null, "PRESS ON THE DESIRED CELL");
			}
				
			else if	(temp.getCastArea()==AreaOfEffect.DIRECTIONAL) {
				abilityTemp=temp;
				JOptionPane.showMessageDialog(null, "CHOOSE A DIRECTION");
			}
			else {
				try {
					model.castAbility(temp);
				}catch(NotEnoughResourcesException e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}catch(AbilityUseException e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}catch(CloneNotSupportedException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());
				}
				
			}
		    refresh();
		}
		if(view4 !=null &&j==view4.getAbility2()) {
			Ability temp =model.getCurrentChampion().getAbilities().get(1);
			if(temp.getCastArea()==AreaOfEffect.SINGLETARGET) {
				abilityTemp=temp;
				JOptionPane.showMessageDialog(null, "PRESS ON THE DESIRED CELL");
			}
				
			else if	(temp.getCastArea()==AreaOfEffect.DIRECTIONAL) {
				abilityTemp=temp;
				JOptionPane.showMessageDialog(null, "CHOOSE A DIRECTION");
			}
			else {
				try {
					model.castAbility(temp);
				}catch(NotEnoughResourcesException e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}catch(AbilityUseException e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}catch(CloneNotSupportedException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());	
				}
				
			}
		   refresh();
		}
		if(view4 !=null &&j==view4.getAbility3()) {
			Ability temp =model.getCurrentChampion().getAbilities().get(2);
			if(temp.getCastArea()==AreaOfEffect.SINGLETARGET) {
				abilityTemp=temp;
				JOptionPane.showMessageDialog(null, "PRESS ON THE DESIRED CELL");
			}
				
			else if	(temp.getCastArea()==AreaOfEffect.DIRECTIONAL) {
				abilityTemp=temp;
				JOptionPane.showMessageDialog(null, "CHOOSE A DIRECTION");
			}
			else {
				try {
					model.castAbility(temp);
				}catch(NotEnoughResourcesException e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}catch(AbilityUseException e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}catch(CloneNotSupportedException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());
				}
				
			}
		   refresh();
		}
		if(view4 !=null &&j==view4.getLeaderAbility()) {
			try {
				model.useLeaderAbility();
			}catch(LeaderNotCurrentException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}catch(LeaderAbilityAlreadyUsedException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		      refresh();
		}
		if(j==view1.getB1()) {
			view1.dispose();
			view2.setVisible(true);
		}
		 if(j==view2.getNext()) {
			model.getFirstPlayer().setName(view2.getPlayer1().getText());
			model.getSecondPlayer().setName(view2.getPlayer2().getText());
			
			view2.dispose();
			view3.setVisible(true);
			choose=true;
			view3.getProp().setText("                      These are the available champions      \n"
	 				+ "                       "+model.getFirstPlayer().getName() +" , please choose your leader and then two more champions");
			
		}
		else if (choose){
			
		int r=Buttons.indexOf(j);
		if(model.getFirstPlayer().getTeam().size()<3) {
			j.setEnabled(false);
			model.getFirstPlayer().getTeam().add(model.getAvailableChampions().get(r));
			view3.getProp().setText("\n              choose again...");
			if(model.getFirstPlayer().getTeam().size()==3) {
				view3.getProp().setText( "                          "+model.getFirstPlayer().getName()+"'s Champions are  (" + model.getFirstPlayer().getTeam().get(0).getName() +" [LEADER]"
						+" - "+model.getFirstPlayer().getTeam().get(1).getName()+
						" - "+model.getFirstPlayer().getTeam().get(2).getName()+") \n                          Now "+model.getSecondPlayer().getName()+" ,it's your time to choose your team to begin the WAR \n                         Start by choosing your leader ");
				model.getFirstPlayer().setLeader(model.getFirstPlayer().getTeam().get(0)); 
			}
			
		}
		else if(model.getSecondPlayer().getTeam().size()<3) {
			j.setEnabled(false);
			model.getSecondPlayer().getTeam().add(model.getAvailableChampions().get(r));
			view3.getProp().setText("\n                         choose again...");
			if(model.getSecondPlayer().getTeam().size()==3) {
				view3.getProp().setText("                         5las kfaya"+ " \n   \n                         "
						+ "Second team Champions is  (" + model.getSecondPlayer().getTeam().get(0).getName()
						+" - "+model.getSecondPlayer().getTeam().get(1).getName()+
						" - "+model.getSecondPlayer().getTeam().get(2).getName()+")");
				model.getSecondPlayer().setLeader(model.getSecondPlayer().getTeam().get(0));
				view3.dispose();
				view4.setVisible(true);
				choose=false;
				model.placeChampions();
				view4.getPlayer1().setText("  "+model.getFirstPlayer().getName());
				view4.getPlayer1().setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf",Font.BOLD,25));
				view4.getPlayer2().setText(model.getSecondPlayer().getName());
				view4.getPlayer2().setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf",Font.BOLD,25));
				view4.getChamp1().setIcon(icon(model.getFirstPlayer().getTeam().get(0)));
				view4.getChamp2().setIcon(icon(model.getFirstPlayer().getTeam().get(1)));
				view4.getChamp3().setIcon(icon(model.getFirstPlayer().getTeam().get(2)));
				view4.getChamp4().setIcon(icon(model.getSecondPlayer().getTeam().get(0)));
				view4.getChamp5().setIcon(icon(model.getSecondPlayer().getTeam().get(1)));
				view4.getChamp6().setIcon(icon(model.getSecondPlayer().getTeam().get(2)));
				int i=0;
				for (Champion c : model.getFirstPlayer().getTeam()) {	
					model.getTurnOrder().insert(c);
					champs[i]=c;
					i++;
				}
				for (Champion c : model.getSecondPlayer().getTeam()) {
					model.getTurnOrder().insert(c);
					champs[i]=c;
					i++;
				}
				refresh();
				
				

			}
		}
		else {
			view3.getProp().setText("                     ma  5las ya wa7sh ");
			
		}
		}
		
	}
	public void refresh() {
		if (model.checkGameOver()!=null) {
			view4.dispose();
			view5.setVisible(true);
			view5.getEnd().setText("<html> The winner is "+ model.checkGameOver().getName());
			view5.getEnd().setFont(new Font("/Marvel-M2/marvel images/HeroesAssemble3DRegular-gz3p.otf", Font.BOLD , 40));
		
		}
		if (model.isFirstLeaderAbilityUsed()) {
			view4.getLeader1().setText("<html> Leader Ability <br> used");
		}
		if (model.isSecondLeaderAbilityUsed()) {
			view4.getLeader1().setText("<html> Leader Ability <br> used");
		}

		if(model.getCurrentChampion().getCurrentActionPoints()==0) {
			model.endTurn();
		}
		for (int i=0 ;i<champs.length;i++) {
			if (i==0 && champs[i].getCurrentHP()==0) {
				view4.getChamp1().setVisible(false);
			}
			if(i==1 && champs[i].getCurrentHP()==0) {
				view4.getChamp2().setVisible(false);
			}
			if(i==2 && champs[i].getCurrentHP()==0) {
				view4.getChamp3().setVisible(false);
			}
			if (i==3 && champs[i].getCurrentHP()==0) {
				view4.getChamp4().setVisible(false);
			}
			if(i==4 && champs[i].getCurrentHP()==0) {
				view4.getChamp5().setVisible(false);
				
			}
			if(i==5 && champs[i].getCurrentHP()==0) {
				view4.getChamp6().setVisible(false);
			}
		}
		
		view4.getAbility1().setText("<html> "+ model.getCurrentChampion().getAbilities().get(0).getName()+ "<br> CoolDown: "+ model.getCurrentChampion().getAbilities().get(0).getCurrentCooldown());
		
		view4.getAbility2().setText("<html> "+ model.getCurrentChampion().getAbilities().get(1).getName()+ "<br> CoolDown: "+ model.getCurrentChampion().getAbilities().get(1).getCurrentCooldown());
		
		view4.getAbility3().setText("<html> "+ model.getCurrentChampion().getAbilities().get(2).getName()+ "<br> CoolDown: "+ model.getCurrentChampion().getAbilities().get(2).getCurrentCooldown());
		
		
		view4.getEffects().setText(printeff(model.getCurrentChampion()));
		view4.getCurrentText().setText("<html>Current Champion: <br>   <br>" + printCurrentChampion(model.getCurrentChampion()));
		view4.getCurrentText().setFont(new Font("", Font.BOLD,18));

		view4.getTurnOrder().setText(printnext(model));
		view4.getTurnOrder().setFont(new Font(printnext(model), Font.BOLD,16));
		view4.getCurrentIcon().setIcon(photo(model.getCurrentChampion()));
		setBoard();
		
	}
	
	public void setBoard() {

		
		    int c=0;
			for( int i=4 ; i>=0;i--) {
				for(int j=0;j<5;j++) {
					if(model.getBoard()[i][j] instanceof Cover) {
						
						view4.getButtons().get(c).setIcon(new ImageIcon("board/wall.jpg"));
						
						
					}
					else if (model.getBoard()[i][j] instanceof Champion) {
						
	
					
						view4.getButtons().get(c).setIcon(photo((Champion) model.getBoard()[i][j]));
					}
					else {
						view4.getButtons().get(c).setIcon(new ImageIcon("marvel images/white_back.jpg"));
					}
					c++;
				}
			}
		
	}
	public ImageIcon icon(Champion c) {
		ImageIcon image ;
			switch(c.getName()) {
			case "Captain America" :	
				image= new ImageIcon("label team icons/captain.png");
		        break;
			case "Deadpool":
				image= new ImageIcon("label team icons/deadpool.png");
		        break;
			case "Dr Strange":
				
				image =new ImageIcon("label team icons/strange.png");
				
		        break;
			case "Electro":
				
				image=new ImageIcon("label team icons/electro.png");
				
		        break;
			case "Ghost Rider":
				
				image=new ImageIcon("label team icons/ghost.png");
				
		        break;
			case "Hela":
				
				image=new ImageIcon("label team icons/hela.png");
				
		        break;
			case "Hulk":
				
				image =new ImageIcon("label team icons/hulk.png");
				
		        break;
			case "Iceman":
				
				image=new ImageIcon("label team icons/iceman.png");
				
		        break;
			case "Ironman":
				
				image=new ImageIcon("label team icons/iron.png");
				
		        break;
			case "Loki":
				
				image=new ImageIcon("label team icons/loki.png");
				
		        break;
			case "Quicksilver":
				
				image=new ImageIcon("label team icons/quick.png");
				
		        break;
			case "Spiderman":
				
				image=new ImageIcon("label team icons/spider.png");
				
		        break;
			case "Thor":
				
				image=new ImageIcon("label team icons/thor.png");
				
		        break;
			case "Venom":
				
				image=new ImageIcon("label team icons/venom.png");
				
		        break;
			default :
				
				image=new ImageIcon("label team icons/yellow.png");
				
		        break;
		 	}
			return image;
			
		
	}
	public ImageIcon photo(Champion c) {
		ImageIcon image ;
			switch(c.getName()) {
			case "Captain America" :	
				image= new ImageIcon("board/captain.png");
		        break;
			case "Deadpool":
				image= new ImageIcon("board/deadpool.png");
		        break;
			case "Dr Strange":
				
				image =new ImageIcon("board/dr_strange.png");
				
		        break;
			case "Electro":
				
				image=new ImageIcon("board/electro.png");
				
		        break;
			case "Ghost Rider":
				
				image=new ImageIcon("board/ghost.jpg");
				
		        break;
			case "Hela":
				
				image=new ImageIcon("board/hela.png");
				
		        break;
			case "Hulk":
				
				image =new ImageIcon("board/hulk.png");
				
		        break;
			case "Iceman":
				
				image=new ImageIcon("board/iceman.png");
				
		        break;
			case "Ironman":
				
				image=new ImageIcon("board/iron.png");
				
		        break;
			case "Loki":
				
				image=new ImageIcon("board/loki.png");
				
		        break;
			case "Quicksilver":
				
				image=new ImageIcon("board/quick.png");
				
		        break;
			case "Spiderman":
				
				image=new ImageIcon("board/spider.png");
				
		        break;
			case "Thor":
				
				image=new ImageIcon("board/thor.png");
				
		        break;
			case "Venom":
				
				image=new ImageIcon("board/venom.png");
				
		        break;
			default :
				
				image=new ImageIcon("board/yellow.png");
				
		        break;
		 	}
			return image;
			
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
	       JButton j = (JButton) e.getSource();
	       if(choose) {
			for(int i=0;i<model.getAvailableChampions().size();i++) {
			if(j== Buttons.get(0)) {
			Buttons.get(0).setToolTipText((String)printchamp(model.getAvailableChampions().get(0)));}
			if(j== Buttons.get(1)) {
				Buttons.get(1).setToolTipText((String)printchamp(model.getAvailableChampions().get(1)));}
			if(j== Buttons.get(2)) {
				Buttons.get(2).setToolTipText((String)printchamp(model.getAvailableChampions().get(2)));}
			if(j== Buttons.get(3)) {
				Buttons.get(3).setToolTipText((String)printchamp(model.getAvailableChampions().get(3)));}
			if(j== Buttons.get(4)) {
				Buttons.get(4).setToolTipText((String)printchamp(model.getAvailableChampions().get(4)));}
			if(j== Buttons.get(5)) {
				Buttons.get(5).setToolTipText((String)printchamp(model.getAvailableChampions().get(5)));}
			if(j== Buttons.get(6)) {
				Buttons.get(6).setToolTipText((String)printchamp(model.getAvailableChampions().get(6)));}
			if(j== Buttons.get(7)) {
				Buttons.get(7).setToolTipText((String)printchamp(model.getAvailableChampions().get(7)));}
			if(j== Buttons.get(8)) {
				Buttons.get(8).setToolTipText((String)printchamp(model.getAvailableChampions().get(8)));}
			if(j== Buttons.get(9)) {
				Buttons.get(9).setToolTipText((String)printchamp(model.getAvailableChampions().get(9)));}
			if(j== Buttons.get(10)) {
				Buttons.get(10).setToolTipText((String)printchamp(model.getAvailableChampions().get(10)));}
			if(j== Buttons.get(11)) {
				Buttons.get(11).setToolTipText((String)printchamp(model.getAvailableChampions().get(11)));}
			if(j== Buttons.get(12)) {
				Buttons.get(12).setToolTipText((String)printchamp(model.getAvailableChampions().get(12)));}
			if(j== Buttons.get(13)) {
				Buttons.get(13).setToolTipText((String)printchamp(model.getAvailableChampions().get(13)));}
			if(j== Buttons.get(14)) {
				Buttons.get(14).setToolTipText((String)printchamp(model.getAvailableChampions().get(14)));}  
				}
	       }
	       else if (j==view4.getAbility1()) {
	    	   view4.getAbility1().setToolTipText((String)printabil(model.getCurrentChampion().getAbilities().get(0)));
			}
	       else if (j==view4.getAbility2()) {
	    	   view4.getAbility2().setToolTipText((String)printabil(model.getCurrentChampion().getAbilities().get(1)));
	       }
	       else if (j==view4.getAbility3()) {
	    	   view4.getAbility3().setToolTipText((String)printabil(model.getCurrentChampion().getAbilities().get(2)));
	       }
	       else {
			int c=0;
			
			for( int i=4 ; i>=0;i--) {
				for(int k=0;k<5;k++) {
					if(model.getBoard()[i][k] instanceof Cover) {
						
						view4.getButtons().get(c).setToolTipText("HP = "+((Cover)model.getBoard()[i][k]).getCurrentHP());
						
						
					}
					else if (model.getBoard()[i][k] instanceof Champion) {
						
						view4.getButtons().get(c).setToolTipText((String)printchamp((Champion)model.getBoard()[i][k]));
					}
					else {
						view4.getButtons().get(c).setToolTipText(null);
					}
		
					c++;
				}
			}
		
	       }
		}
		else {
			JLabel l = new JLabel();
			if (l==view4.getChamp1()) {
				System.out.println("hello");
				view4.getChamp1().setToolTipText((String)printchamp(model.getFirstPlayer().getTeam().get(0)));
			}
			if (l==view4.getChamp2()) {
				view4.getChamp2().setToolTipText((String)printchamp(model.getFirstPlayer().getTeam().get(1)));
			}
			if (l==view4.getChamp3()) {
				view4.getChamp3().setToolTipText((String)printchamp(model.getFirstPlayer().getTeam().get(2)));
			}
			if (l==view4.getChamp4()) {
				view4.getChamp4().setToolTipText((String)printchamp(model.getSecondPlayer().getTeam().get(0)));
			}
			if (l==view4.getChamp5()) {
				view4.getChamp5().setToolTipText((String)printchamp(model.getSecondPlayer().getTeam().get(1)));
			}
			if (l==view4.getChamp6()) {
				view4.getChamp6().setToolTipText((String)printchamp(model.getSecondPlayer().getTeam().get(2)));
			}
		}
		}
    public String printabil(Ability a) {
    	String s;
    	if(a instanceof HealingAbility) {
    		s="<html> Type: Healing Ability <br> Area Of Effect: "+ a.getCastArea()
    		       	 + " <br> Cast Range: "+a.getCastRange()+",  Action Points: "+a.getRequiredActionPoints() +"<br> BaseCooldown:"+a.getBaseCooldown()
    		           +"<br> Mana Cost: " +a.getManaCost()+ " <br> Healing Amount: "+((HealingAbility)a).getHealAmount();
    	 
    }
    	else if(a instanceof DamagingAbility) {
    		s="<html> Type: Damaging Ability <br> Area Of Effect: "+ a.getCastArea()
   		       	 + " <br> Cast Range: "+a.getCastRange()+",  Action Points: "+a.getRequiredActionPoints() +"<br> BaseCooldown:"+a.getBaseCooldown()
   		           +"<br> Mana Cost: " +a.getManaCost()+ " <br> Damage Amount: "+((DamagingAbility)a).getDamageAmount();}
    	
    	else {
    		s="<html> Type: CrowdControl Ability <br> Area Of Effect: "+ a.getCastArea()
      		       	 + " <br> Cast Range: "+a.getCastRange()+",  Action Points: "+a.getRequiredActionPoints() +"<br> BaseCooldown:"+a.getBaseCooldown()
      		           +"<br> Mana Cost: " +a.getManaCost()+ " <br> Effect: "+((CrowdControlAbility)a).getEffect().getName();}
    	return(s);
    	
    }
    public String printeff(Champion c) {
    	String s="<html>  Applied Effects: ";
    	for(int i=0;i<c.getAppliedEffects().size();i++) {
    		s=s+"<br>  "+c.getAppliedEffects().get(i).getName()+"("+c.getAppliedEffects().get(i).getDuration()+") <br>";
    	}
    	return(s);
    }
    public String printchamp(Champion c) {
    	
    		String s=" ";
    	
    	if (c instanceof Hero)
    	  s= "<html> Name: " + c.getName()+ "<br> Type: Hero <br>  MAX HP: " +c.getMaxHP() + "<br> Current HP: " +c.getCurrentHP()
    	 + " <br> Mana: "+c.getMana()+ "<br> Action Points: "+c.getCurrentActionPoints() 
    	 +" <br> Attack Range: "+c.getAttackRange()+" <br> Attack Damage: "+c.getAttackDamage()+" <br> Speed: "+c.getSpeed()   ;
    	else if (c instanceof AntiHero) {
    		s= "<html> Name: " + c.getName()+ "<br> Type: AntiHero <br>  MAX HP: " +c.getMaxHP() + "<br> Current HP: " +c.getCurrentHP()
    		    	 + " <br> Mana: "+c.getMana()+ "<br> Action Points: "+c.getCurrentActionPoints() 
    		    	 +" <br> Attack Range: "+c.getAttackRange()+" <br> Attack Damage: "+c.getAttackDamage()+" <br> Speed: "+c.getSpeed()   ;
    	}
    	else if (c instanceof Villain){
    		s= "<html> Name: " + c.getName()+ "<br> Type: Villain <br>  MAX HP: " +c.getMaxHP() + "<br> Current HP: " +c.getCurrentHP()
    		    	 + " <br> Mana: "+c.getMana()+ "<br> Action Points: "+c.getCurrentActionPoints() 
    		    	 +" <br> Attack Range: "+c.getAttackRange()+" <br> Attack Damage: "+c.getAttackDamage()+" <br> Speed: "+c.getSpeed() ;
    	}
    	s+="<br> His abilites: ";
    	for(Ability a : c.getAbilities()) {
    		s+=" "+ a.getName() + ",";
    	}
    	s+= printeff(c);
    	return(s);
    	
    }
    public String printCurrentChampion(Champion c) {
		String s=" ";
		if (model.getFirstPlayer().getLeader()!=null &&c.getName().equals(model.getFirstPlayer().getLeader().getName())) {
    		s=s+"<html> THE LEADER <br>";
    	}
    	if (model.getSecondPlayer().getLeader()!=null &&c==model.getSecondPlayer().getLeader()) {
    		s=s+"<html> THE LEADER <br>";
    	}
	if (c instanceof Hero)
	  s= "<html> Name: " + c.getName()+ " ,  Type: Hero <br>  MAX HP: " +c.getMaxHP() + " ,  Current HP: " +c.getCurrentHP()
	 + " <br> Mana: "+c.getMana()+ " ,  Action Points: "+c.getCurrentActionPoints() 
	 +" <br> Attack Range: "+c.getAttackRange()+"  ,  Attack Damage: "+c.getAttackDamage()+" <br> Speed: "+c.getSpeed()   ;
	else if (c instanceof AntiHero) {
		s= "<html> Name: " + c.getName()+ " ,  Type: AntiHero <br>  MAX HP: " +c.getMaxHP() + "  , Current HP: " +c.getCurrentHP()
		    	 + " <br> Mana: "+c.getMana()+ " ,  Action Points: "+c.getCurrentActionPoints() 
		    	 +" <br> Attack Range: "+c.getAttackRange()+"  , Attack Damage: "+c.getAttackDamage() +" <br> Speed: "+c.getSpeed()  ;
	}
	else if (c instanceof Villain){
		s= "<html> Name: " + c.getName()+ " ,  Type: Villain <br>  MAX HP: " +c.getMaxHP() + "  ,  Current HP: " +c.getCurrentHP()
		    	 + " <br> Mana: "+c.getMana()+ " ,  Action Points: "+c.getCurrentActionPoints() 
		    	 +" <br> Attack Range: "+c.getAttackRange()+"  ,  Attack Damage: "+c.getAttackDamage()+" <br> Speed: "+c.getSpeed()   ;
	}
	
	return(s);
}
    public String printnext(Game e) {
    	String s="<html> TurnOrder: <br>";
    	ArrayList<Champion> Champ=new ArrayList<Champion>();
    	while(!model.getTurnOrder().isEmpty()) {
    		s=s+((Champion) model.getTurnOrder().peekMin()).getName()+"<br> ";
    		Champ.add((Champion) model.getTurnOrder().remove());
    		
    	}
    	while(!Champ.isEmpty()) {
          model.getTurnOrder().insert(Champ.remove(0));
    	}
    	return(s);
    }

}
