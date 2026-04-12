package arrayrelatedquestions;
import java.util.*;
public class LinearSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int findValue = 34;
		System.out.println("Enter the size of an array");
        int size = sc.nextInt();
        System.out.println("Enter the all " + size + "values into the array");
		int [] val = new int[size];
	
	  for(int i=0; i<size; i++) {
		  val[i] = sc.nextInt();
	  }
	  for(int i=0; i<size; i++) {
		  if(findValue==val[i]) {
			  System.out.println("The value is found and the index is " + i);
			  System.out.println("The value is " + val[i]);
		  }
	  }
	}
	

}
