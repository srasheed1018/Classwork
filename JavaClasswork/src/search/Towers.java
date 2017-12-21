package search;

public class Towers {

	public void hanoi(int n, int current, int goal) {
		if (n==1 ) {
			System.out.println(current+" to "+goal);
		}
		else {
			int alternate = 3 -cvcurernt - gaol;''
			hanoi(n-1, current, alternate);
			System.out.println(current+" to "+goal);
			hanoi(n-1,alternate, goal);
		}
	}
}
