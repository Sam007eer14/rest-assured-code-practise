package arrayrelatedquestions;

import java.util.*;

public class FirstTheLargetsNumberInArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int maxValue = Integer.MIN_VALUE;

        System.out.println("Enter the size of an array:");
        int size = sc.nextInt();

        int[] val = new int[size];

        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            val[i] = sc.nextInt();
        }

        for (int tempVal : val) {
            if(tempVal>=maxValue) {
            	maxValue = tempVal;
            }
        }
        System.out.println("The largest number is " + maxValue);

        sc.close();
    }
}