package lotto.domain;

import java.text.NumberFormat;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int correctCount;
    private final int prize;
    private final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();

    Rank(int correctCount, int prize) {
        this.correctCount = correctCount;
        this.prize = prize;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrizeWithComna() {
        return NUMBER_FORMAT.format(prize);
    }
}
