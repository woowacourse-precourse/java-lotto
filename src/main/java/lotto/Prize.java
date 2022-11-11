package lotto;

import java.util.Arrays;

public class Prize {
    private Ranks rank;
    private final int money;

    Prize(int winningNumberCount, int bonusNumberCount) {
        rank = getRankByMatchingNumberCount(winningNumberCount, bonusNumberCount);
        money = rank.getPrizeMoney();
    }

    public Ranks getRankByMatchingNumberCount(int myMatchingWinningNumberCount, int myMatchingBonusNumberCount) {
        return Arrays.stream(Ranks.values())
                .filter(rank -> rank.matchingWinningNumberCount == myMatchingWinningNumberCount
                        && rank.matchingBonusNumberCount == myMatchingBonusNumberCount)
                .findFirst()
                .orElse(Ranks.NONE);
    }

    public int getMoney() {
        return money;
    }

    public enum Ranks {
        THREE_NUMBERS(3, 0, 5_000),
        FOUR_NUMBERS(4, 0, 50_000),
        FIVE_NUMBERS(5, 0, 1_500_000),
        BONUS_NUMBERS(5, 1, 30_000_000),
        SIX_NUMBERS(6, 0, 2_000_000_000),
        NONE(0, 0, 0);

        private final int matchingWinningNumberCount;
        private final int matchingBonusNumberCount;
        private final int prizeMoney;

        Ranks(int matchingWinningNumberCount, int matchingBonusNumberCount, int prizeMoney) {
            this.matchingWinningNumberCount = matchingWinningNumberCount;
            this.matchingBonusNumberCount = matchingBonusNumberCount;
            this.prizeMoney = prizeMoney;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }
    }
}
