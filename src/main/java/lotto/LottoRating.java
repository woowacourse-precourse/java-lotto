package lotto;

import java.util.Arrays;

public enum LottoRating {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NOTHING(0, 0, false);

    private final int prizeOfMatch;
    private final int winningMoney;
    private final boolean bonusMatch;

    LottoRating(int prizeOfMatch, int winningMoney, boolean bonusMatch) {
        this.prizeOfMatch = prizeOfMatch;
        this.winningMoney = winningMoney;
        this.bonusMatch = bonusMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRating find(int winningCount, boolean bonusNumber) {
        if (winningCount == 5 && bonusNumber) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(lottoRating -> !lottoRating.bonusMatch)
                .filter(lottoRating -> lottoRating.prizeOfMatch == winningCount)
                .findAny()
                .orElse(NOTHING);
    }
}
