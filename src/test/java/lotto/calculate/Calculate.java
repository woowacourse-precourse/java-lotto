package calculate;

import java.util.List;

public class Calculate {
	public static void run(List<Integer> correctNums) {
		System.out.println("당첨 통계");
		System.out.println("---");
		int num = PrizeSum.run(correctNums);
		int cost = correctNums.size()*1000;
		YieldCalculate.run(num, cost);
	}
}
