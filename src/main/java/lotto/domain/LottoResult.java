package lotto.domain;

public class LottoResult {
    private final int normalCount;
    private final int bonusCount;

    public LottoResult(int normalCount, int bonusCount) {
        this.normalCount = normalCount;
        this.bonusCount = bonusCount;
    }

    public int getNormalCount() {
        return normalCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    public static LottoResult of(int normalCount, int bonusCount) {
        return new LottoResult(normalCount, bonusCount);
    }
}
