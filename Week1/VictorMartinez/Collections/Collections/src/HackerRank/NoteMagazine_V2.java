package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NoteMagazine_V2 {

	static void checkMagazine(String[] magazine, String[] note) {
		boolean nPossible = false;
		// Crear mapa con los valores del magazine
		HashMap<String, Integer> magazineM = new HashMap<String, Integer>();
		for (String word : magazine) {
			if (magazineM.get(word) == null) {
				magazineM.put(word, 1);
			} else {
				magazineM.put(word, magazineM.get(word) + 1);
			}
		}
		
		// Comparar que los recurrencias de cada palabra en el diccionario, se preste para reproducir el mensaje
		for(String words : note) {
			if(!magazineM.containsKey(words) || magazineM.get(words)<1) {
				nPossible = true;
			}else {
				magazineM.put(words, magazineM.get(words)-1);
			}
		}
		if(!nPossible) {
		System.out.println("Yes");}
		else {
		System.out.println("No");
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
		// String[] mn = scanner.nextLine().split(" ");

		// int m = Integer.parseInt(mn[0]);
		
		// int n = Integer.parseInt(mn[1]);
		
		

		String[] magazineItems = "two times three is not four".split(" ");
		// String[] magazineItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int m = magazineItems.length;
		String[] magazine = new String[m];
		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}
		
		String[] noteItems = "two times two is four".split(" ");
		int n =noteItems.length;
		String[] note = new String[n];
		
		
		// String[] noteItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
