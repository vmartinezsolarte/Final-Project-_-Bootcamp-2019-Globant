package HashTables;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import LIST.auxObject;


public class auxfunctions {

	
	static int lengthString = 4;
	
	public static long getTime() {return System.nanoTime();}
	
	public static HashMap<Integer, Integer> createIntegerHashMap(int range){
		
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(int i =0; i<range;i++) {
			hmap.put(i, randomNumberGenerator(range));
		}
		return hmap;
	}
	
	public static TreeMap<Integer, Integer> createIntegerTreeMap(int range){
		
		
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
		for(int i =0; i<range;i++) {
			tmap.put(i, randomNumberGenerator(range));
		}
		return tmap;
	}
	
	
	public static HashMap<String, String> createStringHashMap(int range){
		
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		for(int i =0; i<range;i++) {
			hmap.put(randomStringsGenerator(lengthString), randomStringsGenerator(lengthString));
		}
		return hmap;
	}
	
	public static TreeMap<Integer, auxObject> createObjectTreeMap(int range){
		
		
		TreeMap<Integer, auxObject> tmap = new TreeMap<Integer, auxObject>();
		for(int i =0; i<range;i++) {
			tmap.put(i, new auxObject(randomStringsGenerator(lengthString), randomNumberGenerator(range)));
		}
		return tmap;
	}
	
	public static HashMap<Integer, auxObject> createObjectHashMap(int range){
		
		
		HashMap<Integer, auxObject> hmap = new HashMap<Integer, auxObject>();
		for(int i =0; i<range;i++) {
			hmap.put(i, new auxObject(randomStringsGenerator(lengthString), randomNumberGenerator(range)));
		}
		return hmap;
	}
	
	
	
	public static TreeMap<String, String> createStringTreeMap(int range){
		
		
		TreeMap<String, String> tmap = new TreeMap<String, String>();
		for(int i =0; i<range;i++) {
			tmap.put(randomStringsGenerator(lengthString), randomStringsGenerator(lengthString));
		}
		return tmap;
	}
	
	
	public static String randomStringsGenerator(int length) {
		String res = "";
		char alphabet[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < length; i++) {
			int index = (int) Math.floor((Math.random() * alphabet.length));
			res = res + alphabet[index];
		}
		return res;
	}
	public static int randomNumberGenerator(int limit) { return (int)Math.floor(Math.random()*limit)-1; }
	
	public static void printSomeIntegerKeysValues(Map<Integer, Integer> maps, int muestras) {
		int cont = 0;
		for(Map.Entry <Integer, Integer> entry : maps.entrySet()) {
			if(cont == entry.getKey() && cont <muestras) {
				System.out.println(entry.getKey()+ " " + entry.getValue());
				cont++;
			}
		}
		
	}
}
