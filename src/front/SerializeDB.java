/*
package front;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SerializeDB {
	
	private ArrayList<Car> carList;
	File file;
	Scanner scannerTxt;
	PrintWriter writeInTxt;
	
	public SerializeDB(ArrayList<Car> carList) {
		this.carList = carList;
		findFile();
		readFile();
		readCarList();
	}
	
	public void writeCarList() throws FileNotFoundException {
		writeInTxt = new PrintWriter("baza.txt");
		int x=0;
		for(Car caro: carList) {
			String a = "Auto nr "+(x+1);
			writeInTxt.println("START");
			writeInTxt.println(a);
			writeInTxt.println(caro.getMark());
			writeInTxt.println(caro.getModel());
			writeInTxt.println(caro.getNrReg());
			writeInTxt.println(caro.getYearBuild());
			writeInTxt.println(caro.getInsurance());
			writeInTxt.println(caro.getInsuranceTo());
			writeInTxt.println(caro.getDataFile());
			writeInTxt.println("END");
			x++;
		}
	}
	
	public void readCarList() {
	//TODO
	}

	public void findFile() {
		try {
			file = new File("baza.txt");
		}catch(Exception e) {
			System.out.println("B³¹d wyszukiwania pliku: "+e);
		}
	}
	public void readFile() {
		try {
			scannerTxt = new Scanner(file);
		}catch(Exception e) {
			System.out.println("B³¹d odczytu pliku: "+e);
		}
	}
	
}
*/
