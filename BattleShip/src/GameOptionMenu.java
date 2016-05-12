import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


	public class GameOptionMenu extends Observable implements Observer, ActionListener,ChangeListener{
		JPanel MenuPanel;
		JFrame GameMenu;
		public JComboBox BoardSize;
		public String ChoosenBoardSize;
		public JSlider sliderPatrolBoat;
		public JSlider sliderDestroyer;
		public JSlider sliderBattleship;
		public JSlider sliderAircraftCarrier;
		String Small="Small";
		String Medium="Medium";
		String Large="Large";
		Color background;
		Color AIbackground;		
		Color Playercolor;
		Color AiColor;
		public GameOptionMenu(JPanel MenuPanel,JFrame GameMenu,JComboBox BoardSize,JSlider sliderPatrolBoat,JSlider sliderDestroyer,JSlider sliderBattleship,JSlider sliderAircraftCarrier){
			this.MenuPanel=MenuPanel;
			this.GameMenu=GameMenu;
			this.BoardSize=BoardSize;
			this.sliderPatrolBoat=sliderPatrolBoat;
			this.sliderDestroyer=sliderDestroyer;
			this.sliderBattleship=sliderBattleship;
			this.sliderAircraftCarrier=sliderAircraftCarrier;
			
		}
		

		@Override
		public void update() {
			
			
			MenuPanel.setVisible(false);
			JPanel StartGame= new JPanel(new GridLayout());
			JPanel ShipsAmount = new JPanel(new GridLayout(4,2));
			JPanel BoardSizeChoosing = new JPanel(new GridLayout(2,1));
			
			/**Start The Game*/
			 JButton Single = new JButton("Start");
			 StartGame.add(Single);
			 Single.addActionListener(new ActionListener(){
				 
				 @Override
					public void actionPerformed(ActionEvent e) {
					 String ChoosenSize = (String)BoardSize.getSelectedItem();
					 int PatrolBoatsAmount=sliderPatrolBoat.getValue();
						int DestroyersAmount=sliderDestroyer.getValue();
						int BattleShipAmount=sliderBattleship.getValue();
						int AircraftCarrierAmount=sliderAircraftCarrier.getValue();
						int sumofBoatsElements=(AircraftCarrierAmount*5)+(BattleShipAmount*4)+(DestroyersAmount*3)+(PatrolBoatsAmount*2);
						int sumOfBoats=PatrolBoatsAmount+DestroyersAmount+BattleShipAmount+AircraftCarrierAmount;
						if((Playercolor==null)||(AiColor==null)){
							{JOptionPane.showMessageDialog(GameMenu,
							        "<html>No Color Choosen"
							        + "<br>"
							        +" You need To choose color of ships</html");}	
							      
							
						}
						else{
						if(ChoosenSize.equals(Small)){
							if(sumOfBoats>1){
								{JOptionPane.showMessageDialog(GameMenu,
								        "<html>Too many ships."
								        + "<br>"
								        +" Only one ship allowed on small board"	
								        +"<br>"
								        + "Take less or choose larger board</html>");}}
								else{
						
						if(sumofBoatsElements>0){
					 Battleship Battleship = new Battleship(GameMenu,BoardSize,sliderPatrolBoat, sliderDestroyer, sliderBattleship, sliderAircraftCarrier,background,Playercolor,AiColor);
									
									  notifyObserver(Battleship);}
						else{
							JOptionPane.showMessageDialog(GameMenu,
							        "You need to choose at least one ship");
						}}}
						if(ChoosenSize.equals(Medium)){
							if(sumofBoatsElements>10){
								{JOptionPane.showMessageDialog(GameMenu,
								        "<html>Too many ships."
								        + "<br>"
								        + "Take less or choose larger board</html>");}}
								else{
						
						if(sumofBoatsElements>0){
					 Battleship Battleship = new Battleship(GameMenu,BoardSize,sliderPatrolBoat, sliderDestroyer, sliderBattleship, sliderAircraftCarrier,background,Playercolor,AiColor);
									
									  notifyObserver(Battleship);}
						else{
							JOptionPane.showMessageDialog(GameMenu,
							        "You need to choose at least one ship");
						}}
						}
						if(ChoosenSize.equals(Large)){
							if(sumofBoatsElements>25){
								{JOptionPane.showMessageDialog(GameMenu,
								        "<html>Too many ships."
								        + "<br>"
								        + "Take less.</html>");}}
								else{
						
						if(sumofBoatsElements>0){
					 Battleship Battleship = new Battleship(GameMenu,BoardSize,sliderPatrolBoat, sliderDestroyer, sliderBattleship, sliderAircraftCarrier,background,Playercolor,AiColor);
									
									  notifyObserver(Battleship);}
						else{
							JOptionPane.showMessageDialog(GameMenu,
							        "You need to choose at least one ship");
						}}
						}
						
						}}});
			 
			/**Choosing Amount of Ships*/
			ShipsAmount.setBounds(10, 200, 200, 100);
			StartGame.setBounds(350,10,80,30);
			JButton AircraftCarrier = new JButton("Aircraft Carrier");
			sliderAircraftCarrier=new JSlider(0,5);
			sliderAircraftCarrier.setMajorTickSpacing(1);
			sliderAircraftCarrier.setPaintLabels(true);
			sliderAircraftCarrier.setPaintTicks(true);
			sliderAircraftCarrier.addChangeListener(this);
			JButton BattleShip = new JButton("BattleShip");
			sliderBattleship=new JSlider(0,5);
			sliderBattleship.setMajorTickSpacing(1);
			sliderBattleship.setPaintLabels(true);
			sliderBattleship.setPaintTicks(true);
			sliderBattleship.addChangeListener(this);
			JButton Destroyer = new JButton("Destroyer");
			sliderDestroyer=new JSlider(0,5);
			sliderDestroyer.setMajorTickSpacing(1);
			sliderDestroyer.setPaintLabels(true);
			sliderDestroyer.setPaintTicks(true);
			sliderDestroyer.addChangeListener(this);
			JButton PatrolBoat = new JButton("Patrol Boat");
			sliderPatrolBoat=new JSlider(0,5);
			sliderPatrolBoat.setMajorTickSpacing(1);
			sliderPatrolBoat.setPaintLabels(true);
			sliderPatrolBoat.setPaintTicks(true);
			sliderPatrolBoat.addChangeListener(this);
			
			/**Choosing board size*/
			String[] BoardSizes = { "Small","Medium", "Large"};
			BoardSize = new JComboBox(BoardSizes);
			BoardSize.setSelectedIndex(2);
			BoardSize.addActionListener(this);
			JLabel LabelBoardSize = new JLabel("Choose size of the board:");
			
			/**Choosing Colors*/
			/**Player Color*/
			JLabel PlayerColor=new JLabel("Choose color of Your Ship");
			JButton button = new JButton();

		    ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        Color initialBackground = button.getBackground();
		        Color background = JColorChooser.showDialog(null, "JColorChooser Sample", initialBackground);
		        if (background != null) {
		          button.setBackground(background);
		          Playercolor = button.getBackground();
		         
		          
		        }
		      }
		    };
		    button.addActionListener(actionListener);
		    JPanel colorchoose = new JPanel(new GridLayout(2,1));
		    colorchoose.setVisible(true);
		    colorchoose.setBounds(10,15,200,50);
		    colorchoose.add(PlayerColor);
		    colorchoose.add(button);
			
		    
			/**AI Color*/
			JLabel AIColor=new JLabel("Choose color of AI Ship");
			JButton button2 = new JButton();

		    ActionListener AIactionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        Color AIinitialBackground = button2.getBackground();
		        Color AIbackground = JColorChooser.showDialog(null, "JColorChooser Sample", AIinitialBackground);
		        if (AIbackground != null) {
		          button2.setBackground(AIbackground);
		          AiColor = button2.getBackground();
		      	GameOptionMenu sizeships = new GameOptionMenu(MenuPanel,GameMenu,BoardSize,sliderPatrolBoat,sliderDestroyer,sliderBattleship,sliderAircraftCarrier);	
		        }
		      }
		    };
		    button2.addActionListener(AIactionListener);
		    JPanel colorchooseAI = new JPanel(new GridLayout(2,1));
		    colorchooseAI.setVisible(true);
		    colorchooseAI.setBounds(500,15,200,50);
		    colorchooseAI.add(AIColor);
		    colorchooseAI.add(button2);
			
			
			/**Adding all components to panels
			 * Setting size of all panels
			 */
			BoardSizeChoosing.add(LabelBoardSize);
			BoardSizeChoosing.add(BoardSize);	
			GameMenu.add(colorchoose);
			GameMenu.add(colorchooseAI);
			GameMenu.add(ShipsAmount);
			GameMenu.add(StartGame);
			GameMenu.add(BoardSizeChoosing);
			ShipsAmount.add(AircraftCarrier);
			ShipsAmount.add(sliderAircraftCarrier);
			ShipsAmount.add(BattleShip);
			ShipsAmount.add(sliderBattleship);
			ShipsAmount.add(Destroyer);
			ShipsAmount.add(sliderDestroyer);
			ShipsAmount.add(PatrolBoat);
			ShipsAmount.add(sliderPatrolBoat);
			ShipsAmount.setVisible(true);
			StartGame.setVisible(true);
			BoardSizeChoosing.setVisible(true);
			BoardSizeChoosing.setBounds(350,200,200,50);
			ShipsAmount.setBounds(10, 200, 300, 160);
			StartGame.setBounds(350,10,80,30);
		
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			BoardSize = (JComboBox)e.getSource();
	        GameOptionMenu size = new GameOptionMenu(MenuPanel,GameMenu,BoardSize,sliderPatrolBoat,sliderDestroyer,sliderBattleship,sliderAircraftCarrier);
	       
		}


		@Override
		public void stateChanged(ChangeEvent e) {
			GameOptionMenu sizeships = new GameOptionMenu(MenuPanel,GameMenu,BoardSize,sliderPatrolBoat,sliderDestroyer,sliderBattleship,sliderAircraftCarrier);	
			
		}


	
		
	}


