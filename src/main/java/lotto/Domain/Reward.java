package lotto.Domain;


import java.util.Arrays;

public enum Reward {
    BLANK(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int count;
    private final int reward;

    Reward(int count, int reward) {
        this.count = count;
        this.reward = reward;
    }

    public static Reward getRanKing(int hit, boolean bonus) {
        if (hit == THIRD.count && bonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(ranking -> ranking.count == hit)
                .findAny()
                .orElse(BLANK);
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }
}