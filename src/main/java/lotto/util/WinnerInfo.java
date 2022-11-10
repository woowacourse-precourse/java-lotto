package lotto.util;

public enum WinnerInfo {

    RANK1(1, 6, 2_000_000_000),
    RANK2(2, 5, 30_000_000),
    RANK3(3, 5, 1_500_000),
    RANK4(4, 4, 50_000),
    RANK5(5, 3, 5_000);

    private final int rank;
    private final int winningCondition;
    private final int prize;

    WinnerInfo(int rank, int winningCondition, int prize) {
        this.rank = rank;
        this.winningCondition = winningCondition;
        this.prize = prize;
    }

    public int getRank() {
        return this.rank;
    }

    public int getWinningCondition() {
        return this.winningCondition;
    }

    public int getPrizeInformation() {
        return this.prize;
    }

}
