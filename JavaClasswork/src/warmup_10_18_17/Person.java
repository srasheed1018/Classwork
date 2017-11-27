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
	private Hobby hobby;
	private Person[] friends;

	public Person (String first, String last, Borough home)
	{
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
	}
	
	//chooses friends from People based on whom is
	//of the same class as this instance and who has the same hobbies
	public void mingle(Person[] people)
	{
		for (Person p:people)
		{
			if (p != this)
			{
				//reassign p to the better of the two friends:
				//your current best friend or p
				p = betterFriend(p, friends[0]);
				
				addFriendToFirstPlace(p);
			}
		}
	}
	
	private Person betterFriend(Person p, Person q) {
		if (p==null)
		{
			return q;
		}
		if (q==null)
		{
			return p;
		}
		if (p.getClass() == q.getClass() && q.getClass() == this.getClass())
		{
			if (p.hobby == this.hobby)
			{
				return p;
			}
			if (q.hobby == this.hobby)
			{
				return q;
			}
			return p;
		}
		else 
		{
			if (p.getClass()== this.getClass())
			{
				return p;
			}
			if (q.getClass() == this.getClass())
			{
				return q;
			}
		}
		//if none of them these are true; just take p
		return p;
	}

	public void printFriends()
	{
		System.out.println("My name is "+firstName+" "+lastName+" and these are my friends:");
		for (Person f:friends)
		{
			if (f!=null) System.out.println(f);
		}
	}
	
	//moves all Persons in friends back one index and puts p at 0
	private void addFriendToFirstPlace(Person p)
	{
		//goes backwards
		for (int i=friends.length-1; i>0; i--)
		{
			friends[i] = friends[i-1];
		}
		friends[0] = p;
	}
	
	public String toString()
	{
		return "My name is "+firstName+" "+lastName+" and I live in "+home+". I like to "+hobby;
	}
}
