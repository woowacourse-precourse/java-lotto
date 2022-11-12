package lotto.domain;

import java.util.Map;

public class PrizeCount {

    private Map<Prize, Integer> items = Map.of(
            Prize.FIRST, 0,
            Prize.SECOND, 0,
            Prize.THIRD, 0,
            Prize.FOURTH, 0,
            Prize.FIFTH, 0
    );

    public void addPrizeCount(Prize prize) {
        items.put(prize, items.get(prize) + 1);
    }

    public int getTotalPrizeMoney(Prize prize) {
        return prize.getMoney() * items.get(prize);
    }

}
