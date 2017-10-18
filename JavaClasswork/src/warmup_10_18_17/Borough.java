package warmup_10_18_17;

public class Borough {
	
	public static final Borough[] NY_BOROUGHS = {new Borough("Brooklyn"), new Borough("Bronx"), new Borough("Queens"), new Borough("Manhattan"), new Borough("Staten Island")};

	private String name;
	
	public Borough (String name)
	{
		this.name = name;
	}
	public String toString()
	{
		return name;
	}
}
