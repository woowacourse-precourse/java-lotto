package lotto;

import java.util.Arrays;
import java.util.List;

public class Prize {
    private Ranks myRank;
    private int reward;

    Prize(int winningNumberCount, int bonusNumberCount) {
        myRank = getRankByMatchingNumberCount(winningNumberCount, bonusNumberCount);
        reward = myRank.getPrizeMoney();
    }

    public int getReward() {
        return reward;
    }

    public Ranks getRankByMatchingNumberCount(int winningNumberCount, int bonusNumberCount) {
        return Arrays.stream(myRank.values())
                .filter(rank -> rank.matchingWinningNumberCount == winningNumberCount
                        && rank.matchingBonusNumberCount == bonusNumberCount)
                .findFirst()
                .orElse(Ranks.NONE);
    }

    public enum Ranks {
        FIRST(6, 0, 2_000_000_000),
        SECOND(5, 1, 30_000_000),
        THIRD(5, 0, 1_500_000),
        FOURTH(4, 0, 50_000),
        FIFTH(3, 0, 5_000),
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

        public Ranks getRankByMatchingNumberCount(int winningNumberCount, int bonusNumberCount) {
            return Arrays.stream(values())
                    .filter(rank -> rank.matchingWinningNumberCount == winningNumberCount
                            && rank.matchingBonusNumberCount == bonusNumberCount)
                    .findFirst()
                    .orElse(Ranks.NONE);
        }
    }
}
