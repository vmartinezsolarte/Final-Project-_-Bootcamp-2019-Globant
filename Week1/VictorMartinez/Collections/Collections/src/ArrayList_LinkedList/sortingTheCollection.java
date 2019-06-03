package ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import HashTables.auxfunctions;
import LIST.auxObject;

public class sortingTheCollection {
	

	static int rangeValues = ArrayList_LinkedList.auxfunctions.range;
	static long start;
	static long end;
	static int extraIndex = 10000000;
	final static String LLIST = "LinkedList";
	final static String ALIST = "ArrayList";

	public static List<Integer> sortingIntegerElement(List<Integer> arr, String title) {
		
		start = auxfunctions.getTime();
		arr.sort(Comparator.naturalOrder());
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return arr;
	}

	public static List<String> sortingStringElement(List<String> arr, String title) {
		
		start = auxfunctions.getTime();
		arr.sort(Comparator.naturalOrder());
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time String " + title + " : " + end + " us");
		return arr;
	}

	public static List<auxObject> sortingObjectElement(List<auxObject> arr, String title) {
		
		start = auxfunctions.getTime();
		arr.sort(Comparator.naturalOrder());
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return arr;
	}

	public static void TestsortingElement() {
		System.out.println(" sortingElement Test: ArrayList vs LinkedList");
		TestsortingElement1();
		TestsortingElement2();
		TestsortingElement3();
	}

	private static void TestsortingElement1() {

		// Create DataStructures : Integers, String, Object with two properties: Name,
		// Age.
		ArrayList<Integer>  intAL = ArrayList_LinkedList.auxfunctions.createIntegerArrayList(rangeValues);
		LinkedList<Integer> intLL = ArrayList_LinkedList.auxfunctions.createIntegerLinkedList(rangeValues);

		System.out.println("Starting Test");
		System.out.println("");
		System.out.println("Integer : ArrayList and LinkedList");

		sortingIntegerElement((ArrayList<Integer>)intAL, ALIST);
		sortingIntegerElement((LinkedList<Integer>)intLL, LLIST);
		System.out.println("");
	}

	private static void TestsortingElement2() {
		
		ArrayList<String>  strAL = ArrayList_LinkedList.auxfunctions.createStringArrayList(rangeValues);
		LinkedList<String> strLL = ArrayList_LinkedList.auxfunctions.createStringLinkedList(rangeValues);
			

		System.out.println("String : ArrayList and LinkedList");
		sortingStringElement((ArrayList<String>)strAL, ALIST);
		sortingStringElement((LinkedList<String>)strLL, LLIST);
		System.out.println("");

	}

	private static void TestsortingElement3() {
		ArrayList<auxObject>  objAL = ArrayList_LinkedList.auxfunctions.createObjectArrayList(rangeValues);
		LinkedList<auxObject> objLL = ArrayList_LinkedList.auxfunctions.createObjectLinkedList(rangeValues);
			
		System.out.println("Object : ArrayList and LinkedList");
		sortingObjectElement((ArrayList<auxObject>)objAL, ALIST);
		sortingObjectElement((LinkedList<auxObject>)objLL, LLIST);
		System.out.println("");
		System.out.println("End Test");
	}

}
