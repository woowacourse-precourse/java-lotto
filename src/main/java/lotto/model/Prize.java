package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ;

    private final int match;

    private final boolean bonus;

    private final int money;

    static final Map<Integer, Map<Boolean, Prize>> matchPrize = new HashMap<>();

    static {
        for (Prize prize : Prize.values()) {
            int match = prize.getMatch();
            Map<Boolean, Prize> booleanPrize = matchPrize.getOrDefault(match, new HashMap<>());
            booleanPrize.put(prize.isBonus(), prize);
            matchPrize.put(match, booleanPrize);
        }
    }

    Prize(int match, boolean bonus, int money) {
        this.match = match;
        this.bonus = bonus;
        this.money = money;
    }

    public static Prize search(int match, boolean bonus) {
        Map<Boolean, Prize> booleanPrize = matchPrize.get(match);

        if (booleanPrize == null || booleanPrize.size() == 0) {
            return Prize.NONE;
        }

        Prize prize = booleanPrize.get(bonus);

        if (prize == null) {
            return Prize.NONE;
        }

        return prize;
    }

    public int getMoney() {
        return money;
    }

    public int getMatch() {
        return match;
    }

    public boolean isBonus() {
        return bonus;
    }
}
