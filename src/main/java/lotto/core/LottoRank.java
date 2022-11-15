package lotto.core;

import static lotto.validator.ErrorMessage.INVALID_CORRECT_WINNING_NUMBER_ERROR;

import java.util.Arrays;

public enum LottoRank {
    _1st(2_000_000_000, 6, false),
    _2nd(30_000_000, 5, true),
    _3rd(1_500_000, 5, false),
    _4th(50_000, 4, false),
    _5th(5_000, 3, false),
    DRAW(0, 2, false);

    public final long winningPrize;
    public final int winningNumberMatchCount;
    public final boolean isCorrectBonusNumber;

    LottoRank(int winningPrize, int winningNumberMatchCount, boolean isCorrectBonusNumber) {
        this.winningPrize = winningPrize;
        this.winningNumberMatchCount = winningNumberMatchCount;
        this.isCorrectBonusNumber = isCorrectBonusNumber;
    }

    public static LottoRank winningResult(int winningNumberMatchCount, boolean isCorrectBonusNumber) {
        validate(winningNumberMatchCount);
        return Arrays.stream(LottoRank.values())
                .filter(rank -> isWin(winningNumberMatchCount, isCorrectBonusNumber, rank))
                .findFirst()
                .orElse(DRAW);
    }

    private static void validate(int winningNumberMatchCount) {
        if (winningNumberMatchCount < 0 || winningNumberMatchCount > 6) {
            throw new IllegalArgumentException(INVALID_CORRECT_WINNING_NUMBER_ERROR);
        }
    }

    private static boolean isWin(int winningNumberMatchCount, boolean isCorrectBonusNumber, LottoRank rank) {
        return rank.winningNumberMatchCount <= winningNumberMatchCount
                && !(rank.isCorrectBonusNumber && !isCorrectBonusNumber);
    }
}
