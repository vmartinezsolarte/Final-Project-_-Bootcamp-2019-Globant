package HashTables;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import LIST.auxObject;

//Starting Test  	 			Time Results after finding an element by key

//Integer : HashMap and TreeMap
//Time Integer HashMap : 75 us
//Time Integer TreeMap : 56 us
//
//String : HashMap and TreeMap
//Time String HashMap : 16 us
//Time String TreeMap : 8 us
//
//Object : HashMap and TreeMap
//Time Object HashMap : 10 us
//Time Object TreeMap : 16 us
//
//End Test



public class FindNewElementByKey {
	
	
	static int rangeValues = HashMap_vs_TreeMap.range;
	static long start;
	static long end;
	static int extraIndex = 10000000;
	final static String HMAP = "HashMap";
	final static String TMAP = "TreeMap";

	public static Map<Integer, Integer> findIntegerElement(Map<Integer, Integer> map, String title) {

		start = auxfunctions.getTime();
		map.containsKey(auxfunctions.randomNumberGenerator(extraIndex-1));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return map;
	}

	public static Map<String, String> findStringElement(Map<String, String> map, String title) {

		start = auxfunctions.getTime();
		map.containsKey(auxfunctions.randomStringsGenerator(auxfunctions.lengthString));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time String " + title + " : " + end + " us");
		return map;
	}

	public static Map<Integer, auxObject> findObjectElement(Map<Integer, auxObject> map, String title) {

		start = auxfunctions.getTime();
		map.containsKey(auxfunctions.randomNumberGenerator(extraIndex-1));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Object " + title + " : " + end + " us");
		return map;
	}
	
	public static void TestFindElement() {
		TestFindElement1();
		TestFindElement2();
		TestFindElement3();
	}
	
	private static void TestFindElement1() {
		

		// Create DataStructures : Integers, String, Object with two properties: Name,
		// Age.
		HashMap<Integer, Integer> intHM   = auxfunctions.createIntegerHashMap(rangeValues);
		TreeMap<Integer, Integer> intTM   = auxfunctions.createIntegerTreeMap(rangeValues);
		
		System.out.println("Starting Test");
		System.out.println("");
		System.out.println("Integer : HashMap and TreeMap");
		
		findIntegerElement(intHM,HMAP);
		findIntegerElement(intTM,TMAP);
		System.out.println("");
	}
	
	private static void TestFindElement2() {
		HashMap<String, String> strHM	  = auxfunctions.createStringHashMap(rangeValues);
		TreeMap<String, String> strTM 	  = auxfunctions.createStringTreeMap(rangeValues);
		
		
		System.out.println("String : HashMap and TreeMap");
		findStringElement(strHM, HMAP);
		findStringElement(strTM, TMAP);
		System.out.println("");
	
	}
	private static void TestFindElement3(){	
		HashMap<Integer, auxObject> objHM = auxfunctions.createObjectHashMap(rangeValues);
		TreeMap<Integer, auxObject> objTM = auxfunctions.createObjectTreeMap(rangeValues);

		System.out.println("Object : HashMap and TreeMap");
		findObjectElement(objHM, HMAP);
		findObjectElement(objTM, TMAP);
		System.out.println("");
		System.out.println("End Test");
	}
	

}
