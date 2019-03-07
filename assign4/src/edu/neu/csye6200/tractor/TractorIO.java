package edu.neu.csye6200.tractor;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class TractorIO {
    public String path;
    public String fileName;
    private static Logger log = Logger.getLogger(TractorTaxation.class.getName());
    private static String timeStamp = new SimpleDateFormat().format( new Date() );
    private static String pattern = "./assign4/src/edu/neu/csye6200/tractor/log/IO_"+timeStamp+".log";
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler(pattern);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public TractorIO(String fileName) {
        this.path = "./assign4/src/edu/neu/csye6200/tractor/output/";
        this.fileName = fileName;
        log.addHandler(fh);
        log.info("TractorIO class constructed.");
    }

    /**
     *     Tractor write method. Classes have the following variables need be written.
     *     Tractor
     *     String make;	// Manufacturer
     *     String model;	// Tractor model
     *     double power;	// in kw
     *     String fuelType;  // Fuel type. Diesel, gasoline, kerosence, electric
     *     double fuelCap;		// Liters
     *     double fuelLoad;	// Liters
     *     double fuelEff;		// Kilometers per liters. Normally 2.34 to 5.1.
     *     double range;
     *     private double price;   // Price of tractor
     *     private static int idCount = 0;
     *     private int tractorID;
     *     private String ownerID;
     *
     *     FrontLoader
     *     double loaderWidth;     // in cm
     *     double loaderCap;       // in cm^3
     *
     * @param tractorArrayList        object to write
     * @param path      file path
     * @param fileName  file name
     */
    public void WriteTextFile (ArrayList<Tractor> tractorArrayList, String path, String fileName){
        try {
            // Append the the result
            FileWriter writer = new FileWriter(path+fileName, true);
            writer.append("{");
            for (Tractor tr: tractorArrayList) {
                // Set type of object Tractor of FrontLoader
                String type;
                if (tr instanceof FrontLoader) type = "FrontLoader";
                else type = "Tractor";
                // Write content
                if (tr instanceof FrontLoader) {
                FrontLoader fl = (FrontLoader) tr;
                writer.append("{\"type\": \"" + type + "\", \n\"make\": \"" + fl.getMake() + "\", \n\"model\":\"" + fl.getModel() +
                     "\", \n\"power\":" + fl.getPower() + ", \n\"fuelType\":\"" + fl.getFuelType() + "\", \n\"fuelCap\":" + fl.getFuelCap() +
                     ", \n\"fuelLoad\":" + fl.getFuelLoad() + ", \n\"fuelEff\":" + fl.getFuelEff() + ", \n\"range\":" + fl.getRange() +
                     ", \n\"price\":" + fl.getPrice() + ", \n\"tractorID\":" + fl.getTractorID() + ", \n\"ownerID\":\"" + fl.getOwnerID() +
                     ", \n\"loaderWidth\":" + fl.getLoaderWidth() + ", \n\"loaderCap\":" + fl.getLoaderCap() + "}");
                } else {
                writer.append("{\"type\": \"" + type + "\", \n\"make\": \"" + tr.getMake() + "\", \n\"model\":\"" + tr.getModel() +
                     "\", \n\"power\":" + tr.getPower() + ", \n\"fuelType\":\"" + tr.getFuelType() + "\", \n\"fuelCap\":" + tr.getFuelCap() +
                     ", \n\"fuelLoad\":" + tr.getFuelLoad() + ", \n\"fuelEff\":" + tr.getFuelEff() + ", \n\"range\":" + tr.getRange() +
                     ", \n\"price\":" + tr.getPrice() + ", \n\"tractorID\":" + tr.getTractorID() + ", \n\"ownerID\":\"" + tr.getOwnerID() + "\"},\n");
                }
             }
            writer.append("}");
            writer.close();
            log.info(tractorArrayList.getClass()+" saved to file " + fileName + " successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            log.severe(e.getMessage());
        }
    }

    /**
     * Reading the file to String
     */
    public String ReadTextFile (String path, String fileName){
        String listOfTractor = "";
        File file = new File(path+fileName);

        if (!file.exists()) {
            System.out.println("File does not exist. Quitting");
            log.warning(fileName+" does not exist. Reading failed.");
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) != null)
                listOfTractor += st;
                log.info(fileName + " has been successfully read.");
            } catch (IOException e) {
                e.printStackTrace();
                log.severe(e.getMessage());
            }
        }
        return listOfTractor;
    }

    /**
     * Serialize tractor array list
     * @param tractorList tractor list
     */
    public void Save (ArrayList<Tractor> tractorList,String path, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path+fileName);
            ObjectOutputStream outObj = new ObjectOutputStream(fileOut);
            outObj.writeObject(tractorList);
            outObj.close();
            fileOut.close();
            System.out.println("Array list serialized as "+fileName);
            log.info("Serialization completed");
        }catch (IOException e){
            e.printStackTrace();
            log.severe(e.getMessage());
        }
    }

    /**
     * Deserialize ser file to object
     */
    public ArrayList<Tractor> Load (String path, String fileName) {
        ArrayList<Tractor> tractorArrayList = new ArrayList<Tractor>();

        try {
            FileInputStream fileIn = new FileInputStream(path + fileName);
            ObjectInputStream inObj = new ObjectInputStream(fileIn);
            tractorArrayList = (ArrayList<Tractor>) inObj.readObject();
            inObj.close();
            fileIn.close();
            log.info("Deserialization completed");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            log.severe(e.getMessage());
        }
        return tractorArrayList;
    }
}


