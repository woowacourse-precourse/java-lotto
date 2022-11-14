package lotto.service;

public enum LottoType {

    MATCHING_THREE(3, 5000),
    MATCHING_FOUR(4, 50000),
    MATCHING_FIVE(5, 1500000),
    MATCHING_FIVE_WITH_BONUS(7, 30000000),
    MATCHING_SIX(6, 2000000000);

    private final Integer matchingCount;
    private final Integer matchingCountMoney;

    LottoType(Integer matchingCount, Integer matchingCountMoney) {
        this.matchingCount = matchingCount;
        this.matchingCountMoney = matchingCountMoney;
    }

    public Integer getMatchingCount() {
        return matchingCount;
    }

    public Integer getMatchingCountMoney() {
        return matchingCountMoney;
    }
}
