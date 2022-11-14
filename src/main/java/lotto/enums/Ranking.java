package lotto.enums;

import java.util.Arrays;

public enum Ranking {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(15, 30000000),
    FIRST(6, 2000000000),
    NONE(-1, 0);

    private final int matchingNumbers;
    private final int prize;
    private int winningResult;

    Ranking(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.winningResult = 0;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getWinningResult() {
        return this.winningResult;
    }

    public void plusWinningResult() {
        this.winningResult++;
    }

    public static Ranking getRankByMatchingNumbers(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchingNumbers == numberOfMatch)
                .findFirst()
                .orElse(NONE);
    }
}