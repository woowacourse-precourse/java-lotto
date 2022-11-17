package lotto.domain;

public class LottoResult {

    private int threeCount;

    private int fourCount;

    private int fiveCount;

    private int fiveWithBonusCount;

    private int sixCount;

    public int getThreeCount() {
        return threeCount;
    }

    public int getFourCount() {
        return fourCount;
    }

    public int getFiveCount() {
        return fiveCount;
    }

    public int getFiveWithBonusCount() {
        return fiveWithBonusCount;
    }

    public int getSixCount() {
        return sixCount;
    }

    public void addThreeCount() {
        this.threeCount += 1;
    }

    public void addFourCount() {
        this.fourCount += 1;
    }

    public void addFiveCount() {
        this.fiveCount += 1;
    }

    public void addFiveWithBonusCount() {
        this.fiveWithBonusCount += 1;
    }

    public void addSixCount() {
        this.sixCount += 1;
    }
}
