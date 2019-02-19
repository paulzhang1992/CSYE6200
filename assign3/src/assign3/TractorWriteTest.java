package assign3;

import java.io.*;
import java.util.ArrayList;

public class TractorWriteTest {
    static private Tractor tr1 = new Tractor();
    static private Tractor tr2 = new Tractor();
    static private Tractor tr3 = new Tractor();
    static private Tractor tr4 = new Tractor();
    static private Tractor tr5 = new Tractor();
    static private FrontLoader fl1 = new FrontLoader();
    private ArrayList<Tractor> tractorList = new ArrayList<>();

    private TractorWriteTest() {

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
    }

    /**
     * List save to file
     * @param fileName  file name
     */
    private void listToFile(String fileName) {
        try {
            // Setting file and getting the current directory
            File directory = new File(".");
            // The folder path
            String path = directory.getCanonicalPath() + "/assign3/src/assign3/output/";
            // New file
            File file = new File(path + fileName);
            // Check if the file exist. If not creat new one.
            if (!file.exists()) {
                file.createNewFile();
            } else {
                // If exist. Delete old one and creat new one.
                System.out.println("Found duplicated file. Deleting....");
                file.delete();
                System.out.println("File deleted. Creating new.....");
                file.createNewFile();
            }
            // Open the file and append instead of overwrite
            FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
            // File start with [ to math the json format
            writer.append("{");
            writer.close();

            // Loop through the tractor list and write the content
            TractorIO writeText = new TractorIO(fileName);
            for (Tractor tr : tractorList) writeText.WriteTextFile(tr,path,fileName);

            // Match the json format ending with ]
            FileWriter writer2 = new FileWriter(file.getAbsoluteFile(), true);
            writer2.append("}");
            writer2.close();
            System.out.println("File wrote to "+path+"/"+fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Do works here
     */
    private void run(){
        TractorArrayList array = new TractorArrayList();
        // Add tractors and front loaders to the array list
        array.listTractor(tractorList, tr1,"add");
        array.listTractor(tractorList, tr2,"add");
        array.listTractor(tractorList, tr3,"add");
        array.listTractor(tractorList, tr4,"add");
        array.listTractor(tractorList, tr5,"add");
        array.listTractor(tractorList, fl1, "add");

        // Test write method
        listToFile("tractor.txt");
        // Test array list print method
        array.listPrint(tractorList);

        // Test serialize object save as tr.ser
        TractorIO trio = new TractorIO("tr.ser");
        trio.Save(tractorList);
    }

    /**
     * Test cast of Tractor
     */
    public static void main(String[] args) {
        // Create 5 instances of tractors and a instance of front loader for testing
        tractorGen();

        // Run tractor write to file test
        TractorWriteTest tts1 = new TractorWriteTest();
        tts1.run();
    }
}