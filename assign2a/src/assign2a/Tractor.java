/**
 * 
 */
package assign2a;

/**
 * @author Zeyu ZHANG
 * 
 *
 */
public class Tractor {
	String make;	// Manufacturer
	String model;	// Tractor model
	double power;	// in kw
	String fuelType;  // Fuel type. Diesel, gasoline, kerosence, electric
	double fuelCap;		// Liters
	double fuelLoad;	// Liters
	double fuelEff;		// Kilometers per liters. Normally 2.34 to 5.1.
	double range;
	// constructor
	public Tractor() {
		make = "Kubota";
		model = "B2320";
		power = 17.2;
		fuelType = "diesel";
		fuelCap = 26.1;
		fuelLoad = 0.9 * fuelCap;
		fuelEff = 4.4;
		range = this.estRange();
		
	}
	
	public Tractor(String make, String model, double power, String fuelType, double fuelCap, double fuelLoad, double fuelEff) {
		this.make = make;
		this.model = model;
		this.power = power;
		this.fuelType = fuelType;
		this.fuelCap = fuelCap;
		this.fuelLoad = fuelLoad;
		this.fuelEff = fuelEff;
		this.range = this.estRange();
	}
	
		
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the power
	 */
	public double getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(double power) {
		this.power = power;
	}

	/**
	 * @return the fuelType
	 */
	public String getFuelType() {
		return fuelType;
	}

	/**
	 * @param fuelType the fuelType to set
	 */
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	/**
	 * @return the fuelCap
	 */
	public double getFuelCap() {
		return fuelCap;
	}

	/**
	 * @param fuelCap the fuelCap to set
	 */
	public void setFuelCap(double fuelCap) {
		this.fuelCap = fuelCap;
	}

	/**
	 * @return the fuelLoad
	 */
	public double getFuelLoad() {
		return fuelLoad;
	}

	/**
	 * @param fuelLoad the fuelLoad to set
	 */
	public void setFuelLoad(double fuelLoad) {
		this.fuelLoad = fuelLoad;
	}

	/**
	 * @return the fuelEff
	 */
	public double getFuelEff() {
		return fuelEff;
	}

	/**
	 * @param fuelEff the fuelEff to set
	 */
	public void setFuelEff(double fuelEff) {
		this.fuelEff = fuelEff;
	}
	

	
	/**
	 * @return the range
	 */
	public double getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(double range) {
		this.range = range;
	}

	// estimate range based on fuel load & fuel efficiency
	public double estRange() {
		double range = fuelLoad * fuelEff;
		return range;
	}
	
	// Reformat the output string
	public String toString() {
		String output = String.format("%1$15s %2$10s %3$10.1f %4$12s %5$13.1f %6$15.1f %7$13.2f", make, model, power, fuelType, fuelCap, fuelLoad, range);
		return output;
	}
	
	
}
