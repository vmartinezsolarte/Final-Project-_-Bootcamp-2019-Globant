package HashTables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import LIST.auxObject;

//Starting Test					Time Results after making an iteration per element.

//
//Integer : HashMap and TreeMap
//Time Integer HashMap : 248 ms
//Time Integer TreeMap : 261 ms
//
//String : HashMap and TreeMap
//Time String HashMap : 47  ms
//Time String TreeMap : 29  ms
//
//Object : HashMap and TreeMap
//Time Object HashMap : 282 ms
//Time Object TreeMap : 336 ms
//
//End Test




public class IterateThroughMaps {
	

	static int rangeValues = HashMap_vs_TreeMap.range;
	static long start;
	static long end;
	static int extraIndex = 10000000;
	final static String HMAP = "HashMap";
	final static String TMAP = "TreeMap";

	public static Map<Integer, Integer> iterateInIntegerElement(Map<Integer, Integer> map, String title) {

		
		start = auxfunctions.getTime();
		Iterator<Integer> it = map.values().iterator();
		while(it.hasNext()) {
			it.next();
		}
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return map;
	}

	public static Map<String, String> iterateInStringElement(Map<String, String> map, String title) {
		//Generate random Index
		
		
		start = auxfunctions.getTime();
		Iterator<String> it = map.values().iterator();
		while(it.hasNext()) {
			it.next();
		}
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time String " + title + " : " + end + " us");
		return map;
	}

	public static Map<Integer, auxObject> iterateInObjectElement(Map<Integer, auxObject> map, String title) {
		
		start = auxfunctions.getTime();
		Iterator<auxObject> it = map.values().iterator();
		while(it.hasNext()) {
			it.next();
		}
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Object " + title + " : " + end + " us");
		return map;
	}
	
	public static void TestIterativeElement() {
		TestIterativeElement1();
		TestIterativeElement2();
		TestIterativeElement3();
	}
	
	private static void TestIterativeElement1() {
		

		// Create DataStructures : Integers, String, Object with two properties: Name,
		// Age.
		HashMap<Integer, Integer> intHM   = auxfunctions.createIntegerHashMap(rangeValues);
		TreeMap<Integer, Integer> intTM   = auxfunctions.createIntegerTreeMap(rangeValues);
		
		System.out.println("Starting Test");
		System.out.println("");
		System.out.println("Integer : HashMap and TreeMap");
		
		iterateInIntegerElement(intHM,HMAP);
		iterateInIntegerElement(intTM,TMAP);
		System.out.println("");
	}
	
	private static void TestIterativeElement2() {
		HashMap<String, String> strHM	  = auxfunctions.createStringHashMap(rangeValues);
		TreeMap<String, String> strTM 	  = auxfunctions.createStringTreeMap(rangeValues);
		
		
		System.out.println("String : HashMap and TreeMap");
		iterateInStringElement(strHM, HMAP);
		iterateInStringElement(strTM, TMAP);
		System.out.println("");
	
	}
	private static void TestIterativeElement3(){	
		HashMap<Integer, auxObject> objHM = auxfunctions.createObjectHashMap(rangeValues);
		TreeMap<Integer, auxObject> objTM = auxfunctions.createObjectTreeMap(rangeValues);

		System.out.println("Object : HashMap and TreeMap");
		iterateInObjectElement(objHM, HMAP);
		iterateInObjectElement(objTM, TMAP);
		System.out.println("");
		System.out.println("End Test");
	}
	

	
	
	
	

}
