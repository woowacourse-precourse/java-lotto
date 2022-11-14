package lotto.userinterface;

import java.util.HashMap;
import java.util.Map;

public enum Hit {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 15_000_000),
    FIVE_BONUS(5, 30_000_000),
    SIZE(6, 2_000_000_000);

    private final static Map<Integer, Hit> map;
    private Integer count;
    private Integer prize;

    static {
        map = new HashMap<>();
        for (Hit hit : Hit.values()) {
            map.put(hit.count, hit);
        }
    }

    Hit(Integer count, Integer prize) {
        this.count = count;
        this.prize = prize;
    }

    public Integer getPrize() {
        return prize;
    }

    public static Hit getByCount(Integer count, Boolean hitBonus) {
        Hit hit = map.get(count);

        if (hitBonus && hit.count == 5) {
            return FIVE_BONUS;
        }

        return hit;
    }
}
