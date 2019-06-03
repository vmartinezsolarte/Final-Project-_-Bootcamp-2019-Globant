package ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import HashTables.auxfunctions;
import LIST.auxObject;


//iterateElement Test: ArrayList vs LinkedList			Test Results after interating through the Whole Collection
//Starting Test
//
//Integer : ArrayList and LinkedList
//Time Integer ArrayList : 25669 us
//Time Integer LinkedList : 206093 us
//
//String : ArrayList and LinkedList
//Time String ArrayList : 17376 us
//Time String LinkedList : 331224 us
//
//Object : ArrayList and LinkedList
//Time Integer ArrayList : 19226 us
//Time Integer LinkedList : 390983 us
//
//End Test



public class iterateOverWholeCollection {


	static int rangeValues = ArrayList_LinkedList.auxfunctions.range;
	static long start;
	static long end;
	static int extraIndex = 10000000;
	final static String LLIST = "LinkedList";
	final static String ALIST = "ArrayList";

	public static List<Integer> iterateIntegerElement(List<Integer> arr, String title) {
		
		start = auxfunctions.getTime();
		Iterator<Integer> it = arr.iterator();
		while(it.hasNext()) {
			it.next();
		}
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return arr;
	}

	public static List<String> iterateStringElement(List<String> arr, String title) {
		
		start = auxfunctions.getTime();
		Iterator<String> it = arr.iterator();
		while(it.hasNext()) {
			it.next();
		}
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time String " + title + " : " + end + " us");
		return arr;
	}

	public static List<auxObject> iterateObjectElement(List<auxObject> arr, String title) {
		
		start = auxfunctions.getTime();
		Iterator<auxObject> it = arr.iterator();
		while(it.hasNext()) {
			it.next();
		}
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return arr;
	}

	public static void TestiterateElement() {
		System.out.println(" iterateElement Test: ArrayList vs LinkedList");
		TestiterateElement1();
		TestiterateElement2();
		TestiterateElement3();
	}

	private static void TestiterateElement1() {

		// Create DataStructures : Integers, String, Object with two properties: Name,
		// Age.
		ArrayList<Integer>  intAL = ArrayList_LinkedList.auxfunctions.createIntegerArrayList(rangeValues);
		LinkedList<Integer> intLL = ArrayList_LinkedList.auxfunctions.createIntegerLinkedList(rangeValues);

		System.out.println("Starting Test");
		System.out.println("");
		System.out.println("Integer : ArrayList and LinkedList");

		iterateIntegerElement((ArrayList<Integer>)intAL, ALIST);
		iterateIntegerElement((LinkedList<Integer>)intLL, LLIST);
		System.out.println("");
	}

	private static void TestiterateElement2() {
		
		ArrayList<String>  strAL = ArrayList_LinkedList.auxfunctions.createStringArrayList(rangeValues);
		LinkedList<String> strLL = ArrayList_LinkedList.auxfunctions.createStringLinkedList(rangeValues);
			

		System.out.println("String : ArrayList and LinkedList");
		iterateStringElement((ArrayList<String>)strAL, ALIST);
		iterateStringElement((LinkedList<String>)strLL, LLIST);
		System.out.println("");

	}

	private static void TestiterateElement3() {
		ArrayList<auxObject>  objAL = ArrayList_LinkedList.auxfunctions.createObjectArrayList(rangeValues);
		LinkedList<auxObject> objLL = ArrayList_LinkedList.auxfunctions.createObjectLinkedList(rangeValues);
			
		System.out.println("Object : ArrayList and LinkedList");
		iterateObjectElement((ArrayList<auxObject>)objAL, ALIST);
		iterateObjectElement((LinkedList<auxObject>)objLL, LLIST);
		System.out.println("");
		System.out.println("End Test");
	}

	
}
