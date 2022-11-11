package lotto;

import java.text.DecimalFormat;

public enum LottoRanking {
    RANK_LOSE("꽝", 0),
    RANK_5("3개 일치", 5000),
    RANK_4("4개 일치", 50000),
    RANK_3("5개 일치", 1500000),
    RANK_2("5개 일치, 보너스 볼 일치", 30000000),
    RANK_1("6개 일치", 2000000000);

    private final String description;
    private final int reward;

    LottoRanking(String description, int reward) {
        this.description = description;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return description + " (" + formatter.format(reward) + ")";
    }
}
