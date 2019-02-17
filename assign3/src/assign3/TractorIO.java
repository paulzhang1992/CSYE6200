package assign3;

import assign3.Tractor;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;

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

    /**
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
     */
    public void WriteFile (Tractor tr , String path, String fileName){
        if (tr instanceof FrontLoader) type = "FrontLoader";
        else type = "Tractor";
        try {
            FileWriter writer = new FileWriter(path+"/"+fileName);
            writer.append("[{ \"type\": \"" + type + "\", \"make\": \"" + tr.getMake() + "\", \"model\":" + tr.getModel() +
                    "\", \"power\":" + tr.getPower() + "\", \"fuelType\":" + tr.getFuelType() + "\", \"fuelCap\":" + tr.getFuelCap() +
                    "\", \"fuelLoad\":" + tr.getFuelLoad() + "\", \"fuelEff\":" + tr.getFuelEff() + "\", \"range\":" + tr.getRange() +
                    "\", \"price\":" + tr.getPrice() + "\", \"tractorID\":" + tr.getTractorID() + "\", \"ownerID\":" + tr.getOwnerID());
            if (tr instanceof FrontLoader) {
                FrontLoader fl = (FrontLoader) tr;
                writer.append( "\", \"loaderWidth\":" +  fl.getLoaderWidth() +  "\", \"loaderCap\":" + fl.getLoaderCap()+"\" }]");
            } else {
                writer.append("\" }]");
            }




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void OpenFile (String path, String fileName){

    }



}
