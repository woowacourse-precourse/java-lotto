package confirm;

import java.util.List;

public class WinNumErrorCheck {
	public static void run(List<Integer> winNums) {
		int[] checkNum = new int[45];
		for (int i : winNums) {
			overflowCheck.run(i);
			checkNum[i]+=1;			
		}
		for (int i : checkNum) {
			DuplicateCheck.run(i);
		}
	}
}
