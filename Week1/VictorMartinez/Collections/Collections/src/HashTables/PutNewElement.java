package HashTables;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import LIST.auxObject;

//Starting Test          Time Results after Adding a new element
//
//Integer : HashMap and TreeMap
//Time Integer HashMap : 19 us
//Time Integer TreeMap : 6 us
//
//String : HashMap and TreeMap
//Time String HashMap : 14 us
//Time String TreeMap : 4 us
//
//Object : HashMap and TreeMap
//Time Object HashMap : 20 us
//Time Object TreeMap : 7 us
//
//End Test

public class PutNewElement {
	static int rangeValues = HashMap_vs_TreeMap.range;
	static long start;
	static long end;
	static int extraIndex = 10000000;
	final static String HMAP = "HashMap";
	final static String TMAP = "TreeMap";

	public static Map<Integer, Integer> putIntegerElement(Map<Integer, Integer> map, String title) {

		start = auxfunctions.getTime();
		map.put(extraIndex, auxfunctions.randomNumberGenerator(extraIndex));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return map;
	}

	public static Map<String, String> putStringElement(Map<String, String> map, String title) {

		start = auxfunctions.getTime();
		map.put(auxfunctions.randomStringsGenerator(auxfunctions.lengthString),
				auxfunctions.randomStringsGenerator(auxfunctions.lengthString));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time String " + title + " : " + end + " us");
		return map;
	}

	public static Map<Integer, auxObject> putObjectElement(Map<Integer, auxObject> map, String title) {

		start = auxfunctions.getTime();
		map.put(extraIndex, new auxObject(auxfunctions.randomStringsGenerator(auxfunctions.lengthString),
				auxfunctions.randomNumberGenerator(extraIndex)));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Object " + title + " : " + end + " us");
		return map;
	}
	
	public static void TestPutNewElement() {
		TestPutNewElement1();
		TestPutNewElement2();
		TestPutNewElement3();
	}
	
	private static void TestPutNewElement1() {
		

		// Create DataStructures : Integers, String, Object with two properties: Name,
		// Age.
		HashMap<Integer, Integer> intHM   = auxfunctions.createIntegerHashMap(rangeValues);
		TreeMap<Integer, Integer> intTM   = auxfunctions.createIntegerTreeMap(rangeValues);
		
		System.out.println("Starting Test");
		System.out.println("");
		System.out.println("Integer : HashMap and TreeMap");
		
		putIntegerElement(intHM,HMAP);
		putIntegerElement(intTM,TMAP);
		System.out.println("");
	}
	
	private static void TestPutNewElement2() {
		HashMap<String, String> strHM	  = auxfunctions.createStringHashMap(rangeValues);
		TreeMap<String, String> strTM 	  = auxfunctions.createStringTreeMap(rangeValues);
		
		
		System.out.println("String : HashMap and TreeMap");
		putStringElement(strHM, HMAP);
		putStringElement(strTM, TMAP);
		System.out.println("");
	
	}
	private static void TestPutNewElement3(){	
		HashMap<Integer, auxObject> objHM = auxfunctions.createObjectHashMap(rangeValues);
		TreeMap<Integer, auxObject> objTM = auxfunctions.createObjectTreeMap(rangeValues);

		System.out.println("Object : HashMap and TreeMap");
		putObjectElement(objHM, HMAP);
		putObjectElement(objTM, TMAP);
		System.out.println("");
		System.out.println("End Test");
	}

}
