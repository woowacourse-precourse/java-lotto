package lotto.domain;

public enum LottoRanking {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 30000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000),
    LOSING(0, 0);

    private int matches;
    private int reward;

    LottoRanking(int matches, int reward) {
        this.matches = matches;
        this.reward = reward;
    }

    public int getMatches() {
        return matches;
    }

    public int getReward() {
        return reward;
    }
}
