package HashTables;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import LIST.auxObject;


//Starting Test						Time Results for removing an element by key
//
//Integer : HashMap and TreeMap
//Time Integer HashMap : 33 us
//Time Integer TreeMap : 117 us
//
//String : HashMap and TreeMap
//Time String HashMap : 13 us
//Time String TreeMap : 17 us
//
//Object : HashMap and TreeMap
//Time Object HashMap : 14 us
//Time Object TreeMap : 83 us
//
//End Test





public class RemoveElementByKey {


	static int rangeValues = HashMap_vs_TreeMap.range;
	static long start;
	static long end;
	static int extraIndex = 10000000;
	final static String HMAP = "HashMap";
	final static String TMAP = "TreeMap";

	public static Map<Integer, Integer> removeIntegerElement(Map<Integer, Integer> map, String title) {

		start = auxfunctions.getTime();
		map.remove(auxfunctions.randomNumberGenerator(extraIndex-1));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Integer " + title + " : " + end + " us");
		return map;
	}

	public static Map<String, String> removeStringElement(Map<String, String> map, String title) {
		//Generate random Index
		Random generator = new Random();
		Object[] values = map.values().toArray();
		String randomValue = (String)values[generator.nextInt(values.length)];
		
		start = auxfunctions.getTime();
		map.remove(randomValue);
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time String " + title + " : " + end + " us");
		return map;
	}

	public static Map<Integer, auxObject> removeObjectElement(Map<Integer, auxObject> map, String title) {

		start = auxfunctions.getTime();
		map.remove(auxfunctions.randomNumberGenerator(extraIndex-1));
		end = auxfunctions.getTime();
		end = (end - start) / 1000;
		System.out.println("Time Object " + title + " : " + end + " us");
		return map;
	}
	
	public static void TestRemoveElement() {
		TestRemoveElement1();
		TestRemoveElement2();
		TestRemoveElement3();
	}
	
	private static void TestRemoveElement1() {
		

		// Create DataStructures : Integers, String, Object with two properties: Name,
		// Age.
		HashMap<Integer, Integer> intHM   = auxfunctions.createIntegerHashMap(rangeValues);
		TreeMap<Integer, Integer> intTM   = auxfunctions.createIntegerTreeMap(rangeValues);
		
		System.out.println("Starting Test");
		System.out.println("");
		System.out.println("Integer : HashMap and TreeMap");
		
		removeIntegerElement(intHM,HMAP);
		removeIntegerElement(intTM,TMAP);
		System.out.println("");
	}
	
	private static void TestRemoveElement2() {
		HashMap<String, String> strHM	  = auxfunctions.createStringHashMap(rangeValues);
		TreeMap<String, String> strTM 	  = auxfunctions.createStringTreeMap(rangeValues);
		
		
		System.out.println("String : HashMap and TreeMap");
		removeStringElement(strHM, HMAP);
		removeStringElement(strTM, TMAP);
		System.out.println("");
	
	}
	private static void TestRemoveElement3(){	
		HashMap<Integer, auxObject> objHM = auxfunctions.createObjectHashMap(rangeValues);
		TreeMap<Integer, auxObject> objTM = auxfunctions.createObjectTreeMap(rangeValues);

		System.out.println("Object : HashMap and TreeMap");
		removeObjectElement(objHM, HMAP);
		removeObjectElement(objTM, TMAP);
		System.out.println("");
		System.out.println("End Test");
	}
	

	
}
