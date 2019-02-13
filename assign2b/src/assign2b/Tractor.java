package assign2b;

/**
 * @@author Zeyu Zhang
 */


public class Tractor {

    /**
     *
     * • Add Strings for both the make and model
     *      (i.e. make: Kubota, model: B2320DT)
     * • Add an Owner ID string (i.e. “ m.munson ”)
     * • Add a tractor value ( ie.e . $20,000)
     * • Add value for tractor power in terms of of horsepower (HP) or  KiloWatts (KW).
     * • Add a String to hold the fuel type (diesel, gasoline, kerosene, electric, etc.), capacity and current fuel load
     * • Add a constructor that sets the make and model, along with the other instance variables
     * • Add methods to calculate the range based on fuel load and a fuel efficiency value (kilometers per liter)
     */

    String make;	// Manufacturer
    String model;	// Tractor model
    double power;	// in kw
    String fuelType;  // Fuel type. Diesel, gasoline, kerosence, electric
    double fuelCap;		// Liters
    double fuelLoad;	// Liters
    double fuelEff;		// Kilometers per liters. Normally 2.34 to 5.1.
    double range;
    private double price;   // Price of tractor
    private static int idCount = 0;
    private int tractorID;
    private String ownerID;
    double tax;

    /***
     * Default constructor
     */
    public Tractor() {
        make = "Unknown";
        model = "Unknown";
        ownerID = "Unknown";
        price = 20000;
        fuelType = "diesel";
        power = 15;
        fuelCap = 20;
        fuelLoad = 0.9*fuelCap;
        fuelEff = 4;
        range = this.estRange();
        tractorID = idCount++;
        tax = 0;
            }

    /**
     *
     * Setters & Getters
     */
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        if (power <= 0) {
            power = 15;
            System.out.println("Power need to be larger than 0. Set to default as " + power);
        }
        this.power = power;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(double fuelCap) {
        if (fuelCap <= 0) {
            fuelCap = 20;
            System.out.println("Power need to be larger than 0. Set to default as " + fuelCap);
        }
        this.fuelCap = fuelCap;
    }

    public double getFuelLoad() {
        return fuelLoad;
    }

    public void setFuelLoad(double fuelLoad) {
        if (fuelLoad <= 0) {
            fuelLoad = this.fuelCap*0.9;
            System.out.println("Power need to be larger than 0. Set fuel load to 90% of fuel cap as " + fuelLoad);
        }
        this.fuelLoad = fuelLoad;
    }

    public double getFuelEff() {
        return fuelEff;
    }

    public void setFuelEff(double fuelEff) {
        if (fuelEff <= 0) {
            fuelEff = 4;
            System.out.println("Power need to be larger than 0. Set to default as " + fuelEff);
        }
        this.fuelEff = fuelEff;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            price = 20000;
            System.out.println("Power need to be larger than 0. Set to default as " + price);
        }
        this.price = price;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public int getTractorID() {
        return tractorID;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        String line = "--------------------------------------------------------------------------------------------------------------------------------\n";
        String title = "    Make       Model    Power    Fuel Type      Fuel Type    Fuel Load    Fuel Efficiency     Range   Price     ID       Owner\n";
        String output = String.format("%1$12s %2$7s %3$7.1f %4$12s %5$13.1f %6$12.1f %7$13.2f %8$16.2f %9$6.1fk %10$5d %11$12s \n"
                ,make, model,power, fuelType, fuelCap, fuelLoad,fuelEff,range,price/1000,tractorID,ownerID);


        return title+ output+ line;
    }

    /**
     * Estimate range left based on fuel load and fuel efficiency
     * range (km) = load (L) * eff (km/L)
     * @return range left for tractor
     */
    public double estRange() {
        double range = fuelLoad * fuelEff;
        return range;
    }
}
