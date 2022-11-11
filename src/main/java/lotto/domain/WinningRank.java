package lotto.domain;

public enum WinningRank {
    FIFTH_RANK(5_000, "3개 일치", 5),
    FOURTH_RANK(50_000, "4개 일치", 4),
    THIRD_RANK(1_500_000, "5개 일치", 3),
    SECOND_RANK(30_000_000, "5개 일치, 보너스 볼 일치", 2),
    FIRST_RANK(2_000_000_000, "6개 일치", 1);

    private final int prizeMoney;
    private final String winningRule;
    private final int rank;

    WinningRank(int prizeMoney, String winningRule, int rank) {
        this.prizeMoney = prizeMoney;
        this.winningRule = winningRule;
        this.rank = rank;
    }


}
