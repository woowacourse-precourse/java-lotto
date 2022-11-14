package lotto;

import java.util.Arrays;

public enum Statistics {
    FIRST(0, 6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(1, 5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(2, 5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(3, 4, 50000, "4개 일치 (50,000원)"),
    FIFTH(4, 3, 5000, "3개 일치 (5,000원)");

    private final int value;
    private final int matchingNumbers;
    private final int prize;
    private final String result;


    Statistics(int value, int matchingNumbers, int prize, String result) {
        this.value = value;
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.result = result;
    }

    public int getValue() {
        return value;
    }

    public int getPrize() {
        return prize;
    }

    public String getResult() {
        return result;
    }

    public static Statistics valueOfValue(int v) {
        return Arrays.stream(values())
                .filter(Statistics -> Statistics.value == v)
                .findFirst()
                .orElse(null);
    }

    public static Statistics getRank(int matchingCount, boolean isBonus) {
        if (!isBonus && matchingCount == 5)
            return THIRD;
        return Arrays.stream(Statistics.values())
                .filter(Statistics -> Statistics.matchingNumbers == matchingCount)
                .findFirst()
                .orElse(null);
    }

}
