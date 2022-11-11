package lotto;

import java.util.List;
import java.util.TreeMap;

public class Analyse {
    private static TreeMap<Prize, Integer> stats = new TreeMap<>();

    public Analyse() {

    }

    private static void setStats() {
        stats.put(Prize.FIRST, 0);
        stats.put(Prize.SECOND, 0);
        stats.put(Prize.THIRD, 0);
        stats.put(Prize.FOURTH, 0);
        stats.put(Prize.FIFTH, 0);
        stats.put(Prize.ZERO, 0);
    }

    public static void clearStats() {
        stats.clear();
    }

    public static TreeMap<Prize, Integer> getStats() {
        return stats;
    }

    public static void analyseLotto(List<Lotto> lottos, List<Integer> prize) {
        setStats();

        for(Lotto lotto : lottos) {
            countSameNum(lotto, prize);
        }

        stats.remove(Prize.ZERO);
    }

    private static void countSameNum(Lotto lotto, List<Integer> prize) {
        int count = 0;
        List<Integer> lottoNum = lotto.getNumbers();

        for(int i=0; i< prize.size()-1; i++) {
            if(lottoNum.contains(prize.get(i))) {
                count++;
            }
        }

        if(count==5 && lottoNum.contains(prize.get(6))) {
            stats.replace(Prize.SECOND, stats.get(Prize.SECOND)+1);
            return;
        }

        Prize prizeName = Prize.findPrize(count);
        stats.replace(prizeName, stats.get(prizeName)+1);
    }

    //로또 수익률
    public static double rateLotto(int budget) {
        long total = getTotalPrizeWon();

        return Math.round(((double)total/budget)*1000)/10.0;
    }

    private static long getTotalPrizeWon() {
        long prizeWon = 0L;

        for(Prize p : stats.keySet()) {
            prizeWon += p.getPrizeWon() * stats.get(p);
        }

        return prizeWon;
    }

}
