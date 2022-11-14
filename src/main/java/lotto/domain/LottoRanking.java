package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {

    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    FAIL(0, -1, false);

    private int prize;
    private int correctNumbers;
    private boolean hasBonusNumber;

    LottoRanking(int prize, int correctNumbers, boolean hasBonusNumber) {
        this.prize = prize;
        this.correctNumbers = correctNumbers;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoRanking findRank(int count, boolean bonusNumber) {
        if (count == 5) {
            return chooseSecondOrThird(bonusNumber);
        }
        return Arrays.stream(LottoRanking.values())
                .filter(rank -> rank.correctNumbers() == count)
                .findFirst()
                .orElse(FAIL);
    }

    private static LottoRanking chooseSecondOrThird(boolean bonusNumber) {
        if (bonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public int prize() {
        return prize;
    }

    public int correctNumbers() {
        return correctNumbers;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}