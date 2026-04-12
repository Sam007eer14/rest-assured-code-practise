package aeiou;

import java.util.*;
public class ReverseOnlyLetters {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	 System.out.println("Enter the value to be noted");
	 String value = sc.nextLine();
	 char [] splitValue = value.toCharArray();
	 int left =0;
	 int right = splitValue.length -1;
	 while(left<right) {
		 if(!Character.isLetter(splitValue[left])) {
			 left++;
		 }
		 else if(!Character.isLetter(splitValue[right])) {
			 right--;
		 }
		 else {
			 char temp;
			 temp = splitValue[left];
			 splitValue[left]= splitValue[right];
			 splitValue[right] = temp;
			 left++;
			 right--;
		 }
	 }
	 System.out.println("The reversed Letter values are");
	 System.out.println(splitValue);
	}
}
