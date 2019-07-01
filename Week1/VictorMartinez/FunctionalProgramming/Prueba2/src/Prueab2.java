import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prueab2 {

	public static void main(String [] args) {

		
		ArrayList<Integer> Andreas = new ArrayList<Integer>();
		Andreas.add(1);
		Andreas.add(2468);
		
		ArrayList<Integer> Marias = new ArrayList<Integer>();
		Marias.add(1);
		Marias.add(8642);
		
		
		
		
		
		
		PrintElement(convertArr(Andreas));
		System.out.println("");
		PrintElement(convertArr(Marias));
		System.out.println("");
		System.out.println(counting(convertArr(Andreas), convertArr(Marias)));
}
	
	
	public static int counting(ArrayList<Integer> Andrea, ArrayList<Integer> Maria) {
		
		int cont =0; 
		int index =0;
		boolean debugging = true;
		while(index<Andrea.size()) {
			if(Andrea.get(index)<Maria.get(index)) {
				Andrea.set(index, Andrea.get(index)+1);
				cont++;
			}else if(Andrea.get(index)>Maria.get(index)) {
				Andrea.set(index, Andrea.get(index)-1);
				cont++;
			}else {
				index ++;
			}

		}
		return cont;
	}
	
	public static ArrayList<Integer> converIntArr(int[]arr){
		ArrayList<Integer> elements = new ArrayList<Integer>();
		for(Integer num : arr) {
			elements.add(num);
		}
		return elements;
	}
	
	public static ArrayList<Integer> convertArr(ArrayList<Integer> arr) {
		ArrayList<Integer> Arr_converted = new ArrayList<Integer>();
		for(Integer row : arr) {
			int temp = row;
			ArrayList<Integer> inverted = new ArrayList<Integer>();
			while(temp>0) {
				int res = temp%10;
				inverted.add(temp%10);
				temp = temp/10;
			}
			inverted= Invert(inverted);
			Arr_converted = merge(Arr_converted, inverted);
			
		}
		return Arr_converted;
	}
	
	
	
	
	public static ArrayList<Integer> merge(ArrayList<Integer> left , ArrayList<Integer> right){
		ArrayList<Integer> temp = left;
		for(int i =0; i<right.size();i++) {
			temp.add(right.get(i));
			}
		return temp;
	}
	
	
	
	
	public static ArrayList<Integer> Invert(ArrayList<Integer> arr){
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = arr.size()-1; i>=0;i--) {
			res.add(arr.get(i));
		}
		return res;
		
	}
	
	


	public static void PrintElement(ArrayList<Integer> arr) {
		for(int i =0; i<arr.size();i++) {
			System.out.print(arr.get(i));
		}
	}
}
