package lotto;

import java.util.Arrays;

public enum Ranks {
    THREE_NUMBERS(
            3,
            5_000,
            "3개 일치 (5,000원)"),
    FOUR_NUMBERS(
            4,
            50_000,
            "4개 일치 (50,000원)"),
    FIVE_NUMBERS(
            5,
            1_500_000,
            "5개 일치 (1,500,000원)"),
    BONUS_NUMBERS(
            5,
            30_000_000,
            "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_NUMBERS(
            6,
            2_000_000_000,
            "6개 일치 (2,000,000,000원)");

    private final int matchingWinningNumberCount;
    private final int prizeMoney;
    private final String message;

    Ranks(int matchingWinningNumberCount, int prizeMoney, String message) {
        this.matchingWinningNumberCount = matchingWinningNumberCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public static int getPrizeMoneyBy(int myMatchingWinningNumberCount, int myMatchingBonusNumberCount) {
        if (myMatchingWinningNumberCount == 5 && myMatchingBonusNumberCount == 1) {
            return Ranks.BONUS_NUMBERS.prizeMoney;
        }
        for (Ranks ranks : Ranks.values()) {
            if (myMatchingWinningNumberCount == ranks.matchingWinningNumberCount) {
                return ranks.prizeMoney;
            }
        }
        return 0;
    }

    public static Ranks getRankBy(Integer prizeMoney) {
        return Arrays.stream(Ranks.values())
                .filter(rank -> rank.prizeMoney == prizeMoney)
                .findFirst()
                .orElse(null);
    }
}

