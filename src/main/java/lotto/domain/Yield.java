package lotto.domain;

public class Yield {
    public static double calculateYield(int money, int earn) {
        if (money == 0 || earn == 0) {
            return 0;
        }
        return  ((double) money / (double) earn) * 100;
    }
}
