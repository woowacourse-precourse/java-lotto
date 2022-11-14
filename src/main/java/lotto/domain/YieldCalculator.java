package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;
import lotto.resource.Rank;

public class YieldCalculator {
    private static final int HUNDRED = 100;

    private final Map<String, Integer> winningCountRepository;
    private final Integer purchasePrice;

    public YieldCalculator(Map<String, Integer> winningCountRepository, Integer purchasePrice) {
        this.winningCountRepository = winningCountRepository;
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal calculate() {
        BigDecimal bigDecimal = BigDecimal.valueOf(getTotalPrizeMoney() / purchasePrice * HUNDRED);
        return bigDecimal.setScale(1, RoundingMode.HALF_UP);
    }

    private double getTotalPrizeMoney() {
        float totalPrizeMoney = 0;
        for (Entry<String, Integer> winningCountEntry : winningCountRepository.entrySet()) {
            String rankName = winningCountEntry.getKey();
            Integer winningCount = winningCountEntry.getValue();
            totalPrizeMoney += Rank.valueOf(rankName).getPrizeMoney() * winningCount;
        }
        return totalPrizeMoney;
    }
}
