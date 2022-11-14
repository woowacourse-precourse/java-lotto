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
        printPrizeStatistics();
        printEarnings();
    }

    private void printPrizeStatistics() {
        Iterator<Prize> prizeIterator = prizes.keySet().iterator();
        while (prizeIterator.hasNext()) {
            Prize eachPrize = prizeIterator.next();
            Integer eachPrizeCount = prizes.get(eachPrize);
            eachPrize.printPrizeStatistics(eachPrizeCount);
        }
    }

    private void printEarnings() {
        Iterator<Prize> prizeIterator = prizes.keySet().iterator();
        int ticket = 0;
        int earning = 0;
        while (prizeIterator.hasNext()) {
            Prize eachPrize = prizeIterator.next();
            Integer eachPrizeCount = prizes.get(eachPrize);
            ticket += eachPrizeCount;
            earning += eachPrize.calculateEachEarning(eachPrizeCount);
        }
        String earningRate = String.format("%.1f", earning / (ticket * 10.0));
        System.out.println("총 수익률은 "+earningRate+"%입니다.");
    }
}
