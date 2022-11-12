package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class PrizeCount {

    private final Map<Prize, Integer> items = new HashMap<>() {
        {
            put(Prize.FIRST, 0);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.FIFTH, 0);
        }
    };

    public void addPrizeCount(Prize prize) {
        items.put(prize, items.get(prize) + 1);
    }

    public int getPrizeCount(Prize prize) {
        return items.get(prize);
    }

    public int getTotalPrizeMoney(Prize prize) {
        return prize.getMoney() * items.get(prize);
    }

}
