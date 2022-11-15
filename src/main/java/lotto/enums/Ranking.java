package lotto.enums;

import java.util.Arrays;

public enum Ranking {
    FIFTH(3, "3개 일치 (5,000원) - ", 5000),
    FOURTH(4, "4개 일치 (50,000원) - ", 50000),
    THIRD(5, "5개 일치 (1,500,000원) - ", 1500000),
    SECOND(15, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    FIRST(6, "6개 일치 (2,000,000,000원) - ", 2000000000),
    NOTHING(-1, "", 0);

    private final int matchingNumbers;
    private final String message;
    private final int prize;
    private int winningResult;

    Ranking(int matchingNumbers, String message, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.message = message;
        this.prize = prize;
        this.winningResult = 0;
    }

    public int getMatchingNumbers() {
        return this.matchingNumbers;
    }

    public String getMessage() {
        return this.message;
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
                .orElse(NOTHING);
    }
}