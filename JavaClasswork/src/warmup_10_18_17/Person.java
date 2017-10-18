package warmup_10_18_17;

public class Person {
	
	public static final String[] FIRST_START = {"Chr", "M","L","S","Gr","Ph","B","St","T","V"};
	public static final String[] FIRST_MIDDLE = {"isti","icha","iddee","ari","oma","ara"};
	public static final String[] FIRST_END = {"","na","q","n","p","y","s","ph","l"};
	
	public static final String[] LAST_START = {"Sm","R","Ph","S","L","H","T","J"};
	public static final String[] LAST_MIDDLE = {"o","oa","ashee","ari","oma","ara"};
	public static final String[] LAST_END = {"","na","q","n","p","y","s","ph","rian","tz"};
	
	private String firstName;
	private String lastName;
	private Borough home;

	public Person (String first, String last, Borough home)
	{
		this.firstName = first;
		this.lastName = last;
		this.home = home;
	}
	public String toString()
	{
		return "My name is "+firstName+" "+lastName+" and I live in "+home+".";
	}
}
