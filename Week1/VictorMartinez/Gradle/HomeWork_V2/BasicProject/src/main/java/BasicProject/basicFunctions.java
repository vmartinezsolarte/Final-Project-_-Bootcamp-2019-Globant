package BasicProject;

public class basicFunctions {
	
	private String username = "Pepito Perez";
	private String passWord = "*******";
	
	void printUserGreeting(){
			System.out.println("************Dear customer, Welcome to Globant Transactions Service*************");
			System.out.println("Please, enter you personal information");
			System.out.println("UserName: _ _ _ _ _ _ _ _ ");
			System.out.println("PassWord: _ _ _ _ _ _ _ _ ");
	}
	
	public String getUserName() { return username;}
	public String getPassword() { return passWord;}
	public void setUserName(String name) {this.username = name;System.out.println("Name updated");}
	public void setPassword(String code) {this.passWord = code; System.out.println("PassWord Updated");}
}
