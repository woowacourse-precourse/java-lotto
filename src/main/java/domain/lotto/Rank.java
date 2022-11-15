package domain.lotto;

import java.util.Arrays;

public enum Rank {
    NONE("없음", 0L, 0, false),
    FIFTH("3개 일치", 5000L, 3, false),
    FOURTH("4개 일치", 50000L, 4, false),
    THIRD("5개 일치", 1500000L, 5, false),
    SECOND("5개 일치, 보너스 볼 일치", 30000000L, 5, true),
    FIRST("6개 일치", 2000000000L, 6, false);

    private final String output;
    private final Long reward;
    private final int condition;
    private int count;
    private boolean isContainBonusNumber;

    Rank(String output, Long reward, int condition, boolean isContainBonusNumber) {
        this.output = output;
        this.reward = reward;
        this.condition = condition;
        this.count = 0;
        this.isContainBonusNumber = isContainBonusNumber;
    }

    public static Rank findRank(int NumberOfMatch, boolean isBonusNumberContain) {

        return Arrays.stream(Rank.values())
                .filter(e -> e.condition == NumberOfMatch)
                .filter(e -> e.isContainBonusNumber == isBonusNumberContain)
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
