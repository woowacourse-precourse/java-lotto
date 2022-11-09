package lotto.domain;

public enum Rank {
    _1등(2000000000, 6, null, null),
    _2등(30000000, 5, 5, true),
    _3등(1500000, 5, 5, false),
    _4등(50000, 4, 4, null),
    _5등(5000, 3, 3, null),
    _6등(0, null, null, null);

    final private Integer winning;
    final private Integer minMatchNum;
    final private Integer maxMatchNum;
    final private Boolean isBonusRequired;

    Rank(Integer winning, Integer minMatchNum, Integer maxMatchNum, Boolean isBonusRequired) {
        this.winning = winning;
        this.minMatchNum = minMatchNum;
        this.maxMatchNum = maxMatchNum;
        this.isBonusRequired = isBonusRequired;
    }

    public Integer getWinning() {
        return winning;
    }

    public Integer getWinning(int correctNumberCount, boolean isBonusCorrect) {
        if (minMatchNum != null && correctNumberCount < minMatchNum) {
            return null;
        }
        if (maxMatchNum != null && correctNumberCount > maxMatchNum) {
            return null;
        }
        if (isBonusRequired != null && isBonusCorrect != isBonusRequired) {
            return null;
        }
        return winning;
    }

}
