package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.Prize;

public class PrizeCount {
    private Map<Prize, Integer> prizes;

    public PrizeCount() {
        prizes = new EnumMap<Prize, Integer>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizes.put(prize, 0);
        }
    }

    public void addPrize(final Prize prize) {
        prizes.put(prize, prizes.get(prize) + 1);
    }

    public int getPrize(final Prize prize) {
        return prizes.get(prize);
    }
}
