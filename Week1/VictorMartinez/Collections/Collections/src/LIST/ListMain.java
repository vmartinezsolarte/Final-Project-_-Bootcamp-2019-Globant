package LIST;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Function;

/*
 * 
 * 
						Collections : ArrayList vs LinkedList
	
	Adding a Simple Value
	
	//	Time for ArrayList   : 14305 ns								 // Adding an Integer value to ArrayList
	//  Time for LinkedList  :  5915 ns              				 // Adding an Integer value to LinkedList 

	//  Time for ArrayList   :  1893 ns								 // Adding a String value to ArrayList
	//  Time for LinkedLIst  :  1147 ns                                // Adding a String value to LinkedLIst

	// 	Time for ArrayList   :  1975 ns 							 // Adding an Object to ArrayList 
	//	Time for LinkedList	 :  2512 ns 							 // Adding an Object to LinkedList 
	
	Sorting Results
	
	//	Time for ArrayList   : 16269 ms								 // Time Ordering Integer ArrayList  Elements
	//  Time for LinkedList  : 19549 ms              				 // Time Ordering Integer LinkedList Elements
	
	//  Time for ArrayList   : 22009 ms                             // Time Ordering String ArrayList  Elements
	//  Time for LinkedList  : 24892 ms                             // Time Ordering String LinkedList  Elements

	//	Time for ArrayList   : 23879 ms								// Time Ordering Object ArrayList Elements
	//	Time for LinkedList  : 26278 ms								// Time Ordering Object LinkedList Elements

	Removing an item from the middle

	//	Time for ArrayList   : 59 ms						    // Time removing Integer  from ArrayList  
	//  Time for LinkedList  : 60 ms              				 // Time removing Integer from LinkedList 
	
	//  Time for ArrayList   : 114 ms                             // Time removing String from ArrayList 
	//  Time for LinkedList  : 116 ms                             // Time removing String from LinkedList 

	//	Time for ArrayList   : 170 ms								// Time removing Object from ArrayList 
	//	Time for LinkedList  : 157 ms								// Time removing Object from LinkedList 


	Insert an item in the middle

	//	Time for ArrayList   : 11.836 us						    // Time Inserting Integer to ArrayList  
	//  Time for LinkedList  : 12.894 us              				// Time Inserting Integer to LinkedList 
	
	//  Time for ArrayList   : 12 ms                             // Time Inserting String to ArrayList 
	//  Time for LinkedList  : 9  ms                             // Time Inserting String to LinkedList 

	//	Time for ArrayList   : 113.776 us								// Time Inserting Object to ArrayList 
	//	Time for LinkedList  : 105.977 us								// Time Inserting Object to LinkedList 


	Iterate through the Whole Collection

	//	Time for ArrayList   : 27.511 ms						    // Time Iteration on Integers - ArrayList  
	//  Time for LinkedList  : 21.046 ms              				// Time Iteration on Integers - LinkedList 
	
	//  Time for ArrayList   : 25.192 ms                             // Time, Iteration on String  - ArrayList 
	//  Time for LinkedList  : 30.350 ms                             // Time, Iteration on Strings - LinkedList 

	//	Time for ArrayList   : 25.202 ms								// Time, Iteration on Objects - ArrayList 
	//	Time for LinkedList  : 39.395 ms								// Time, Iteration ob objects - LinkedList 

*/
public class ListMain {
	static int range = 10000000; // Creating 10 millions of elements
	static long start; // Initial time variable
	static long end; // End time variable
	static int stringLength = 4; // Limiting the String length;
	static int addedIntegerValue[];

