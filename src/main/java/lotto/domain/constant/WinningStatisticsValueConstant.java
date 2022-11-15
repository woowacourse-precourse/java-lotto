package lotto.domain.constant;

public enum WinningStatisticsValueConstant {

    MATCHED_THREE(3, 5_000L, 5),
    MATCHED_FOUR(4, 50_000L, 4),
    MATCHED_FIVE(5, 1_500_000L, 3),
    MATCHED_FIVE_AND_BONUS_BALL(100, 30_000_000L, 2),
    MATCHED_SIX(6, 2_000_000_000L, 1),
    NOTHING(0, 0L, 0);

    final Integer number;
    final Long reward;
    final Integer ranking;

    WinningStatisticsValueConstant(Integer number, Long reward, Integer ranking) {
        this.number = number;
        this.reward = reward;
        this.ranking = ranking;
    }

    public Integer getNumber() {
        return number;
    }

    public Long getReward() {
        return reward;
    }

    public Integer getRanking() {
        return ranking;
    }

}
