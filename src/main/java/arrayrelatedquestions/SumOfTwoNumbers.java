package arrayrelatedquestions;
import java.util.*;

public class SumOfTwoNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array");
	    int size = sc.nextInt();
	    int [] val = new int[size];
		System.out.println("Enter the target which you want to check");
	    int target = sc.nextInt();
	    int tempVal =0;
	    int matchVal;
	    boolean found=false;
	    System.out.println("Enter the " + size + "array elements");
	    for(int i=0; i<size; i++) {
	    	val[i] = sc.nextInt();
	    }
	    for(int i=0; i<size; i++) {
	    	for(int j=i+1; j<size; j++) {
	    		matchVal = val[i] + val[j];
	    		if(matchVal==target) {
	    			System.out.println("The target is found and the indexs are "+ i +" "+j);
	    			found=true;
	    		}
	    	}
	    }
	    if(!found) {
	        System.out.println("No pair found");
	    }
	    
	    
	}

}
