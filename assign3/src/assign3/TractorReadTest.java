package assign3;

import java.util.ArrayList;


class TractorReadTest {

    private TractorReadTest() {
    }

    /**
     * Do works here
     */
    private void run() {
        // Test read method
        TractorIO readText = new TractorIO("tractor.txt");
        String tractorText = readText.ReadTextFile();
        // Print out the read result
        System.out.println(tractorText);

        // Test deserialize objects
        TractorIO load = new TractorIO("tr.ser");
        ArrayList<Tractor> tractorArrayList = load.Load();

        TractorArrayList array = new TractorArrayList();
        // Check if the object read correctly
        array.listPrint(tractorArrayList);
    }

    public static void main(String[] args) {
        TractorReadTest trt = new TractorReadTest();
        trt.run();
    }
}
