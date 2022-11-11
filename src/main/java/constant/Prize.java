package constant;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false,1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0),
    ;

    private final int match;

    private final boolean bonus;

    private final int money;

    private static class SearchTool {
        static Map<Integer, Map<Boolean, Prize>> matchPrize = new HashMap<>();
    }

    Prize(int match, boolean bonus, int money) {
        this.match = match;
        this.bonus = bonus;
        this.money = money;
        updateSearchTool(match, bonus, this);
    }

    private void updateSearchTool(int match, boolean bonus, Prize prize) {
        Map<Boolean, Prize> booleanPrize = SearchTool.matchPrize.getOrDefault(match, new HashMap<>());
        booleanPrize.put(bonus, prize);
        SearchTool.matchPrize.put(match, booleanPrize);
    }

    public static Prize search(int match, boolean bonus) {
        Map<Boolean, Prize> booleanPrize = SearchTool.matchPrize.get(match);

        if (booleanPrize == null || booleanPrize.size() == 0) {
            return NONE;
        }

        Prize prize = booleanPrize.get(bonus);

        if (prize == null) {
            return NONE;
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

    @Override
    public String toString() {
        return Integer.toString(money);
    }
}
