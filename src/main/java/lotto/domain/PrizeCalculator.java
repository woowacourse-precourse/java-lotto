package lotto.domain;

import java.util.List;
import lotto.constant.LottoStatistic;

public enum PrizeCalculator {
    THREE_MATCH(3, false, 5000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(5, false, 1_500_000),
    FIVE_MATCH_PLUS_BONUS(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000);

    private final int matchingNumbers;
    private final boolean bonus;
    private final long prizeAmount;
    private int count;

    PrizeCalculator(int matchingNumbers, boolean bonus, long prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.bonus = bonus;
        this.prizeAmount = prizeAmount;
        this.count = 0;
    }

    public static long getResultForLotto(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchingCount = compareWinningNumbers(lotto, winningNumbers);
        boolean doesBonusMatch = false;
        if (matchingCount == LottoStatistic.NUMBER_OF_LOTTERY_NUMBERS.getValue() - 1) {
            doesBonusMatch = lotto.doesContainNumber(bonusNumber);
        }
        return getPrizeAmount(matchingCount, doesBonusMatch);
    }

    public static int compareWinningNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : winningNumbers) {
            if (lotto.doesContainNumber(number)) {
                count++;
            }
        }
        return count;
    }

    public static long getPrizeAmount(int numberOfMatches, boolean doesBonusMatch) {
        long prizeAmount = 0;
        for (PrizeCalculator prize : values()) {
            if (prize.matchingNumbers == numberOfMatches && prize.bonus == doesBonusMatch){
                prize.increaseCount();
                prizeAmount = prize.prizeAmount;
                return prizeAmount;
            }
        }
        return prizeAmount;
    }

    private void increaseCount() {
        this.count++;
    }
}
