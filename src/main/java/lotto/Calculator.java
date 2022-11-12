package lotto;

public class Calculator {
    static public float calculate(int buyPrice) {
        return 0;
    }

    public static float getTotalPrize() {
        float result = 0;
        for (Rank rank : Rank.values()) {
            result += rank.getPrize() * rank.getCount();
        }
        return result;
    }
}
