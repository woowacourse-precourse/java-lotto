package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoManager {

    public double analyzeMarginRate(Map<LottoPlace, Integer> winningRecords) {
        int countPurchased = winningRecords.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * Lotto.PRICE)
                .sum();
        int countWinning = winningRecords.entrySet().stream()
                .filter(entry-> !entry.getKey().equals(LottoPlace.NONE))
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();
        System.out.println(countWinning + " : " + countPurchased);
        return 100.0 * (double) countWinning / (double) countPurchased;
    }
}
