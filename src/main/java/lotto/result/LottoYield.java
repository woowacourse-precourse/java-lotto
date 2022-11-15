package lotto.result;

import java.util.Map;

public class LottoYield {

    double totalWinnings;
    double totalPurchase;

    public LottoYield(Map<String, Integer> prizesMap) {
        totalWinnings = 0;
        totalPurchase = 0;
        for (LottoPrizes lottoPrize : LottoPrizes.values()) {
            if (prizesMap.containsKey(lottoPrize.name())) {
                int winsCount = prizesMap.get(lottoPrize.name());
                plusToTotalWinnings(lottoPrize, winsCount);
                plusToTotalPurchase(winsCount);
            }
        }
    }
    private void plusToTotalWinnings(LottoPrizes lottoPrize, int winsCount) {
        totalWinnings += winsCount * lottoPrize.money();
    }
    private void plusToTotalPurchase(int winsCount) {
        totalPurchase += winsCount * LottoPrizes.purchasingPrice();
    }
    public double yield() {
        return totalWinnings / totalPurchase;
    }

}
