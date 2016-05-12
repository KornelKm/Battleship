import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class GameMenu extends Observable implements Observer {
	public JComboBox BoardSize;
	public JSlider sliderPatrolBoat;
	public JSlider sliderDestroyer;
	public JSlider sliderBattleship;
	public JSlider sliderAircraftCarrier;
	public Color AIbackground;
	public int max;
	public GameMenu(){
	JFrame GameMenu = new JFrame();
	GameMenu.setLayout(null);
	GameMenu.setTitle("Battleships");	
	JPanel MenuPanel = new JPanel(new GridLayout(4,1));
	GameMenu.add(MenuPanel);
	MenuPanel.setBounds(150, 100, 400, 300);
	
	
	/**Start the Single Player*/
	 JButton Single = new JButton("Single Player");
	 MenuPanel.add(Single);
	 Single.addActionListener(new ActionListener(){
		 
		 @Override
			public void actionPerformed(ActionEvent e) {
				
			 GameOptionMenu GameOptionMenu = new GameOptionMenu(MenuPanel,GameMenu,BoardSize,sliderPatrolBoat,sliderDestroyer,sliderBattleship,sliderAircraftCarrier);
							
							  notifyObserver(GameOptionMenu);
			}});
	 
	 /**Load the Game*/
	 JButton Load = new JButton("Load");
	 MenuPanel.add(Load);
     Load.addActionListener(new ActionListener(){
		 
		 @Override
			public void actionPerformed(ActionEvent e) {
				
			 Load Load = new Load(MenuPanel,GameMenu,BoardSize,sliderPatrolBoat,sliderDestroyer,sliderBattleship,sliderAircraftCarrier,max);
							
							  notifyObserver(Load);
			}});
	 
	 /**Instructions*/
	 JButton Instructions = new JButton("Instructions");
	 MenuPanel.add(Instructions);
	 Instructions.addActionListener(new ActionListener(){
		 @Override
			public void actionPerformed(ActionEvent e) {
				
			 Instructions Instructions = new Instructions(MenuPanel,GameMenu);
							
							  notifyObserver(Instructions);
			}});
	 
	 
	 /**Quit the game*/
	 JButton Quit = new JButton("Quit");
	 MenuPanel.add(Quit);
	 Quit.addActionListener(new ActionListener(){
		 
		 @Override
			public void actionPerformed(ActionEvent e) {
			 int choice = JOptionPane.showOptionDialog(null, 
				      "You really want to quit?", 
				      "Quit?", 
				      JOptionPane.YES_NO_OPTION, 
				      JOptionPane.QUESTION_MESSAGE, 
				      null, null, null);
				 
				 
				  if (choice == JOptionPane.YES_OPTION)
				  {
				    System.exit(0);
				  }
				
			
			}});

/**Managing the Frame*/
	 GameMenu.setSize(800, 600);
	 GameMenu.setVisible(true);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
}
