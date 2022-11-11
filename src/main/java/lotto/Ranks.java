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
            "6개 일치 (2,000,000,000원)"),
    NONE(
            0,
            0,
            "3개 이상 일치하는 공이 없습니다.");

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

    public static Ranks getRankBy(int myMatchingWinningNumberCount, int myMatchingBonusNumberCount) {
        if (myMatchingWinningNumberCount == 5 && myMatchingBonusNumberCount == 1) {
            return Ranks.BONUS_NUMBERS;
        }
        return Arrays.stream(Ranks.values())
                .filter(rank -> rank.matchingWinningNumberCount == myMatchingWinningNumberCount)
                .findFirst()
                .orElse(Ranks.NONE);
    }

    public static Ranks getRankBy(Integer prizeMoney) {
        return Arrays.stream(Ranks.values())
                .filter(rank -> rank.prizeMoney == prizeMoney)
                .findFirst()
                .orElse(NONE);
    }
}

