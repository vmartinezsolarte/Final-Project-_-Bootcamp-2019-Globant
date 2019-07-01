import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Exercise {

	static String inputx;
	static String cur;
	static ArrayList<String> arr = new ArrayList<String>();

	public static void main(String[] args) {

		String testWord = "attract";
		generate(testWord);
		print(arr);
		arr = filterNotPalindrome(arr);
		print(arr);
		
	}

	public static ArrayList<String> filterNotPalindrome(ArrayList<String> elements) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < elements.size(); i++) {
			if (isPalindrome(elements.get(i))) {
				res.add(elements.get(i));
			}
		}
		return res;
	}

	public static boolean isPalindrome(String str) {
		String reverse = "";

		for (int i = str.length() - 1; i >= 0; i--)
			reverse = reverse + str.charAt(i);
		if (str.equalsIgnoreCase(reverse)) {
			return true;
		} else {
			return false;
		}
	}

	public static void next(int pos, int reminder) {
		cur += (inputx.charAt(pos));

		if (reminder == 1) {
			arr.add(cur);
		} else {
			for (int i = pos + 1; i + reminder - 1 <= inputx.length(); i++)
				next(i, reminder - 1);
		}
		cur = cur.substring(0, cur.length() - 1);
		// deleteCharAt(cur.length() - 1);
	}

	public static void generate(String input) {
		// cur = new StringBuilder();
		cur = "";
		inputx = input;
		for (int length = 1; length <= input.length(); length++)
			for (int pos = 0; pos + length <= input.length(); pos++)
				next(pos, length);
	}

	public static void print(ArrayList<String> arr) {
		for (String args : arr) {
			System.out.print(args + " ");
		}
		System.out.println("");
	}

}
