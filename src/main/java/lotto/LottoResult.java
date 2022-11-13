package lotto;

import java.util.Map;

public class LottoResult {

    double totalWinnings;
    double totalPurchase;

    public LottoResult(Map<String, Integer> prizesMap) {
        double winningsSum = 0;
        double purchaseSum = 0;
        winningsSum += prizesMap.get("FIRST") * 2000000000;
        purchaseSum += prizesMap.get("FIRST");
        winningsSum += prizesMap.get("SECOND") * 30000000;
        purchaseSum += prizesMap.get("SECOND");
        winningsSum += prizesMap.get("THIRD") * 1500000;
        purchaseSum += prizesMap.get("THIRD");
        winningsSum += prizesMap.get("FOURTH") * 50000;
        purchaseSum += prizesMap.get("FOURTH");
        winningsSum += prizesMap.get("FIFTH") * 5000;
        purchaseSum += prizesMap.get("FIFTH");
        purchaseSum += prizesMap.get("NOTHING");
        totalWinnings = winningsSum;
        totalPurchase = purchaseSum * Payment.LOTTO_PRICE;
    }
    public double yield() {
        return totalWinnings / totalPurchase;
    }
}
