package lotto.domain;

public class Result {
    private final int sameNumberCount;
    private final boolean isSameBonusNumber;

    public Result(int sameNumberCount, boolean isSameBonusNumber) {
        this.sameNumberCount = sameNumberCount;
        this.isSameBonusNumber = isSameBonusNumber;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public boolean isSameBonusNumber() {
        return isSameBonusNumber;
    }
}