	public static void main(String[] args) {

		// Create the data Structure

			List<Integer> arrList = createArrayList(range); //Integer ArrayList Element
			List<Integer> linList = createLinkedList(range); //Integer Linked List

		//List<String> arrList = createStringArrayList(range); // String ArrayList Element
		//List<String> linList = createStringLinkedList(range); //String LinkedList Element
		
		
		//List<auxObject> arrList = createObjectArrayList(range); // String ArrayList Element
		//List<auxObject> linList = createObjectLinkedList(range); //String LinkedList Element
		
		//Printing Array Size and Some objects for checking the correct Behavior;
		//System.out.println(linList.size());
		//printObjects(linList, 5);
		
		
		
		// Testing Time : Adding a Simple Element    ******

		//arrList = calculateStringAddingElement((ArrayList) arrList, "ArrayList");
		//linList = calculateStringAddingElement((LinkedList) linList, "LinkedLIst");
		//arrList = calculateObjectAddingElement((ArrayList<auxObject> )arrList, "ArrayList");
		//linList = calculateObjectAddingElement((LinkedList<auxObject>) linList, "LinkedLIst");

		
		// Testing time : Ordering ArrayList    	 ***** 
		//arrList= calculateObjectTimeOrdering(arrList, "ArrayList" ); //Testing Time
		// linList= calculateObjectTimeOrdering(linList, "LinkedList"); //Testing Time

		//System.out.println("");
		//printObjects(linList, 5)
		
		
		// Testing time : Remove an element from the Middle ****
		linList= iterateInIntegersCollection((ArrayList<Integer>)arrList, "arrList"); //Testing Time
		linList= iterateInIntegersCollection((ArrayList<Integer>)linList, "LinkedList"); //Testing Time
		
		
		
		//System.out.println(arrList.size());
		//System.out.println(linList.size());
	}

	static List<Integer> calculateIntegerAddingElement(List<Integer> arr, String title) {
		start = 0;
		end = 0;
		start = System.nanoTime();
		arr.add(1);
		end = System.nanoTime();
		end = (end - start);
		end = end;
		System.out.println("Time for " + title + "  : " + start + " - " + end);
		return null;
		// return arr;
	}

	static ArrayList<String> calculateStringAddingElement(LinkedList<String> arr, String title) {
		start = 0;
		end = 0;
		start = System.nanoTime();
		arr.add("abcd");
		end = System.nanoTime();
		end = (end - start);
		end = end;
		System.out.println("Time for " + title + "  : " + "  " + end);
		return null;

	}

	static LinkedList<String> calculateStringAddingElement(ArrayList<String> arr, String title) {
		start = 0;
		end = 0;
		start = System.nanoTime();
		arr.add("abcd");
		end = System.nanoTime();
		end = (end - start);
		end = end;
		System.out.println("Time for " + title + "  : " + " " + end);
		return null;

	}
	
	static ArrayList<auxObject> calculateObjectAddingElement(ArrayList<auxObject> arr, String title) {
		start = 0;
		end = 0;
		start = System.nanoTime();
		arr.add(new auxObject("abcd",stringLength));
		end = System.nanoTime();
		end = (end - start);
		end = end;
		System.out.println("Time for " + title + "  : " + " " + end);
		return null;

	}

	static LinkedList<auxObject> calculateObjectAddingElement(LinkedList<auxObject> arr, String title) {
		start = 0;
		end = 0;
		start = System.nanoTime();
		arr.add(new auxObject("abcd",stringLength));
		end = System.nanoTime();
		end = (end - start);
		end = end;
		System.out.println("Time for " + title + "  : " + " " + end);
		return null;

	}
	
	

	static List<Integer> calculateTimeOrdering(List<Integer> arr, String title) {
		start = 0;
		end = 0;
		start = System.nanoTime();
		arr.sort(Comparator.naturalOrder());
		end = System.nanoTime();
		end = (end - start);
		end = end / 1000000;
		System.out.println("Time for " + title + "  : " + end);
		return null;
		// return arr;
	}

	static List<String> calculateStringTimeOrdering(List<String> arr, String title) {
		start = 0;
		end = 0;
		start = System.nanoTime();
		arr.sort(Comparator.naturalOrder());
		end = System.nanoTime();
		end = (end - start);
		end = end / 1000000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}
	
	static List<auxObject> calculateObjectTimeOrdering(List<auxObject> arr, String title) {
		start = 0;
		end = 0;
		start = System.nanoTime();
		//arr.sort(Co);
		Collections.sort(arr);
		end = System.nanoTime();
		end = (end - start);
		end = end / 1000000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}

	
	static List<auxObject> removeObjectFromMiddle(List<auxObject> arr, String title) {
		start = 0;
		end = 0;
		int middle = (int)arr.size()/2;
		start = System.nanoTime();
		//arr.sort(Co);
		arr.remove(middle);
		end = System.nanoTime();
		end = (end - start);
		end = end / 1000000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}
	
