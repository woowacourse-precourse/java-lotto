package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FIRST("1ST", 6, new int[]{0, 1}, 2_000_000_000L, "2,000,000,000"),
    SECOND("2ND", 5, new int[]{1}, 30_000_000L, "30,000,000"),
    THIRD("3RD", 5, new int[]{0}, 1_500_000L, "1,500,000"),
    FOURTH("4TH", 4, new int[]{0, 1}, 50_000L, "50,000"),
    FIFTH("5TH", 3, new int[]{0, 1}, 5_000L, "5,000"),
    LOSE("LOST", -1, new int[]{0, 1}, 0L, "0");

    private final String label;
    private final int winningCount;
    private final int[] bonusCount;
    private final long prize;
    private final String prizeLabel;

    Ranking(String label, int winningCount, int[] bonusCount, long prize, String prizeLabel) {
        this.label = label;
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
        this.prizeLabel = prizeLabel;
    }

    public static Ranking getRank(int winningCount, int bonusCount) {
        return Arrays.stream(Ranking.values())
                .filter(rank -> rank.winningCount == winningCount
                        && Arrays.stream(rank.bonusCount).anyMatch(number -> number == bonusCount)
                )
                .findAny()
                .orElse(LOSE);
    }

    public static List<Ranking> getAll() {
        return new ArrayList<Ranking>(
                Arrays.asList(
                        Ranking.FIFTH,
                        Ranking.FOURTH,
                        Ranking.THIRD,
                        Ranking.SECOND,
                        Ranking.FIRST)
        );
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

