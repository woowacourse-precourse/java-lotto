package lotto.domain;

public enum LottoRank {
    ONE(6, 2000000000), TWO(5, 30000000), THREE(5, 1500000),
    FOUR(4, 50000), FIVE(3, 5000), NOTHING(0, 0);

    private final int correctNumberCount;
    private final int money;
    LottoRank(int correctNumberCount, int money) {
        this.correctNumberCount = correctNumberCount;
        this.money = money;
    }

    public static LottoRank getLottoRankByCorrectNumberCount(Lotto lotto, int bonusNumber, int correctNumberCount) {
        if (correctNumberCount == ONE.getCorrectNumberCount()) {
            return ONE;
        }
        if (correctNumberCount == TWO.getCorrectNumberCount()) {
            if (lotto.getLotto().contains(bonusNumber)) {
                return TWO;
            }
            return THREE;
        }
        if (correctNumberCount == FOUR.getCorrectNumberCount()) {
            return FOUR;
        }
        if (correctNumberCount == FIVE.getCorrectNumberCount()) {
            return FIVE;
        }
        return NOTHING;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }

    public int getMoney() {
        return money;
    }
}
