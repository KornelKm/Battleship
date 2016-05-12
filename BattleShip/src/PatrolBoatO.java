import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PatrolBoatO implements Observer {
	JPanel ships;
	JFrame f;
	ActionEvent e;
	JButton[][] grid;
	MouseListener[][] listeners;
	JButton PatrolBoat;
    int[][] BoatPartIsHere;
    int max;
    int PatrolBoatsAmount;
    int [][] PatrolBoatIsHere;
    Color Playercolor;
	public PatrolBoatO(JPanel ships,JFrame f,ActionEvent e,JButton[][] grid, int[][] BoatPartIsHere,JButton PatrolBoat,int max, int PatrolBoatsAmount, Color Playercolor) {
		this.ships=ships;
		this.f=f;
		this.e=e;
		this.grid=grid;
		this.PatrolBoat=PatrolBoat;
		this.BoatPartIsHere=BoatPartIsHere;
		this.max=max;
		this.PatrolBoatsAmount=PatrolBoatsAmount;
		listeners = new MouseListener[grid.length][grid[0].length];
		this.Playercolor=Playercolor;
	}
	int PatrolBoatIsHeresum=0;
	@Override
	public void update() {
		
		 
		int [][] PatrolBoatIsHere= new int[max][max];
		 
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
			  PatrolBoatIsHere[thisCol][thisRow]=0;
			 

			 
			  }
		
		/**Putting Ship*/ 
		 else if((event.getClickCount() == 1)&&(PatrolBoatIsHeresum<=(PatrolBoatsAmount*2))){

			  BoatPartIsHere[thisCol][thisRow]=1;
			  PatrolBoatIsHere[thisCol][thisRow]=1;
			  if(thisCol-1>-1){
			  if( PatrolBoatIsHere[thisCol-1][thisRow]!=1){	
				  PatrolBoatIsHere[thisCol-1][thisRow]=3;}}
			  else{}
			  if(thisCol+1<max){
			  if(PatrolBoatIsHere[thisCol+1][thisRow]!=1){
				  PatrolBoatIsHere[thisCol+1][thisRow]=3;}}
			  else{}
			  if(thisRow-1>-1){
			  if(PatrolBoatIsHere[thisCol][thisRow-1]!=1){
				  PatrolBoatIsHere[thisCol][thisRow-1]=3;
			  }}
			  else{}
			  if(thisRow+1<max){
			  if(PatrolBoatIsHere[thisCol][thisRow+1]!=1){
				  PatrolBoatIsHere[thisCol][thisRow+1]=3;}}
			  else{}
			  ((JButton)event.getSource()).setBackground(Playercolor);
			  
			  PatrolBoatIsHeresum = 0;
				for (int rowa = 0; rowa < PatrolBoatIsHere.length; rowa++) {
				    for (int cola = 0; cola < PatrolBoatIsHere[rowa].length; cola++){ 
				    	if((PatrolBoatIsHere[rowa][cola]!=3) &&(PatrolBoatIsHere[rowa][cola]!=4) ){
				    		PatrolBoatIsHeresum+=PatrolBoatIsHere[rowa][cola];
				    	}
				    }
				}
			

			 
				  if(PatrolBoatIsHeresum<(PatrolBoatsAmount*2)){
					  for (int rowa = 0; rowa < PatrolBoatIsHere.length; rowa++) {
						    for (int cola = 0; cola < PatrolBoatIsHere[rowa].length; cola++){ 
						    	if (PatrolBoatIsHere[rowa][cola]==3){
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
			  if((PatrolBoatIsHeresum==2)||(PatrolBoatIsHeresum==4)||(PatrolBoatIsHeresum==6)||(PatrolBoatIsHeresum==8)) {
				  for (int rowa = 0; rowa < PatrolBoatIsHere.length; rowa++) {
					    for (int cola = 0; cola < PatrolBoatIsHere[rowa].length; cola++){ 
					    	
					    	if (PatrolBoatIsHere[rowa][cola]==3){
					    		grid[cola][rowa].removeMouseListener(listeners[cola][rowa]);
					    		 grid[cola][rowa].setEnabled(false);
					    		 PatrolBoatIsHere[rowa][cola]=4;
					    	}
					    	else if(PatrolBoatIsHere[rowa][cola]==0){
					    		grid[cola][rowa].addMouseListener(listeners[cola][rowa]);
					    
					    		 grid[cola][rowa].setEnabled(true);}
					    	}
					    	}
				  
			  }
			  if(PatrolBoatIsHeresum==(PatrolBoatsAmount*2)){
				  PatrolBoat.setEnabled(false);
				  for (int rowa = 0; rowa < BoatPartIsHere.length; rowa++) {
						for (int cola = 0; cola < BoatPartIsHere[rowa].length; cola++){ 
							if((BoatPartIsHere[rowa][cola]==0)||(BoatPartIsHere[rowa][cola]==3)){
								grid[cola][rowa].setEnabled(false);
								grid[cola][rowa].removeMouseListener(listeners[cola][rowa]);}}}
			  
			  }
			  
}}};
if(PatrolBoatsAmount!=0){
if(PatrolBoatIsHeresum<1){
grid[row][col].addMouseListener(listeners[row][col]);
}}

}}
for (int rowa = 0; rowa < BoatPartIsHere.length; rowa++) {
for (int cola = 0; cola < BoatPartIsHere[rowa].length; cola++){ 
	if(BoatPartIsHere[rowa][cola]==1){
		grid[cola][rowa].setEnabled(true);
		grid[cola][rowa].addMouseListener(listeners[cola][rowa]);
          
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