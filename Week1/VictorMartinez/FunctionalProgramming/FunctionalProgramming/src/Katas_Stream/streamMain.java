package Katas_Stream;

import java.util.ArrayList;
import java.util.Optional;

public class streamMain {
	final static int ITEMS = 100;
	public static void main(String [] args) {
		
		Optional<Integer> sum;
		ArrayList<Integer> list = createArr(ITEMS);		//Initialize array 
		sum = list.stream().reduce((a,b)->a+b);
		System.out.println("Total " + sum);
		System.out.println("Total " + summingArrayElements(list));
		
	}
	
	public static ArrayList<Integer> createArr(int val){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i =0; i<val;i++) {
			temp.add((int)(Math.random()*100));
		}
		return temp;
	}
	
	public static int summingArrayElements(ArrayList<Integer> list) {
		int cont =0;
		for(int num : list) {
			cont+=num;
			
		}
		return cont;
	}
}
