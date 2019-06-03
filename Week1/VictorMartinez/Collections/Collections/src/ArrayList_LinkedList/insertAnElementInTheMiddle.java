package ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import HashTables.auxfunctions;
import LIST.auxObject;

//insertElement Test: ArrayList vs LinkedList	Time Result After Inserting an Element in the Middle
//Starting Test
//
//Integer : ArrayList and LinkedList
//Time Integer ArrayList : 12970 us
//Time Integer LinkedList : 62108 us
//
//String : ArrayList and LinkedList
//Time String ArrayList : 101380 us
//Time String LinkedList : 113183 us
//
//Object : ArrayList and LinkedList
//Time Integer ArrayList : 114746 us
//Time Integer LinkedList : 156428 us
//
//End Test



public class insertAnElementInTheMiddle {

	

	static int rangeValues = ArrayList_LinkedList.auxfunctions.range;
	static long start;
	static long end;
	static int extraIndex = 10000000;
	final static String LLIST = "LinkedList";
	final static String ALIST = "ArrayList";

	public static List<Integer> insertIntegerElement(List<Integer> arr, String title) {
		int middle = (int)arr.size()/2;
		start = auxfunctions.getTime();
		arr.add(middle, HashTables.auxfunctions.randomNumberGenerator(rangeValues));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return arr;
	}

	public static List<String> insertStringElement(List<String> arr, String title) {
		int middle = (int)arr.size()/2;
		start = auxfunctions.getTime();
		arr.add(middle,HashTables.auxfunctions.randomStringsGenerator(ArrayList_LinkedList.auxfunctions.stringLength));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time String " + title + " : " + end + " us");
		return arr;
	}

	public static List<auxObject> insertObjectElement(List<auxObject> arr, String title) {
		int middle = (int)arr.size()/2;
		start = auxfunctions.getTime();
		arr.add(middle, new auxObject(HashTables.auxfunctions.randomStringsGenerator(ArrayList_LinkedList.auxfunctions.stringLength),HashTables.auxfunctions.randomNumberGenerator(rangeValues-1)));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return arr;
	}

	public static void TestinsertElement() {
		System.out.println(" insertElement Test: ArrayList vs LinkedList");
		TestinsertElement1();
		TestinsertElement2();
		TestinsertElement3();
	}

	private static void TestinsertElement1() {

		// Create DataStructures : Integers, String, Object with two properties: Name,
		// Age.
		ArrayList<Integer>  intAL = ArrayList_LinkedList.auxfunctions.createIntegerArrayList(rangeValues);
		LinkedList<Integer> intLL = ArrayList_LinkedList.auxfunctions.createIntegerLinkedList(rangeValues);

		System.out.println("Starting Test");
		System.out.println("");
		System.out.println("Integer : ArrayList and LinkedList");

		insertIntegerElement((ArrayList<Integer>)intAL, ALIST);
		insertIntegerElement((LinkedList<Integer>)intLL, LLIST);
		System.out.println("");
	}

	private static void TestinsertElement2() {
		
		ArrayList<String>  strAL = ArrayList_LinkedList.auxfunctions.createStringArrayList(rangeValues);
		LinkedList<String> strLL = ArrayList_LinkedList.auxfunctions.createStringLinkedList(rangeValues);
			

		System.out.println("String : ArrayList and LinkedList");
		insertStringElement((ArrayList<String>)strAL, ALIST);
		insertStringElement((LinkedList<String>)strLL, LLIST);
		System.out.println("");

	}

	private static void TestinsertElement3() {
		ArrayList<auxObject>  objAL = ArrayList_LinkedList.auxfunctions.createObjectArrayList(rangeValues);
		LinkedList<auxObject> objLL = ArrayList_LinkedList.auxfunctions.createObjectLinkedList(rangeValues);
			
		System.out.println("Object : ArrayList and LinkedList");
		insertObjectElement((ArrayList<auxObject>)objAL, ALIST);
		insertObjectElement((LinkedList<auxObject>)objLL, LLIST);
		System.out.println("");
		System.out.println("End Test");
	}


	
}
