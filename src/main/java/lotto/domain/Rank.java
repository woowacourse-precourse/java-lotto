package lotto.domain;

import lotto.Statistic;

import java.util.HashMap;
import java.util.Map;

public class Rank {
    private final Map<Statistic, Integer> ranks;

    public Rank() {
        ranks = new HashMap<>();
        ranks.put(Statistic.SAME_SIX, 0);
        ranks.put(Statistic.SAME_FIVE_BONUS, 0);
        ranks.put(Statistic.SAME_FIVE, 0);
        ranks.put(Statistic.SAME_FOUR, 0);
        ranks.put(Statistic.SAME_THREE, 0);
    }

    public Map<Statistic, Integer> getRanks() {
        return ranks;
    }

    public void setCount(int cnt, boolean bonus) {
        if(cnt == Statistic.SAME_SIX.getValue()) {
            ranks.replace(Statistic.SAME_SIX, ranks.get(Statistic.SAME_SIX)+ 1);
        }else if(cnt == Statistic.SAME_FIVE.getValue() && bonus) {
            ranks.replace(Statistic.SAME_FIVE_BONUS, ranks.get(Statistic.SAME_FIVE_BONUS) + 1);
        }else if(cnt == Statistic.SAME_FIVE.getValue()) {
            ranks.replace(Statistic.SAME_FIVE, ranks.get(Statistic.SAME_FIVE) + 1);
        }else if(cnt == Statistic.SAME_FOUR.getValue()) {
            ranks.replace(Statistic.SAME_FOUR, ranks.get(Statistic.SAME_FOUR) + 1);
        }else if(cnt == Statistic.SAME_THREE.getValue()) {
            ranks.replace(Statistic.SAME_THREE, ranks.get(Statistic.SAME_THREE) + 1);
        }
    }
}
