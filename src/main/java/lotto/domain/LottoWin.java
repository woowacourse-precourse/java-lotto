package lotto.domain;

import java.util.Arrays;

public enum LottoWin {
    LOSER(0, 0, 0),
    FIFTH_PRICE_WINNER(3, 0, 5_000),
    FOURTH_PRICE_WINNER(4, 0, 50_000),
    THIRD_PRICE_WINNER(5, 0, 1_500_000),
    SECOND_PRICE_WINNER(5, 1, 30_000_000),
    FIRST_PRICE_WINNER(6, 0, 2_000_000_000);

    private final int sameNumberCount;
    private final int sameBonusNumberCount;
    private final int prize;

    LottoWin(int sameNumberCount, int sameBonusNumberCount, int prize) {
        this.sameNumberCount = sameNumberCount;
        this.sameBonusNumberCount = sameBonusNumberCount;
        this.prize = prize;
    }

    public static LottoWin of(int sameCount, int sameBonusCount) {
        return Arrays.stream(LottoWin.values())
                .filter(lottoWin -> lottoWin.sameNumberCount == sameCount && lottoWin.sameBonusNumberCount == sameBonusCount)
                .findFirst()
                .orElse(LOSER);
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public boolean isAnyBonus() {
        return sameBonusNumberCount != 0;
    }
}
