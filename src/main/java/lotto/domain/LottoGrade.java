package lotto.domain;

public class LottoGrade {
    private int correctNumberCount;
    private boolean isBonusCorrect;

    public LottoGrade() {
        this.correctNumberCount = 0;
        this.isBonusCorrect = false;
    }

    public void increaseCorrectNumberCount() {
        correctNumberCount += 1;
    }

    public void makeBonusCorrect() {
        isBonusCorrect = true;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }

    public boolean isBonusCorrect() {
        return isBonusCorrect;
    }
}
