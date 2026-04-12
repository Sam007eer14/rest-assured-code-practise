package aeiou;

import java.util.*;
public class ReverseVowels {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String value = sc.nextLine();  //My Name is Sameer
		int firstVal = 0;
		int lastVal = value.length() -1;
		char [] splitValue = value.toCharArray();
		
		String vowelsVal = "aeiouAEIOU";
		List<Character> list = new ArrayList();
		char [] charVal = vowelsVal.toCharArray();
		for(char temp : charVal) {
			list.add(temp);
		}
		
		while(firstVal<lastVal) {
			if(!list.contains(splitValue[firstVal])) {
				firstVal++;
			}
			else if(!list.contains(splitValue[lastVal])) {
				lastVal--;
			}
			else {
				char temp;
				temp = splitValue[firstVal] ;
				splitValue[firstVal] = splitValue[lastVal];
				splitValue[lastVal] = temp;
				firstVal++;
				lastVal--;
				
			}
		}
		System.out.println("he Reversed Strings are ");
		System.out.println(splitValue);
		
	}

}
