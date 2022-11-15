package lotto.domain;

import java.text.NumberFormat;

public enum Rank {
    NONE(0,0),
    FIFTH_PLACE(3, 5000),
    FOURTH_PLACE(4, 50000),
    THIRD_PLACE(5, 1500000),
    SECOND_PLACE(5, 30000000),
    FIRST_PLACE(6, 2000000000);

    private final int correctCount;
    private final int prizeMoney;
    private final NumberFormat PRIZE_FORM = NumberFormat.getInstance();

    Rank(int correctCount, int prizeMoney) {
        this.correctCount = correctCount;
        this.prizeMoney = prizeMoney;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeIncludeComma() {
        return PRIZE_FORM.format(prizeMoney);
    }
}
