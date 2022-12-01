package lotto.domain;

import java.text.NumberFormat;
import java.util.Arrays;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

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

    public String getPrizeWithComma() {
        return NUMBER_FORMAT.format(prize);
    }

    public static Rank convertRank(int count, boolean isSecond) {
        if (count == SECOND.getCorrectCount() && isSecond) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.getCorrectCount() == count)
                .findFirst()
                .orElse(NONE);
    }
}
