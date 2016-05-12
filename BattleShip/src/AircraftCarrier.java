import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class AircraftCarrier implements Observer {
JPanel ships;
JFrame f;
ActionEvent e;
JButton[][] grid;
MouseListener[][] listeners;
int[][] BoatPartIsHere;
int[][] AircraftCarrier;
JButton AirCraftCarrier;
int AircraftCarrierAmount;
int max;
Color Playercolor;

	public AircraftCarrier(JPanel ships,JFrame f,ActionEvent e,JButton[][] grid,int[][] BoatPartIsHere, JButton AirCraftCarrier, int max, int AircraftCarrierAmount, Color Playercolor) {
		this.ships=ships;
		this.f=f;
		this.e=e;
		this.grid=grid;
		this.BoatPartIsHere=BoatPartIsHere;
		this.AirCraftCarrier=AirCraftCarrier;
		this.max=max;
		this.AircraftCarrierAmount=AircraftCarrierAmount;
		listeners = new MouseListener[grid.length][grid[0].length];
		this.Playercolor=Playercolor;
		
	}
	

int AircraftCarriersum=0;

	@Override
	public void update() {
		int[][] AircraftCarrier = new int[max][max];
		
		 
		for (int row = 0; row < grid.length; row++) {
		    for (int col = 0; col < grid[row].length; col++){ 
			grid[row][col].setEnabled(true);
			
			
			final int thisRow = row;
			final int thisCol = col;
			
			listeners[row][col] = new MouseAdapter() {
				public void mouseClicked(MouseEvent event){		
					
					 /**Removing ship - actually function turned off*/
					 if (event.getClickCount() == 2) {
						  ((JButton)event.getSource()).setBackground(null);
						  if(thisRow+1 < grid[thisRow].length){
						  grid[thisRow+1][thisCol].setEnabled(true);
						  grid[thisRow+1][thisCol].addMouseListener(listeners[thisRow+1][thisCol]);
						  }
						  if(thisRow-1 >-1){
						  grid[thisRow-1][thisCol].setEnabled(true);
						  grid[thisRow-1][thisCol].addMouseListener(listeners[thisRow-1][thisCol]);
						  }
						  if(thisCol-1 >-1){
						  grid[thisRow][thisCol-1].setEnabled(true);
						  grid[thisRow][thisCol-1].addMouseListener(listeners[thisRow][thisCol-1]);
						  }
						  if(thisCol+1 < grid[thisCol].length){
						  grid[thisRow][thisCol+1].setEnabled(true);
						  grid[thisRow][thisCol+1].addMouseListener(listeners[thisRow][thisCol+1]);
						  }
						  
						 
						  BoatPartIsHere[thisCol][thisRow]=0;
						  AircraftCarrier[thisCol][thisRow]=0;
						  
						  
						 

						 
						  }
					
					 /**Putting ship*/
					 else if((event.getClickCount() == 1)&&(AircraftCarriersum<=(AircraftCarrierAmount*5))){

						  BoatPartIsHere[thisCol][thisRow]=1;
						  AircraftCarrier[thisCol][thisRow]=1;
						  if(thisCol-1>0){
						  if( AircraftCarrier[thisCol-1][thisRow]!=1){	
							  AircraftCarrier[thisCol-1][thisRow]=3;}}
						  else{}
						  if(thisCol+1<max){
						  if(AircraftCarrier[thisCol+1][thisRow]!=1){
							  AircraftCarrier[thisCol+1][thisRow]=3;}}
						  else{}
						  if(thisRow-1>0){
						  if(AircraftCarrier[thisCol][thisRow-1]!=1){
							  AircraftCarrier[thisCol][thisRow-1]=3;
						  }}
						  else{}
						  if(thisRow+1<max){
						  if(AircraftCarrier[thisCol][thisRow+1]!=1){
							  AircraftCarrier[thisCol][thisRow+1]=3;}}
						  else{}
						  ((JButton)event.getSource()).setBackground(Playercolor);
						  
						  AircraftCarriersum = 0;
							for (int rowa = 0; rowa < AircraftCarrier.length; rowa++) {
							    for (int cola = 0; cola < AircraftCarrier[rowa].length; cola++){ 
							    	if((AircraftCarrier[rowa][cola]!=3) &&(AircraftCarrier[rowa][cola]!=4) ){
							    		AircraftCarriersum+=AircraftCarrier[rowa][cola];
							    	}
							    }
							}
						

						 
							  if(AircraftCarriersum<(AircraftCarrierAmount*5)){
								  for (int rowa = 0; rowa < AircraftCarrier.length; rowa++) {
									    for (int cola = 0; cola < AircraftCarrier[rowa].length; cola++){ 
									    	if (AircraftCarrier[rowa][cola]==3){
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
						  if((AircraftCarriersum==5)||(AircraftCarriersum==10)||(AircraftCarriersum==15)||(AircraftCarriersum==20)||(AircraftCarriersum==25)){
							  
							  for (int rowa = 0; rowa < AircraftCarrier.length; rowa++) {
								    for (int cola = 0; cola < AircraftCarrier[rowa].length; cola++){ 
								    	
								    	if (AircraftCarrier[rowa][cola]==3){
								    		grid[cola][rowa].removeMouseListener(listeners[cola][rowa]);
								    		 grid[cola][rowa].setEnabled(false);
								    		 AircraftCarrier[rowa][cola]=4;
								    	}
								    	else if(AircraftCarrier[rowa][cola]==0){
								    		grid[cola][rowa].addMouseListener(listeners[cola][rowa]);
								    
								    		 grid[cola][rowa].setEnabled(true);}
								    	}
								    	}
							  
						  }
						  if(AircraftCarriersum==(AircraftCarrierAmount*5)){		 
							  AirCraftCarrier.setEnabled(false);
							  for (int rowa = 0; rowa < BoatPartIsHere.length; rowa++) {
									for (int cola = 0; cola < BoatPartIsHere[rowa].length; cola++){ 
										if((BoatPartIsHere[rowa][cola]==0)||(BoatPartIsHere[rowa][cola]==3)){
											grid[cola][rowa].setEnabled(false);
											grid[cola][rowa].removeMouseListener(listeners[cola][rowa]);}}}
						  
						  
						  }
						  
			}}};
			if(AircraftCarrierAmount!=0){
			if(AircraftCarriersum<1){
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