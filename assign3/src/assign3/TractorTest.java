package assign3;

public class TractorTest {
    static private Tractor tr1 = new Tractor();
    static private Tractor tr2 = new Tractor();
    static private Tractor tr3 = new Tractor();
    static private Tractor tr4 = new Tractor();
    static private Tractor tr5 = new Tractor();
    static private FrontLoader fl1 = new FrontLoader();

    public TractorTest() {



    }
    /**
     * Do works here
     */
    public void run() {


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
    static private void tractorGen() {
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

        // FrontLoader 1

    }



    /**
     * Test cast of Tractor
     * @param args
     */
    public static void main(String[] args) {
        // Create 5 instances of tractors for testing
        tractorGen();


        TractorTest tts1 = new TractorTest();
        tts1.run();


    }
}
