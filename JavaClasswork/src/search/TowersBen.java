package search;

public class TowersBen {
	//Full commands with pics:
	public static void main(String[] args) {
		ttest(5,0,2);
	}
	
	public static void ttest(int numDisks, int where, int goal) {
		int other;
		
		//if you are a stack:
		if(numDisks == 1) {
			System.out.println(where + " to " + goal);
		}else {
			other = 3 - where - goal;
			//move the guys ontop of you first
			ttest(numDisks-1, where, other);
			//then move you to goal
			System.out.println(where + " to " + goal);
			//then move other guys ontop of you
			ttest(numDisks-1, other, goal);
			
			
		}
	}
	
	
	/**
	 * n=1
	 * 1 0 0
	 * 
	 * a to b
	 * 0 1 0
	 * 
	 * 
	 * 
	 * ________________
	 * n=2
	 * 1
	 * 2 0 0
	 * 
	 * a to b
	 * 2 1 0
	 * 
	 * a to c
	 * 0 1 2
	 * 
	 * b to c
	 *     1
	 * 0 0 2
	 * 
	 * 
	 * 
	 * ________________
	 * n=3
	 * 1
	 * 2
	 * 3 0 0
	 * 
	 * a to b
	 * 2
	 * 3 1 0
	 * 
	 * a to c
	 * 3 1 2
	 * 
	 * CANT CLEAR A anymore - > clear B
	 * b to c
	 *     1
	 * 3 0 2
	 * 
	 * CONTINUE clearing A
	 * a to b
	 *     1
	 * 0 3 2
	 * 
	 * EMPTY A -> start moving to B (c is the new a)
	 * c to a
	 * 1 3 2
	 * 
	 * c to b
	 *   2
	 * 1 3
	 * 
	 * a to b
	 *   1
	 *   2
	 *   3
	 * 
	 * 
	 * ________________
	 * n=4
	 * 1
	 * 2
	 * 3
	 * 4
	 * 
	 * a to b
	 * 2
	 * 3
	 * 4 1
	 * 
	 * a to c
	 * 3
	 * 4 1 2
	 * 
	 * b to c
	 * 3   1
	 * 4 0 2
	 * 
	 * a to b
	 *     1
	 * 4 3 2
	 * 
	 * CLEAR C (c is the new a)
	 * c to a
	 * 1
	 * 4 3 2
	 * 
	 * c to b
	 * 1 2
	 * 4 3 0
	 * 
	 * a to c
	 *   1
	 *   2
	 * 4 3 
	 * 
	 * a to c
	 *   1
	 *   2
	 *   3 4
	 * 
	 * CLEAR B (b is the new a)
	 * b to c
	 *   2 1
	 *   3 4
	 * 
	 * b to a
	 *     1
	 * 2 3 4
	 * 
	 * c to a
	 * 1
	 * 2 3 4
	 * 
	 * b to c
	 * 1   3
	 * 2   4
	 * 
	 * a to b
	 *     3
	 * 2 1 4
	 * 
	 * a to c
	 *     2
	 *     3
	 *   1 4
	 *   
	 * b to c
	 *     1
	 *     2
	 *     3
	 *     4
	 *     
	 * 
	 * **/
	
	//just commands:
	/**
	 * n=1
	 * a to b
	 * 
	 * ____________________________________________________________
	 * n = 2
	 * a to b
	 * a to c
	 * b to c
	 * 
	 * ____________________________________________________________
	 * n=3
	 * a to b
	 * a to c
	 * CANT CLEAR A anymore - > clear B
	 * b to c
	 * CONTINUE clearing A
	 * a to b
	 * EMPTY A -> start moving to B (c is the new a)
	 * c to a
	 * c to b
	 * a to b
	 * 
	 * _____________________________________________________________
	 * n=4
	 * a to b
	 * a to c
	 * b to c
	 * a to b
	 * CLEAR C (c is the new a)
	 * c to a
	 * c to b
	 * a to c
	 * a to c
	 * CLEAR B (b is the new a)
	 * b to c
	 * b to a
	 * c to a
	 * b to c
	 * a to b
	 * a to c
	 * b to c
	 * @return 
	 * **/
	

	
	public static void printTowers(String[] towers) {
		for(String s: towers) {
			System.out.println(s);
		}
	}
	
	public static void HanoiTowers(String[] towers, int clearGoal){
		int a = 0;
		int b = 1;
		int c = 0;
		int check;
		
		//try to move A -> check b & c
		if(towers[clearGoal].length() > 0) {
			
			//check other spaces to move;
			check = (clearGoal + 1) % 3;
			if(Integer.parseInt(towers[check].substring(0,1)) < Integer.parseInt(towers[clearGoal])) {
				towers = moveDisc(towers, check, clearGoal);
			}else {
				check = (clearGoal + 2) % 3;
				if(Integer.parseInt(towers[check].substring(0,1)) < Integer.parseInt(towers[clearGoal])) {
					towers = moveDisc(towers, check, clearGoal);
				}
			}
		}
		
		printTowers(towers);
		
	}

	private static String[] moveDisc(String[] towers, int check, int clearGoal) {
		towers[check]+= towers[clearGoal].substring(0,1);
		towers[clearGoal] = towers[clearGoal].substring(1);
		return towers;
	}

	//unfinished
	public static int fibonacci(int n) {
		if (n==0) {
			return 1;
		}
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
}
