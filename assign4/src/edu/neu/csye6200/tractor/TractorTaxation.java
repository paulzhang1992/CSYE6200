package edu.neu.csye6200.tractor; /**
 * @@author Zeyu Zhang
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class TractorTaxation {
    private static Logger log = Logger.getLogger(TractorTaxation.class.getName());
    private static TractorTaxation instance = null;
    private double taxRate1;
    private double taxRate2;
    private double taxRate3;
    private double taxRate4;
    private ArrayList<Tractor> tractorTax;
    private static String pattern = "./assign4/src/edu/neu/csye6200/tractor/log/tax.log";

    private TractorTaxation() {
        taxRate1 = 25; // 25 dollars per 1000 value
        taxRate2 = 35; // 35 dollars per 1000 value
        taxRate3 = 50; // 50 dollars per 1000 value
        taxRate4 = 100; // 100 dollars per 1000 value
        tractorTax = new ArrayList<>();
    }

    public static TractorTaxation getInstance() {
        if (instance == null) {
            instance = new TractorTaxation();
            try {
                log.addHandler(new FileHandler(pattern));
                log.info("TractorTaxation class has been constructed");
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    /**
     * Tax calculator
     * @param tr tractor
     */
    public double estTAX (Tractor tr) {
        double tax;
        // Get the tractor price
        double price = tr.getPrice();

        if (price<= 5000) tax = price/1000*taxRate1;
        else if (5000 < price & price <= 10000) tax = 5*taxRate1 + (price-5000)/1000*taxRate2;
        else if (10000 < price & price <=15000) tax = 5*taxRate1+5*taxRate2+(price-10000)/1000*taxRate3;
        else if (15000 < price) {
            tax = 5 * (taxRate1 + taxRate2 + taxRate3) + (price - 15000) / 1000 * taxRate4;
        } else {
            tax = 0;
            System.out.println("Tractor value error. Tax been set to 0.");
        }
        //tr.setTax(tax);
        return tax;
    }
    public void add (Tractor tr){
        tr.setTax(estTAX(tr));
        tractorTax.add(tr);
        try {
            log.addHandler(new FileHandler(pattern));
            log.info(tr.getMake()+"-"+tr.getModel()+" ---- Tax calculated and stored successfully");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Tractor> quickSort(String criteria, ArrayList<Tractor> list)
    {
        if (list.isEmpty())
            return list; // start with recursion base case
        ArrayList<Tractor> sorted;  // this shall be the sorted list to return, no needd to initialise
        ArrayList<Tractor> smaller = new ArrayList<Tractor>(); // Tractors smaller than pivot
        ArrayList<Tractor> larger = new ArrayList<Tractor>(); // Tractors larger than pivot
        Tractor pivot = list.get(0);  // first Tractor in list, used as pivot
        int i;
        Tractor j;     // Variable used for Tractors in the loop
        for (i=1;i<list.size();i++)
        {
            j=list.get(i);
            if (j.compare(criteria,pivot)<0)   // make sure Tractor has proper compareTo method
                smaller.add(j);
            else
                larger.add(j);
        }
        smaller=quickSort(criteria,smaller);  // capitalise 's'
        larger=quickSort(criteria,larger);  // sort both halfs recursively
        smaller.add(pivot);          // add initial pivot to the end of the (now sorted) smaller Tractors
        smaller.addAll(larger);     // add the (now sorted) larger Tractors to the smaller ones (now smaller is essentially your sorted list)
        sorted = smaller;            // assign it to sorted; one could just as well do: return smaller

        return sorted;
    }

    public ArrayList<Tractor> getTractorTax() {
        return tractorTax;
    }

    /**
     * Print the tax form including all tractor and their tax
     */
    public void taxPrint(ArrayList<Tractor> tractorList) {
        System.out.println("*******************************************************     TAX FORM     *******************************************************\n");
        System.out.println("                Make            Model          ID           Owner          Price(k)           Tax($)                             \n");
        for (Tractor tr : tractorList) {
            String strOut = String.format("       %1$12s %2$17s %3$11d %4$15s %5$15.1fk %6$16.0f",tr.getMake(),tr.getModel(),tr.getTractorID(),tr.getOwnerID(),tr.getPrice()/1000,tr.getTax());
            System.out.println(strOut);
        }
        System.out.println("\n********************************************************************************************************************************\n\n\n");

    }


}
