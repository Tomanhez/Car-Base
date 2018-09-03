package sdf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import front.Car;

public class SerDes implements Serializable{
	
	ArrayList<Car> carList = new ArrayList<Car>();
	private String name;
	
	public SerDes(String name,ArrayList<Car> carList) {
		this.name = name;
		this.carList = carList;
	}
	
	public void Write()throws FileNotFoundException,IOException {
		FileOutputStream fos = new FileOutputStream(name);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		if(carList.size()>0) {
			for(Car caro: carList) {
				System.out.println("write - ok");
				oos.writeObject(caro);
			}
		}
		
		oos.flush();
		oos.close();
	}
	
	public void Read(String nazwa) throws FileNotFoundException,IOException,ClassNotFoundException{
		FileInputStream fis = new FileInputStream(nazwa);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		
		while(true) {
			try {
				carList.add((Car)ois.readObject());
				System.out.println("read - ok");
			} catch (Exception e) {
				System.out.println("first added table's - ok");
				break;
			}
		}
		ois.close();
		
	}
	
	public ArrayList<Car> getCarList(){
		return carList;
	}
	
}
