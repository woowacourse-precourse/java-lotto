package calculate;

import java.util.List;

public class Calculate {
	public static void run(List<Integer> correctNums, int coin) {
		System.out.println("당첨 통계");
		System.out.println("---");
		int num = PrizeSum.run(correctNums);
		int cost = coin;
		YieldCalculate.run(num, cost);
	}
}
