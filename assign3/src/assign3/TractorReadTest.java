package assign3;

/**
 * @@author Zeyu Zhang
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class TractorReadTest {
    String tractorST;


    public TractorReadTest() {
    }


    /**
     * Do works here
     */
    public void run() {
        TractorIO trio = new TractorIO();

        // Setting file and getting the current directory
        String fileName = "tractor.txt";
        File directory = new File(".");
        // The folder path
        try {
            String path = directory.getCanonicalPath()+ "/assign3/src/assign3/output/";
            // Test read method
            this.tractorST = trio.ReadFile(path,fileName);
            // Print out the read result
            System.out.println(this.tractorST);

            // Deserialize objects
            ArrayList<Tractor> tractorArrayList = new ArrayList<>();
            tractorArrayList = trio.Load(path, "tr.ser");

            TractorArrayList array = new TractorArrayList();
            // Check if the object read correctly
            array.listPrint(tractorArrayList);

        } catch (IOException e) {
            e.printStackTrace();
        }






        }





    public static void main(String[] args) {
        TractorReadTest trt = new TractorReadTest();
        trt.run();
    }
}
