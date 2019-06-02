package LIST;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Function;
/*
 * 
 * 
						Collections : ArrayLIST vs LinkedList
	
	Results. 
	
	//	Time for ArrayList   : 16269 ms								 // Time Ordering Integer ArrayList  Elements
	//  Time for LinkedList  : 19549 ms              				 // Time Ordering Integer LinkedList Elements
	
	//  Time for ArrayList   : 22009 ms                             // Time Ordering String ArrayList  Elements
	//  Time for LinkedList  : 24892 ms                             // Time Ordering String ArrayList  Elements





*/
public class ListMain {
	static int range = 10000000;                 //Creating 10 millions of elements
	static long start;							// Initial time variable
	static long end;                            //End time variable
	static int stringLength = 4;				//Limiting the String length;
	public static void main(String [] args) {
	
	
	
	
	
	//Create the List for comparison 
	//List<Integer> arrList = createArrayList(range);           //Integer ArrayList Element
	//List<Integer> linList = createLinkedList(range);          //Integer Linked List Element
	
	List<String> arrList = createStringArrayList(range);           //Integer ArrayList Element
	List<String> linList = createStringLinkedList(range);         

	
	
	// Testing Time
	
	arrList= calculateStringTimeOrdering(arrList, "ArrayList" );		//Testing Time Ordering ArrayList
	arrList= calculateStringTimeOrdering(linList, "LinkedList");		//Testing Time Ordering LinkedList
	
	//	Time for ArrayList   : 16269 ms								 // Time Ordering Integer ArrayList  Elements
	//  Time for LinkedList  : 19549 ms              				 // Time Ordering Integer LinkedList Elements
	
	//  Time for ArrayList   : 22009 ms                             // Time Ordering String ArrayList  Elements
	//  Time for LinkedList  : 24892 ms                             // Time Ordering String ArrayList  Elements
	
	
	}
	
	
	static List<Integer>calculateTimeOrdering(List<Integer> arr, String title){
		start = 0;
		end   = 0;
		start = System.nanoTime();
		arr.sort(Comparator.naturalOrder());
		end   =System.nanoTime();
		end = (end-start);
		end = end/1000000;
		System.out.println("Time for "+ title +"  : "+end);
		return null;
		//return arr;
	}
	
	static List<String>calculateStringTimeOrdering(List<String> arr, String title){
		start = 0;
		end   = 0;
		start = System.nanoTime();
		arr.sort(Comparator.naturalOrder());
		end   =System.nanoTime();
		end = (end-start);
		end = end/1000000;
		System.out.println("Time for "+ title +"  : "+end);
		//return null;
		return arr;
	}
	
	
	
	static ArrayList<Integer> createArrayList(int quantity)
	{	ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i =0; i<quantity;i++) {
			arr.add(randomNumberGenerator(range));
		}
		return arr;
	}
	
	static LinkedList<Integer> createLinkedList(int quantity)
	{	LinkedList<Integer> arr = new LinkedList<Integer>();
		for(int i =0; i<quantity;i++) {
			arr.add(randomNumberGenerator(range));
		}
		return arr;
	}
	
	static int randomNumberGenerator(int range) {
		
		return  (int)Math.floor(Math.random()*9999999);
	}
	
	static String randomStringsGenerator(int length) {
		String res = "";
		char alphabet [] = {'a','b','c','d','e','f','g','h','i','j',
							'k','l','m','n','o','p','q','r','s','t',
							'u','v','w','x','y','z'};
		for(int i =0; i<length;i++) {
			int index = (int)Math.floor((Math.random()*alphabet.length));
			res=res+alphabet[index];
		}
		return res;
	}
	
	static ArrayList<String> createStringArrayList(int quantity)
	{	ArrayList<String> arr = new ArrayList<String>();
		for(int i =0; i<quantity;i++) {
			arr.add(randomStringsGenerator(stringLength));
		}
		return arr;
	}
	
	static LinkedList<String> createStringLinkedList(int quantity)
	{	LinkedList<String> arr = new LinkedList<String>();
		for(int i =0; i<quantity;i++) {
			arr.add(randomStringsGenerator(stringLength));
		}
		return arr;
	}

	
}



