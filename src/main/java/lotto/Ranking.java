package lotto;

import java.util.Arrays;
import lotto.domain.Lotto;

public enum Ranking {
    FIRST(Lotto.RANK_FIRST, 6, 0, 2_000_000_000L, "2,000,000,000"),
    SECOND(Lotto.RANK_SECOND, 5, 1, 30_000_000L, "30,000,000"),
    THIRD(Lotto.RANK_THIRD, 5, 0, 1_500_000L, "1,500,000"),
    FOURTH(Lotto.RANK_FOURTH, 4, 0, 50_000L, "50,000"),
    FIFTH(Lotto.RANK_FIFTH, 3, 0, 5_000L, "5,000"),
    LOSE(Lotto.LOSE, -1, -1, 0L, "0");

    private String label;
    private int winningCount;
    private int bonusCount;
    private long prize;
    private String prizeLabel;

    Ranking(String label, int winningCount, int bonusCount, long prize, String prizeLabel) {
        this.label = label;
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
        this.prizeLabel = prizeLabel;
    }

    public static Ranking getRank(int winningCount, int bonusCount) {
        if (winningCount == 5 && bonusCount == 1) {
            return Arrays.stream(Ranking.values())
                    .filter(rank -> rank.label.equals(Lotto.RANK_SECOND))
                    .findAny()
                    .orElse(LOSE);
        }
        return Arrays.stream(Ranking.values())
                .filter(rank -> rank.winningCount == winningCount
                        && rank.bonusCount == 0)
                .findAny()
                .orElse(LOSE);
    }

    public String getLabel() {
        return this.label;
    }

    public long getPrize() {
        return this.prize;
    }

    public String getPrizeLabel() {
        return this.prizeLabel;
    }

    public int getWinningCount() {
        return this.winningCount;
    }

}
