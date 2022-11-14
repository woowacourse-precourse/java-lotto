package lotto;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, false, 0, "0개 일치"),
    THREE(3, false, 5000, "3개 일치 (5,000원) - "),
    FOUR(4, false, 50000, "4개 일치 (50,000원) - "),
    FIVE(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    FIVE_BONUS(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, false, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int correctNumbers;
    private final boolean correctBonusNumber;
    private final int prize;
    private final String rankDescription;

    Rank(int correctNumbers, boolean correctBonusNumber, int prize, String rankDescription) {
        this.correctNumbers = correctNumbers;
        this.correctBonusNumber = correctBonusNumber;
        this.prize = prize;
        this.rankDescription = rankDescription;
    }

    public static Rank findRank(int number, boolean bonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(lottoRank -> lottoRank.getCorrectNumbers() == number)
                .filter(lottoRank -> lottoRank.getCorrectBonusNumber() == bonusNumber)
                .findAny()
                .orElseGet(() -> NOTHING);
    }

    public int getPrize() {
        return prize;
    }

    public int getCorrectNumbers() {
        return correctNumbers;
    }

    public boolean getCorrectBonusNumber() {
        return correctBonusNumber;
    }

    public String getRankDescription() {
        return rankDescription;
    }
}
