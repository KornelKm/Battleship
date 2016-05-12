import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Battleship extends Observable implements Observer {
	
	JFrame GameMenu;
	String ChoosenBoardSize;
	JComboBox BoardSize;
	String Small = "Small";
	String Medium = "Medium";
	String Large = "Large";
	int[][] BoatPartIsHere;
	int[][] AIBoatPartIsHere;
	int[][]AIfiredHere;
	JButton[][] grid;
	JFrame f;
	JPanel panel2;
	JPanel panel1;
	JButton[][] gridAI;
	public int max;
	JSlider sliderPatrolBoat;
	JSlider sliderDestroyer;
	JSlider sliderBattleship;
	JSlider sliderAircraftCarrier;
private Color background;
Color Playercolor;
Color AiColor;
		
		public Battleship(JFrame gameMenu, JComboBox BoardSize,JSlider sliderPatrolBoat,JSlider sliderDestroyer,JSlider sliderBattleship,JSlider sliderAircraftCarrier, Color background, Color Playercolor,Color AiColor) {
		this.GameMenu=GameMenu;
		this.BoardSize=BoardSize;
		this.sliderPatrolBoat=sliderPatrolBoat;
		this.sliderDestroyer=sliderDestroyer;
		this.sliderBattleship=sliderBattleship;
		this.sliderAircraftCarrier=sliderAircraftCarrier;
		this.background=background;
		this.Playercolor=Playercolor;
		this.AiColor=AiColor;


	}

		@Override
		public void update() {			
		
			String ChoosenSize = (String)BoardSize.getSelectedItem();
			int PatrolBoatsAmount=sliderPatrolBoat.getValue();
			int DestroyersAmount=sliderDestroyer.getValue();
			int BattleShipAmount=sliderBattleship.getValue();
			int AircraftCarrierAmount=sliderAircraftCarrier.getValue();
	
			
/**Ships choosing*/
		
JPanel ships = new JPanel(new GridLayout(1,4));
JButton AirCraftCarrier = new JButton("Aircraft Carrier");
if(AircraftCarrierAmount==0){
	AirCraftCarrier.setEnabled(false);
}
JButton BattleShip = new JButton("BattleShip");
if(BattleShipAmount==0){
	BattleShip.setEnabled(false);
}
JButton Destroyer = new JButton("Destroyer");
if(DestroyersAmount==0){
	Destroyer.setEnabled(false);
}
JButton PatrolBoat = new JButton("Patrol Boat");
if(PatrolBoatsAmount==0){
	PatrolBoat.setEnabled(false);
}
JButton Instructions = new JButton("Instructions");
ships.add(PatrolBoat);
ships.add(Destroyer);
ships.add(BattleShip);
ships.add(AirCraftCarrier);


/**Board Size =small*/
if (ChoosenSize.equals(Small)){
	max=7;
BoatPartIsHere = new int[7][7];
AIBoatPartIsHere = new int[7][7];
		/**Creating Frame & Panel*/
f = new JFrame();
f.setLayout(null);
f.setTitle("Battleships");
JPanel panel1 = new JPanel(new GridLayout(7,7));
panel1.setBorder(BorderFactory.createLineBorder(Color.black));
/**Grid,field etc*/
grid = new JButton[7][7];
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
panel2 = new JPanel(new GridLayout(7,7));
panel2.setBorder(BorderFactory.createLineBorder(Color.black));
/**Grid,field etc*/
gridAI = new JButton[7][7];
for (int rowAI = 0; rowAI < gridAI.length; rowAI++) {
    for (int colAI = 0; colAI < gridAI[rowAI].length; colAI++){ 
	gridAI[rowAI][colAI] = new JButton();
	gridAI[rowAI][colAI].setEnabled(false);
    panel2.add(gridAI[rowAI][colAI]);
	
    }
}	
panel1.setBounds(50, 100, 300, 300);
panel2.setBounds(400, 100, 300, 300);
f.add(panel1);
f.add(panel2); 
}

/**Board Size=Medium*/
if (ChoosenSize.equals(Medium)){
	max=8;
BoatPartIsHere = new int[8][8];
AIBoatPartIsHere = new int[8][8];
		/**Creating Frame & Panel*/
f = new JFrame();
f.setLayout(null);
f.setTitle("Battleships");
JPanel panel1 = new JPanel(new GridLayout(8,8));
panel1.setBorder(BorderFactory.createLineBorder(Color.black));
/**Grid,field etc*/
grid = new JButton[8][8];
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
panel2 = new JPanel(new GridLayout(8,8));
panel2.setBorder(BorderFactory.createLineBorder(Color.black));
/**Grid,field etc*/
gridAI = new JButton[8][8];
for (int rowAI = 0; rowAI < gridAI.length; rowAI++) {
    for (int colAI = 0; colAI < gridAI[rowAI].length; colAI++){ 
	gridAI[rowAI][colAI] = new JButton();
	gridAI[rowAI][colAI].setEnabled(false);
    panel2.add(gridAI[rowAI][colAI]);
	
    }
}	
panel1.setBounds(50, 100, 300, 300);
panel2.setBounds(400, 100, 300, 300);
f.add(panel1);
f.add(panel2); 
}

/**Board Size=Large*/
if (ChoosenSize.equals(Large)){
	max=10;
BoatPartIsHere = new int[10][10];
AIBoatPartIsHere = new int[10][10];
		/**Creating Frame & Panel*/
f = new JFrame();
f.setLayout(null);
f.setTitle("Battleships");
JPanel panel1 = new JPanel(new GridLayout(10,10));
panel1.setBorder(BorderFactory.createLineBorder(Color.black));
/**Grid,field etc*/
grid = new JButton[10][10];
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
panel2 = new JPanel(new GridLayout(10,10));
panel2.setBorder(BorderFactory.createLineBorder(Color.black));
/**Grid,field etc*/
gridAI = new JButton[10][10];
for (int rowAI = 0; rowAI < gridAI.length; rowAI++) {
    for (int colAI = 0; colAI < gridAI[rowAI].length; colAI++){ 
	gridAI[rowAI][colAI] = new JButton();
	gridAI[rowAI][colAI].setEnabled(false);
    panel2.add(gridAI[rowAI][colAI]);
	
    }
}	
panel1.setBounds(50, 100, 300, 300);
panel2.setBounds(400, 100, 300, 300);
f.add(panel1);
f.add(panel2); 
}


    /**Aircraft Carrier choosing*/
    AirCraftCarrier.addActionListener(new ActionListener(){
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			
						AircraftCarrier AircraftCarrier = new AircraftCarrier(ships,f,e,grid,BoatPartIsHere,AirCraftCarrier,max,AircraftCarrierAmount,Playercolor);
						
							  notifyObserver(AircraftCarrier);
							 
						  }});
			
			

    /**BattleShip choosing*/
BattleShip.addActionListener(new ActionListener(){
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			
						BattleShipO BattleShipO = new BattleShipO(ships,f,e,grid,BoatPartIsHere, BattleShip,max,BattleShipAmount,Playercolor);
						
						  notifyObserver(BattleShipO);
		}});
    
