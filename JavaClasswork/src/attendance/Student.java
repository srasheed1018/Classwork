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
		return null;
	}

}
