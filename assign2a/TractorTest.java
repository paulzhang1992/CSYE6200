package assign2a;


/**
 * @author Zeyu ZHANG
 * 
 *
 */


public class TractorTest {

	public TractorTest() {
		// TODO Auto-generated constructor stub
	}
	public void run() {
		
		//Tractor(String make, String model, double power, String fuelType, double fuelCap, double fuelLoad, double fuelEff)
		Tractor kubota = new Tractor();
		
		Tractor ford = new Tractor();
		ford.make = "ford";
		ford.model = "1920";
		ford.power = 24.8;
		ford.fuelCap = 37.1;
		ford.fuelEff = 3.2;
		ford.setRange(ford.estRange());
		
		Tractor fiat = new Tractor();
		fiat.make = "fiat";
		fiat.model = "500";
		fiat.power = 37.3;
		fiat.fuelCap = 54.1;
		fiat.fuelLoad = 54.1;
		fiat.fuelEff = 2.7;
		fiat.setRange(fiat.estRange());
		
		Tractor newHolland = new Tractor();
		newHolland.setMake("New Holland");
		newHolland.setModel("T4.75");
		newHolland.setPower(55.2);
		newHolland.setFuelCap(90.1);
		newHolland.setFuelEff(3.8);
		newHolland.setRange(newHolland.estRange());
		
		Tractor johnDeere = new Tractor ("John Deere", "3303R",24.6,"diesel",44.7,44.7,5.2);
		
		System.out.println("         Make        Model       Power     Fuel Type    Fuel Capacity     Fuel Load     Range\n");
		System.out.println(kubota);
		System.out.println(ford);
		System.out.println(fiat);
		System.out.println(newHolland);
		System.out.println(johnDeere);
	}
	
	
	
	
	
	public static void main(String[] args) {
		TractorTest showTractors = new TractorTest();
		showTractors.run();
		

	}

}
