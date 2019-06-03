package ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import HashTables.auxfunctions;
import LIST.auxObject;
//
//removeElement Test: ArrayList vs LinkedList          Time Results after removing the Middle Element
//Starting Test
//
//Integer : ArrayList and LinkedList
//Time Integer ArrayList  : 13520 us
//Time Integer LinkedList : 59038 us
//
//String : ArrayList and LinkedList
//Time String ArrayList  :  5828 us
//Time String LinkedList : 107819 us
//
//Object : ArrayList and LinkedList
//Time Integer ArrayList  : 115411 us
//Time Integer LinkedList : 159433 us
//
//End Test




public class removeElementFromMiddle {
	

	static int rangeValues = ArrayList_LinkedList.auxfunctions.range;
	static long start;
	static long end;
	static int extraIndex = 10000000;
	final static String LLIST = "LinkedList";
	final static String ALIST = "ArrayList";

	public static List<Integer> removeIntegerElement(List<Integer> arr, String title) {
		int middle = (int)arr.size()/2;
		start = auxfunctions.getTime();
		arr.remove(middle);
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return arr;
	}

	public static List<String> removeStringElement(List<String> arr, String title) {
		int middle = (int)arr.size()/2;
		start = auxfunctions.getTime();
		arr.remove(middle);
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time String " + title + " : " + end + " us");
		return arr;
	}

	public static List<auxObject> removeObjectElement(List<auxObject> arr, String title) {
		int middle = (int)arr.size()/2;
		start = auxfunctions.getTime();
		arr.remove(middle);
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return arr;
	}

	public static void TestRemoveElement() {
		System.out.println(" removeElement Test: ArrayList vs LinkedList");
		TestRemoveElement1();
		TestRemoveElement2();
		TestRemoveElement3();
	}

	private static void TestRemoveElement1() {

		// Create DataStructures : Integers, String, Object with two properties: Name,
		// Age.
		ArrayList<Integer>  intAL = ArrayList_LinkedList.auxfunctions.createIntegerArrayList(rangeValues);
		LinkedList<Integer> intLL = ArrayList_LinkedList.auxfunctions.createIntegerLinkedList(rangeValues);

		System.out.println("Starting Test");
		System.out.println("");
		System.out.println("Integer : ArrayList and LinkedList");

		removeIntegerElement((ArrayList<Integer>)intAL, ALIST);
		removeIntegerElement((LinkedList<Integer>)intLL, LLIST);
		System.out.println("");
	}

	private static void TestRemoveElement2() {
		
		ArrayList<String>  strAL = ArrayList_LinkedList.auxfunctions.createStringArrayList(rangeValues);
		LinkedList<String> strLL = ArrayList_LinkedList.auxfunctions.createStringLinkedList(rangeValues);
			

		System.out.println("String : ArrayList and LinkedList");
		removeStringElement((ArrayList<String>)strAL, ALIST);
		removeStringElement((LinkedList<String>)strLL, LLIST);
		System.out.println("");

	}

	private static void TestRemoveElement3() {
		ArrayList<auxObject>  objAL = ArrayList_LinkedList.auxfunctions.createObjectArrayList(rangeValues);
		LinkedList<auxObject> objLL = ArrayList_LinkedList.auxfunctions.createObjectLinkedList(rangeValues);
			
		System.out.println("Object : ArrayList and LinkedList");
		removeObjectElement((ArrayList<auxObject>)objAL, ALIST);
		removeObjectElement((LinkedList<auxObject>)objLL, LLIST);
		System.out.println("");
		System.out.println("End Test");
	}


}
