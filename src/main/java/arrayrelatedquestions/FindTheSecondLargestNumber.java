package arrayrelatedquestions;
import java.util.*;

public class FindTheSecondLargestNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		int largestValue = Integer.MIN_VALUE;
		int secondLargestValue = Integer.MIN_VALUE;
		int [] val = new int[size];
		for(int i=0; i<size; i++) {
			val[i] = sc.nextInt();
		}
		for(int tempValue : val) {
			if(tempValue>largestValue && largestValue>=secondLargestValue) {
				secondLargestValue = largestValue;
				largestValue=tempValue;
				
			}
			else if(tempValue>secondLargestValue && secondLargestValue!=largestValue) {
				secondLargestValue = tempValue;
			}
		}
		System.out.println("The second largest value is " + secondLargestValue);
		
		
	}

}
