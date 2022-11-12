package lotto;

import java.util.List;

public class Profit {

    private static final int UNIT_STANDARD = 1_000;
    private static final int ROUND_STANDARD = 10;
    private static final int PERCENTAGE = 100;

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
        double purchaseAmount = lottoQuantity * UNIT_STANDARD;

        return (total / purchaseAmount);
    }

    public double toPercent(double rate) {
        return rate * PERCENTAGE;
    }

    public double roundUpSecondDigit(double percent) {
        return (double) Math.round(percent * ROUND_STANDARD) / ROUND_STANDARD;
    }
}
