class classHelloWorld{

	private static  String intro  = "Hello World ";
	private static String source = "-From Java class Secondary Branch ";
	private static char alphabet[]=
	{
			'a','b','c','d','e','f','g',
			'h','i','j','k','l','m','n',
			'o','p','q','r','s','t','u',
			'v','w','x','y','z'
	};

	public static String getName2() {
		String res = "";
		int length = genNum();
		for(int i =0; i<length;i++) {
			 
			res=res+alphabet[genNum()];
		}
	return res;
	}
	private static int genNum(){
		return (int)Math.floor((Math.random()*25));
	}	
	//Deprecated Function - use another  print one
	/*
	public static void printHelloWorld3(){
		printHelloWorld2(getName2());	
	}	
	*/

	static void printHelloWorld4(){
		printHelloWorld2("Mr. Constantine");
	}


	static void printHelloWorld2(){
		System.out.println(intro + source);
	}

	static  void printHelloWorld2(String name){
		System.out.println(intro + name + source);
	}


}
