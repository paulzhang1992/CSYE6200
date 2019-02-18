package assign3;

/**
 * @@author Zeyu Zhang
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            String path = directory.getCanonicalPath()+ "\\assign3\\src\\assign3";
            // Test read method
            this.tractorST = trio.ReadFile(path,fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Print out the read result
        System.out.println(this.tractorST);


        List<String> tractors = trio.StringToList(tractorST,"|");
        for (String tractor : tractors){
            List<String> properties = trio.StringToList(tractor,",");

            for (String property : properties) {
                List<String> items = trio.StringToList(property,":");
                //System.out.println(property);

            }

        }




    }
    public static void main(String[] args) {
        TractorReadTest trt = new TractorReadTest();
        trt.run();
    }
}
