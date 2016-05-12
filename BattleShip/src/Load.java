import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Load extends Observable implements Observer {
	JFrame GameMenu;
	String ChoosenBoardSize;
	JComboBox BoardSize;
	JPanel panel2;
	JPanel panel1;
	JSlider sliderPatrolBoat;
	JSlider sliderDestroyer;
	JSlider sliderBattleship;
	JSlider sliderAircraftCarrier;
	int[][] BoatPartIsHere;
	int[][] AIfiredHere;
	int[][] AIBoatPartIsHere;
	int [][] PlayerfiredHere;
	int max;
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
	JPanel Savegame;
	String Large="Large";
	String Medium="Medium";
	String Small="Small";
	int[][]AiShootsHere;
	JPanel MenuPanel;

	public Load(JPanel MenuPanel, JFrame GameMenu, JComboBox BoardSize, JSlider sliderPatrolBoat, JSlider sliderDestroyer, JSlider sliderBattleship, JSlider sliderAircraftCarrier, int max) {
this.MenuPanel=MenuPanel;
this.GameMenu=GameMenu;
this.BoardSize=BoardSize;
this.sliderPatrolBoat=sliderPatrolBoat;
this.sliderDestroyer=sliderDestroyer;
this.sliderBattleship=sliderBattleship;
this.sliderAircraftCarrier=sliderAircraftCarrier;
this.max=max;
	}

	@Override
	public void update() {
		BoatPartIsHere = new int[max][max];
		AIfiredHere=new int[max][max];
		int [][] SavedBoatPartIsHere = new int[max][max];
		int [][] SavedAIfiredHere = new int[max][max];
		int [][] SavedAIBoatPartIsHere = new int[max][max];
		int [][] SavedPlayerfiredHere= new int[max][max];
		Scanner scan;
		Scanner scan2;
		Scanner scan3;
		
		/**Loading Players boats**/
		try {
			FileInputStream fis = new FileInputStream("boatPartIsHere.dat");
			ObjectInputStream iis = new ObjectInputStream(fis);
			SavedBoatPartIsHere = (int[][]) iis.readObject();

		} catch (Exception e) {
			{JOptionPane.showMessageDialog(GameMenu,
			        "<html>No Game Save stored");}
		}
		

		
		/**Loading AI boats**/
		try {
			FileInputStream fis2 = new FileInputStream("AIBoatPartIsHere.dat");
			ObjectInputStream iis2 = new ObjectInputStream(fis2);
			SavedAIBoatPartIsHere = (int[][]) iis2.readObject();

		} catch (Exception e) {
			{JOptionPane.showMessageDialog(GameMenu,
			        "<html>No Game Save stored");}
		}
		
		
		/**Loading Previous Shoots**/
		try {
			FileInputStream fis3 = new FileInputStream("AIfiredHere.dat");
			ObjectInputStream iis3 = new ObjectInputStream(fis3);
			SavedAIfiredHere = (int[][]) iis3.readObject();

		} catch (Exception e) {
			{JOptionPane.showMessageDialog(GameMenu,
			        "<html>No Game Save stored");}
		}
		
		try {
			FileInputStream fis4 = new FileInputStream("PlayerfiredHere.dat");
			ObjectInputStream iis4 = new ObjectInputStream(fis4);
			SavedPlayerfiredHere = (int[][]) iis4.readObject();

		} catch (Exception e) {
			{JOptionPane.showMessageDialog(GameMenu,
			        "<html>No Game Save stored");}
		}
		
		
		
		
		GameLoad GameLoad = new GameLoad(SavedBoatPartIsHere, SavedAIBoatPartIsHere, SavedAIfiredHere, SavedPlayerfiredHere);
	notifyObserver(GameLoad);
		
	}}