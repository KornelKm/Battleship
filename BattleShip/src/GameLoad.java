import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameLoad extends Observable implements Observer {
int[][]SavedBoatPartIsHere;	
int[][]SavedAIBoatPartIsHere;
int[][] SavedAIfiredHere;
JFrame GameMenu;
int[][] BoatPartIsHere;
int[][] AIBoatPartIsHere;
int[][]AIfiredHere;
int [][] SavedPlayerfiredHere;;
JButton[][] grid;
JFrame f;
JPanel panel2;
JPanel panel1;
JButton[][] gridAI;
public int max;
public int PlayerShoots=0;
public int AIShoots=0;
public int hit=0;
public int x=0;
static int shoot;
static int shoot2;
MouseListener[][] listeners;
MouseListener[][] listenersAI;
	
	public GameLoad(int[][] SavedBoatPartIsHere, int[][] SavedAIBoatPartIsHere, int[][] SavedAIfiredHere,int[][]SavedPlayerfiredHere) {
		this.SavedBoatPartIsHere=SavedBoatPartIsHere;
		this.SavedAIBoatPartIsHere=SavedAIBoatPartIsHere;
		this.SavedAIfiredHere=SavedAIfiredHere;
		this.SavedPlayerfiredHere=SavedPlayerfiredHere;
		
		
	}

	@Override
	public void update() {
		
		/**Preparing Previous state of game:**/
		/**Variables:**/
		max = SavedAIfiredHere.length;
		System.out.println(max);
		int [][] BoatPartIsHere = new int[SavedBoatPartIsHere.length][];
		for(int i = 0; i < SavedBoatPartIsHere.length; i++)
			BoatPartIsHere[i] = SavedBoatPartIsHere[i].clone();
		
		int [][] AIBoatPartIsHere = new int[SavedAIBoatPartIsHere.length][];
		for(int i = 0; i < SavedAIBoatPartIsHere.length; i++)
			AIBoatPartIsHere[i] = SavedAIBoatPartIsHere[i].clone();
		
		int [][] AIfiredHere = new int[SavedAIfiredHere.length][];
		for(int i = 0; i < SavedAIfiredHere.length; i++)
			AIfiredHere[i] = SavedAIfiredHere[i].clone();
		
		int [][] PlayerfiredHere = new int[SavedPlayerfiredHere.length][];
		for(int i = 0; i < SavedPlayerfiredHere.length; i++)
			PlayerfiredHere[i] = SavedPlayerfiredHere[i].clone();
		
		/**GUI:**/
		f = new JFrame();
		f.setLayout(null);
		f.setTitle("Battleships");
		JPanel panel1 = new JPanel(new GridLayout(max,max));
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		/**Grid,field etc*/
		grid = new JButton[max][max];
		for (int row = 0; row < grid.length; row++) {
		    for (int col = 0; col < grid[row].length; col++){ 
			grid[row][col] = new JButton();
			grid[row][col].putClientProperty( "Row", new Integer( row ) );
			grid[row][col].putClientProperty( "Col", new Integer( col ) );
			grid[row][col].setEnabled(false);
		    panel1.add(grid[row][col]);
		    }
		}
		
		/**Creating Panel for AI*/
		panel2 = new JPanel(new GridLayout(max,max));
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		/**Grid,field etc*/
		gridAI = new JButton[max][max];
		for (int rowAI = 0; rowAI < gridAI.length; rowAI++) {
		    for (int colAI = 0; colAI < gridAI[rowAI].length; colAI++){ 
			gridAI[rowAI][colAI] = new JButton();
			gridAI[rowAI][colAI].setEnabled(false);
		    panel2.add(gridAI[rowAI][colAI]);
			
		    }
		}
		listeners = new MouseListener[grid.length][grid[0].length];
		listenersAI = new MouseListener[gridAI.length][gridAI[0].length];
		
		panel1.setBounds(50, 100, 300, 300);
		panel2.setBounds(400, 100, 300, 300);
		f.add(panel1);
		f.add(panel2); 
		f.setSize(800, 600);
		f.setVisible(true);
		
		/**Frame with instructions*/
		 JPanel InstructionColors=new JPanel(new GridLayout(4,2));
		 InstructionColors.setBorder(BorderFactory.createLineBorder(Color.black));
		 InstructionColors.setVisible(true);
		 JButton GREEN = new JButton();
		 JLabel GREEN2 = new JLabel("Your Ships");
		 GREEN.setBackground(Color.GREEN);
		 GREEN.setSize(10, 10);
		 JButton RED = new JButton();
		 JLabel RED2 = new JLabel("Enemy Ships");
		 RED.setBackground(Color.RED);
		 RED.setSize(10, 10);
		 JButton BLUE = new JButton();
		 JLabel BLUE2 = new JLabel("Enemy Hits");
		 BLUE.setBackground(Color.BLUE);
		 BLUE.setSize(10, 10);
		 JButton GREY = new JButton();
		 JLabel GREY2 = new JLabel("Miss");
		 GREY.setBackground(Color.GRAY);
		 GREY.setSize(10, 10);
		 InstructionColors.add(GREEN);
		 InstructionColors.add(GREEN2);
		 InstructionColors.add(RED);
		 InstructionColors.add(RED2);
		 InstructionColors.add(BLUE);
		 InstructionColors.add(BLUE2);
		 InstructionColors.add(GREY);
		 InstructionColors.add(GREY2);
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
			 JPanel ships = new JPanel(new GridLayout(1,4));
			 JButton AirCraftCarrier = new JButton("Aircraft Carrier");
			 JButton BattleShip = new JButton("BattleShip");
			 JButton Destroyer = new JButton("Destroyer");
			 JButton PatrolBoat = new JButton("Patrol Boat");
			 ships.add(PatrolBoat);
			 ships.add(Destroyer);
			 ships.add(BattleShip);
			 ships.add(AirCraftCarrier);
			 AirCraftCarrier.setEnabled(false);
				BattleShip.setEnabled(false);
				Destroyer.setEnabled(false);
				PatrolBoat.setEnabled(false);
				
		 f.add(ships);
		 f.add(InstructionColors);
		 ships.setBounds(100, 5, 500, 20);
		 InstructionColors.setBounds(335,420,250,50);
		
		for(int r=0; r<AIfiredHere.length; r++) {
		       for(int c=0; c<AIfiredHere[r].length; c++){
		    	   if(AIfiredHere[r][c]==3){
		    		   grid[r][c].setBackground(Color.BLUE);
		    		   
		    	   }
		    	   if(AIfiredHere[r][c]==1){
		    		   grid[r][c].setBackground(Color.GRAY);
		       }
		       }}
		for(int r=0; r<BoatPartIsHere.length; r++) {
		       for(int c=0; c<BoatPartIsHere[r].length; c++){
		    	   if(BoatPartIsHere[r][c]==1){
		    		   grid[r][c].setBackground(Color.GREEN);
		    		   
		    	   }
		       }
		       }
		for(int r=0; r<PlayerfiredHere.length; r++) {
		       for(int c=0; c<PlayerfiredHere[r].length; c++){
		    	   if(PlayerfiredHere[r][c]==2){
		    		   gridAI[r][c].setBackground(Color.RED);
		    		   
		    	   }
		    	   if(PlayerfiredHere[r][c]==1){
		    		   gridAI[r][c].setBackground(Color.GRAY);
		       }
		       }}
		
		
		
		/**Battle**/
		Random rand = new Random();
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
						    System.out.println("aa");
					    while(AIfiredHere[shoot2][shoot]==1){
					    	shoot = rand.nextInt(max) + 0;
						    shoot2 =rand.nextInt(max)+0;}
				    	if((BoatPartIsHere[shoot2][shoot]==0)&&(AIfiredHere[shoot2][shoot]==0)){
				    	grid[shoot2][shoot].setBackground(Color.GRAY);	
				    	hit=0;
				    	AIfiredHere[shoot2][shoot]=1;
				    
				    }
				    	else if((BoatPartIsHere[shoot2][shoot]==1)&&(AIfiredHere[shoot2][shoot]==0)){
				    	grid[shoot2][shoot].setBackground(Color.BLUE);
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
					    	grid[shoot2-1][shoot].setBackground(Color.BLUE);
					   		 BoatPartIsHere[shoot2-1][shoot]=0;
					   		AIfiredHere[shoot2-1][shoot]=3;		 
					   		x=2;
					   
					    		
					    	}}
				    	else{
				    		x=2;
				    	}
				    	}
				    
				    else if((hit==1)&&(x==2)){
				    	if (shoot2+1<max){
				    	if((BoatPartIsHere[shoot2+1][shoot]==0)&&(AIfiredHere[shoot2+1][shoot]==0)){
					    	grid[shoot2+1][shoot].setBackground(Color.GRAY);	
					    	AIfiredHere[shoot2+1][shoot]=1;
					    	x=3;
					    	
					    }
					    	else if(BoatPartIsHere[shoot2+1][shoot]==1){
					    	grid[shoot2+1][shoot].setBackground(Color.BLUE);
					   		 BoatPartIsHere[shoot2+1][shoot]=0;
					   		AIfiredHere[shoot2+1][shoot]=3;
					   		x=3;
					    		
					    	}
					    	
				    }
				    	else{
				    		x=3;
				    	}}
				    
					 else if((hit==1)&&(x==3)){
						 if(shoot-1>0){
							    	if((BoatPartIsHere[shoot2][shoot-1]==0)&&(AIfiredHere[shoot2][shoot-1]==0)){
								    	grid[shoot2][shoot-1].setBackground(Color.GRAY);	
								    	x=4;
								    	AIfiredHere[shoot2][shoot-1]=1;
								    	
								    }
								    	else if(BoatPartIsHere[shoot2][shoot-1]==1){
								    	grid[shoot2][shoot-1].setBackground(Color.BLUE);
								   		 BoatPartIsHere[shoot2][shoot-1]=0;
								   		AIfiredHere[shoot2][shoot-1]=3;
								   		x=4;
								    		
								    	}
					    	 }
						 else{
							 x=4;
						 }}
						 
			    	 else if((hit==1)&&(x==4)){
			    		 if(shoot+1<max){
							    	if((BoatPartIsHere[shoot2][shoot+1]==0)&&(AIfiredHere[shoot2][shoot+1]==0)){
								    	grid[shoot2][shoot+1].setBackground(Color.GRAY);	
								    	x=0;
								    	hit=0;
								    	AIfiredHere[shoot2][shoot+1]=1;
								   
								    }
								    	else if(BoatPartIsHere[shoot2][shoot+1]==1){
								    	grid[shoot2][shoot+1].setBackground(Color.BLUE);
								   		 BoatPartIsHere[shoot2][shoot+1]=0;
								   		AIfiredHere[shoot2][shoot+1]=3;
								   		x=0;
								   		hit=0;
								    		
								    	}
								    
					    	 }else{
					    		 x=0;
					    		 hit=0;
					    	 }
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
						
						  
							
						   /**Informing who has won*/
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
							((JButton)event1.getSource()).setBackground(Color.RED);
						AIBoatPartIsHere[thisRowAI][thisColAI]=0;
						PlayerfiredHere[thisRowAI][thisColAI]=2;}
						}
					}
				 
				};
				
			gridAI[rowAI][colAI].addMouseListener(listenersAI[rowAI][colAI]);
		    }
	}

		}
	 

		
		
		
	}


