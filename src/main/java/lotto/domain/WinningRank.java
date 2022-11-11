package lotto.domain;

public enum WinningRank {
    FIFTH_RANK(5_000, "3개 일치"),
    FOURTH_RANK(50_000, "4개 일치"),
    THIRD_RANK(1_500_000, "5개 일치"),
    SECOND_RANK(30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST_RANK(2_000_000_000, "6개 일치");

    private final int prizeMoney;
    private final String winningRule;

    WinningRank(int prizeMoney, String winningRule) {
        this.prizeMoney = prizeMoney;
        this.winningRule = winningRule;
    }


}
