#Assignment 1

• Write a java program that helps  model the weight of a square bucket of fluid:

• Each bucket has a width, length and a height measured in meters

• The fluid density varies with the height:

• Cubic Weight based on depth = (1.0 + 0.03 * (meter depth) 2 ) Kg

• For example, at 3 meters deep, the weight of a cubic meter would be:

	W(3m) = 1.0 + (0.03) * (3m) 2 = 1.27 Kg

•Use a loop to accept keyboard command input

• Use a switch statement to provide four input options (commands) :

1) Request the size (i.e. width, length and height) of the bucket measured in meters

2) Calculate the  cubic volume (m 3 ) of the bucket

3) Calculate the weight of the bucket contents using the fluid density function shown above  – Note: Do not use Calculus  – Iterate over the volume and sum the weight values

4) Print a history of the last three  bucket calculations and their volume/weight totals

5) Quit – Allow the user to exit from the program

