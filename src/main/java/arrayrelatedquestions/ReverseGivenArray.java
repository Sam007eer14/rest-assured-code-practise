package arrayrelatedquestions;
import java.util.*;

public class ReverseGivenArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = sc.nextInt();
		System.out.println("Enter the total " + size + " of values in an array");
		int [] listOfNum = new int[size];
		for(int i=0; i<size; i++) {
			listOfNum[i] = sc.nextInt();
		}
		for(int i=size-1; i>=0; i--) {
			System.out.println("The Reversed number array is" + listOfNum[i]);
		}
	}

}