	static List<Integer> removeIntegerFromMiddle(List<Integer> arr, String title) {
		start = 0;
		end = 0;
		int middle = (int)arr.size()/2;
		start = System.nanoTime();
		//arr.sort(Co);
		arr.remove(middle);
		end = System.nanoTime();
		end = (end - start);
		end = end / 1000000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}
	static List<String> removeStringFromMiddle(List<String> arr, String title) {
		start = 0;
		end = 0;
		int middle = (int)arr.size()/2;
		start = System.nanoTime();
		//arr.sort(Co);
		arr.remove(middle);
		end = System.nanoTime();
		end = (end - start);
		end = end / 1000000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}
	static List<String> insertStringInMiddle(List<String> arr, String title) {
		start = 0;
		end = 0;
		int middle = (int)arr.size()/2;
		start = System.nanoTime();
		//arr.sort(Co);
		arr.add(middle, "abcd");
		end = System.nanoTime();
		end = (end - start);
		end = end / 1000000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}
	
	static List<Integer> insertIntegerInMiddle(List<Integer> arr, String title) {
		start = 0;
		end = 0;
		int middle = (int)arr.size()/2;
		start = System.nanoTime();
		//arr.sort(Co);
		arr.add(middle, 1);
		end = System.nanoTime();
		end = (end - start);
		end = end /1000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}
	
	
	static List<auxObject> insertObjectInMiddle(List<auxObject> arr, String title) {
		start = 0;
		end = 0;
		int middle = (int)arr.size()/2;
		start = System.nanoTime();
		//arr.sort(Co);
		arr.add(middle, new auxObject("abcd",stringLength));
		end = System.nanoTime();
		end = (end - start);
		end = end /1000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}
	
	static List<auxObject> iterateInObjectCollection(List<auxObject> arr, String title) {
		start = 0;
		end = 0;
		Iterator it = arr.iterator();
		start = System.nanoTime();
	
		while(it.hasNext()) {
			it.next();
		}
		
		end = System.nanoTime();
		end = (end - start);
		end = end /1000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}
	
	static List<String> iterateInStringsCollection(List<String> arr, String title) {
		start = 0;
		end = 0;
		Iterator it = arr.iterator();
		start = System.nanoTime();
	
		while(it.hasNext()) {
			it.next();
		}
		
		end = System.nanoTime();
		end = (end - start);
		end = end /1000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}
	

	static List<Integer> iterateInIntegersCollection(List<Integer> arr, String title) {
		start = 0;
		end = 0;
		Iterator it = arr.iterator();
		start = System.nanoTime();
	
		while(it.hasNext()) {
			it.next();
		}
		
		end = System.nanoTime();
		end = (end - start);
		end = end /1000;
		System.out.println("Time for " + title + "  : " + end);
		// return null;
		return arr;
	}

	static ArrayList<Integer> createArrayList(int quantity) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < quantity; i++) {
			arr.add(randomNumberGenerator(range));
		}
		return arr;
	}

	static LinkedList<Integer> createLinkedList(int quantity) {
		LinkedList<Integer> arr = new LinkedList<Integer>();
		for (int i = 0; i < quantity; i++) {
			arr.add(randomNumberGenerator(range));
		}
		return arr;
	}

	static int randomNumberGenerator(int range) {

		return (int) Math.floor(Math.random() * 9999999);
	}

	static String randomStringsGenerator(int length) {
		String res = "";
		char alphabet[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < length; i++) {
			int index = (int) Math.floor((Math.random() * alphabet.length));
			res = res + alphabet[index];
		}
		return res;
	}

	static ArrayList<String> createStringArrayList(int quantity) {
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < quantity; i++) {
			arr.add(randomStringsGenerator(stringLength));
		}
		return arr;
	}

	static LinkedList<String> createStringLinkedList(int quantity) {
		LinkedList<String> arr = new LinkedList<String>();
		for (int i = 0; i < quantity; i++) {
			arr.add(randomStringsGenerator(stringLength));
		}
		return arr;
	}
	
	static ArrayList<auxObject> createObjectArrayList (int val){
		ArrayList<auxObject> res = new ArrayList<auxObject>();
		for(int i =0; i<val;i++) {
			res.add(new auxObject(randomStringsGenerator(stringLength), randomNumberGenerator(range)));
		}
		
	return res;
	}
	
	static LinkedList<auxObject> createObjectLinkedList (int val){
		LinkedList<auxObject> res = new LinkedList<auxObject>();
		for(int i =0; i<val;i++) {
			res.add(new auxObject(randomStringsGenerator(stringLength), randomNumberGenerator(range)));
		}
	return res;
	}
	
	static void printObjects (List<auxObject> r, int views) {
		int cont =0;
		Iterator l = r.iterator();
		while(l.hasNext() && cont< views) {
			System.out.println(l.next().toString());
			cont++;
		}
		
	}
	

}
