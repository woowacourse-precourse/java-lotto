package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PrizeOfUser {
    private final Map<Prize, Integer> prizes;

    public PrizeOfUser() {
        this.prizes = new HashMap<>();
        prizes.put(Prize.NONE, 0);
        prizes.put(Prize.FIFTH, 0);
        prizes.put(Prize.FOURTH, 0);
        prizes.put(Prize.THIRD, 0);
        prizes.put(Prize.SECOND, 0);
        prizes.put(Prize.FIRST, 0);
    }

    public void addPrize(Prize eachLottoPrize) {
        Integer beforeCount = prizes.get(eachLottoPrize);
        prizes.put(eachLottoPrize, beforeCount + 1);
    }

    public void printPrize() {
        Iterator<Prize> prizeIterator = prizes.keySet().iterator();
        while (prizeIterator.hasNext()) {
            Prize eachPrize = prizeIterator.next();
            Integer eachPrizeCount = prizes.get(eachPrize);
            eachPrize.printPrizeStatistics(eachPrizeCount);
        }
    }
}
