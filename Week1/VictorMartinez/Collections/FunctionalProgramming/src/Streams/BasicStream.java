package Streams;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class BasicStream {

	public static void main(String [] args) {
		
		
		Stream <String> rr = Stream.of("R,R,R,R,R");
		System.out.println(rr.anyMatch(a->{
			return a == "R,R,R,R,r";
		}));
	}

	Predicate <String> isR(){
		return r-> r=="R";
	}
	
}
