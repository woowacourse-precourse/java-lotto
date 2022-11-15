package calculate;

public class YieldCalculate {
	public static void run(int num, int cost) {
		double yield = num / cost;
		System.out.println("총 수익률은 "+Math.round(yield)+"%입니다.");
	}
}
