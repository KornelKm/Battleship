import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AIShips implements Observer {
	int[][] AIBoatPartIsHere;
	 String ChoosenSize;
	int max;
	int PatrolBoatsAmount;
	int DestroyersAmount;
	int BattleShipAmount;
	int AircraftCarrierAmount;
	long startTime;
	long endTime;
	int tries;
	boolean shipfits;
	
	public AIShips(int[][] AIBoatPartIsHere, int max, int PatrolBoatsAmount, int DestroyersAmount, int BattleShipAmount, int AircraftCarrierAmount) {
		this.AIBoatPartIsHere=AIBoatPartIsHere;
		this.max=max;
		this.PatrolBoatsAmount=PatrolBoatsAmount;
		this.DestroyersAmount=DestroyersAmount;
		this.BattleShipAmount=BattleShipAmount;
		this.AircraftCarrierAmount=AircraftCarrierAmount;
	}

	@Override
	public void update() {

		/** AI sets ships by random: */
		/** 1 is for ship
		 * 3 is for water-required 1 square space between ships
		 * Whenever ship is going to be set, program by random decides if the ship
		 * will be in vertical or in level
		 * then it looks for free space on the board(ship can't be set on 1(another ship)
		 * or on 3(required space) but it can share required space with another ship
		 */
		
		
		/**AicrfatCarrier:*/
		
		for (int i=0;i<AircraftCarrierAmount;i++){
		
		/**VerticalLevel - decides whether ship will be placed in Level or in Vertical*/
		int VerticalLevel =ThreadLocalRandom.current().nextInt(0,2);
		
		/**Random choose first column and row from witch ship placing will starts*/
		int n3 = ThreadLocalRandom.current().nextInt(0,max);
	    int n4 = ThreadLocalRandom.current().nextInt(0,max);
		
		
		/**Puts ship in Level*/
		if(VerticalLevel==0){

		tries = 0;
		boolean shipset = false;

while(!shipset && tries<300){
	shipfits = false;
 
     n3 =ThreadLocalRandom.current().nextInt(0,max);
     n4 = ThreadLocalRandom.current().nextInt(2,max-2);
/**middle**/
if((n4>2)&&(n4<max-3)&&(n3<max-1)&&(n3>0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-2]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)&&(AIBoatPartIsHere[n3][n4-3]!=1)){
		shipfits=true;
		break;}
	else{
		shipfits=false;
	}

/**top-middle**/
if((n3==0)&&(n4>=3)&&(n4<max-3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)&&(AIBoatPartIsHere[n3][n4-3]!=1)){
	shipfits=true;
	break;}
 else{
 shipfits=false;
 }
/**left-top**/
if((n3==0)&&(n4==2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)){
	shipfits=true;
	break;}
else{
shipfits=false;
}


/**right-top**/
if((n3==0)&&(n4==max-3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4-3]!=1)){
	shipfits=true;
	break;}
else{
shipfits=false;
}

/**left-bottom**/
if((n3==max-1)&&(n4==2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-2]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)){
	shipfits=true;
	break;}
else{
shipfits=false;
}


	/**bottom-middle**/
if((n3==max-1)&&(n4<max-3)&&(n4>=3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-2]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)&&(AIBoatPartIsHere[n3][n4-3]!=1)){
	shipfits=true;
	break;}
else{
shipfits=false;
}
/**right-middle**/
if((n4==max-3)&&(n3<max-1)&&(n3>=1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-2]!=1)&&(AIBoatPartIsHere[n3][n4-3]!=1)){
	shipfits=true;
		break;}
else{
shipfits=false;
}
/**left-middle**/
if((n4==2)&&(n3<max-1)&&(n3>=1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-2]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)){
	shipfits=true;
	break;}
else{
shipfits=false;
}
/**right-bottom**/
if((n3==max-1)&&(n4==max-3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-2]!=1)&&(AIBoatPartIsHere[n3][n4-3]!=1)){
	shipfits=true;
	break;}
else{
shipfits=false;
}

