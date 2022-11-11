package lotto.domain;

import java.util.Arrays;

public enum WinningRank {
    NONE_RANKED(6, 0, ""),
    FIFTH_RANK(5, 5_000, "3개 일치"),
    FOURTH_RANK(4, 50_000, "4개 일치"),
    THIRD_RANK(3, 1_500_000, "5개 일치"),
    SECOND_RANK(2, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST_RANK(1, 2_000_000_000, "6개 일치");

    private final int rank;
    private final int prizeMoney;
    private final String winningRule;

    WinningRank(int rank, int prizeMoney, String winningRule) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
        this.winningRule = winningRule;
    }

    public static WinningRank findByRank(int rankNum){
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank.rank == rankNum)
                .findAny()
                .orElse(NONE_RANKED);
    }


}
