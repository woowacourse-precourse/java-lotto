package lotto.domain;

public class LottoResult {

    private final int correctCount;
    private final boolean havingBonusNumber;

    public LottoResult(int correctCount, boolean havingBonusNumber) {
        this.correctCount = correctCount;
        this.havingBonusNumber = havingBonusNumber;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public boolean isHavingBonusNumber() {
        return havingBonusNumber;
    }

}
