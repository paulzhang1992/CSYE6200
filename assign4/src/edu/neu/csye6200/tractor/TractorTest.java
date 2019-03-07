package edu.neu.csye6200.tractor;

public class TractorTest {
    public TractorTest() {
    }


    // Doo works here
    private void run(){
        // Use tractor generator to creat 7 instances of default instances
        TractorTaxation trTax = TractorTaxation.getInstance();
        DefaultTractorList tl = DefaultTractorList.getInstance();
        for (Tractor tr : tl.getTractorArrayList()) trTax.add(tr);

        // Add 3 more tractors
        Tractor tr1 = new Tractor();
        tr1.make = "Kubota";
        tr1.model = "B3300";
        tr1.power = 19.8;
        tr1.fuelType = "diesel";
        tr1.fuelCap = 40;
        tr1.fuelLoad = 0.9 * tr1.fuelCap;
        tr1.fuelEff = 4.0;
        tr1.setRange(tr1.estRange());
        tr1.setPrice(18900);
        tr1.setOwnerID("Paul");

        Tractor tr2 = new Tractor();
        tr2.make = "Fiat";
        tr2.model = "920";
        tr2.power = 26.7;
        tr2.fuelCap = 55;
        tr2.fuelEff = 3.9;
        tr2.setRange(tr2.estRange());
        tr2.setPrice(29000);
        tr2.setOwnerID("James");

        FrontLoader fl1 = new FrontLoader();
        fl1.setMake("Cat");
        fl1.setModel("450P");
        fl1.setPower(32);
        fl1.setFuelCap(80);
        fl1.setFuelEff(3.5);
        fl1.setRange(fl1.estRange());
        fl1.setPrice(26500);
        fl1.setLoaderCap(140000);
        fl1.setLoaderWidth(180);

        trTax.add(tr1);
        trTax.add(tr2);
        trTax.add(fl1);

        // Print tax form
        trTax.taxPrint(trTax.getTractorTax());
        // Use price to sort
        trTax.taxPrint(trTax.quickSort("price",trTax.getTractorTax()));
        // Use ownerID to sort
        trTax.taxPrint(trTax.quickSort("ownerid",trTax.getTractorTax()));
        // Use ID to sort
        trTax.taxPrint(trTax.quickSort("id",trTax.getTractorTax()));

        // Test file IO
        // First time run the program without output folder to generate error log
        // Second time test the IO
        TractorIO io = new TractorIO("tr.txt");
        io.WriteTextFile(trTax.getTractorTax(), io.path,io.fileName);
        io.ReadTextFile(io.path,io.fileName);

        io.fileName = "re.ser";
        io.Save(trTax.getTractorTax(),io.path,io.fileName);
        tl.listPrint(io.Load(io.path,io.fileName));

    }
    public static void main(String[] args) {
        TractorTest trt = new TractorTest();
        trt.run();
    }
}
