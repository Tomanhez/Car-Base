/*
 * program komis
 * 11.08.2018/2h/layouts and primary
 * 13.08.2018/1h 40min 
 * start 
 */
package front;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sdf.SerDes;

public class MainPanel extends JPanel implements ActionListener,Serializable {

	private MyJLabel labelMark;
	private MyJLabel labelModel;
	private MyJLabel labelNrReg;
	private MyJLabel labelYearBuild;
	private MyJLabel labelInsurance;
	private MyJLabel labelInsuranceTo;
	private MyJLabel labelDataFile;
	
	private MyJTextField mark;
	private MyJTextField model;
	private MyJTextField nrReg;
	private MyJTextField yearBuild;
	private MyJTextField insurance;
	private MyJTextField insuranceTo;
	private MyJTextField dataFile;
	
	JPanel partialPanel1;
	JPanel partialPanel2;
	JPanel partialPanel3;
	JPanel partialPanel4;
	JPanel partialPanel5;
	
	MyButton addButton;
	MyButton editButton;
	MyButton searchButton;
	MyButton deleteFieldsButton;
	
	JTextArea area;
	JTextArea cmdArea;
	JScrollPane scrolPane;
	JScrollPane scrolPaneCmd;
	
	Car car;
	
	ArrayList<Car> carList;
	ArrayList<String> cmdList;
	
