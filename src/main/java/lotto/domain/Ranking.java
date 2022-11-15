package lotto.domain;

public enum Ranking {
    NONE(0, 0, "2개 이하로 일치", 0),
    FIRST(1, 6,"6개 일치", 2_000_000_000),
    SECOND(2, 5, "5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD(3, 5, "5개 일치", 1_500_000),
    FOURTH(4, 4, "4개 일치", 50_000),
    FIFTH(5, 3, "3개 일치", 5_000);

    private final int place;
    private final int matchingNumberCount;
    private final String condition;
    private final int reward;

    Ranking(int place, int matchingNumberCount, String condition, int reward) {
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

    public int getReward() {
        return this.reward;
    }
}
