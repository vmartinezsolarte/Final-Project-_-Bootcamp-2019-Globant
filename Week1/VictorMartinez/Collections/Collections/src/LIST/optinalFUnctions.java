package LIST;

import java.util.ArrayList;
import java.util.LinkedList;

public class optinalFUnctions {

	public static ArrayList generateArrayList(int range) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i =0; i<range;i++) {
			res.add((int)Math.floor(Math.random()*1000));
		}
		return res;
	}
	
	public static LinkedList generateLinkedList(int range) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		for(int i =0; i<range;i++) {
			res.add((int)Math.floor(Math.random()*1000));
		}
		return res;
	}
	
	public static LinkedList copyArray2LinkedList(ArrayList<Integer> val) {
		LinkedList<Integer>res = new LinkedList<Integer>();
		for(int i =0; i<val.size();i++) {
			res.add(val.get(i));
		}
	return res;
	}
}
