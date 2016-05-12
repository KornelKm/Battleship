import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends Observable implements Observer {
	JPanel ships;
	JFrame f;
	ActionEvent e;
	JButton[][] grid;
	JButton[][] gridAI;
	MouseListener[][] listeners;
	MouseListener[][] listenersAI;
	JButton AirCraftCarrier;
	JButton BattleShip;
	JButton Destroyer;
	JButton PatrolBoat;
	JButton Gamep;
	int[][] AIBoatPartIsHere;
	String Large="Large";
	String Medium="Medium";
	String Small="Small";
	int[][]AiShootsHere;
	int [][] BoatPartIsHere;
	int [][] AIfiredHere;
	public int PlayerShoots=0;
	public int AIShoots=0;
	public int hit=0;
	public int x=0;
	int max;
	int min;
	static int shoot;
	static int shoot2;
	Color AiColor;
	
	
	
	public Game(JPanel ships,JFrame f,ActionEvent e,JButton[][] grid,JButton[][] gridAI,JButton AirCraftCarrier,JButton BattleShip,JButton Destroyer,JButton PatrolBoat, JButton Gamep, int[][] BoatPartIsHere,int[][] AIBoatPartIsHere, int max, Color AiColor) {
		this.ships=ships;
		this.f=f;
		this.e=e;
		this.grid=grid;
		this.BoatPartIsHere=BoatPartIsHere;
		this.gridAI=gridAI;
		this.AirCraftCarrier=AirCraftCarrier;
		this.BattleShip=BattleShip;
		this.Destroyer=Destroyer;
		this.PatrolBoat=PatrolBoat;
		this.Gamep=Gamep;
		this.AIBoatPartIsHere=AIBoatPartIsHere;
		this.max=max;
		this.AiColor=AiColor;
		
		listeners = new MouseListener[grid.length][grid[0].length];
		listenersAI = new MouseListener[gridAI.length][gridAI[0].length];
	}
	
	
	
	@Override
	public void update() {		
		Random rand = new Random();
		
			int [][] AIfiredHere = new int[max][max];
			int [][] PlayerfiredHere = new int[max][max];
			/**Saving the game:*/
			JPanel Savegame = new JPanel(new GridLayout());
			JButton Save = new JButton("Save");
			Savegame.add(Save);
			Save.addActionListener(new ActionListener(){

			@Override
				public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null, "Game Saved ", "Information", JOptionPane.INFORMATION_MESSAGE);
					
								Save Save = new Save(BoatPartIsHere,AIBoatPartIsHere,AIfiredHere,max,PlayerfiredHere);
								
								notifyObserver(Save);
				}});
			 Savegame.setBounds(335, 60, 80, 30);
			 
			 f.add(Savegame); 
		
		/**Battle:*/
		/** Enabling player to shoot to AI:*/
		for (int rowAI = 0; rowAI < gridAI.length; rowAI++) {
		    for (int colAI = 0; colAI < gridAI[rowAI].length; colAI++){ 
			gridAI[rowAI][colAI].setEnabled(true);
			final int thisRowAI = rowAI;
			final int thisColAI = colAI;
			listenersAI[rowAI][colAI] = new MouseAdapter() {
				public void mouseClicked(MouseEvent event1){	
					PlayerShoots++;
					/** AI Shoots*/	
					/**AI Shooting Strategy:
					 * AI choose button by random
					 * if hit:
					 * do 4 shoots around the place it hit(column +1 column - 1, row - 1, row+1
					 * if miss all four - random 
					 * AI checks its previous shoots and never shoots again same place
					 */
					
				    if( AIShoots<PlayerShoots){
				    	AIShoots++;
				    
				   
				    	
					    if ((hit==0)&&(x==0)){
					    	shoot = rand.nextInt(max) + 0;
						    shoot2 =rand.nextInt(max)+0;
					    while(AIfiredHere[shoot2][shoot]!=0){
					    	shoot = rand.nextInt(max) + 0;
						    shoot2 =rand.nextInt(max)+0;}
				    	if((BoatPartIsHere[shoot2][shoot]==0)&&(AIfiredHere[shoot2][shoot]==0)){
				    	grid[shoot][shoot2].setBackground(Color.GRAY);	
				    	hit=0;
				    	AIfiredHere[shoot2][shoot]=1;
				    }
				    	else if((BoatPartIsHere[shoot2][shoot]==1)&&(AIfiredHere[shoot2][shoot]==0)){
				    	grid[shoot][shoot2].setBackground(Color.BLUE);
				   		BoatPartIsHere[shoot2][shoot]=0;
				   		AIfiredHere[shoot2][shoot]=3;
				   		hit=1;
				   		x=1;
				    	}}
				    else if((hit==1)&&(x==1)){
				    	if(shoot2-1>0){
				    	if((BoatPartIsHere[shoot2-1][shoot]==0)&&(AIfiredHere[shoot2-1][shoot]==0)){
					    	grid[shoot][shoot2-1].setBackground(Color.GRAY);	
					    	x=2;
					    	AIfiredHere[shoot2-1][shoot]=1;
					    	
					    }
					    	else if(BoatPartIsHere[shoot2-1][shoot]==1){
					    	grid[shoot][shoot2-1].setBackground(Color.BLUE);
					   		 BoatPartIsHere[shoot2-1][shoot]=0;
					   		AIfiredHere[shoot2-1][shoot]=3;		 
					   		x=2;
					   
					    		
					    	}
					    	else{
					    		x=2;}}
				    	else{
				    		x=2;
				    	}
				    	}
				    
				    else if((hit==1)&&(x==2)){
				    	if (shoot2+1<max){
				    	if((BoatPartIsHere[shoot2+1][shoot]==0)&&(AIfiredHere[shoot2+1][shoot]==0)){
					    	grid[shoot][shoot2+1].setBackground(Color.GRAY);	
					    	AIfiredHere[shoot2+1][shoot]=1;
					    	x=3;
					    	
					    }
					    	else if(BoatPartIsHere[shoot2+1][shoot]==1){
					    	grid[shoot][shoot2+1].setBackground(Color.BLUE);
					   		 BoatPartIsHere[shoot2+1][shoot]=0;
					   		AIfiredHere[shoot2+1][shoot]=3;
					   		x=3;
					    		
					    	}else{
					    		x=3;}
					    	
				    }
				    	else{
				    		x=3;
				    	}}
				    
					 else if((hit==1)&&(x==3)){
						 if(shoot-1>0){
							    	if((BoatPartIsHere[shoot2][shoot-1]==0)&&(AIfiredHere[shoot2][shoot-1]==0)){
								    	grid[shoot-1][shoot2].setBackground(Color.GRAY);	
								    	x=4;
								    	AIfiredHere[shoot2][shoot-1]=1;
								    	
								    }
								    	else if(BoatPartIsHere[shoot2][shoot-1]==1){
								    	grid[shoot-1][shoot2].setBackground(Color.BLUE);
								   		 BoatPartIsHere[shoot2][shoot-1]=0;
								   		AIfiredHere[shoot2][shoot-1]=3;
								   		x=4;
								    		
								    	}
					    	  else{
								 x=4;}}
						 else{
							 x=4;
						 }}
						 
			    	 else if((hit==1)&&(x==4)){
			    		 if(shoot+1<max){
							    	if((BoatPartIsHere[shoot2][shoot+1]==0)&&(AIfiredHere[shoot2][shoot+1]==0)){
								    	grid[shoot+1][shoot2].setBackground(Color.GRAY);	
								    	x=0;
								    	hit=0;
								    	AIfiredHere[shoot2][shoot+1]=1;
								
								   
								    }
								    	else if(BoatPartIsHere[shoot2][shoot+1]==1){
								    	grid[shoot+1][shoot2].setBackground(Color.BLUE);
								   		 BoatPartIsHere[shoot2][shoot+1]=0;
								   		AIfiredHere[shoot2][shoot+1]=3;
								   		x=0;
								   		hit=0;
								   	
								    	}else{
								    		 x=0;
								    		 hit=0;
								    		
								    	 }
								    
					    	 }else{
					    		 x=0;
					    		 hit=0;
					    		
					    	 }
					    	 }
			    	 else{
			    		 x=0;
			    		 hit=0;
			    	
			    	 }
				    
				    }
				    	
					if (event1.getClickCount()==1){
						/**Counting AI boats*/
						int sumAIBoats =0;
						for (int rowa = 0; rowa < AIBoatPartIsHere.length; rowa++) {
						    for (int cola = 0; cola < AIBoatPartIsHere[rowa].length; cola++){ 
						    	if(AIBoatPartIsHere[rowa][cola]!=3){
						   sumAIBoats+=AIBoatPartIsHere[rowa][cola];
						  }
						    }}
						   /**Counting Player boats*/
						    int sumPlayerBoats =0;
							for (int rowa2 = 0; rowa2 < BoatPartIsHere.length; rowa2++) {
							    for (int cola2 = 0; cola2 < BoatPartIsHere[rowa2].length; cola2++){ 
							    	if(BoatPartIsHere[rowa2][cola2]!=3){
							   sumPlayerBoats+=BoatPartIsHere[rowa2][cola2];}
							    }}
						
						
						   /**Informing who has win*/
						 if(sumAIBoats==0){
							 JOptionPane.showMessageDialog(f, "<html>Set Sail!<BR>We Won</html>");
							 System.exit(0);}
						 if(sumPlayerBoats==0){
							 JOptionPane.showMessageDialog(f, "<html>Oh Captain, My Captain...<BR> We Lost</html>");
							 System.exit(0);}
						 
						
						
						/**Miss*/
						if((AIBoatPartIsHere[thisRowAI][thisColAI]==0)||(AIBoatPartIsHere[thisRowAI][thisColAI]==3)){
						((JButton)event1.getSource()).setBackground(Color.GRAY);
						PlayerfiredHere[thisRowAI][thisColAI]=1;
						}
						
							
						/**Enemy boat*/
						else if(AIBoatPartIsHere[thisRowAI][thisColAI]==1) {
							((JButton)event1.getSource()).setBackground(AiColor);
						AIBoatPartIsHere[thisRowAI][thisColAI]=0;
						PlayerfiredHere[thisRowAI][thisColAI]=2;}
						}
					}
				 
				};
				
			gridAI[rowAI][colAI].addMouseListener(listenersAI[rowAI][colAI]);
		    }
	}

		
		
/** Disabling panel with user ships*/
	for (int row = 0; row < grid.length; row++) {
	    for (int col = 0; col < grid[row].length; col++){ 
		grid[row][col].removeMouseListener(listeners[row][col]);
		grid[row][col].setEnabled(false);
	}
}
	
	/** Disabling Classes that are used to deploy ships*/
	AirCraftCarrier.setEnabled(false);
	BattleShip.setEnabled(false);
	Destroyer.setEnabled(false);
	PatrolBoat.setEnabled(false);
	Gamep.setEnabled(false);
	
	
	/**Updating Frame*/
	f.revalidate();
	f.repaint();
}
}