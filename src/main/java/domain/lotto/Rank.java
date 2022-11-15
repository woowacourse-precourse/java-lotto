package domain.lotto;

import java.util.Arrays;

public enum Rank {
    NONE("없음", 0L, 0),
    FIFTIETH("3개 일치", 5000L, 3),
    FOURTH("4개 일치", 50000L, 4),
    THIRD("5개 일치", 1500000L, 5),
    SECOND("5개 일치, 보너스 볼 일치", 30000000L, 5),
    FIRST("6개 일치", 2000000000L, 6);

    private final String output;
    private final Long reward;
    private final int condition;
    private int count;

    Rank(String output, Long reward, int condition) {
        this.output = output;
        this.reward = reward;
        this.condition = condition;
        this.count = 0;
    }

    public static Rank findRank(int NumberOfMatch, boolean isBonusNumberContain) {

        if (NumberOfMatch == 5 && isBonusNumberContain) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(e -> e.condition == NumberOfMatch)
                .findAny()
                .orElse(NONE);
    }

    public Long getReward() {
        return reward;
    }

    public String getOutput() {
        return output;
    }

    public int getCount() {
        return count;
    }

    public void plusCount() {
        this.count++;
    }
}
