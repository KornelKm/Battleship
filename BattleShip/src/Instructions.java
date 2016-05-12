import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instructions implements Observer {
	JPanel MenuPanel;
	JFrame GameMenu;
	
	public Instructions(JPanel MenuPanel,JFrame GameMenu){
		this.MenuPanel=MenuPanel;
		this.GameMenu=GameMenu;
		
	}
	
	@Override
	public void update() {
		MenuPanel.setVisible(false);
		JPanel InstructionPanel = new JPanel(new GridLayout(10,10));
		InstructionPanel.setSize(800, 800);
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener(){
			 @Override
				public void actionPerformed(ActionEvent e) {
				 InstructionPanel.setVisible(false);
				 MenuPanel.setVisible(true);
				 
				}});
		JLabel info = new JLabel("<html>During the game: "
				+ "<BR>To set ship click ones"		
				+"<BR>Player is allowed to set ships any way he wants"
				+"<BR>Computer can set ships only in vertical/level"
				+ "<BR>Ships Are not allowed to be next to each other(atleast 1 square space required)</html>"
				); 
		GameMenu.add(InstructionPanel);
		InstructionPanel.add(Back);
		InstructionPanel.setVisible(true);
		InstructionPanel.add(info);
		
	}
	
}
