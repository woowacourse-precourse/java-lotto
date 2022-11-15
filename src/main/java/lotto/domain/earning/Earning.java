package lotto.domain.earning;

import java.util.Map;

import lotto.domain.prize.PrizeType;

public class Earning {
    private final double earning;

    public Earning(int purchaseAmount, Map<PrizeType, Integer> prizeStatistics) {
        this.earning = calculateEarning(purchaseAmount, prizeStatistics);
    }

    public double getEarning() {
        return earning;
    }

    private double calculateEarning(int purchaseAmount, Map<PrizeType, Integer> prizeStatistics) {
        double sumOfPrizeMoney = 0;

        for (PrizeType prizeType : PrizeType.values()) {
            int count = prizeStatistics.get(prizeType);
            sumOfPrizeMoney += prizeType.getPrizeMoney() * count;
        }

        return (sumOfPrizeMoney / purchaseAmount) * 100;
    }
}
