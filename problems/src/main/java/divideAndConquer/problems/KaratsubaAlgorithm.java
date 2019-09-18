package divideAndConquer.problems;

//A divide and Conquer way of multiplying two binary numbers

public class KaratsubaAlgorithm {

	public static void main(String args[]) {
		System.out.println(multiply("1100", "1010"));
	}
	
	public static long multiply(String x, String y) {
		int n = makeEqualLength(x, y);
		
		//Base Cases
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return multiplySingleBit(x, y);
		}
		
		//Dividing the input into half
		int fh = n/2;
		int sh = n - fh;
		
		String x1 = x.substring(0, fh);
		String x0 = x.substring(fh, sh);
		
		String y1 = y.substring(0, fh);
		String y0 = y.substring(fh, sh);
		
		long P1 = multiply(x1, y1);
		long P2 = multiply(x0, y0);
		long P3 = multiply(addBitStrings(x1, x0), addBitStrings(y1, y0));
		return (P1 * (1<<(2*sh))) + (P3-P1-P2)*(1<<sh) + P2; 
	}
	
	public static String addBitStrings(String first, String second) {
		String result = "";
		int length = makeEqualLength(first, second);
		int carry = 0;
		for(int i = length-1; i>=0; i--) {
			int firstBit = first.charAt(i) - '0';
			int secondBit = second.charAt(i) - '0';
			
			int sum = (firstBit ^ secondBit ^ carry);
			
			result = (char) sum + result;
			
			carry = (firstBit & secondBit) |(secondBit & carry) | (firstBit & carry);
		}
		if(carry == 1) {
			result = '1' + result;
		}
		return result;
	}
	
	public static int multiplySingleBit(String x, String y) {
		return(x.charAt(0) - '0') * (y.charAt(0) - '0');
	}
	
	public static int makeEqualLength(String x, String y) {
		int diff = 0;
		if(x.length() > y.length()) {
			diff = x.length() - y.length();
			for(int i = 0; i<diff; i++) {
				y = "0" + y;
			}
		}
		else {
			diff = y.length() - x.length();
			for(int i = 0; i<diff; i++) {
				x = "0" + x;
			}
		}
		return x.length();
	}
}
