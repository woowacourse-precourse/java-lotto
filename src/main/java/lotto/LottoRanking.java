package lotto;

public enum LottoRanking {
    RANK_5("3개 일치 (5,000원)", 5000),
    RANK_4("4개 일치 (50,000원)", 50000),
    RANK_3("5개 일치 (1,500,000원)", 1500000),
    RANK_2("5개 일치 (30,000,000원)", 30000000),
    RANK_1("6개 일치 (2,000,000,000원)", 2000000000);

    private final String description;
    private final int reward;

    LottoRanking(String description, int reward) {
        this.description = description;
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public int getReward() {
        return reward;
    }
}
