package caveExplorer;

import java.util.InputMismatchException;

import caveExplorer.CaveExplorer;

public class LightsOutRoom extends CaveRoom {
	
	private boolean active;
	private String input;
	private String buffer;
	private String tutorial = "In Lights Out, your goal is to turn off all the lights."+"\n"+
							  "You can select a space to toggle by inputting your desired row and column like this:"+"\n"+
							  "(row,column)"+"\n"+"When you select a space, that space and its four adjacent spaces will be toggled. 'O' means on and 'X' means off. Turn off all the lights to win."+"\n"+
							  "Press enter to start. Good luck!";
	private boolean askingForTutorial;
	private int size;
	private String numbers = "1234567890";
	private boolean[][] grid;

	public LightsOutRoom(String description) {
		super(description);
	}

	public String validKeys() {
		return "wdsae";
	}


	public void interpretInput(String input) {
		int dir = validKeys().indexOf(input);
		if (dir==4) {
			start();
		}
	}
	
	public void printAllowedEntry() {
		System.out.println("You can only enter 'w', 'a', 's' 'd', or 'e'.");
	}
	
	public void performAction (int direction) {
		if (direction==4) {
			start();
		}	
	}

	public static void print(String s){
		System.out.println(s);
	}
	
	public void start() {
		print("Welcome to Lights Out! Do you need a tutorial?");
		askingForTutorial = true;
		while(askingForTutorial) {
			input = CaveExplorer.in.nextLine();
			if (input.equals("no"))
			{
				askingForTutorial = false;
				beginGame();
			}
			else
			{
				if (input.equals("yes")) {
					print(tutorial);
					//makes the user have to press enter
					buffer = CaveExplorer.in.nextLine();
					askingForTutorial = false;
					beginGame();
				}
				else
					print("I didn't catch that. Please answer yes or no.");
			}
		}
		
	}

	public void beginGame() {
		//first, the grid size is defined
		print("Please define the size of your grid with an integer greater than 5, but less than 9 (for example, typing 5 now would set the grid to 5x5)");
		try {
			size = CaveExplorer.in.nextInt();
			if (size<5) {
				size = 5;
			}
			if (size>9) {
				size = 9;
			}
		}
		catch (InputMismatchException e) {
			print("Since you don't wanna cooperate and give a number, let's play on a randomly sized grid :)");
			size = (int)(5+Math.random()*3);
		}
		grid = new boolean[size][size];
		active = true;
		//give each boolean in the 2d array a value
		populateGrid(grid);
		//game actually starts here
		while(active) {
			printGrid(grid);
			input = CaveExplorer.in.nextLine();
			//cheat code
			if (input.equals("Siddeeq")) {
				print("Too hard? You can always re-enter and try again");
				active = false;
				break;
			}
			while(!Valid(input)) {
				print("Please format your coords like so: (row,column)");
				input = CaveExplorer.in.nextLine();
			}
			buttonClick(Integer.parseInt(input.substring(1, 2)), Integer.parseInt(input.substring(3, 4)));
			if (allOff(grid)) {
				print("Congrats, you won!");
				buffer = CaveExplorer.in.nextLine();
				active = false;
			}
		}
	}

	public boolean Valid(String in) {
		//check if input is empty
		if(in.equals("")) {
			return false;
		}
		//check if input is formatted correctly
		if (!(in.substring(0, 1).equals("(") && 
				numbers.indexOf(in.substring(1,2)) >= 0 && 
				in.substring(2, 3).equals(",") &&
			  numbers.indexOf(in.substring(3,4)) >= 0 && 
			  in.substring(4, 5).equals(")"))
		   ) {
			return false;
		}
		//check if numbers are in bounds
		if (Integer.parseInt(in.substring(1, 2)) >= grid.length || 
			Integer.parseInt(in.substring(3, 4)) >= grid.length ||
			Integer.parseInt(in.substring(1, 2)) < 0 ||
			Integer.parseInt(in.substring(3, 4)) < 0) {
			return false;
		}
		return true;
	}

	public void populateGrid(boolean[][] grid) {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (Math.random() < 0.5)
					grid[r][c] = false;
				else
					grid[r][c] = true;
			}
		}
		
	}

	public void printGrid(boolean[][] grid) {
		String temp = "";
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c])
					temp += "O ";
				else
					temp += "X ";
			}
			temp += "\n";
		}
		print(temp);
	}

	public void switchRow(boolean[] row, int x) {
		if (x==0) {
			row[x]=!row[x];
			row[x+1]=!row[x+1];
		} else {
			if (x == row.length-1) {
				row[x-1]=!row[x-1];
				row[x]=!row[x];
			} else {
				row[x-1]=!row[x-1];
				row[x]=!row[x];
				row[x+1]=!row[x+1];
			}
		}
	}
	
	public void switchColumn (boolean[][] grid, int r, int c) {
		if (r==0) {
			grid[r+1][c]=!grid[r+1][c];
		} else {
			if (r == grid.length-1) {
				grid[r-1][c]=!grid[r-1][c];
			} else {
				grid[r-1][c]=!grid[r-1][c];
				grid[r+1][c]=!grid[r+1][c];
			}
		}
	}
	
	public void buttonClick (int r, int c) {
		switchRow(grid[r], c);
		switchColumn(grid, r, c);
	}
	
	public boolean allOff (boolean[][] g) {
		for (int r = 0; r < g.length; r++) {
			for (int c = 0; c < g[r].length; c++) {
				if (g[r][c])
					return false;
			}
		}
		return true;
	}
}
