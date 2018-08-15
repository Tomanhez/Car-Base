/*
 * 13.08.2018/15min
 */
package front;

import javax.swing.JTextField;

public class Car {
	
	private boolean flagCar;
	
	private String mark,model,nrReg,yearBuild,insurance,insuranceTo,dataFile;

	public Car() {
		mark = "";
		model = "";
		nrReg = "";
		yearBuild = "";
		insurance = "";
		insuranceTo = "";
		dataFile = "";
	}
	public Car(Car car) {
		 this.mark = car.getMark();
		 this.model = car.getModel();
		 this.nrReg = car.getNrReg();
		 this.yearBuild = car.getYearBuild();
		 this.insurance = car.getInsurance();
		 this.insuranceTo = car.getInsuranceTo();
		 this.dataFile = car.getDataFile();
	}
	public Car(String mark,String model,String nrReg,String yearBuild,String insurance,String insuranceTo,String dataFile) {
		 this.mark = mark;
		 this.model = model;
		 this.nrReg = nrReg;
		 this.yearBuild = yearBuild;
		 this.insurance = insurance;
		 this.insuranceTo = insuranceTo;
		 this.dataFile = dataFile;
	}
	public void copyCar(Car car) {
		 this.mark = car.getMark();
		 this.model = car.getModel();
		 this.nrReg = car.getNrReg();
		 this.yearBuild = car.getYearBuild();
		 this.insurance = car.getInsurance();
		 this.insuranceTo = car.getInsuranceTo();
		 this.dataFile = car.getDataFile();
	}
	public boolean equalsCar(Car car) {
		if(
		 this.mark == car.getMark() &
		 this.model == car.getModel() &
		 this.nrReg == car.getNrReg() &
		 this.yearBuild == car.getYearBuild() &
		 this.insurance == car.getInsurance() &
		 this.insuranceTo == car.getInsuranceTo() &
		 this.dataFile == car.getDataFile()) {
			return true;
		} else return false;
	}
	public boolean isEmpty(Car car) {
		if(
		 car.getMark().length() == 0 & 
		 car.getModel().length() == 0 &
		 car.getNrReg().length() == 0 &
		 car.getYearBuild().length() == 0 &
		 car.getInsurance().length() == 0 &
		 car.getInsuranceTo().length() == 0 &
		 car.getDataFile().length() == 0) {
			return true;
		} else return false;
	}
	public boolean isEmpty() {
		if(
		 this.getMark().length() == 0 & 
		 this.getModel().length() == 0 &
		 this.getNrReg().length() == 0 &
		 this.getYearBuild().length() == 0 &
		 this.getInsurance().length() == 0 &
		 this.getInsuranceTo().length() == 0 &
		 this.getDataFile().length() == 0) {
			return true;
		} else return false;
	}

	/*
	 * getters and seters
	 */
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNrReg() {
		return nrReg;
	}

	public void setNrReg(String nrReg) {
		this.nrReg = nrReg;
	}

	public String getYearBuild() {
		return yearBuild;
	}

	public void setYearBuild(String yearBuild) {
		this.yearBuild = yearBuild;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getInsuranceTo() {
		return insuranceTo;
	}

	public void setInsuranceTo(String insuranceTo) {
		this.insuranceTo = insuranceTo;
	}

	public String getDataFile() {
		return dataFile;
	}

	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}
	public boolean isFlagCar() {
		return flagCar;
	}
	public void setFlagCar(boolean flagCar) {
		this.flagCar = flagCar;
	}

}
