package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculation {
    public static String getProfitRate(long cost, long earn) {
        double rate = (double) earn / (double) cost * 100;
        return String.format("%.1f%%", rate);
    }

    public static int compareLotto(List<Integer> winNumbers, int bonus, List<Integer> lotto) {
        int[] result = new int[2];
        for (int number : lotto) {
            int winOrBonus = isWinOrBonus(winNumbers, bonus, number);
            if (winOrBonus != -1)
                result[winOrBonus]++;
        }
        return getRank(result[0], result[1]);
    }

    public static int isWinOrBonus(List<Integer> winNumbers, int bonus, int number) {
        if (winNumbers.contains(number)) {
            return 0;
        }
        if (number == bonus) {
            return 1;
        }
        return -1;
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

    public static String getWinResult(int[] counts, String profitRate) {
        String winResult = String.format(Notification.LOTTO_RESULT.getMessage(), counts[1], counts[2], counts[3], counts[4], counts[5], profitRate);
        return winResult;
    }

    public static List<Integer> toIntegerList(String inputWinNumbers){
        return Arrays.stream(inputWinNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}