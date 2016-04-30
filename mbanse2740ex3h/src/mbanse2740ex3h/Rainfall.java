package mbanse2740ex3h;

public class Rainfall {
	private double [] rainfallArray;
	
	public Rainfall (double [] rainfall) {
		rainfallArray = new double[rainfall.length];
		
		for (int i = 0; i < rainfall.length; i++)
			rainfallArray[i] = rainfall[i];
	}
	
	public Rainfall (String [] rainfall) {
		rainfallArray = new double[rainfall.length];
		
		for (int i = 0; i < rainfall.length; i++)
			rainfallArray[i] = Double.parseDouble(rainfall[i]);
	}
	
	// The getTotal method returns the total of the elements in the rainfallArray.
	public double getTotal() {
		double total = 0.0;
		
		// Add up all the values in the rainfall array.
		for (double value : rainfallArray)
			total += value;
		
		return total;
	}
	
	// The getAverage method returns the average of the elements in the rainfallArray.
	public double getAverage() {
		return getTotal() / rainfallArray.length;
	}
	
	// The getHighest method returns the highest value stored in the rainfallArray.
	public double getHighest() {
		double highest = rainfallArray[0];
		
		// Search the array for highest value.
		for (int i = 1; i < rainfallArray.length; i++)
		{
			if (rainfallArray[i] > highest)
				highest = rainfallArray[i];
		}
		
		return highest;
	}
	
	// The getLowest method returns the lowest value stored in the rainfallArray.
	public double getLowest() {
		double lowest = rainfallArray[0];
		
		// Search the array for the lowest value.
		for (int i = 1; i < rainfallArray.length; i++)
		{
			if (rainfallArray[i] < lowest)
				lowest = rainfallArray[i];
		}
		
		return lowest;
	}
}
