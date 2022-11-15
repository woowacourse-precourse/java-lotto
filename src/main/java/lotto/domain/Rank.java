package lotto.domain;

public enum Rank {
    FIRST(2000000000, 6, false),
    SECOND_BONUS(30000000, 5, true),
    SECOND(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    SIX(0, 0, false);

    private final int reward;
    private final int count;
    private final boolean bonus;

    Rank(int reward, final int count, boolean bonus) {
        this.reward = reward;
        this.count = count;
        this.bonus = bonus;
    }
}
