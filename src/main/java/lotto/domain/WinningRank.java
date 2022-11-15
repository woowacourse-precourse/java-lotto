package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum WinningRank {
    NONE_RANKED(0, "2개 이하 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount >= 0 && duplicatedNumberCount < 3)),
    FIFTH_RANK(5_000, "3개 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount == 3)),
    FOURTH_RANK(50_000, "4개 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount == 4)),
    THIRD_RANK(1_500_000, "5개 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount == 5 && !isContainBonusNumber)),
    SECOND_RANK(30_000_000, "5개 일치, 보너스 볼 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount == 5 && isContainBonusNumber)),
    FIRST_RANK(2_000_000_000, "6개 일치",
            (duplicatedNumberCount, isContainBonusNumber) -> (duplicatedNumberCount == 6 && !isContainBonusNumber));


    public static final String RANK_NOT_FOUND_ERROR_MESSAGE = "[ERROR] 잘못된 조건이 입력되었습니다.";

    private static final String DECIMAL_FORMAT = "###,###";

    private final int prizeMoney;
    private final String winningRule;
    private final BiFunction<Integer, Boolean, Boolean> winningRuleExpression;

    WinningRank(int prizeMoney, String winningRule, BiFunction<Integer, Boolean, Boolean> winningRuleExpression) {
        this.prizeMoney = prizeMoney;
        this.winningRule = winningRule;
        this.winningRuleExpression = winningRuleExpression;
    }


    public static WinningRank findByWinningCondition(int duplicatedNumberCount, boolean isContainBonusNumber)
            throws IllegalArgumentException {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank.isWin(duplicatedNumberCount, isContainBonusNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(RANK_NOT_FOUND_ERROR_MESSAGE));
    }

    public boolean isWin(int duplicatedNumberCount, boolean isContainBonusNumber) {
        return winningRuleExpression.apply(duplicatedNumberCount, isContainBonusNumber).booleanValue();
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }


    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        return this.winningRule + " (" + decimalFormat.format(this.prizeMoney) + "원)";
    }
}
