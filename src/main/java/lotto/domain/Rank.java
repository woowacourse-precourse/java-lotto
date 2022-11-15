package lotto.domain;

public enum Rank {
    FIRST_PLACE("6개 일치 (2,000,000,000원)"),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PLACE("5개 일치 (1,500,000원)"),
    FOURTH_PLACE("4개 일치 (50,000원)"),
    FIFTH_PLACE("3개 일치 (5,000원)"),
    UNRANK("3개 미만 일치 (0원)");

    private final String reward;

    Rank(String reward) {
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }
}