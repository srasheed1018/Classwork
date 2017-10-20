package arrays2d;

public class Main {
 
	public static void main(String[] args)
		{
		
		}

	
	/**
	 * adds 1 to the element in arr at index psn
	 * and subs 1 the elements at psm -1 and psn +1 IF THEY EXIST
	 * @param arr
	 * @param psn
	 * THIS idea is another major topic in APCSA.
	 * It is the idea of avoiding an ArrayIndexOutOfBoundsException
	 * You will see it on quizzes, tests, and project rubrics
	 * ALWAYS BE MINDFUL!
	 */
	public static void changeNeighbors(int[] arr, int psn)
	{
		if (psn==0)
		{
			//code that adds 1 to first and subs1 from second
			arr[psn]++;
			arr[psn+1]--;
		}
		else
		{
			if (psn==arr.length-1)
			{
				//code that adds 1 to last and subs 1 from second to last
				arr[psn]++;
				arr[psn-1]--;
			}
			else
			{
				//code that runs normally
				arr[psn-1]--;
				arr[psn]++;
				arr[psn+1]--;
			}
		}
	}
}
