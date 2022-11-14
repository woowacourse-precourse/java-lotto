package lotto;

public class Calculator {
    static public float calculate(int buyPrice) {
        float result = getTotalPrize() / buyPrice * 100;
        print(result);
        return result;
    }

    private static void print(float percent) {
        String profit = String.format("%.1f", percent);
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    public static float getTotalPrize() {
        float result = 0;
        for (Rank rank : Rank.values()) {
            result += rank.getPrize() * rank.getCount();
        }
        return result;
    }
}
