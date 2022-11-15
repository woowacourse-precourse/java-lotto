package lotto.vo;

public enum Score {
    FIFTH(3, false, "3개 일치", 5_000),
    FORTH(4, false, "4개 일치", 50_000),
    THIRD(5, false, "5개 일치", 1_500_000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치", 30_000_000),
    FIRST(6, false, "6개 일치", 2_000_000_000),
    ;

    private final int matchCountCondition;
    private final boolean bonusMatchingCondition;
    private final String description;
    private final Integer price;

    Score(int matchCountCondition, boolean bonusMatchingCondition, String description, Integer price) {
        this.matchCountCondition = matchCountCondition;
        this.bonusMatchingCondition = bonusMatchingCondition;
        this.description = description;
        this.price = price;
    }

    public boolean isMatchingToScoreCondition(int matchCountCondition, boolean bonusMatchingCondition) {
        return matchCountCondition == this.matchCountCondition && bonusMatchingCondition == this.bonusMatchingCondition;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }
}