package mhammond2740ex3h;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		double[] dblRainFall = {
				1.2, 2.7, 2.2, 3.1, 2.9, 5.1,
				3.2, 2.7, 3.6, 1.8, 2.2, 1.7 };
		String[] strRainFall = {
				"1.2", "2.7", "2.2", "3.1", "2.9", "5.1",
				"3.2", "2.7", "3.6", "1.8", "2.2", "1.7" };
		DecimalFormat fmt = new DecimalFormat("#0.0");
		
		Rainfall rainfall1 = new Rainfall(dblRainFall);
		System.out.println("Rainfall1 total:   " + fmt.format(rainfall1.getTotal()));
		System.out.println("Rainfall1 average:   " + fmt.format(rainfall1.getAverage()));
		System.out.println("Rainfall1 highest:   " + fmt.format(rainfall1.getHighest()));
		System.out.println("Rainfall1 lowest:   " + fmt.format(rainfall1.getLowest()));
		
	
		Rainfall rainfall = new Rainfall(strRainFall);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Rainfall total:   " + fmt.format(rainfall1.getTotal()));
		System.out.println("Rainfall average:   " + fmt.format(rainfall1.getAverage()));
		System.out.println("Rainfall highest:   " + fmt.format(rainfall1.getHighest()));
		System.out.println("Rainfall lowest:   " + fmt.format(rainfall1.getLowest()));
	}
}

