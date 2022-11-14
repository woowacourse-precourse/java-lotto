package lotto.domain;

public enum Ranking {
    FIRST(1,"6개 일치", "2,000,000,000원"),
    SECOND(2, "5개 일치, 보너스 볼 일치", "30,000,000원"),
    THIRD(3, "5개 일치", "1,500,000원"),
    FOURTH(4, "4개 일치", "50,000원"),
    FIFTH(5, "3개 일치", "5,000원");

    private final int place;
    private final String condition;
    private final String reward;

    Ranking(int place, String condition, String reward) {
        this.place = place;
        this.condition = condition;
        this.reward = reward;
    }

    public int getPlace() {
        return place;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getReward() {
        return this.reward;
    }
}
