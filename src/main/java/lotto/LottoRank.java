package lotto;

import java.text.DecimalFormat;

public enum LottoRank {

    FIRST("6개 일치", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD("5개 일치", 1_500_000),
    FOURTH("4개 일치", 50_000),
    FIFTH("3개 일치", 5_000),
    ;

    private final String description;
    private final Integer reward;
    private static final DecimalFormat decFormat = new DecimalFormat("###,###");


    LottoRank(String description, Integer reward) {
        this.description = description;
        this.reward = reward;
    }

    public Integer getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return description + " (" + decFormat.format(reward) + "원)";
    }
}
