package lotto.domain.statistic;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0, "",false),
    THREE(3, 5_000,"5,000원", false),
    FOUR(4, 50_000, "50,000원",false),
    FIVE(5, 1_500_000, "1,500,000원",false),
    FIVE_BONUS(5, 30_000_000, "30,000,000원", true),
    SIX(6, 2_000_000_000, "2,000,000,000원", false);

    private final Integer correctCount;
    private final Integer money;
    private final String moneyResult;
    private final boolean hasBonusNumber;

    Rank(Integer correctCount, Integer money, String moneyResult, boolean hasBonusNumber) {
        this.correctCount = correctCount;
        this.money = money;
        this.moneyResult = moneyResult;
        this.hasBonusNumber = hasBonusNumber;
    }

    public Integer getCorrectCount() {
        return this.correctCount;
    }

    public Integer getMoney() {
        return this.money;
    }

    public String getMoneyResult() {
        return moneyResult;
    }

    public static Rank getRank(long correctCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> (rank.correctCount == correctCount) && (rank.hasBonusNumber == hasBonusNumber))
                .findFirst()
                .orElse(NONE);
    }
}
