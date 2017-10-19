package warmup_10_18_17;

public class ObjectArrays {

	public ObjectArrays() {
		Person[] people = new Person[20];
		populate(people);
		for (Person p:people)
		{
			p.mingle(people);
			p.printFriends();
		}
	}

	private void populate(Person[] people) {
		for (int i = 0; i < people.length; i++)
		{
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough b = randomBorough();
			//BIG IDEA!!!
			//In Object arrays (not primitive or double),
			//You can have multiple data types (sub-classes of the declared type)
			if (Math.random()<0.6)
			{
				//60% of the time...	
				int grade = (int)(Math.random()*5)+9;
				people[i] = new Student(firstName, lastName, b, grade);
			}
			else
			{
				//40% of the time...
				people[i] = new Person(firstName, lastName, b);
			}
		}
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a)+get(b)+get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random()*a.length)];
	}
	
	public Person[] selectGroup(Person[] population, int length)
	{
		/*
		 * failed method
		 * int slot = 0;
		int toDo = length-1;
		boolean found = false;
		Person[] out = new Person[length];
		int[] used = new int[length];
		while (toDo>0)
		{
			slot = (int)(Math.random()*length);
			found = false;
			for (int i = 0; i < used.length; i ++)
			{
				if (slot==used[i])
				{
					found = true;
					break;
				}
				else
				{
					found = false;
				}
			}
			if (found)
			{
				
			}
			else 
			{
				out[toDo] = population[slot];
				toDo--;
			}
		}
		return out;
	*/
	Person[] group = new Person[length];
	group[0] = selectAPerson(population);
	for (int i = 1; i < length; i++)
	{
		Person nextPerson = selectAPerson(population);
		while (personInGroup(group, nextPerson))
		{
			nextPerson = selectAPerson(population);
		}
		group[i] = nextPerson;
	}
	return group;
}

	private Person selectAPerson(Person[] population) {
		return population[(int)(Math.random()*population.length)];
	}
	
	private static boolean personInGroup(Person[] group, Person nextPerson)
	{
		for (int i = 0; i < group.length; i++) 
		{
			if(group[i] == nextPerson)
			{
				return true;
			}
		}
		return false;
	}
	
	//return the number of differences between the two arrays.
	//a "difference" means they dont have the same element at
	//the same position.
	public int countDifferences(Person[] arr1, Person[] arr2)
	{
		int diffs = 0;
		for (int i = 0; i < arr1.length; i++)
		{
			if (arr1[i]!=arr2[i])
			{
				diffs++;
			}
		}
		return diffs;
	}
	
	//calls count differences on two Person arrays;
	//each array must contain the same elements. but randomly ordered
	//Print the number of differences between the two arrays
	//do this 100 times,print average
	public void testShuffling()
	{
		int sum = 0;
		int temp = 0;
		for (int i=0; i<100; i++)
		{
			temp = countDifferences(people, selectGroup(people, people.length));
			//aaaaaa
		}
	}
}

