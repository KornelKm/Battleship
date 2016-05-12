import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Save implements Observer{

	int[][] boatPartIsHere;
	int[][] AIBoatPartIsHere;
	int [][] AIfiredHere;
	int [][] PlayerfiredHere;
	int max;
	public Save(int[][] boatPartIsHere,int[][] AIBoatPartIsHere, int [][] AIfiredHere, int max,int [][] PlayerfiredHere) {
		this.boatPartIsHere=boatPartIsHere;
		this.AIBoatPartIsHere=AIBoatPartIsHere;
		this.AIfiredHere=AIfiredHere;
		this.max=max;
		this.PlayerfiredHere=PlayerfiredHere;
	}

	@Override
	public void update() {
		
		/**Saving ships coordinates and place where ai allready fired*/
		
	          
	         /**Player Boats**/
	          try {
	      		FileOutputStream fos = new FileOutputStream("boatPartIsHere.dat");
	      		ObjectOutputStream oos = new ObjectOutputStream(fos);
	      		oos.writeObject(boatPartIsHere);
	          } catch (Exception e) {

	      	}
	            
	            /**AI Boats**/
	          try{
	  		FileOutputStream fos2 = new FileOutputStream("AIBoatPartIsHere.dat");
      		ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
      		oos2.writeObject(AIBoatPartIsHere);
          } catch (Exception e) {

      	}
		            
      
	           
	      /**Areas where AI allready fired**/
		 try{
			FileOutputStream fos3 = new FileOutputStream("AIfiredHere.dat");
      		ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
      		oos3.writeObject(AIfiredHere);
          } catch (Exception e) {

      	}
		 
		  /**Areas where Player allready fired**/
		 try{
			FileOutputStream fos4 = new FileOutputStream("PlayerfiredHere.dat");
      		ObjectOutputStream oos4 = new ObjectOutputStream(fos4);
      		oos4.writeObject(PlayerfiredHere);
          } catch (Exception e) {

      	}
          

     

		 
	
		
	}}


