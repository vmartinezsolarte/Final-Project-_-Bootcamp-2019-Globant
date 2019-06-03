package ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import HashTables.HashMap_vs_TreeMap;
import HashTables.auxfunctions;
import LIST.auxObject;

//Starting Test						Time Results after adding an element.
//
//Integer : ArrayList and LinkedList
//Time Integer ArrayList : 21 us
//Time Integer LinkedList : 1 us
//
//String : ArrayList and LinkedList
//Time String ArrayList : 12 us
//Time String LinkedList : 2 us
//
//Object : ArrayList and LinkedList
//Time Integer ArrayList : 21 us
//Time Integer LinkedList : 3 us
//
//End Test

public class addNewElement {

	static int rangeValues = ArrayList_LinkedList.auxfunctions.range;
	static long start;
	static long end;
	static int extraIndex = 10000000;
	final static String LLIST = "LinkedList";
	final static String ALIST = "ArrayList";

	public static List<Integer> addIntegerElement(List<Integer> arr, String title) {

		start = auxfunctions.getTime();
		arr.add(HashTables.auxfunctions.randomNumberGenerator(extraIndex));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return arr;
	}

	public static List<String> addStringElement(List<String> arr, String title) {

		start = auxfunctions.getTime();
		arr.add(HashTables.auxfunctions.randomStringsGenerator(ArrayList_LinkedList.auxfunctions.stringLength));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time String " + title + " : " + end + " us");
		return arr;
	}

	public static List<auxObject> addObjectElement(List<auxObject> arr, String title) {

		start = auxfunctions.getTime();
		arr.add(new auxObject(
				HashTables.auxfunctions.randomStringsGenerator(ArrayList_LinkedList.auxfunctions.stringLength),
				HashTables.auxfunctions.randomNumberGenerator(extraIndex)));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return arr;
	}

	public static void TestAddElement() {
		System.out.println(" addNewElement Test: ArrayList vs LinkedList");
		TestAddElement1();
		TestAddElement2();
		TestAddElement3();
	}

	private static void TestAddElement1() {

		// Create DataStructures : Integers, String, Object with two properties: Name,
		// Age.
		ArrayList<Integer> intAL = ArrayList_LinkedList.auxfunctions.createIntegerArrayList(rangeValues);
		LinkedList<Integer> intLL = ArrayList_LinkedList.auxfunctions.createIntegerLinkedList(rangeValues);

		System.out.println("Starting Test");
		System.out.println("");
		System.out.println("Integer : ArrayList and LinkedList");

		addIntegerElement((ArrayList<Integer>) intAL, ALIST);
		addIntegerElement((LinkedList<Integer>) intLL, LLIST);
		System.out.println("");
	}

	private static void TestAddElement2() {

		ArrayList<String> strAL = ArrayList_LinkedList.auxfunctions.createStringArrayList(rangeValues);
		LinkedList<String> strLL = ArrayList_LinkedList.auxfunctions.createStringLinkedList(rangeValues);

		System.out.println("String : ArrayList and LinkedList");
		addStringElement((ArrayList<String>) strAL, ALIST);
		addStringElement((LinkedList<String>) strLL, LLIST);
		System.out.println("");

	}

	private static void TestAddElement3() {
		ArrayList<auxObject> strAL = ArrayList_LinkedList.auxfunctions.createObjectArrayList(rangeValues);
		LinkedList<auxObject> strLL = ArrayList_LinkedList.auxfunctions.createObjectLinkedList(rangeValues);

		System.out.println("Object : ArrayList and LinkedList");
		addObjectElement((ArrayList<auxObject>) strAL, ALIST);
		addObjectElement((LinkedList<auxObject>) strLL, LLIST);
		System.out.println("");
		System.out.println("End Test");
	}

}
