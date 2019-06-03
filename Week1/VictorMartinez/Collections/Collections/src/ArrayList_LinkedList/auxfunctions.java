package ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import HashTables.auxfunctions.*;
import LIST.ListMain;
import LIST.auxObject;

//sortingElement Test: ArrayList vs LinkedList		Time Result after Sorting the Collections
//Starting Test
//
//Integer : ArrayList and LinkedList
//Time Integer ArrayList : 16506596 us
//Time Integer LinkedList : 20862921 us
//
//String : ArrayList and LinkedList
//Time String ArrayList : 23248737 us
//Time String LinkedList : 26020507 us
//
//Object : ArrayList and LinkedList
//Time Integer ArrayList : 26811431 us
//Time Integer LinkedList : 27888732 us
//
//End Test


public class auxfunctions {
	static int stringLength = 4;
	static int range = 10000000;

	public static ArrayList<Integer> createIntegerArrayList(int num) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			res.add(HashTables.auxfunctions.randomNumberGenerator(range));
		}
		return res;

	}

	public static LinkedList<Integer> createIntegerLinkedList(int num) {

		LinkedList<Integer> res = new LinkedList<Integer>();
		for (int i = 0; i < num; i++) {
			res.add(HashTables.auxfunctions.randomNumberGenerator(range));
		}
		return res;

	}

	public static ArrayList<String> createStringArrayList(int num) {

		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < num; i++) {
			res.add(HashTables.auxfunctions.randomStringsGenerator(stringLength));
		}
		return res;

	}

	public static LinkedList<String> createStringLinkedList(int num) {

		LinkedList<String> res = new LinkedList<String>();
		for (int i = 0; i < num; i++) {
			res.add(HashTables.auxfunctions.randomStringsGenerator(stringLength));
		}
		return res;

	}

	public static ArrayList<auxObject> createObjectArrayList(int num) {

		ArrayList<auxObject> res = new ArrayList<auxObject>();
		for (int i = 0; i < num; i++) {
			res.add(new auxObject(HashTables.auxfunctions.randomStringsGenerator(stringLength),
					HashTables.auxfunctions.randomNumberGenerator(range - 1)));
		}
		return res;

	}

	public static LinkedList<auxObject> createObjectLinkedList(int num) {

		LinkedList<auxObject> res = new LinkedList<auxObject>();
		for (int i = 0; i < num; i++) {
			res.add(new auxObject(HashTables.auxfunctions.randomStringsGenerator(stringLength),
					HashTables.auxfunctions.randomNumberGenerator(range)));
		}
		return res;
	}
	
	public static long getTime() {return HashTables.auxfunctions.getTime();}
	
	public static <T> void printSomeValues(List<T> arr, int views ) {
		for(int i =0; i<views;i++) {
			System.out.println(arr.get(i).toString());
		}
	}

}
