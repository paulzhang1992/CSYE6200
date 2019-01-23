package assign1;
import java.util.Scanner;

/**
 * A starter file for implementing CSYE 6200 Assignment 1 <br>
 * Note: the package is 'assign1' so your code should be in your source folder under 'assign1'
 * Filename: CSYE6200Assign1.java <br>
 * 
 * 
 * @author Zeyu Zhang
 */


public class CSYE6200Assign1 {
	
	public static void main(String args[]) throws java.io.IOException {
		// Create an instance of the class, and call the constructor method
		CSYE6200Assign1 prog1 = new CSYE6200Assign1();
		
		prog1.run(); 
	}
	
	public CSYE6200Assign1() {
		
	}
	
	public void run() throws java.io.IOException {
		char inChar = ' ';
		//Initiate 3x5 empty array to store the histor data
		double [][] historyRecords = new double[3][5];
		
		double [] dims = new double[3];
		double vol;
		double weight;
		
 		System.out.println("Enter choice (1,2,3,4,q), then press <enter>.\n" +
 				"1) Enter width, length and height of the bucket measured in meters\n" + 
 				"2) Show the  cubic volume (m 3 ) of the bucket\n" + 
 				"3) Show the weight of the bucket contents\n" + 
 				"4) Print the last three  bucket calculations and their volume/weight totals\n" + 
 				"q) Quit");
		do {
			inChar = (char) System.in.read();
            if (inChar == '\n') continue; // Skip a (newline) character
            if (inChar == '\r') continue; // Skip a (carriage return) character
			// react to input and take appropriate action
			
			switch (inChar) {
			case '1':
				System.out.println("Please enter the width");
				//System.out.println(records[0][0]);
				Scanner scan = new Scanner( System.in );
				//Ask input of dimensions from user
				for (int i =0; i < 3; i++) { 
					dims [i] = scan.nextDouble();
				}
				//Check if the entered data are valid for calculating
				if (isLegalDim(dims) == false) { 
					System.out.println("You can not enter 0 or negative value for dimensions.\n"
							+ "Please re-enter again.");
					//If not valid, enter again
					for (int i =0; i < 3; i++) { 
						dims [i] = scan.nextDouble();
					}
				}
				//Store the data into records array & shift the volume & weight data alongside
				historyRecords = recordShift(historyRecords,dims);

				System.out.println(String.format("Input success!\n1The dimension of bucket is %.2f * %.2f * %.2f",dims [0], dims [1],dims[2]));
				
				
				break;
			case '2':
				System.out.println("You selected calculate the  cubic volume (m 3 ) of the bucket");
				//Calculate volume. Stored in records array.
				vol = calcVolume(dims);
				//Update the volume in records matrix
				historyRecords[2][3] = vol;
				//records = volUpdate (records,vol);
				System.out.println(String.format("The volume of current bucket is %.2f cubic meter(s)",historyRecords[2][3]));
				break;
			case '3':
				System.out.println("You selected calculate the weight");
				//Calculate weight. Stored in records array.
				weight = calcWeight(dims);
				//Update the weight in records matrix
				historyRecords[2][4] = weight;
				//records = weightUpdate(records,weight);
				System.out.println(String.format("The weight of current fluid is %.2f kilogram(s)",historyRecords[2][4]));
				break;   
			case '4':
				System.out.println("Printing dimension, volume and weight records.\n");
				System.out.println(String.format("1. width: %.2f, length: %.2f, height: %.2f, volume: %.2f, weight: %.2f "
						,historyRecords[0][0],historyRecords[0][1],historyRecords[0][2],historyRecords[0][3],historyRecords[0][4]));
				System.out.println(String.format("2. width: %.2f, length: %.2f, height: %.2f, volume: %.2f, weight: %.2f "
						,historyRecords[1][0],historyRecords[1][1],historyRecords[1][2],historyRecords[1][3],historyRecords[1][4]));
				System.out.println(String.format("3. width: %.2f, length: %.2f, height: %.2f, volume: %.2f, weight: %.2f\n "
						,historyRecords[2][0],historyRecords[2][1],historyRecords[2][2],historyRecords[2][3],historyRecords[2][4]));
				/*
				*	records array   width  length  height  volume  weight	
				*	2 entries ago	0		0		0		0		0
				*		last		0		0		0		0		0
				*	   current		0		0		0		0		0
				*/
				double totalVol = 0;
				double totalWeight = 0;
				totalVol = historyRecords[0][3] + historyRecords[1][3] + historyRecords[2][3];
				totalWeight = historyRecords[0][4] + historyRecords[1][4] + historyRecords[2][4];
				System.out.println(String.format("The total volume of last 3 records is %.2f cubic meter(s)",totalVol));
				System.out.println(String.format("The total weight of last 3 records is %.2f kilogram(s)",totalWeight));
				break;   
			default:
				System.out.println("Invalid selection: " + inChar);
				break; 
			case 'q':
				break;
			}


		} 
		while (inChar != 'q'); // Exit on quit
		System.out.println("Quiting...");
	}
	
	
	public double calcCubicWeight(double depth) {
		//Cubic Weight based on depth = (1.0 + 0.03 x (meter depth)^ 2 ) Kg
		double cubW = depth * depth * 0.03 +1;
		return cubW;
		
	}
	
	public double calcVolume (double[] dimension) {
		//Volume = width x length x depth
		double vol = dimension[0] * dimension[1] * dimension[2];
		
		return vol;
	}
	
	public double calcWeight (double[] dimension) {
		//Weight
		double weight = 0;
		//Start iterating from 1 meter deep. For fraction part, calculated separately. Depth less than 1 can pass this loop directly.
		for (int j = 1; j <= dimension[2]-1;j++) {
			//For each meter, weight of this part = length*width*height(equal to 1)*cubic weight
			//Then ad to previous total
			weight = weight + calcCubicWeight(j) * dimension[0]*dimension[1];
			//System.out.println(weight);
		}
		//Obtain the integer part of depth and subtract it from total depth.
		int i = (int) dimension[2] ;
		//Add the last few fraction of weight to total weight
		weight = weight + calcCubicWeight(dimension[2]-i) * dimension[0]*dimension[1] * (dimension[2]-i);
		return weight;
	}
	
	public boolean isLegalDim (double[] dimension){
		//Check if any of the entered values is greater than 0
		for(int k = 0; k < dimension.length; k++){
			if (dimension[k] <= 0)
				return false;
			}
		return true;
	}
	
	public double[][] recordShift (double [][] records, double [] newDim) {
		//Shift the last two row of dimensional data up by 1
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j<5; j++) {
				records [i][j] = records[i+1][j];
			}
		}
		//Store the newly entered data at last entry
		for (int j = 0; j< 3; j++) {
			records [2][j] = newDim [j];
		}
		//Reset the volume and weight to 0
		records [2][3] = 0;
		records [2][4] = 0;
		return records;
	}


}



