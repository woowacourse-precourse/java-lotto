package lotto;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, false, 0),
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int correctNumbers;
    private final boolean correctBonusNumber;
    private final int prize;

    public int getPrize() {
        return prize;
    }

    public int getCorrectNumbers() {
        return correctNumbers;
    }

    public boolean getCorrectBonusNumber() {
        return correctBonusNumber;
    }

    Rank(int correctNumbers, boolean correctBonusNumber, int prize) {
        this.correctNumbers = correctNumbers;
        this.correctBonusNumber = correctBonusNumber;
        this.prize = prize;
    }

    public static Rank findRank(int number, boolean bonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(lottoRank -> lottoRank.getCorrectNumbers() == number)
                .filter(lottoRank -> lottoRank.getCorrectBonusNumber() == bonusNumber)
                .findAny()
                .orElseGet(() -> NOTHING);
    }
}
