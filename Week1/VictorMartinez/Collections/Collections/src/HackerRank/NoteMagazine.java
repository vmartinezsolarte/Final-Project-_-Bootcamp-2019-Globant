package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NoteMagazine {
	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		if ((magazine.length < 1 || note.length < 1) && (magazine.length > 5 || note.length > 5)) {
			System.out.println("No");
		} else {
			int isWord[] = new int[note.length];
			int tempValue = 0;
			for (int i = 0; i < note.length; i++) {
				for (int j = 0; j < magazine.length; j++) {
					System.out.println(note[i] + "-" + magazine[j]);
					if (note[i].contentEquals(magazine[j])) {
						isWord[i] = 1;
						magazine[i] = " ";
						break;
					}
				}
			}
			print(isWord);
			for (int i = 0; i < isWord.length; i++) {
				tempValue += isWord[i];
			}
			if (tempValue == note.length) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	static void print(String[] element) {
		for (int i = 0; i < element.length; i++) {
			System.out.print(element[i] + " ");
		}
		System.out.println("");
	}

	static void print(int[] element) {
		for (int i = 0; i < element.length; i++) {
			System.out.print(element[i] + " ");
		}
		System.out.println("");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		 String[] mn = scanner.nextLine().split(" ");

		 int m = Integer.parseInt(mn[0]);
		
		 int n = Integer.parseInt(mn[1]);
		
		 String[] magazine = new String[m];

		 String[] magazineItems = scanner.nextLine().split(" ");
		 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];
		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
