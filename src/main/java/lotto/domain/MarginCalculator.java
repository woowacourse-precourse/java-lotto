package lotto.domain;

import java.util.Iterator;
import java.util.Map;

public class MarginCalculator {
    public static double getMarginRatio(Map<String, Integer> winningInfo, int lottoCount) {
        long totalAmount = getTotalWinningAmount(winningInfo);
        int paymentAmount = lottoCount * Policy.PRICE;

        return (double)totalAmount / paymentAmount * 100;
    }

    private static long getTotalWinningAmount(Map<String, Integer> winningInfo) {
        long totalAmount = 0;
        Iterator<String> keys = winningInfo.keySet().iterator();

        while(keys.hasNext()) {
            String key = keys.next();
            totalAmount += Policy.WinningAmount.valueOf(key).getAmount() * winningInfo.get(key);
        }
        return totalAmount;
    }
}
