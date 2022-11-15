package calculate;

import java.util.List;

public class PrizeSum {
	public static int run(List<Integer> correctNums) {
		int answer = 0;
		answer += FifthPrize.run(correctNums);
		answer += FourthPrize.run(correctNums);
		answer += ThirdPrize.run(correctNums);
		answer += SecondPrize.run(correctNums);
		answer += FirstPrize.run(correctNums);
		return answer;
	}
}
