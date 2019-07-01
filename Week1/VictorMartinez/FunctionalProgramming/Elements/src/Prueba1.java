import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Prueba1 {

	public static void main(String [] args) {
		
		//ArrayList<ArrayList<Integer>> pureColors  = new ArrayList<ArrayList<Integer>>();
		List<String> arrs = new ArrayList<String>(Arrays.asList(
				"101111010110011011100100",
				"110000010101011111101111",
				"100110101100111111101101",
				"010111011010010110000011",
				"000000001111111111111111" 
				));
		
		arrs = evaluate(arrs);
		printStrings(arrs);
		
		/*String reg = "000000001111111111111111";
		ArrayList<Integer> testNumber = (convertNums(converString2Numbers(reg)));
		System.out.println(getDistances(testNumber));
		*/
	}
	
	public static List<String> evaluate(List<String> pixels){
		List<String> res = new ArrayList<String>();
		for(String pixel : pixels) {
			res.add(getDistances(convertNums(converString2Numbers(pixel))));
		}
		return res;
	}
	
	public static String getDistances(ArrayList<Integer> number) {
				
		ArrayList<Integer> Black = new ArrayList<Integer>(Arrays.asList(0,0,0)); 
		ArrayList<Integer> White = new ArrayList<Integer>(Arrays.asList(255,255,255)); 
		ArrayList<Integer> Red = new ArrayList<Integer>(Arrays.asList(255,0,0)); 
		ArrayList<Integer> Green = new ArrayList<Integer>(Arrays.asList(0,255,0)); 
		ArrayList<Integer> Blue = new ArrayList<Integer>(Arrays.asList(0,0,255)); 
	
		ArrayList<Double> Res = new ArrayList<Double>();
		Res.add(euclideanDIstance(number, Black));
		Res.add(euclideanDIstance(number, White));
		Res.add(euclideanDIstance(number, Red));
		Res.add(euclideanDIstance(number, Green));
		Res.add(euclideanDIstance(number, Blue));
		//printArr2(Res);
		
		//printArr2(Res);
		double[] res =(Arr2arr(Res));
		Arrays.sort(res);
		int index = Res.indexOf(res[0]); 
		
		//detect duplicates
		HashSet unique = new HashSet();
		for(Double vals : Res) {
			if(!unique.add(vals) && vals.equals(res[0])) {
				return "Ambiguous";
			}
		}
	
		
		
		switch(index) {
			case 0 : return "Black"; 
			case 1 : return "White"; 
			case 2 : return "Red"; 
			case 3 : return "Green"; 
			case 4 : return "Blue"; 
			default: return "Ambiguous"; 
		}
		
		
		
		
	}
	public static double[] Arr2arr(ArrayList<Double> arr) {
		double []res = new double[arr.size()]; 
		for(int i =0; i<arr.size();i++) {
			res[i]= arr.get(i);
		}
		return res;
	}
	
	
	public static double euclideanDIstance(ArrayList<Integer> distA, ArrayList<Integer> distB) {
		double total = 0;
		for(int i =0; i<distA.size();i++) {
			total += Math.pow((distA.get(i)-(distB.get(i))),2);
		}
		return Math.sqrt(total);
	}
	
	
	public static ArrayList<Integer> converString2Numbers(String code) {
		ArrayList<Integer> colorRGB = new ArrayList<Integer>();
		
		String Red = code.substring(0, 8);
		String Green = code.substring(8, 16);
		String Blue = code.substring(16, 24);
		colorRGB.add(Integer.parseInt(Red));
		colorRGB.add(Integer.parseInt(Green));
		colorRGB.add(Integer.parseInt(Blue));
		
		
		return colorRGB;
	}
	public static int convert2Dec(int num) {
		int result = 0;
		int exp =0;
		int temp = num; 
		while(temp>0) {
			
			result += (temp%10)*Math.pow(2, exp);
			temp = temp/10;
			exp++;
		}
		return result;
	}
	
	public static void printArr(ArrayList<Integer> nums) {
		for(Integer num : nums) {
			System.out.println(num);
		}
	}
	
	public static void printArr2(ArrayList<Double> nums) {
		System.out.println(nums.size());
		for(Double num : nums) {
			System.out.println(num);
		}
	}
	
	public static int passBin2Int(ArrayList<Integer> num) {
		int total = 0;
		for(int i =0; i<num.size();i++) {
			total+= num.get(i)*Math.pow(2, i);
		}
		return total;
	}
	
	
	public static ArrayList<Integer> convertNums(ArrayList<Integer> nums){
		ArrayList<Integer> dec = new ArrayList<Integer>();
		for(Integer num : nums ) {
			dec.add(convert2Dec(num));
		}
		return dec;
	}
	
	public static void printStrings(List<String> args) {
		for(String ar : args) {
			System.out.println(ar);
		}
	}
	
}