/**Patrol Boat choosing*/
int PatrolBoatIsHeresum;
PatrolBoat.addActionListener(new ActionListener(){
   	
		@Override
		public void actionPerformed(ActionEvent e) {
			
						PatrolBoatO PatrolBoatO = new PatrolBoatO(ships,f,e,grid,BoatPartIsHere,PatrolBoat,max,PatrolBoatsAmount,Playercolor);
						
						  notifyObserver(PatrolBoatO);}});
/**Destroyer choosing*/
Destroyer.addActionListener(new ActionListener(){
   	
		@Override
		public void actionPerformed(ActionEvent e) {
			
						DestroyerO DestroyerO = new DestroyerO(ships,f,e,grid,BoatPartIsHere,Destroyer,max,DestroyersAmount,Playercolor);
						
						  notifyObserver(DestroyerO);
		}});
			



/**Starting the game:*/
JPanel gamepanel = new JPanel(new GridLayout());
 JButton Gamep = new JButton("Start");
 gamepanel.add(Gamep);
 Gamep.addActionListener(new ActionListener(){
 
 @Override
	public void actionPerformed(ActionEvent e) {
		
					Game Game = new Game(ships,f,e,grid, gridAI,AirCraftCarrier,BattleShip,Destroyer,PatrolBoat,Gamep,BoatPartIsHere,AIBoatPartIsHere, max,AiColor);
					
					  notifyObserver(Game);
					  AIShips AIShips = new AIShips(AIBoatPartIsHere,max,PatrolBoatsAmount,DestroyersAmount,BattleShipAmount,AircraftCarrierAmount);
					  notifyObserver(AIShips);
	}});
 

 /**Frame with instructions*/
 JPanel InstructionColors=new JPanel(new GridLayout(4,2));
 InstructionColors.setBorder(BorderFactory.createLineBorder(Color.black));
 InstructionColors.setVisible(true);
 JButton GREEN = new JButton();
 JLabel GREEN2 = new JLabel("Your Ships");
 GREEN.setBackground(Playercolor);
 GREEN.setSize(10, 10);
 JButton RED = new JButton();
 JLabel RED2 = new JLabel("Enemy Ships");
 RED.setBackground(AiColor);
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
 
 
 
/** Parameters of panels, frame etc.*/
 

 ships.setBounds(100, 5, 500, 20);
 gamepanel.setBounds(335,30,80,30);
 InstructionColors.setBounds(335,420,250,50);

f.add(gamepanel);
f.add(ships);
 
f.add(InstructionColors);
f.setSize(800, 600);
f.setVisible(true);


}

	
		
	}

		
	
