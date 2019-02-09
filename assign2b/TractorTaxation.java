package assign2b;

/**
 * @@author Zeyu Zhang
 */

import java.util.ArrayList;
import java.util.HashMap;

public class TractorTaxation {
    private HashMap<String, Tractor> tractorMap = new HashMap<String, Tractor>();
    private ArrayList<Tractor> tractorList = new ArrayList<Tractor>();

    static private Tractor tr1 = new Tractor();
    static private Tractor tr2 = new Tractor();
    static private Tractor tr3 = new Tractor();
    static private Tractor tr4 = new Tractor();
    static private Tractor tr5 = new Tractor();
    static private Tractor tr0 = new Tractor();

    int taxRate;    // tax rate dollars/1000 dollars
    double tax;     // tax based on taxRate and price

    public TractorTaxation() {
        taxRate = 25; // 25 dollars per 1000 value
        tax = 0;    // default set to 0

    }

    /**
     * Data of five tractors for testing
     * tr1, tr2, tr3, tr4, tr5
     * Data found from the internet
     * Fuel Load is set 90% of fuel capacity as default
     * Fuel Efficiency is assumed with reason
     * Tractor is auto generated
     * Owner ID is set by author preferences
     */
    private void tractorGen() {
        // Tractor 1
        tr1.make = "Kubota";
        tr1.model = "B2320";
        tr1.power = 17.2;
        tr1.fuelType = "diesel";
        tr1.fuelCap = 26.1;
        tr1.fuelLoad = 0.9 * tr1.fuelCap;
        tr1.fuelEff = 4.4;
        tr1.setRange(tr1.estRange());
        tr1.setPrice(16000);
        tr1.setOwnerID("Paul");

        // Tractor 2
        tr2.make = "ford";
        tr2.model = "1920";
        tr2.power = 24.8;
        tr2.fuelCap = 37.1;
        tr2.fuelEff = 3.2;
        tr2.setRange(tr2.estRange());
        tr2.setPrice(13000);
        tr2.setOwnerID("James");

        // Tractor 3
        tr3.make = "fiat";
        tr3.model = "500";
        tr3.power = 37.3;
        tr3.fuelCap = 54.1;
        tr3.fuelLoad = 54.1;
        tr3.fuelEff = 2.7;
        tr3.setRange(tr3.estRange());
        tr3.setPrice(5000);
        tr3.setOwnerID("Mark");

        // Tractor 4
        tr4.setMake("New Holland");
        tr4.setModel("T4.75");
        tr4.setPower(55.2);
        tr4.setFuelCap(90.1);
        tr4.setFuelEff(3.8);
        tr4.setRange(tr4.estRange());
        tr4.setPrice(39000);
        tr4.setOwnerID("Mia");

        // Tractor 5
        tr5.setMake("John Deere");
        tr5.setModel("3303R");
        tr5.setPower(24.6);
        tr5.setFuelCap(44.7);
        tr5.setFuelLoad(44.7);
        tr5.setFuelEff(5.2);
        tr5.setRange(tr5.estRange());
        tr5.setPrice(29900);
    }

    /**
     * Modify the tractor list with commands
     * @param tractorList The list that need be modified
     * @param tr  object (tractor)
     * @param action   action can be "add", "get" or "remove"
     */
    public void listTractor(ArrayList<Tractor> tractorList, Tractor tr, String action) {
        // For add, use .add
        if (action == "add") {
            tractorList.add(tr);
            //return tr0;
        }
        // For get use .get with the index of tr
        else if (action == "get") {
            Tractor currentTractor = tractorList.get(tractorList.indexOf(tr));
            System.out.println("The requested tractor information from Tractor List is stated as below: \n\n" + currentTractor + "\n\n\n");
            //return currentTractor;
        }
        // For remove use .remove
        else if (action == "remove" ) {
            tractorList.remove(tr);
            //return tr0;
        }
        // Output error if none above
        else {
            System.out.println("Wrong argument, please enter add, get or remove");
            //return tr0;
        }

    }


    /**
     * Iterate the tractor list and print each one of it
     * Output error message if the list is empty
     * @param tractorList is an array list created to store the tractor info
     */
    public void listPrint(ArrayList<Tractor> tractorList) {
        // Check if empty
        if (tractorList.isEmpty() == true) {
            System.out.println("The tractor list is empty\n\n\n");
        }
        else {

            System.out.println("******************************************************************     TRACTOR LIST     ******************************************************************\n");
            for (Tractor tr : tractorList) {
                System.out.println(tr);
            }
            System.out.println("\n**********************************************************************************************************************************************************\n\n\n");
        }

    }

    /**
     * Add or retrieve tractor, print error if action is not included
     * @param tractorMap    map
     * @param tr    tractor
     * @param action    can be add or get
     */
    public void mapTractor(HashMap<String, Tractor> tractorMap, Tractor tr, String action) {
        // Get the OwnerID from the tractor and stored them in the hashMap
        if (action == "add") tractorMap.put(tr.getOwnerID(), tr);
        else if (action == "get") {
            Tractor currentTractor = tractorMap.get(tr.getOwnerID()); // Get the tractor with tr owner ID
            System.out.println("The requested tractor information from Tractor Map is stated as below: \n\n" + currentTractor + "\n\n\n");
        }
        else System.out.println("Wrong argument, please enter add or get");

    }

    /**
     * Tax calculator
     * @param tr tractor
     * @return
     */
    public double estTAX (Tractor tr) {
        // Get the tractor price
        int price = tr.getPrice();
        // tax = price/1000 * tax rate (tax rate is dollars per thousand dollars)
        tax = price/1000*taxRate;
        return tax;
    }

    /**
     * Print the tax form including all tractor and their tax
     */
    public void taxPrint() {
        System.out.println("**********************************************************     TAX FORM     **********************************************************\n\n");
        for (Tractor tr : tractorList) {

            System.out.println("                        The annual tax based on tractor value for "+tr.getMake() + " "+ tr.getModel() +" is: "+tr.getTax()+" dollars\n");
        }
        System.out.println("\n**************************************************************************************************************************************\n\n\n");

    }



    public void run() {
        // Create 5 instances of tractors for testing
        tractorGen();

        // Test print list method when the list is empty
        listPrint(tractorList);

        // Add all tractors to list
        listTractor(tractorList, tr1,"add");
        listTractor(tractorList, tr2,"add");
        listTractor(tractorList, tr3,"add");
        listTractor(tractorList, tr4,"add");
        listTractor(tractorList, tr5,"add");

        // Try get action to the list
        listTractor(tractorList, tr2,"get");

        // Print the list
        listPrint(tractorList);

        // Add all tractors to the hash map with their pre set owner id as key
        mapTractor(tractorMap, tr1, "add");
        mapTractor(tractorMap, tr2, "add");
        mapTractor(tractorMap, tr3, "add");
        mapTractor(tractorMap, tr4, "add");
        mapTractor(tractorMap, tr5, "add");

        // Retrieve the tr4's information
        mapTractor(tractorMap, tr4, "get");

        // Calculate tax for every entries in the hash map
        for (Tractor tr: tractorMap.values()){
            tr.setTax(estTAX(tr));
        }

        // Print out the tax form
        taxPrint();


    }
    /**
     * Test cast of Tractor Taxation
     * @param args
     */
    public static void main(String[] args) {
        // tax test case
        TractorTaxation tta1 = new TractorTaxation();
        tta1.run();


    }
}
