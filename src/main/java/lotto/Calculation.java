package lotto;

import java.util.List;

public class Calculation {
    public static String getProfitRate(long cost, long earn) {
        double rate = (double) earn / (double) cost * 100;
        return String.format("%.1f%%", rate);
    }

    public static int compareLotto(List<Integer> winNumbers, int bonus, List<Integer> lotto) {
        int[] result = new int[2];
        for (int number : lotto) {
            if (winNumbers.contains(number)) {
                result[0]++;
            } else if (number == bonus) {
                result[1]++;
            }
        }
        return getRank(result[0], result[1]);
    }

    private static int getRank(int winCount, int bonusCount) {
        if (winCount == 6)
            return 5;
        if (winCount == 5 && bonusCount == 1)
            return 4;
        if (winCount == 5)
            return 3;
        if (winCount == 4)
            return 2;
        if (winCount == 3)
            return 1;
        return 0;
    }

    public static long getProfit(int[] counts) {
        int[] prices = {0, 5000, 50000, 1500000, 30000000, 2000000000};
        long sum = 0;
        for (int i = 0; i < counts.length; i++) {
            sum += counts[i] * prices[i];
        }
        return sum;
    }
}