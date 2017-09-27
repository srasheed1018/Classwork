package attendance;

public class Student implements Attendee {

	private boolean presentStatus;
	private String firstName;
	private String lastName;
	
	public Student(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		presentStatus = false;
	}
	
	public boolean isPresent() {
		return presentStatus;
	}

	public void setPresent(boolean present) {
		presentStatus = true;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean mathces(String first, String last) {
		return first.toLowerCase().equals(firstName.toLowerCase()) && last.toLowerCase().equals(lastName.toLowerCase());
	}

	public boolean matches(String last) {
		return last.toLowerCase().equals(lastName.toLowerCase());
	}

	public String getReportString() {
		String temp = "";
		for (int i=0; i<20; i++)
		{
			if (lastName.substring(i, i+1) == null)
			{
				temp = temp+" ";
			}
			else
			{
				temp = temp+lastName.substring(i, i+1);
			}
		}
		for (int i=0; i<20; i++)
		{
			if (firstName.substring(i, i+1) == null)
			{
				temp = temp+" ";
			}
			else
			{
				temp = temp+firstName.substring(i, i+1);
			}
		}
		if (presentStatus)
			temp = temp+"PRESNT/n";
		else
			temp = temp+"ABESNT/n";
		return temp;
	}

}
