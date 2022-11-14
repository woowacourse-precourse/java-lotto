package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.Map;
import java.lang.Math;

public class Result {
    private final List<Integer> winningCounts;
    private final PurchaseAmount purchaseAmount;
    private final List<Integer> matchCounts;

    public enum MatchCase {
        MATCH_THREE(3, 5000), MATCH_FOUR(4, 50000), MATCH_FIVE(5, 1500000), MATCH_FIVE_WITH_BONUS(7,
                30000000), MATCH_SIX(6, 2000000000);


        private final int matchCount;
        private final int prize;

        MatchCase(int matchCount, int prize) {
            this.matchCount = matchCount;
            this.prize = prize;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getPrize() {
            return prize;
        }

        private static final Map<Integer, MatchCase> prizeMap =
                Stream.of(values()).collect(Collectors.toMap(MatchCase::getMatchCount, Function.identity()));

        public static int valueOfPrize(int matchCount) {
            return prizeMap.get(matchCount).prize;
        }
    }

    Result(List<Integer> winningCounts, PurchaseAmount purchaseAmount) {
        this.winningCounts = winningCounts;
        this.purchaseAmount = purchaseAmount;
        this.matchCounts = getNumberOfMatchCounts();
    }

    public int getNumberOfMatchCount(int matchCount) {
        return (int) winningCounts.stream().filter(count -> count == matchCount).count();
    }

    public List<Integer> getNumberOfMatchCounts() {
        return Stream.of(MatchCase.values()).map(MatchCase::getMatchCount).map(this::getNumberOfMatchCount)
                .collect(Collectors.toList());
    }

    public Double getPrizePerPurchaseAmount() {
        int totalPrize = 0;
        for (int i = 0; i < MatchCase.values().length; i++) {
            totalPrize += MatchCase.valueOfPrize(i + 3) * matchCounts.get(i);
        }
        return (double) Math.round((double) totalPrize * 100 / this.purchaseAmount.getNumber() * 100) / 100.0;
    }

}
