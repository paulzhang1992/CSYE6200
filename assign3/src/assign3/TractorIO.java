package assign3;

import assign3.Tractor;

import java.io.*;

import java.io.IOException;

public class TractorIO {
    String path;
    String fileName;
    String type;

    public TractorIO(String path, String fileName, String type) {
        this.path = path;
        this.fileName = fileName;
        this.type = type;
    }

    public TractorIO() {

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
     * @param tr        object to write
     * @param path      file path
     * @param fileName  file name
     */
    public void WriteFile (Tractor tr , String path, String fileName){
        // Set type of object Tractor of FrontLoader
        if (tr instanceof FrontLoader) type = "FrontLoader";
        else type = "Tractor";
        try {
            // Append the the result
            FileWriter writer = new FileWriter(path+"\\"+fileName, true);
            // Write content
            if (tr instanceof FrontLoader) {
                FrontLoader fl = (FrontLoader) tr;
                writer.append("{\"type\": \"" + type + "\", \n\"make\": \"" + fl.getMake() + "\", \n\"model\":\"" + fl.getModel() +
                        "\", \n\"power\":" + fl.getPower() + ", \n\"fuelType\":\"" + fl.getFuelType() + "\", \n\"fuelCap\":" + fl.getFuelCap() +
                        ", \n\"fuelLoad\":" + fl.getFuelLoad() + ", \n\"fuelEff\":" + fl.getFuelEff() + ", \n\"range\":" + fl.getRange() +
                        ", \n\"price\":" + fl.getPrice() + ", \n\"tractorID\":" + fl.getTractorID() + ", \n\"ownerID\":\"" + fl.getOwnerID() +
                        ", \n\"loaderWidth\":" + fl.getLoaderWidth() + ", \n\"loaderCap\":" + fl.getLoaderCap()+"}");

            }
            else {
                writer.append("{\"type\": \"" + type + "\", \n\"make\": \"" + tr.getMake() + "\", \n\"model\":\"" + tr.getModel() +
                        "\", \n\"power\":" + tr.getPower() + ", \n\"fuelType\":\"" + tr.getFuelType() + "\", \n\"fuelCap\":" + tr.getFuelCap() +
                        ", \n\"fuelLoad\":" + tr.getFuelLoad() + ", \n\"fuelEff\":" + tr.getFuelEff() + ", \n\"range\":" + tr.getRange() +
                        ", \n\"price\":" + tr.getPrice() + ", \n\"tractorID\":" + tr.getTractorID() + ", \n\"ownerID\":\"" + tr.getOwnerID()+"\"}\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Reading the file to String
     * @param path          file path
     * @param fileName      file name
     */




}
