package aeiou;
import java.util.*;


public class VowelsCount {
	public static void main(String[] ags) {
		Scanner sc = new Scanner(System.in);
		String vowels = "aeiouAEIOU";
		List<Character> vowelChar = new ArrayList();
		char [] charVal = vowels.toCharArray();
		for(char val : charVal) {
			vowelChar.add(val);
		}
		System.out.println("Enter the String vlaues which needs to be find vowels");
		String enteredValue = sc.nextLine();
		char [] enteredVal = enteredValue.toCharArray();
		HashMap<Character, Integer> map = new HashMap();
		for(char val2 : enteredVal) {
			if(vowelChar.contains(val2)) {
				System.out.println(val2);
				map.put(val2, map.getOrDefault(val2, 0)+1);
			}
		}
		System.out.println(map);
	}

}
