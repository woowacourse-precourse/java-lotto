package calculate;

public class YieldCalculate {
	public static void run(int num, int cost) {
		double yield = num/cost;
		System.out.printf("총 수익률은 %.1f%입니다.",yield);
	}
}
