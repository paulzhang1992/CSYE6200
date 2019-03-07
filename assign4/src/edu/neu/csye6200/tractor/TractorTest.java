package edu.neu.csye6200.tractor;

public class TractorTest {
    public TractorTest() {
    }


    // Doo works here
    private void run(){
        TractorTaxation trTax = TractorTaxation.getInstance();
        DefaultTractorList tl = DefaultTractorList.getInstance();

        for (Tractor tr : tl.getTractorArrayList()) trTax.add(tr);
        trTax.taxPrint(trTax.getTractorTax());
        trTax.taxPrint(trTax.quickSort("price",trTax.getTractorTax()));

    }
    public static void main(String[] args) {
        TractorTest trt = new TractorTest();
        trt.run();
    }
}
