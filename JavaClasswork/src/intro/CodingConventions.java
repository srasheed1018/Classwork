package intro;

//class is a file describing a new data type
public class CodingConventions {
	
	//fields
	private String name;
	private String description;
	
	/*
	this is a special method, a "constructor"
	notice it does not have a return type
	that is because the thing it returns is an instance of the class
	therefore the name of a constructor must always match the name of a class
	*/
	public CodingConventions(String name, int index){
		//In Java, fields are instantiated in a constructor
		this.name = name;
		//static reference begins with a clas name
		description = IntroMain.DESCRIPTIONS[index];
		}
	public void doStuff() {
		//static method call
		System.out.println(name+description);//use a space between operations
		System.out.println("the square root of 12 is " + Math.sqrt(12));
	}
}
