/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
*/
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
public class LetterCount{

	public static void main(String[] args) {
		Scanner receiver = new Scanner(System.in);
		System.out.println("Please enter a long string of characters and hit <ENTER>");
		String phrase = receiver.nextLine();
		HashMap<Character,Integer> letter_counter = MakeDictionary(phrase);
		System.out.println("Now enter a word and hit <ENTER>");
		String word = receiver.nextLine();
		HashSet<Character> letters = MakeSet(word);
		System.out.println("The frequenciesof the word's letters in the string are as follows:");
		for (Character c: letters) {
			if (letter_counter.containsKey(c)) {
				System.out.println(c+": "+letter_counter.get(c));
			}else{
				System.out.println(c+": "+0);
			}

		}

	}
	public static HashMap<Character,Integer> MakeDictionary(String word){
		HashMap<Character,Integer> letter_counter = new HashMap<Character,Integer>();
		for (int i=0; i<word.length(); i++) {
			Character  letter = word.charAt(i);
		 	if (letter_counter.containsKey(letter)) {
		 		Integer counter = letter_counter.get(letter)+1;
		 		letter_counter.put(letter, counter);
		 	}else{
		 		letter_counter.put(letter, 1);
		 	}
		}
		return letter_counter;
	}
	public static HashSet<Character> MakeSet(String word){
		HashSet<Character> letters = new HashSet<Character>();
		for (int i=0; i<word.length(); i++) {
			Character letter = word.charAt(i);
			letters.add(letter);
		}
		return letters;
	}

}