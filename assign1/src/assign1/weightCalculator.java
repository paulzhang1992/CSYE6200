package assign1;

import java.util.Scanner;

/**
 * 
 * Filename: weightCalculator.java <br>
 * 
 *  <br>
 * @author Zeyu Zhang
 */

public class weightCalculator {
	
	public static void main(String args[]) throws java.io.IOException {
		// Create an instance of the class, and call the constructor method
		weightCalculator prog1 = new weightCalculator();
		
		prog1.run(); 
	}
	
	public weightCalculator() {
		
	}
	
	public void run() throws java.io.IOException {
		char inChar = ' ';
		//Initiate 3x5 empty array to store the histor data
		double [][] records = new double[3][5];
		/*for (int i=0;i<records.length;i++)
		*	for (int j=0;j<records[0].length;j++)
		*		records [i][j]=0;
		*/
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
				if (legalDim(dims) == false) { 
					System.out.println("You can not enter 0 or negative value for dimensions.\n"
							+ "Please re-enter again.");
					//If not valid, enter again
					for (int i =0; i < 3; i++) { 
						dims [i] = scan.nextDouble();
					}
				}
				//Store the data into records array
				records = recordShift(records,dims);

				System.out.println(String.format("Input success!\n1The dimension of bucket is %.2f * %.2f * %.2f",dims [0], dims [1],dims[2]));
				
				//Calculate volume & weight. Stored in records array.
				vol = calcVolume(dims);
				records = volUpdate (records,vol);
				weight = calcWeight(dims);
				records = weightUpdate(records,weight);
				
				break;
			case '2':
				System.out.println("You selected calculate the  cubic volume (m 3 ) of the bucket");
				System.out.println(String.format("The volume of current bucket is %.2f cubic meter",records[2][3]));
				break;
			case '3':
				System.out.println("You selected calculate the weight");
				System.out.println(String.format("The weight of current fluid is %.2f kilogram",records[2][4]));
				break;   
			case '4':
				System.out.println("Printing dimension, volume and weight records.\n");
				System.out.println(String.format("1. width: %.2f, length: %.2f, height: %.2f, volume: %.2f, weight: %.2f\n "
						,records[0][0],records[0][1],records[0][2],records[0][3],records[0][4]));
				System.out.println(String.format("2. width: %.2f, length: %.2f, height: %.2f, volume: %.2f, weight: %.2f\n "
						,records[1][0],records[1][1],records[1][2],records[1][3],records[1][4]));
				System.out.println(String.format("3. width: %.2f, length: %.2f, height: %.2f, volume: %.2f, weight: %.2f\n "
						,records[2][0],records[2][1],records[2][2],records[2][3],records[2][4]));
				/*
				*	records array   width  length  height  volume  weight	
				*	2 entries ago	0		0		0		0		0
				*		last		0		0		0		0		0
				*	   current		0		0		0		0		0
				*/
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
	/*private Object i(int i, int j) {
	*	// TODO Auto-generated method stub
	*	return null;
	*}
	*/
	public double calcCubicW(double depth) {
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
		//Weight = volume x cubic weight
		double weight = calcCubicW(dimension[2])*calcVolume(dimension);
		return weight;
	}
	public boolean legalDim (double[] dimension){
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
			for (int j = 0; j<3; j++) {
				records [i][j] = records[i+1][j];
			}
		}
		//Store the newly entered data at last entry
		for (int j = 0; j< 3; j++) {
			records [2][j] = newDim [j];
		}
		
		return records;
	}
	public double[][] volUpdate (double [][] records, double volume) {
		//Shift the last two volume data up by 1
		for (int i = 0; i < 2; i++)
			records [i][3] = records[i+1][3];
		//Store the newly calculated data in last row
		records [2][3] = volume;
		
		return records;
	}
	public double[][] weightUpdate (double [][] records, double weight) {
		//Shift the last two weight result up by 1
		for (int i = 0; i < 2; i++)
			records [i][4] = records[i+1][4];
		//Store the newly calculated weight in last row
		records [2][4] = weight;
		
		return records;
	}
	



}



