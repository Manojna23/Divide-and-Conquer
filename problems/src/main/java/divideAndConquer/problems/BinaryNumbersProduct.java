package divideAndConquer.problems;

//This class converts binary numbers to decimal numbers using recursion and computes their product.
//Time taken for this conversion specifically is: O(2N) and approximately is O(N)

public class BinaryNumbersProduct {

	public static void main(String[] args) {
		int binary1 = 1100;
		int binary2 = 1010;
		
		//Can also use parseInt(String number, int radix) method to directly convert binary to decimal
		//int dec1 = Integer.parseInt(binary1InString,2);
		int decimal1 = convertBinaryToDecimal(binary1, 0);
		int decimal2 = convertBinaryToDecimal(binary2, 0);
		System.out.println(decimal1);
		System.out.println(decimal2);
		
		System.out.println("Product of 2 decimal numbers:"+decimal1*decimal2);
	}
	
	public static int convertBinaryToDecimal(int binary1, int n) {
		if(binary1 == 0) {
			return 0;
		}
		int rem = binary1 % 10;
		binary1 = binary1 / 10;
		return (int) (rem*Math.pow(2, n)) + convertBinaryToDecimal(binary1, ++n);
	}
}
