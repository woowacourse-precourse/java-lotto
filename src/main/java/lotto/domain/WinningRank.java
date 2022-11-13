package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum WinningRank {
    NONE_RANKED(6, 0, "",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount < 3)),
    FIFTH_RANK(5, 5_000, "3개 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount == 3)),
    FOURTH_RANK(4, 50_000, "4개 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount == 4)),
    THIRD_RANK(3, 1_500_000, "5개 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount == 5 && !isContainBonusNumber)),
    SECOND_RANK(2, 30_000_000, "5개 일치, 보너스 볼 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount == 5 && isContainBonusNumber)),
    FIRST_RANK(1, 2_000_000_000, "6개 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount == 6));


    private static final String DECIMAL_FORMAT = "###,###";

    private final int rank;
    private final int prizeMoney;
    private final String winningRule;
    private final BiFunction<Integer, Boolean, Boolean> isWinExpression;

    WinningRank(int rank, int prizeMoney, String winningRule, BiFunction<Integer, Boolean, Boolean> isWinExpression) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
        this.winningRule = winningRule;
        this.isWinExpression = isWinExpression;
    }

    public static WinningRank findByRank(int rankNum) {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank.rank == rankNum)
                .findAny()
                .orElse(NONE_RANKED);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isWin(int duplicatedNumberCount, boolean isContainBonusNumber) {
        return isWinExpression.apply(duplicatedNumberCount, isContainBonusNumber).booleanValue();
    }


    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        return this.winningRule + " (" + decimalFormat.format(this.prizeMoney) + "원)";
    }
}
