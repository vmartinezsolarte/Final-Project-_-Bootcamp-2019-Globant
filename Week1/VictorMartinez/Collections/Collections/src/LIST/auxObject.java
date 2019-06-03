package LIST;

public class auxObject implements Comparable<auxObject> {
	private String name;
	private int Age;
	
	public auxObject(String name, int age ) {
		this.name = name;
		this.Age  = age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.Age;
	}
	
	public String toString() {
		return "(Name :"+this.name+", age :"+this.Age+")";
	}
	public void printValues() {
		System.out.println(this.toString());
	}
	@Override
	public int compareTo(auxObject obj) {
		// TODO Auto-generated method stub
		if (this.Age<obj.getAge()) {
			return -1;
		}
		if(this.Age>obj.getAge()) {
			return 1;
		}
		
		return 0;
	}
}
