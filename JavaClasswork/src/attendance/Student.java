package attendance;

public class Student implements Attendee {

	private boolean presentStatus;
	private String first;
	private String last;
	
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setPresent(boolean present) {
		presentStatus = true;

	}

	public String getFirstName() {
		return this.first;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean mathces(String first, String last) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean matches(String last) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getReportString() {
		// TODO Auto-generated method stub
		return null;
	}

}
