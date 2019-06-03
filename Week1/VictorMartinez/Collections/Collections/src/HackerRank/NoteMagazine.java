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
		int repeated []= new int[magazine.length];
		for(int i =0; i<note.length;i++) {
			for(int j =0; j<magazine.length;j++) {
				if(note[i]==magazine[j]) {
					for(int k =0; k<repeated.length;k++) {
						if(repeated[i]==j) {
							break;
						}
					}
					repeated[i]=j;
				};
			}
		}
		print(repeated);
		if(repeated.length==note.length) {
			System.out.println("Yes");
		}else {
			System.out.println("False");
		}
		
		
	}
	static void print(String[] element) {
		for(int i=0; i<element.length;i++) {
			System.out.print(element[i]+" ");
		}
		System.out.println("");
	}
	static void print(int[] element) {
		for(int i=0; i<element.length;i++) {
			System.out.print(element[i]+" ");
		}
		System.out.println("");
	}
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//String[] mn = scanner.nextLine().split(" ");

		//int m = Integer.parseInt(mn[0]);
		int m = 6;
		//int n = Integer.parseInt(mn[1]);
		int n = 4;
		String[] magazine = new String[m];

		//String[] magazineItems = scanner.nextLine().split(" ");
		String[] magazineItems = "give me one grand today night".split(" ");
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	
		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];
		String[] noteItems = "give one grand today".split(" ");
		//	String[] noteItems = scanner.nextLine().split(" ");
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

	//	scanner.close();
	}
}


