package assign2b;

/**
 * @@author Zeyu Zhang
 */


class Tractor {

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
    Tractor() {
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
    String getMake() {
        return make;
    }

    void setMake(String make) {
        this.make = make;
    }

    String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    double getPower() {
        return power;
    }

    void setPower(double power) {
        if (power <= 0) {
            power = 15;
            System.out.println("Power need to be larger than 0. Set to default as " + power);
        }
        this.power = power;
    }

    String getFuelType() {
        return fuelType;
    }

    void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    double getFuelCap() {
        return fuelCap;
    }

    void setFuelCap(double fuelCap) {
        if (fuelCap <= 0) {
            fuelCap = 20;
            System.out.println("Power need to be larger than 0. Set to default as " + fuelCap);
        }
        this.fuelCap = fuelCap;
    }

    double getFuelLoad() {
        return fuelLoad;
    }

    void setFuelLoad(double fuelLoad) {
        if (fuelLoad <= 0) {
            fuelLoad = this.fuelCap*0.9;
            System.out.println("Power need to be larger than 0. Set fuel load to 90% of fuel cap as " + fuelLoad);
        }
        this.fuelLoad = fuelLoad;
    }

    double getFuelEff() {
        return fuelEff;
    }

    void setFuelEff(double fuelEff) {
        if (fuelEff <= 0) {
            fuelEff = 4;
            System.out.println("Power need to be larger than 0. Set to default as " + fuelEff);
        }
        this.fuelEff = fuelEff;
    }

    double getRange() {
        return range;
    }

    void setRange(double range) {
        this.range = range;
    }

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        if (price <= 0) {
            price = 20000;
            System.out.println("Power need to be larger than 0. Set to default as " + price);
        }
        this.price = price;
    }

    String getOwnerID() {
        return ownerID;
    }

    void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    int getTractorID() {
        return tractorID;
    }

    double getTax() {
        return tax;
    }

    void setTax(double tax) {
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
    double estRange() {
        double range = fuelLoad * fuelEff;
        return range;
    }
}
