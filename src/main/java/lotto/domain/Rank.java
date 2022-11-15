package lotto.domain;

import lotto.util.Statistic;

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
            updateRank(Statistic.SAME_SIX);
        }else if(cnt == Statistic.SAME_FIVE.getValue() && bonus) {
            updateRank(Statistic.SAME_FIVE_BONUS);
        }else if(cnt == Statistic.SAME_FIVE.getValue()) {
            updateRank(Statistic.SAME_FIVE);
        }else if(cnt == Statistic.SAME_FOUR.getValue()) {
            updateRank(Statistic.SAME_FOUR);
        }else if(cnt == Statistic.SAME_THREE.getValue()) {
            updateRank(Statistic.SAME_THREE);
        }
    }

    public void updateRank(Statistic number) {
        ranks.replace(number, ranks.get(number) + 1);
    }

    public long getTotalAmount() {
        return ((long) Statistic.SIX_PRICE.getValue() * ranks.get(Statistic.SAME_SIX))
                + ((long) Statistic.FIVE_BONUS_PRICE.getValue() * ranks.get(Statistic.SAME_FIVE_BONUS))
                + ((long) Statistic.FIVE_PRICE.getValue() * ranks.get(Statistic.SAME_FIVE))
                + ((long) Statistic.FOUR_PRICE.getValue() * ranks.get(Statistic.SAME_FOUR))
                + ((long) Statistic.THREE_PRICE.getValue() * ranks.get(Statistic.SAME_THREE));
    }

    public double getYield(Buyer buyer) {
        return (getTotalAmount() / (double)buyer.getMoney()) * 100;
    }
}
