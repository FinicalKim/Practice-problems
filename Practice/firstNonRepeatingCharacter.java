package Practice;

import java.util.HashMap;

public class firstNonRepeatingCharacter {

	public static void main(String[] args) {
	
		String str = "aaabcccdeeef";
		
		System.out.println(findFirstNonRepeatingChar(str));
	}
	
	public static char findFirstNonRepeatingChar(String s) {
		HashMap<Character, Integer> char_counts = new HashMap<Character, Integer>();
			// cycle through the string 
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (char_counts.containsKey(c)) {	// if the character is in the hashmap then increment the amount of times the character has been seen
				char_counts.put(c, char_counts.get(c) + 1);
			}else {		// if the character is not found then add the character to the hashmap and set its occurrences to 1
				char_counts.put(c, 1);
			}
		}
		for (int i = 0; i <s.length(); i++) {	// cycle through the hashmap one more time to find the first occurring non repeating character
			char c = s.charAt(i);
			if (char_counts.get(c) == 1) {	// if the occurrences equal 1 then return the character
				return c;
			}
		}
		return '_';	// if there is no non repeating characters return an underscore
	}

}
