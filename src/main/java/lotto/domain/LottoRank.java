package lotto.domain;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4,50_000),
    FIFTH(3, 5_000),
    FAILED(0,0);

    private final int winningNumberCount;
    private final int rewardMoney;

    LottoRank(int winningNumberCount, int rewardMoney) {
        this.winningNumberCount = winningNumberCount;
        this.rewardMoney = rewardMoney;
    }
}
