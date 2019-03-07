package edu.neu.csye6200.tractor;

import java.util.ArrayList;

public class TractorArrayList {

    public TractorArrayList() {
    }

    /**
     * Modify the tractor list with commands
     * @param tractorList The list that need be modified
     * @param tr  object (tractor)
     * @param action   action can be "add", "get" or "remove"
     */
    public void listTractor(ArrayList<Tractor> tractorList, Tractor tr, String action) {
        // For add, use .add
        if (action.equals("add")) tractorList.add(tr);
        // For get use .get with the index of tr
        else if (action.equals("get")) {
            Tractor currentTractor = tractorList.get(tractorList.indexOf(tr));
            System.out.println("The requested tractor information from Tractor List is stated as below: \n\n" + currentTractor + "\n\n\n");
        }
        // For remove use .remove
        else if (action.equals("remove")) tractorList.remove(tr);
        // Output error if none above
        else System.out.println("Wrong argument, please enter add, get or remove");
    }

    /**
     * Iterate the tractor list and print each one of it
     * Output error message if the list is empty
     * @param tractorList is an array list created to store the tractor info
     */
    public void listPrint(ArrayList<Tractor> tractorList) {
        // Check if empty
        if (tractorList.isEmpty()) System.out.println("The tractor list is empty\n\n\n");
        else {
            System.out.println("********************************************************************     TRACTOR LIST     ********************************************************************\n");
            for (Tractor tr : tractorList)
                if (tr instanceof FrontLoader) {
                    FrontLoader fl = (FrontLoader) tr;
                    System.out.println(fl);
                } else
                    System.out.println(tr);
            System.out.println("\n*************************************************************************************************************************************************************\n\n\n");
        }
    }
}
