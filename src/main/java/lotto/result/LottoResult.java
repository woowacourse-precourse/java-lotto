package lotto.result;

import java.util.Map;

public class LottoResult {

    double totalWinnings;
    double totalPurchase;

    public LottoResult(Map<String, Integer> prizesMap) {
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
    public double yield() {
        return totalWinnings / totalPurchase;
    }
    private void plusToTotalWinnings(LottoPrizes lottoPrize, int winsCount) {
        totalWinnings += winsCount * lottoPrize.money();
    }
    private void plusToTotalPurchase(int winsCount) {
        totalPurchase += winsCount * LottoPrizes.purchasingPrice();
    }
}
