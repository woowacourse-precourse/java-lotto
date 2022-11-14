package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class PrizeCount {

    private final Map<Prize, Integer> items = new HashMap<>();

    public PrizeCount() {
        for (Prize prize : Prize.values()) {
            items.put(prize, 0);
        }
    }

    public void addPrizeCount(Prize prize) {
        items.put(prize, items.get(prize) + 1);
    }

    public int getTotalPrizeMoney(Prize prize) {
        return prize.getMoney() * items.get(prize);
    }

}
