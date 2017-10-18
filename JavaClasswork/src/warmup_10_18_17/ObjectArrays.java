package warmup_10_18_17;

public class ObjectArrays {

	public ObjectArrays() {
		Object[] people = new Object[20];
		populate(people);
		people[0] = new Thing("coffee maker");
		for(Object p:people)
		{
			System.out.println(p);
		}
	}

	private void populate(Object[] people) {
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
}