	SerDes serdes;
	
	
	public MainPanel() {
		/*
		 * list cars
		 */
		carList = new ArrayList<Car>();
		cmdList = new ArrayList<String>();
		/*
		 * car init
		 */
		car = new Car();
		/*
		 * primary layout
		 */
		new BoxLayout(this, BoxLayout.LINE_AXIS);
		/*
		 * create scroll and area
		 */
		area = new JTextArea(16,25);
		cmdArea = new JTextArea(16,25);
		scrolPane = new JScrollPane(area);
		scrolPaneCmd = new JScrollPane(cmdArea);
		/*
		 * create labels
		 */
		labelMark = new MyJLabel("Marka");
		labelModel = new MyJLabel("Model");
		labelNrReg = new MyJLabel("Nr Rejestracyjny");
		labelYearBuild = new MyJLabel("Rok Produkcji");
		labelInsurance = new MyJLabel("Ubezpieczenie");
		labelInsuranceTo = new MyJLabel("Ubezpieczenie Do");
		labelDataFile = new MyJLabel("Data");
		/*
		 * create textFields
		 */
		int lengthTextField = 15;
		mark = new MyJTextField(lengthTextField);
		model = new MyJTextField(lengthTextField);
		nrReg = new MyJTextField(lengthTextField);
		yearBuild = new MyJTextField(lengthTextField);
		insurance = new MyJTextField(lengthTextField);
		insuranceTo = new MyJTextField(lengthTextField);
		dataFile = new MyJTextField(lengthTextField);
		dataFile.setText(timeCarAdd());
		/*
		 * create buttons and add actionListener
		 */
		addButton = new MyButton("Dodaj");
		editButton = new MyButton("Edytuj");
		searchButton = new MyButton("Szukaj");
		deleteFieldsButton = new MyButton("Wyczyœæ Pola");
		addButton.addActionListener(this);
		editButton.addActionListener(this);
		searchButton.addActionListener(this);
		deleteFieldsButton.addActionListener(this);
		/*
		 * create objects partial panel
		 */
		partialPanel1 = new JPanel();
		partialPanel2 = new JPanel();
		partialPanel3 = new JPanel();
		partialPanel4 = new JPanel();
		partialPanel5 = new JPanel();
		/*
		 * set layouts partialpanel
		 */
		partialPanel1.setLayout(new BoxLayout(partialPanel1,BoxLayout.PAGE_AXIS));
		partialPanel2.setLayout(new BoxLayout(partialPanel2,BoxLayout.Y_AXIS));
		partialPanel3.setLayout(new BoxLayout(partialPanel3,BoxLayout.Y_AXIS));
		partialPanel4.setLayout(new BoxLayout(partialPanel4,BoxLayout.Y_AXIS));
		partialPanel5.setLayout(new BoxLayout(partialPanel5,BoxLayout.Y_AXIS));
		/*
		 * objects added in partialpanel
		 * 
		 * 1)
		 */
		partialPanel1.add(labelMark);
		partialPanel1.add(labelModel);
		partialPanel1.add(labelNrReg);
		partialPanel1.add(labelYearBuild);
		partialPanel1.add(labelInsurance);
		partialPanel1.add(labelInsuranceTo);
		partialPanel1.add(labelDataFile);
		/*
		 * 2
		 */
		partialPanel2.add(mark);
		partialPanel2.add(model);
		partialPanel2.add(nrReg);
		partialPanel2.add(yearBuild);
		partialPanel2.add(insurance);
		partialPanel2.add(insuranceTo);
		partialPanel2.add(dataFile);
		/*
		 * 3)
		 */
		partialPanel3.add(addButton);
		partialPanel3.add(editButton);
		partialPanel3.add(searchButton);
		partialPanel3.add(deleteFieldsButton);
		/*
		 * 4)
		 */
		partialPanel4.add(scrolPane);
		/*
		 *  5)
		 */
		partialPanel5.add(scrolPaneCmd);
		/*
		 * partialPanel add in primary panel
		 */
		add(partialPanel1);
		add(partialPanel2);
		add(partialPanel3);
		add(partialPanel4);
		add(partialPanel5);
		/*
		 * serialize and deserialize
		 */
		serdes = new SerDes("baza.txt", carList);
		try {
			serdes.Read("baza.txt");
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("z³y odczyt pierwszy");
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		Object source = arg0.getSource();
		
		if (source == addButton) {
			System.out.println("dodaj");
			addCar();
			dispCmd();
		}
		else if (source == editButton) {
			System.out.println("edit");
			edit();
			dispCmd();
		}
		else if (source == searchButton) {
			System.out.println("szukaj");
			searchCar();
			dispCmd();
		}
		else if (source == deleteFieldsButton) {
			System.out.println("wyczysc pola");
			cleanTextFields();
			dispCmd();
		}
		
		try {
			serdes.Write();
		} catch (IOException e) {
			System.out.println("Wywali³o zapis");
			e.printStackTrace();
		}
		
	}
	/*
	 * primary method from button
	 */
	
	//key addCar
	public void addCar() {
		getTextFromFrames();
		createObjectCarInList();
		System.out.println("size"+carList.size());
		cleanCarObject();
	}
	//key - edit
		public void edit() {
			//TODO
			//displayAllCars();
			//getLastAction();
			if(carList.size() !=0) {
				area.setText("");
				for(Car caro:carList) {
					appendCarToArea(caro);
					System.out.println("nr "+caro.getNrReg());
				}
			}
		}	
	//key - search
	public void searchCar() {
		getTextFromFrames();
		searchSelectedCar();
		setTextToFrames();
	}
	//key - cleanText
	public void cleanTextFields() {
		cleanAllFrames();
	}
	/*
	 * present time
	 */
	public String timeCarAdd() {
		LocalDateTime date = LocalDateTime.now();
		return date.toString().substring(0, 10);
	}
	/*
	 * methods history
	 */
	public void dispCmd() {
		if(cmdList.size() !=0) {
			cmdArea.setText("");
			for(int x = 0;x<cmdList.size();x++) {
					cmdArea.append(cmdList.get((cmdList.size()-1)-x));
			}
		}
	}
	/*
	 * methods from frames
	 */
	public void getTextFromFrames(){
		car.setMark(mark.getText());
		car.setModel(model.getText());
		car.setNrReg(nrReg.getText());
		car.setYearBuild(yearBuild.getText());
		car.setInsurance(insurance.getText());
		car.setInsuranceTo(insuranceTo.getText());
		car.setDataFile(dataFile.getText());
	}
	public void getTextFromFrames(Car car){
		car.setMark(mark.getText());
		car.setModel(model.getText());
		car.setNrReg(nrReg.getText());
		car.setYearBuild(yearBuild.getText());
		car.setInsurance(insurance.getText());
		car.setInsuranceTo(insuranceTo.getText());
		car.setDataFile(dataFile.getText());
	}
	public void setTextToFrames(){
		mark.setText(car.getMark());
		model.setText(car.getModel());
		nrReg.setText(car.getNrReg());
		yearBuild.setText(car.getYearBuild());
		insurance.setText(car.getInsurance());
		insuranceTo.setText(car.getInsuranceTo());
		dataFile.setText(car.getDataFile());
	}
	public void setTextToFrames(Car car){
		mark.setText(car.getMark());
		model.setText(car.getModel());
		nrReg.setText(car.getNrReg());
		yearBuild.setText(car.getYearBuild());
		insurance.setText(car.getInsurance());
		insuranceTo.setText(car.getInsuranceTo());
		dataFile.setText(car.getDataFile());
	}
	public void setCarToArea(Car car){
		String opis = "\nSamochód:\n";
		String a ="",b="",c="",d="",e="",f="",g="";
		if(car.getMark().length()!=0) a="\n";
		if(car.getModel().length()!=0) b="\n";
		if(car.getNrReg().length()!=0) c="\n";
		if(car.getYearBuild().length()!=0) d="\n";
		if(car.getInsurance().length()!=0) e="\n";
		if(car.getInsuranceTo().length()!=0) f="\n";
		if(car.getDataFile().length()!=0) g="\n";
		area.setText(opis+car.getMark()+a+
				car.getModel()+b+
				car.getNrReg()+c+
				car.getYearBuild()+d+
				car.getInsurance()+e+
				car.getInsuranceTo()+f+
				car.getDataFile()+g);
	}
	public void appendCarToArea(Car car){
		String opis = "\nSamochód:\n";
		String a ="",b="",c="",d="",e="",f="",g="";
		if(car.getMark().length()!=0) a="\n";
		if(car.getModel().length()!=0) b="\n";
		if(car.getNrReg().length()!=0) c="\n";
		if(car.getYearBuild().length()!=0) d="\n";
		if(car.getInsurance().length()!=0) e="\n";
		if(car.getInsuranceTo().length()!=0) f="\n";
		if(car.getDataFile().length()!=0) g="\n";
		area.append(opis+car.getMark()+a+
				car.getModel()+b+
				car.getNrReg()+c+
				car.getYearBuild()+d+
				car.getInsurance()+e+
				car.getInsuranceTo()+f+
				car.getDataFile()+g);
	}
	public void cleanAllFrames(){
		mark.setText("");
		model.setText("");
		nrReg.setText("");
		yearBuild.setText("");
		insurance.setText("");
		insuranceTo.setText("");
		dataFile.setText("");
	}
	public void displayLastAction() {
		if(carList.isEmpty() == false)
		car.copyCar(carList.get(carList.size()-1));
	}
	public void displayAllCars() {
		int i=0;
		for(Car caro:carList) {
		System.out.println("Index nr "+i+":"+caro.getMark());
		i++;
	}
	}
	/*
	 * car methods
	 */
	public void cleanCarObject() {
		car.setMark("");
		car.setModel("");
		car.setNrReg("");
		car.setYearBuild("");
		car.setInsurance("");
		car.setInsuranceTo("");
		car.setDataFile("");
		
	}
	public void cleanCarObject(Car car) {
		car.setMark("");
		car.setModel("");
		car.setNrReg("");
		car.setYearBuild("");
		car.setInsurance("");
		car.setInsuranceTo("");
		car.setDataFile("");
	}
	public void createObjectCarInList(){//new Car in Array List
		
		if(car.isEmpty() == true) {
			cmdList.add("\n Wszystkie pola tekstowe s¹ puste");
		}else if(car.getNrReg().length() == 0) {
			cmdList.add("\n Podaj choæ nr rejestracyjny");
		}else if(searchExsistingCar()){
			cmdList.add("\n Nr rej istnieje ju¿ w danej bazie dancyh");
		}else{
			carList.add(car);
			car = new Car();
			cmdList.add("\n Doda³eœ nowy obiekt");
		}
	}
	/*
	 * other's car methods
	 */
	public String searchSelectedCar(){
		String x = "\n Brak szukanego numeru rejestracyjnego w bazie";
		if(car.isEmpty() == true) {
			cmdList.add("\n Nie szukaj - Wszystkie pola tekstowe s¹ puste");
		}else {
		for(int y=0;y<carList.size();y++) {
			String a = carList.get(y).getNrReg().toString().trim();
			String b = car.getNrReg().toString().trim();
				if(b.equals(a)) { 
					x=("\n Numer znalezionego auta: "+carList.get(y).getNrReg()+" Numer w liœcie: "+carList.size());
				}
			}
		}
		cmdList.add(x);
		return x;
	}
	public boolean searchExsistingCar(){
		boolean x = false;
		if(car.isEmpty() == true) {
			System.out.println("\n don't search textFields are empty");
		}else {
		for(int y=0;y<carList.size();y++) {
			String a = carList.get(y).getNrReg().toString().trim();
			String b = car.getNrReg().toString().trim();
				if(b.equals(a)) { 
					x=true;
				}
			}
		}
		return x;
	}
	public void getLastAction(){
		if(carList.size()>0)
		setTextToFrames(carList.get(carList.size()-1));
	}
	/*
	 * methods database
	 */
	public void getObjectFromDatabase(){
		//TODO
	}
	public void addObjectToDatabase(){
		//TODO
	}

	
}
