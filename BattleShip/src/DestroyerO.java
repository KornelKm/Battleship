import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DestroyerO implements Observer {
	JPanel ships;
	JFrame f;
	ActionEvent e;
	JButton[][] grid;
	MouseListener[][] listeners;
	int[][] BoatPartIsHere;
	JButton Destroyer;
	int max;
	int [][] DestroyerBoatIsHere;
	public int size=0;
	int DestroyersAmount;
	Color Playercolor;
	public DestroyerO(JPanel ships,JFrame f,ActionEvent e,JButton[][] grid,int[][]BoatPartIsHere,JButton Destroyer, int max, int DestroyersAmount, Color Playercolor) {
		this.ships=ships;
		this.f=f;
		this.e=e;
		this.grid=grid;
		this.Destroyer=Destroyer;
		this.BoatPartIsHere=BoatPartIsHere;
		this.max=max;
		this.DestroyersAmount=DestroyersAmount;
		listeners = new MouseListener[grid.length][grid[0].length];
		this.Playercolor=Playercolor;
		
	}
	int DestroyerElements =0;
	int DestroyerBoatIsHeresum =0;
	@Override
	public void update() {
		int [][] DestroyerBoatIsHere= new int[max][max];

		
		 
		for (int row = 0; row < grid.length; row++) {
		    for (int col = 0; col < grid[row].length; col++){ 
			grid[row][col].setEnabled(true);
			
			
			final int thisRow = row;
			final int thisCol = col;
			
			listeners[row][col] = new MouseAdapter() {
				public void mouseClicked(MouseEvent event){		
					
			
					
					
					
					/**Removing Ship - actually function turned off*/
					 if (event.getClickCount() == 2) {
						  ((JButton)event.getSource()).setBackground(null);
						  if(thisRow+1 < grid[thisRow].length){
						  grid[thisRow+1][thisCol].setEnabled(true);
						  grid[thisRow+1][thisCol].addMouseListener(listeners[thisRow+1][thisCol]);
						  }
						  if(thisRow-1 >= 0){
						  grid[thisRow-1][thisCol].setEnabled(true);
						  grid[thisRow-1][thisCol].addMouseListener(listeners[thisRow-1][thisCol]);
						  }
						  if(thisCol-1 >= 0){
						  grid[thisRow][thisCol-1].setEnabled(true);
						  grid[thisRow][thisCol-1].addMouseListener(listeners[thisRow][thisCol-1]);
						  }
						  if(thisCol+1 < grid[thisCol].length){
						  grid[thisRow][thisCol+1].setEnabled(true);
						  grid[thisRow][thisCol+1].addMouseListener(listeners[thisRow][thisCol+1]);
						  }
						  
						 
						  BoatPartIsHere[thisCol][thisRow]=0;
						  DestroyerBoatIsHere[thisCol][thisRow]=0;
						  
						 

						 
						  }
					
					 /**Adding ship*/
					  else if((event.getClickCount() == 1)&&(DestroyerBoatIsHeresum<=(DestroyersAmount*3))){

						  BoatPartIsHere[thisCol][thisRow]=1;
						  DestroyerBoatIsHere[thisCol][thisRow]=1;
						  if(thisCol-1>-1){
						  if( DestroyerBoatIsHere[thisCol-1][thisRow]!=1){					
						  DestroyerBoatIsHere[thisCol-1][thisRow]=3;}}
						  else{}
						  if(thisCol+1<max){
						  if(DestroyerBoatIsHere[thisCol+1][thisRow]!=1){
						  DestroyerBoatIsHere[thisCol+1][thisRow]=3;}}
						  else{
						  }
						  if(thisRow-1>-1){
						  if(DestroyerBoatIsHere[thisCol][thisRow-1]!=1){							  
						  DestroyerBoatIsHere[thisCol][thisRow-1]=3;}
						  }
						  else{}
						  if(thisRow+1<max){
						  if(DestroyerBoatIsHere[thisCol][thisRow+1]!=1){
						  DestroyerBoatIsHere[thisCol][thisRow+1]=3;}}
						  else{}
						  ((JButton)event.getSource()).setBackground(Playercolor);
						  
						  /**Checking amount of ships*/
						  DestroyerBoatIsHeresum = 0;
							for (int rowa = 0; rowa < DestroyerBoatIsHere.length; rowa++) {
							    for (int cola = 0; cola < DestroyerBoatIsHere[rowa].length; cola++){ 
							    	if((DestroyerBoatIsHere[rowa][cola]!=3) &&(DestroyerBoatIsHere[rowa][cola]!=4) ){
							    	DestroyerBoatIsHeresum+=DestroyerBoatIsHere[rowa][cola];
							    	}
							    }
							}
						
			 
						 
							  if(DestroyerBoatIsHeresum<(DestroyersAmount*3)){
								  for (int rowa = 0; rowa < DestroyerBoatIsHere.length; rowa++) {
									    for (int cola = 0; cola < DestroyerBoatIsHere[rowa].length; cola++){ 
									    	if (DestroyerBoatIsHere[rowa][cola]==3){
									    		grid[cola][rowa].addMouseListener(listeners[cola][rowa]);
									    		 grid[cola][rowa].setEnabled(true);
									    		 
									    		 
									    	}
									    	else{
									    		grid[cola][rowa].removeMouseListener(listeners[cola][rowa]);
									    		 grid[cola][rowa].setEnabled(false);
									    		
									    	}
									    	}
									    }
						  
						 
						  }
						  if((DestroyerBoatIsHeresum==3)||(DestroyerBoatIsHeresum==6)||(DestroyerBoatIsHeresum==9)||(DestroyerBoatIsHeresum==12)) {							 
							  for (int rowa = 0; rowa < DestroyerBoatIsHere.length; rowa++) {
								    for (int cola = 0; cola < DestroyerBoatIsHere[rowa].length; cola++){ 
								    	
								    	if (DestroyerBoatIsHere[rowa][cola]==3){
								    		grid[cola][rowa].removeMouseListener(listeners[cola][rowa]);
								    		 grid[cola][rowa].setEnabled(false);
								    		 DestroyerBoatIsHere[rowa][cola]=4;
								    	}
								    	else if(DestroyerBoatIsHere[rowa][cola]==0){
								    		grid[cola][rowa].addMouseListener(listeners[cola][rowa]);
								    
								    		 grid[cola][rowa].setEnabled(true);}
								    	}
								    	}
							  
						  }
						  if(DestroyerBoatIsHeresum==(DestroyersAmount*3)){
							  Destroyer.setEnabled(false);
							  for (int rowa = 0; rowa < BoatPartIsHere.length; rowa++) {
									for (int cola = 0; cola < BoatPartIsHere[rowa].length; cola++){ 
										if((BoatPartIsHere[rowa][cola]==0)||(BoatPartIsHere[rowa][cola]==3)){
											grid[cola][rowa].setEnabled(false);
											grid[cola][rowa].removeMouseListener(listeners[cola][rowa]);}}}
						  
						  }
						  
		  }}};
		  if(DestroyersAmount!=0){
		  if(DestroyerBoatIsHeresum<1){
		  grid[row][col].addMouseListener(listeners[row][col]);
		  }}
		    
		    }}
		for (int rowa = 0; rowa < BoatPartIsHere.length; rowa++) {
		    for (int cola = 0; cola < BoatPartIsHere[rowa].length; cola++){ 
		    	if(BoatPartIsHere[rowa][cola]==1){
		    		grid[cola][rowa].setEnabled(false);
		    		grid[cola][rowa].removeMouseListener(listeners[cola][rowa]);
                       
		    		if(rowa+1<grid[rowa].length){
		    		  grid[cola][rowa+1].setEnabled(false);
					  grid[cola][rowa+1].removeMouseListener(listeners[cola][rowa+1]);
		    		}
					  if(rowa-1 >= 0){
					  grid[cola][rowa-1].setEnabled(false);
					  grid[cola][rowa-1].removeMouseListener(listeners[cola][rowa-1]);
					  }
					  if(cola-1 >= 0){
					  grid[cola-1][rowa].setEnabled(false);
					  grid[cola-1][rowa].removeMouseListener(listeners[cola-1][rowa]);
					  }
					  if(cola+1 < grid[cola].length){
					  grid[cola+1][rowa].setEnabled(false);
					  grid[cola+1][rowa].removeMouseListener(listeners[cola+1][rowa]);
					  } }}
		    	}
		/**Updating Frame*/
			f.revalidate();
			f.repaint();
			
		}}