if(shipfits==false){
tries++;
continue;

}
if(shipfits==true){
shipset=true;
break;}

}
		AIBoatPartIsHere[n3][n4-2]=1;
		AIBoatPartIsHere[n3][n4-1]=1;
		AIBoatPartIsHere[n3][n4]=1;
		AIBoatPartIsHere[n3][n4+1]=1;
		AIBoatPartIsHere[n3][n4+2]=1;

		if(n3+1<max){
			AIBoatPartIsHere[n3+1][n4-2]=3;
			AIBoatPartIsHere[n3+1][n4-1]=3;
			AIBoatPartIsHere[n3+1][n4]=3;
			AIBoatPartIsHere[n3+1][n4+1]=3;
			AIBoatPartIsHere[n3+1][n4+2]=3;
		}
		if(n3-1>-1){
			AIBoatPartIsHere[n3-1][n4-2]=3;
			AIBoatPartIsHere[n3-1][n4-1]=3;
			AIBoatPartIsHere[n3-1][n4]=3;
			AIBoatPartIsHere[n3-1][n4+1]=3;
			AIBoatPartIsHere[n3-1][n4+2]=3;
		}
		if(n4+3<max){
			AIBoatPartIsHere[n3][n4+3]=3;
		}
		if(n4-3>-1){
			AIBoatPartIsHere[n3][n4-3]=3;
		}
		}
		
		/**Puts ship in vertical*/
		if(VerticalLevel==1){
				boolean shipset = false;
				
				while(shipset==false){
				boolean shipfits = false;
				n3 =ThreadLocalRandom.current().nextInt(2,max-2);
				n4 = ThreadLocalRandom.current().nextInt(0,max);
				
				/**middle**/	
				if((n4>0)&&(n4<max-1)&&(n3>2)&&(n3<max-3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3-2][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-2][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)&&(AIBoatPartIsHere[n3-3][n4]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-2][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)){
			shipfits=true;
			break;
			}
					else{
						shipfits=false;
					}
				/**bottom-middle**/
				if((n3==max-3)&&(n4>0)&&(n4<max-1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3-2][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-2][n4+1]!=1)&&(AIBoatPartIsHere[n3-2][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)&&(AIBoatPartIsHere[n3-3][n4]!=1)){
			shipfits=true;
			break;
			}
		else{
			shipfits=false;
		}
			/**bottom-left**/	
				if((n3==max-3)&&(n4==0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3-2][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-2][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3-3][n4]!=1)){
			shipfits=true;
			break;}
		else{
				shipfits=false;			
			}
				/**bottom-right**/	
		if((n3==max-3)&&(n4==max-1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3-2][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-2][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)&&(AIBoatPartIsHere[n3-3][n4]!=1)){
			shipfits=true;
			break;
			}else{
				shipfits=false;
			}
		/**left-middle**/	
				if((n4==0)&&(n3>2)&&(n3<max-3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3-2][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-2][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)&&(AIBoatPartIsHere[n3-3][n4]!=1)){
				shipfits=true;
				break;}
		else{
				shipfits=false;
			}
				/**left-up**/		
				if((n4==0)&&(n3==3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3-2][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-2][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)){
				shipfits=true;
				break;}
		else{
				shipfits=false;
			}
				/**up-middle**/  
		if((n3==0)&&(n4>=0)&&(n4<=max-2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3-2][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-2][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-2][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)){
				shipfits=true;
				break;}
		else{
				shipfits=false;
			}
		/**right-up**/  
		if((n3==3)&&(n4==max-1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3-2][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-2][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)){
				shipfits=true;
				break;}
		else{
				shipfits=false;
			}
		/**right-middle**/
		if((n4==max-1)&&(n3<max-3)&&(n3>2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3-2][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3-2][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)&&(AIBoatPartIsHere[n3-3][n4]!=1)){
				shipfits=true;
				break;}
		else{
				shipfits=false;
			}
		
		if(!shipfits){
			continue;
		}
		if(shipfits=true){
			shipset=true;
			break;}					
				}
				AIBoatPartIsHere[n3+2][n4]=1;
				AIBoatPartIsHere[n3+1][n4]=1;
				AIBoatPartIsHere[n3][n4]=1;
				AIBoatPartIsHere[n3-1][n4]=1;
				AIBoatPartIsHere[n3-2][n4]=1;
				if(n4+1<max){
					AIBoatPartIsHere[n3+2][n4+1]=3;
					AIBoatPartIsHere[n3+1][n4+1]=3;
					AIBoatPartIsHere[n3][n4+1]=3;
					AIBoatPartIsHere[n3-1][n4+1]=3;
					AIBoatPartIsHere[n3-2][n4+1]=3;
				}
				if(n4-1>0){
					AIBoatPartIsHere[n3+2][n4-1]=3;
					AIBoatPartIsHere[n3+1][n4-1]=3;
					AIBoatPartIsHere[n3][n4-1]=3;
					AIBoatPartIsHere[n3-1][n4-1]=3;
					AIBoatPartIsHere[n3-2][n4-1]=3;
				}
				if(n3+3<max){
					AIBoatPartIsHere[n3+3][n4]=3;
				}
				if(n3-3>0){
					AIBoatPartIsHere[n3-3][n4]=3;
				}
				}
		}
		
		
		
		/**BattleShip*/
		for(int AIBattleShipBoats=0; AIBattleShipBoats<BattleShipAmount;AIBattleShipBoats++){
			
			/**VerticalLevel - decides whether ship will be placed in Level or in Vertical*/
			int VerticalLevel = ThreadLocalRandom.current().nextInt(0,2);
			
			/**Random choose first column and row from witch ship placing will starts*/
			int  n3 =ThreadLocalRandom.current().nextInt(0,max);
			int n4 = ThreadLocalRandom.current().nextInt(0,max);
			
			
			
			/**Puts ship in Level*/
			if(VerticalLevel==0){
				
				tries = 0;
				boolean shipset = false;

		while(!shipset && tries<300){
			shipfits = false;
		 
		     n3 =ThreadLocalRandom.current().nextInt(0,max);
		     n4 = ThreadLocalRandom.current().nextInt(2,max-2);
		/**middle**/
		if((n4>2)&&(n4<max-3)&&(n3<max-1)&&(n3>0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
				shipfits=true;
				break;}
			else{
				shipfits=false;
			}

		/**top-middle**/
		if((n3==0)&&(n4>=3)&&(n4<max-3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
			shipfits=true;
			break;}
		 else{
		 shipfits=false;
		 }
		/**left-top**/
		if((n3==0)&&(n4==2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}


		/**right-top**/
		if((n3==0)&&(n4==max-3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}

		/**left-bottom**/
		if((n3==max-1)&&(n4==2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}


			/**bottom-middle**/
		if((n3==max-1)&&(n4<max-3)&&(n4>=3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}
		/**right-middle**/
		if((n4==max-3)&&(n3<max-1)&&(n3>=1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3][n4-2]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
			shipfits=true;
				break;}
		else{
		shipfits=false;
		}
		/**left-middle**/
		if((n4==2)&&(n3<max-1)&&(n3>=1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+2]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4+3]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}
		/**right-bottom**/
		if((n3==max-1)&&(n4==max-3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4+2]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+2]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}

		if(shipfits==false){
		tries++;
		continue;

		}
		if(shipfits==true){
		shipset=true;
		break;}

		}
		
			AIBoatPartIsHere[n3][n4-1]=1;
			AIBoatPartIsHere[n3][n4]=1;
			AIBoatPartIsHere[n3][n4+1]=1;
			AIBoatPartIsHere[n3][n4+2]=1;
			if(n3+1<max){
				AIBoatPartIsHere[n3+1][n4-1]=3;
				AIBoatPartIsHere[n3+1][n4]=3;
				AIBoatPartIsHere[n3+1][n4+1]=3;
				AIBoatPartIsHere[n3+1][n4+2]=3;
			}
			if(n3-1>0){
				AIBoatPartIsHere[n3-1][n4-1]=3;
				AIBoatPartIsHere[n3-1][n4]=3;
				AIBoatPartIsHere[n3-1][n4+1]=3;
				AIBoatPartIsHere[n3-1][n4+2]=3;
			}
			if(n4+3>max){
				AIBoatPartIsHere[n3][n4+3]=3;
			}
			if(n4-2>0){
				AIBoatPartIsHere[n3][n4-2]=3;
			}
			}
			
			/**Puts ship in vertical*/
			if(VerticalLevel==1){
				
					boolean shipset = false;		
					while(shipset==false){
						boolean shipfits = false;
					n3 =ThreadLocalRandom.current().nextInt(2,max-2);
					n4 = ThreadLocalRandom.current().nextInt(0,max);
					
					/**middle**/	
					if((n4>0)&&(n4<max-1)&&(n3>2)&&(n3<max-3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)&&(AIBoatPartIsHere[n3-3][n4]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)){
				shipfits=true;
				break;}
						else{
							shipfits=false;
						}
					/**bottom-middle**/
					if((n3==max-3)&&(n4>0)&&(n4<max-1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)&&(AIBoatPartIsHere[n3-3][n4]!=1)){
				shipfits=true;
				break;}
			else{
				shipfits=false;
			}
			/**bottom-left**/	
					if((n3==max-3)&&(n4==0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3-2][n4]!=1)){
				shipfits=true;
				break;}
			else{
					shipfits=false;
				}
			/**bottom-right**/
			if((n3==max-3)&&(n4==max-1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)&&(AIBoatPartIsHere[n3-2][n4]!=1)){
				shipfits=true;
				break;
				}else{
					shipfits=false;}
			/**left-middle**/	
					if((n4==0)&&(n3>2)&&(n3<max-3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)&&(AIBoatPartIsHere[n3-2][n4]!=1)){
					shipfits=true;
					break;}
			else{
					shipfits=false;
					}
			/**left-up**/	
					if((n4==0)&&(n3==3)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)){
					shipfits=true;
					break;}
			else{
					shipfits=false;
					}
			/**up-middle**/   
			if((n3==0)&&(n4>=0)&&(n4<=max-2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4+1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)){
					shipfits=true;
					break;}
			else{
					shipfits=false;
			}
			/**right-up**/   
			if((n3==3)&&(n4==max-1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)){
					shipfits=true;
					break;}
			else{
					shipfits=false;					
				}
			/**right-middle**/
			if((n4==max-1)&&(n3<max-3)&&(n3>2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)&&(AIBoatPartIsHere[n3+3][n4]!=1)&&(AIBoatPartIsHere[n3-2][n4]!=1)){
					shipfits=true;
					break;}
			else{
					shipfits=false;
				}
			if(!shipfits){
				continue;
			}
			if(shipfits=true){
				shipset=true;}
					}
				
					AIBoatPartIsHere[n3+2][n4]=1;
					AIBoatPartIsHere[n3+1][n4]=1;
					AIBoatPartIsHere[n3][n4]=1;
					AIBoatPartIsHere[n3-1][n4]=1;
					if(n4+1<max){
						AIBoatPartIsHere[n3+2][n4+1]=3;
						AIBoatPartIsHere[n3+1][n4+1]=3;
						AIBoatPartIsHere[n3][n4+1]=3;
						AIBoatPartIsHere[n3-1][n4+1]=3;
					}
					if(n4-1>0){
						AIBoatPartIsHere[n3+2][n4-1]=3;
						AIBoatPartIsHere[n3+1][n4-1]=3;
						AIBoatPartIsHere[n3][n4-1]=3;
						AIBoatPartIsHere[n3-1][n4-1]=3;
					}
					if(n3+3<max){
						AIBoatPartIsHere[n3+3][n4]=3;
					}
					if(n3-3>0){
						AIBoatPartIsHere[n3-2][n4]=3;
					}
					}
			}
	
		
		
		
		
		/**Destroyer*/
		for(int AIDestroyerBoats=0; AIDestroyerBoats<DestroyersAmount;AIDestroyerBoats++){

			/**VerticalLevel - decides whether ship will be placed in Level or in Vertical*/
			int VerticalLevel = ThreadLocalRandom.current().nextInt(0,2);
			
			/**Random choose first column and row from witch ship placing will starts*/
			int n3 = ThreadLocalRandom.current().nextInt(0,max-1);
			int n4 = ThreadLocalRandom.current().nextInt(0,max-1);
			
			
			/**Puts ship in vertical*/
			if (VerticalLevel==1){
				boolean shipset = false;		
				while(shipset==false){
					boolean shipfits = false;
				n3 =ThreadLocalRandom.current().nextInt(2,max-2);
				n4 = ThreadLocalRandom.current().nextInt(0,max);
				
				/**middle**/	
				if((n4>0)&&(n4<max-1)&&(n3>1)&&(n3<max-2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)&&(AIBoatPartIsHere[n3-2][n4]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)){
			shipfits=true;
			break;}
					else{
						shipfits=false;
					}
				/**bottom-middle**/
				if((n3==max-2)&&(n4>0)&&(n4<max-1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3-2][n4]!=1)){
			shipfits=true;
			break;}
		else{
			shipfits=false;
		}
		/**bottom-left**/	
				if((n3==max-2)&&(n4==0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3-2][n4]!=1)){
			shipfits=true;
			break;}
		else{
				shipfits=false;
			}
		/**bottom-right**/
		if((n3==max-2)&&(n4==max-1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3+2][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3-2][n4]!=1)){
			shipfits=true;
			break;
			}else{
				shipfits=false;}
		/**left-middle**/	
				if((n4==0)&&(n3>2)&&(n3<max-2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)&&(AIBoatPartIsHere[n3-2][n4]!=1)){
				shipfits=true;
				break;}
		else{
				shipfits=false;
				}
		/**left-up**/	
				if((n4==0)&&(n3==2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)){
				shipfits=true;
				break;}
		else{
				shipfits=false;
				}
		/**up-middle**/   
		if((n3==1)&&(n4>0)&&(n4<max-2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4-1]!=1)){
				shipfits=true;
				break;}
		else{
				shipfits=false;
		}
		/**right-up**/   
		if((n3==1)&&(n4==max-1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)){
				shipfits=true;
				break;}
		else{
				shipfits=false;					
			}
		/**right-middle**/
		if((n4==max-1)&&(n3<max-2)&&(n3>1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3-1][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)&&(AIBoatPartIsHere[n3-2][n4]!=1)){
				shipfits=true;
				break;}
		else{
				shipfits=false;
			}
		if(!shipfits){
			continue;
		}
		if(shipfits=true){
			shipset=true;}
				}
				
			AIBoatPartIsHere[n3][n4]=1;
			AIBoatPartIsHere[n3+1][n4]=1;
			AIBoatPartIsHere[n3-1][n4]=1;
			if((n3+1<max)&&(n4-1>0)){
				AIBoatPartIsHere[n3+1][n4-1]=3;
			}
			if((n4-1>0)&&(n3-1>0)){
				AIBoatPartIsHere[n3-1][n4-1]=3;
				AIBoatPartIsHere[n3][n4-1]=3;
			}
			if(n3+2<max){
				AIBoatPartIsHere[n3+2][n4]=3;}
			if(n3-2>0){
				AIBoatPartIsHere[n3-2][n4]=3;
			}
			if((n3+1<max)&&(n4+1<max)){
				AIBoatPartIsHere[n3+1][n4+1]=3;
				AIBoatPartIsHere[n3][n4+1]=3;
			}
			if((n3-1>0)&&(n4+1<max)){
				AIBoatPartIsHere[n3-1][n4+1]=3;
			}}
			
			
			/**Puts ship in level*/
			if(VerticalLevel==0){		
				tries = 0;
				boolean shipset = false;

		while(!shipset && tries<300){
			shipfits = false;
		 
		     n3 =ThreadLocalRandom.current().nextInt(0,max);
		     n4 = ThreadLocalRandom.current().nextInt(2,max-2);
		/**middle**/
		if((n4>1)&&(n4<max-2)&&(n3<max-1)&&(n3>0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
				shipfits=true;
				break;}
			else{
				shipfits=false;
			}

		/**top-middle**/
		if((n3==0)&&(n4>1)&&(n4<max-2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
			shipfits=true;
			break;}
		 else{
		 shipfits=false;
		 }
		/**left-top**/
		if((n3==0)&&(n4==1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}


		/**right-top**/
		if((n3==0)&&(n4==max-2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}

		/**left-bottom**/
		if((n3==max-1)&&(n4==1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}


			/**bottom-middle**/
		if((n3==max-1)&&(n4<max-2)&&(n4>1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}
		/**right-middle**/
		if((n4==max-2)&&(n3<max-1)&&(n3>=1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
			shipfits=true;
				break;}
		else{
		shipfits=false;
		}
		/**left-middle**/
		if((n4==1)&&(n3<max-1)&&(n3>=1)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}
		/**right-bottom**/
		if((n3==max-1)&&(n4==max-2)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4-1]==0)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4-2]!=1)){
			shipfits=true;
			break;}
		else{
		shipfits=false;
		}

		if(shipfits==false){
		tries++;
		continue;

		}
		if(shipfits==true){
		shipset=true;
		break;}

		}
		
					AIBoatPartIsHere[n3][n4]=1;
					AIBoatPartIsHere[n3][n4-1]=1;
					AIBoatPartIsHere[n3][n4+1]=1;
					if((n3+1<max)&&(n4-1>0)){
						AIBoatPartIsHere[n3+1][n4-1]=3;
					}
					if((n4-1>0)&&(n3-1>0)){
						AIBoatPartIsHere[n3-1][n4-1]=3;
						AIBoatPartIsHere[n3-1][n4]=3;
					}
					if(n4+2<max){
						AIBoatPartIsHere[n3][n4+2]=3;}
					if(n4-2>0){
						AIBoatPartIsHere[n3][n4-2]=3;
					}
					if((n3+1<max)&&(n4+1<max)){
						AIBoatPartIsHere[n3+1][n4+1]=3;
						AIBoatPartIsHere[n3+1][n4]=3;
					}
					if((n3-1>0)&&(n4+1>0)){
						AIBoatPartIsHere[n3-1][n4+1]=3;
					}
			}
		}
		
		
		
		
		
		
		/**Patrol Boat*/
			       
		for(int AIPatolBoats=0; AIPatolBoats<PatrolBoatsAmount;AIPatolBoats++){
			
			/**VerticalLevel - decides whether ship will be placed in Level or in Vertical*/
	    int VerticalLevel =  ThreadLocalRandom.current().nextInt(0,2);
		
		/**Random choose first column and row from witch ship placing will starts*/
	    int  n3 = ThreadLocalRandom.current().nextInt(2,max);
		int n4 = ThreadLocalRandom.current().nextInt(2,max);
		
	/**Puts ship in level*/
		if (VerticalLevel==1){
			boolean shipset = false;
		while(shipset==false){
			boolean shipfits = false;
		n3 =ThreadLocalRandom.current().nextInt(0,max);
		n4 = ThreadLocalRandom.current().nextInt(0,max);
		
		if((n4>0)&&(n4<max-2)&&(n3<max-1)&&(n3>0)){
			if	((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)){
				shipfits=true;
				break;}
			else{
				shipfits=false;
			}
		}
		
		if((n3==0)&&(n4>=1)&&(n4<max-2)){
/**up-middle**/ if	((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)){
	shipfits=true;
	break;}
else{
	shipfits=false;
	
}
}
		if((n3==0)&&(n4==0)){
/**up-left**/	if ((AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)){
	shipfits=true;
	break;}else{
		shipfits=false;
	}}
if((n3==0)&&(n4==max-2)){
/**up-right**/	if ((AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)){
	shipfits=true;
	break;}else{
		shipfits=false;
		
	}}

		if((n3==max-1)&&(n4==0)){
/**bottom-left**/	if ((AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)){
	shipfits=true;
	break;}
else{
		shipfits=false;
		
	}}
		if((n3==max-1)&&(n4<max-2)&&(n4>=1)){
/**bottom-middle**/		if ((AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)){
	shipfits=true;
	break;}else{
		shipfits=false;
		
	}}
if((n4==max-2)&&(n3<max-1)&&(n3>=1)){
/**right-middle**/     if ((AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)){
       shipfits=true;
       break;}else{
		shipfits=false;
		
	}
}
if((n4==0)&&(n3<max-1)&&(n3>=1)){
/**left-middle**/      if ((AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3][n4+2]!=1)){
		shipfits=true;
		break;}else{
		shipfits=false;
	
	}
}
if((n3==max-1)&&(n4==max-2)){
/**bottom-right**/  if ((AIBoatPartIsHere[n3][n4+1]==0)&&(AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3-1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)){
	shipfits=true;
	break;}else{
		shipfits=false;
		
	}
}
if(!shipfits){
	continue;
}
if(shipfits=true){
	shipset=true;
	break;}
			
		}
		
			AIBoatPartIsHere[n3][n4]=1;
			AIBoatPartIsHere[n3][n4+1]=1;
			if(n3+1<max){
			AIBoatPartIsHere[n3+1][n4]=3;}
			if(n4+2<max-1){
			AIBoatPartIsHere[n3][n4+2]=3;
			}
			if(n3-1>-1){
			AIBoatPartIsHere[n3-1][n4]=3;
			}
			if(n4-1>-1){
			AIBoatPartIsHere[n3][n4-1]=3;
			}
			if((n4+1<max)&&(n3+1<max)){
				AIBoatPartIsHere[n3+1][n4+1]=3;
			}
			if((n4+1<max)&&(n3-1>=0)){
				AIBoatPartIsHere[n3-1][n4+1]=3;
				}
			if(n4+2<max){
				AIBoatPartIsHere[n3][n4+2]=3;
			}
			
		
		}
		/**Puts ship in vertical*/
		if (VerticalLevel==0){
				boolean shipset = false;
			while(shipset==false){
				boolean shipfits = false;
			n3 =ThreadLocalRandom.current().nextInt(0,max);
			n4 = ThreadLocalRandom.current().nextInt(0,max);
			
			if((n4>1)&&(n4<max-2)&&(n3>0)&&(n3<max-2)){
				if	((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)){
					shipfits=true;
					break;}
				else{
					shipfits=false;
				}
			}
			
			if((n3==max-2)&&(n4>0)&&(n4<max-1)){
	/**bottom-middle**/ if	((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)){
		shipfits=true;
		break;}
	else{
		shipfits=false;
	
	}
	}
			if((n3==max-2)&&(n4==0)){
	/**bottom-left**/	if ((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)){
		shipfits=true;
		break;}else{
			shipfits=false;
			
		}}
	if((n3==max-2)&&(n4==max-1)){
	/**bottom-right**/	if ((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)){
		shipfits=true;
		break;}else{
			shipfits=false;
			
		}}
	
			if((n4==0)&&(n3>=0)&&(n3<=max-2)){
	/**left-middle**/	if ((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)){
		shipfits=true;
		break;}else{
			shipfits=false;

		}}
			if((n4==0)&&(n3==0)){
	/**left-up**/		if ((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)){
		shipfits=true;
		break;}else{
			shipfits=false;

		}}
	if((n3==0)&&(n4>=0)&&(n4<=max-2)){
	/**up-middle**/     if ((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3][n4+1]!=1)&&(AIBoatPartIsHere[n3+1][n4+1]!=1)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)){
		shipfits=true;
		break;}else{
			shipfits=false;
			
		}
	}
	if((n3==0)&&(n4==max-1)){
	/**right-up**/      if ((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)){
		shipfits=true;
		break;}else{
			shipfits=false;
			
		}
	}
	if((n4==max-1)&&(n3<max-2)&&(n3>0)){
	/**right-middle**/  if ((AIBoatPartIsHere[n3][n4]==0)&&(AIBoatPartIsHere[n3+1][n4]==0)&&(AIBoatPartIsHere[n3][n4-1]!=1)&&(AIBoatPartIsHere[n3+1][n4-1]!=1)&&(AIBoatPartIsHere[n3+2][n4]!=1)&&(AIBoatPartIsHere[n3-1][n4]!=1) ){
		shipfits=true;
		break;}else{
			shipfits=false;
		}
	}
	if(!shipfits){
		continue;
	}
	if(shipfits=true){
		shipset=true;
		break;}
				
			}
				AIBoatPartIsHere[n3][n4]=1;
				AIBoatPartIsHere[n3+1][n4]=1;
				if((n3+1<max)&&(n4-1>0)){
				AIBoatPartIsHere[n3+1][n4-1]=3;}
				if(n4-1>=0){
				AIBoatPartIsHere[n3][n4-1]=3;
				}
				if(n3-1>=0){
				AIBoatPartIsHere[n3-1][n4]=3;
				}
				if(n3+2<max){
				AIBoatPartIsHere[n3+2][n4]=3;
				}
				if((n4+1<max)&&(n3+1<max)){
					AIBoatPartIsHere[n3+1][n4+1]=3;
				}
				if(n4+1<max){
					AIBoatPartIsHere[n3][n4+1]=3;
					}}
		}		
	}

}
