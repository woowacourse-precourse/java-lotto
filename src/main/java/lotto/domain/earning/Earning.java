package lotto.domain.earning;

import lotto.domain.prize.PrizeStatistics;
import lotto.domain.prize.PrizeType;

public class Earning {
    private final double earning;

    public Earning(int purchaseAmount, PrizeStatistics prizeStatistics) {
        this.earning = calculateEarning(purchaseAmount, prizeStatistics);
    }

    public double getEarning() {
        return earning;
    }

    private double calculateEarning(int purchaseAmount, PrizeStatistics prizeStatistics) {
        double sumOfPrizeMoney = 0;

        for (PrizeType prizeType : PrizeType.values()) {
            int count = prizeStatistics.getCount(prizeType);
            sumOfPrizeMoney += prizeType.getPrizeMoney() * count;
        }

        return (sumOfPrizeMoney / purchaseAmount) * 100;
    }
}
