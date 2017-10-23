package caveExplorer;

public class CaveRoom {
	
	private String description;// tells what the room looks like
	private String directions;//tells what you can do
	private String contents;////a symbol representing what's in the room
	private String defaultContents;
	//the rooms are organized by direction, 'null' signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;

	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is "contents" becomes an X when you're
		//inside the room, but when you leave, it goes back to defaultContents.
		
		//note: by default, arrays will populate with 'null', meaning there are no connections.
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	/**
	 * for every door in doors[], appends a string to 'directions' describing the actions.
	 * for example:
	 *  "there is a door to the north"
	 *
	 *If there are no doors at all, directions should say:
	 * "There are no doors, you're trapped."
	 */
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for (int i = 0; i < doors.length; i++)
		{
			if (doors[i]==null)
			{
				continue;
			}
			else
			{
				doorFound = true;
				directions = directions + "\n  You are able to go to "+toDirection(i)+" via a "+doors[i].getDescription()+". "+doors[i].getDetails();;
			}
			if (!doorFound)
			{
				directions = "Way to go dude, you're stuck.";
			}
		}
	}

	/**
	 * converts an int into a direction
	 * for example:
	 * toDirection (0) --> "the North"
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] directions = {"the North", "the East", "the South", "the West"};
		return directions[dir];
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	
	
}
