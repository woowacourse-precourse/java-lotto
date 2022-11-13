package lotto;

import java.util.Arrays;

public enum Ranking {
    FIRST("1ST", 6, 0, 2_000_000_000L, "2,000,000,000"),
    SECOND("2ND", 5, 1, 30_000_000L, "30,000,000"),
    THIRD("3RD", 5, 0, 1_500_000L, "1,500,000"),
    FOURTH("4TH", 4, 0, 50_000L, "50,000"),
    FIFTH("5TH", 3, 0, 5_000L, "5,000"),
    LOSE("LOST", -1, -1, 0L, "0");

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
                    .filter(rank -> rank.label.equals(SECOND.getLabel()))
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
