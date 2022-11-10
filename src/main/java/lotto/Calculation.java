package lotto;

import java.util.Arrays;
import java.util.List;

public class Calculation {
    public static String profitRate(int cost, int earn) {
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
}