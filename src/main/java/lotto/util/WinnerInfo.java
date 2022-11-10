package lotto.util;

public enum WinnerInfo {

    RANK1(1, "6개 일치", 2_000_000_000),
    RANK2(2, "5개 일치, 보너스 볼 일치", 30_000_000),
    RANK3(3, "5개 일치", 1_500_000),
    RANK4(4, "4개 일치", 50_000),
    RANK5(5, "3개 일치", 5_000);

    private final int rank;
    private final String winningCondition;
    private final int prize;

    WinnerInfo(int rank, String winningCondition, int prize) {
        this.rank = rank;
        this.winningCondition = winningCondition;
        this.prize = prize;
    }

    public int getRank() {
        return this.rank;
    }

    public String getWinningCondition() {
        return this.winningCondition;
    }

    public int getPrizeInformation() {
        return this.prize;
    }

}
