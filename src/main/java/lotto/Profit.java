package lotto;

import static lotto.constant.PercentageConstant.PERCENTAGE;
import static lotto.constant.StandardConstant.MONEY_UNIT_STANDARD;
import static lotto.constant.StandardConstant.ROUND_STANDARD;

import java.util.List;

public class Profit {

    private final List<WinningStat> winningStats;

    public Profit(List<WinningStat> winningStats) {
        this.winningStats = winningStats;
    }

    public double calculate(Quantity quantity) {
        long total = totalPrize();

        double rate = toRate(quantity, total);

        double percent = toPercent(rate);

        return roundUpSecondDigit(percent);
    }

    public long totalPrize() {
        return winningStats.stream()
                .map(winningStat -> {
                    MatchingType matchingType = winningStat.getMatchingType();
                    int count = winningStat.getCount();

                    return matchingType.calculatePrize(count);
                })
                .mapToLong(number -> number)
                .sum();
    }

    public double toRate(Quantity quantity, long total) {
        int lottoQuantity = quantity.getNumber();
        double purchaseAmount = lottoQuantity * MONEY_UNIT_STANDARD.getValue();

        return (total / purchaseAmount);
    }

    public double toPercent(double rate) {
        return rate * PERCENTAGE.getValue();
    }

    public double roundUpSecondDigit(double percent) {
        return (double) Math.round(percent * ROUND_STANDARD.getValue()) / ROUND_STANDARD.getValue();
    }
}
