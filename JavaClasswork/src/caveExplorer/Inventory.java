package caveExplorer;

public class Inventory {

	private String map;
	private String score;
	private int winCount = 0;
	
	public Inventory() {
		updateMap();
		updateScore();
	}
	

	public int getWinCount() {
		return winCount;
	}



	public  void setWinCount(int winCount) {
		this.winCount = winCount;
	}



	public void updateScore() {
		if (winCount==1)
			score = "You've successfully completed Lights Out "+winCount+" time.";
		else
			score = "You've successfully completed Lights Out "+winCount+" times.";
	}

	public void updateMap() {
		map = " ";
		//create line across top:
		for (int i = 0; i < CaveExplorer.caves[0].length-1; i++) {
			map += "____";//4 underscores
		}
		map += "___\n";//3 underscores, then a new line (for symmetry)
		for (CaveRoom[] row : CaveExplorer.caves) {
			//3 rows of text
			for (int i = 0; i < 3; i++) {
				String text = "";
				for (CaveRoom cr : row) {
					//if door is open, leave open
					if (cr.getDoor(CaveRoom.WEST) != null &&
							cr.getDoor(CaveRoom.WEST).isOpen()) {
						text += " ";
					}
					else {
						text += "|";
					}
					//contents of room depend on what row this is
					if (i==0) {
						text += "   ";//3 spaces
					}
					else if(i == 1) {
						text += " "+cr.getContents()+" ";
					}
					else if(i == 2) {
						//draw space if door to south is open
						if (cr.getDoor(CaveRoom.SOUTH) != null &&
								cr.getDoor(CaveRoom.SOUTH).isOpen()) {
							text += "   ";//3 spaces
						}
						else {
							text += "___";
						}
					}
				}//last caveroom in row
				text += "|";
				map += text+"\n";
			}
		}
	}

	public String getDescription() {
		return map;
		//return "You have nothing in your inventory";
	}

}
