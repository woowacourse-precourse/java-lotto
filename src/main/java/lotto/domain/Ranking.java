package lotto.domain;

public enum Ranking {
    FIFTH(5, 3, "3개 일치", "5,000원"),
    FOURTH(4, 4, "4개 일치", "50,000원"),
    THIRD(3, 5, "5개 일치", "1,500,000원"),
    SECOND(2, 5, "5개 일치, 보너스 볼 일치", "30,000,000원"),
    FIRST(1, 6,"6개 일치", "2,000,000,000원");


    private final int place;
    private final int matchingNumberCount;
    private final String condition;
    private final String reward;

    Ranking(int place, int matchingNumberCount, String condition, String reward) {
        this.place = place;
        this.matchingNumberCount = matchingNumberCount;
        this.condition = condition;
        this.reward = reward;
    }

    public int getPlace() {
        return place;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getReward() {
        return this.reward;
    }
}
