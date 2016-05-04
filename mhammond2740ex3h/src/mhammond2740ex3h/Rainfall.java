package mhammond2740ex3h;

public class Rainfall {
	
	private double [] rainfallArray;
	
	public Rainfall(double[] rainfall) {
		rainfallArray = new double[rainfall.length];
		for (int i = 0; i < rainfall.length; i++)
			rainfallArray[i] = rainfall[i];
	}
	public Rainfall(String[] rainfall) {
		rainfallArray = new double[rainfall.length];
		for (int i = 0; i < rainfall.length; i++)			
			rainfallArray[i] = Double.parseDouble(rainfall[i]);
	}
	
	//****************************************************
	//***The getTotal methods returns the total of the *** 
	//***********elements in the rainfall array***********
	//****************************************************
	
	public double getTotal() {
		double total = 0.0;
		for (double amt : rainfallArray)
			total += amt;
			return total;
		
	}
	
	//***************************************************
	// The getAverage method returns the average of the * 
	//*********elements in the rainfall array************
	//***************************************************
	
	public double getAverage() {
		return getTotal() / this.rainfallArray.length;
		
	}
	
	//***************************************************
	//**The getHighest method returns the highest value** 
	//**********stored in the rainfall array*************
	//***************************************************
	public double getHighest() {
		double highest = 0.0;
		for (int i = 1; i < rainfallArray.length; i++) {
			if (rainfallArray[i] > highest)
				highest = rainfallArray[i];
		
	}
		return highest;
	}
	
	//***************************************************
	// The getLowest method returns the lowest value  *** 
	//**********stored in the rainfall array*************
	//***************************************************
		public double getLowest() {
			double lowest = rainfallArray[0];
			for (int i = 1; i < rainfallArray.length; i++) {
				if (rainfallArray[i] < lowest)
					lowest = rainfallArray[i];
				
			}
			return lowest;
		}
}
