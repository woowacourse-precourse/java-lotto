package lotto.domain;

import java.util.List;

public class MarginCalculator {
    private static int[] winningAmount; // 당첨금액

    public MarginCalculator() {
        winningAmount = new int[6];
        winningAmount[1] = 2000000000;
        winningAmount[2] = 30000000;
        winningAmount[3] = 1500000;
        winningAmount[4] = 50000;
        winningAmount[5] = 5000;
    }

    public double getMarginRatio(List<Integer> winningInfo, int lottoCount) {
        long totalAmount = getTotalWinningAmount(winningInfo);
        int paymentAmount = lottoCount * LottoStore.PRICE;

        return (double)totalAmount / paymentAmount * 100;
    }

    private long getTotalWinningAmount(List<Integer> winningInfo) {
        long totalAmount = 0;
        for(int i=1 ; i<winningInfo.size() ; i++) {
            totalAmount += (long)winningAmount[i] * winningInfo.get(i);
        }
        return totalAmount;
    }
}
