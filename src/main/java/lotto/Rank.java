package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000),
    LOSE(0 ,0 ,0);


    private final Integer lotto;
    private final Integer bonus;
    private final Integer money;

    private Rank(Integer lotto, Integer bonus, Integer money) {
        this.lotto = lotto;
        this.bonus = bonus;
        this.money = money;
    }

    public static Rank generateRank(Integer lotto, Integer bonus) {
        return Arrays.stream(values())
                .filter(value -> value.lotto.equals(lotto) && value.bonus.equals(bonus))
                .findAny()
                .orElse(LOSE);
    }

    public Integer getMoney() {
        return money;
    }
}
