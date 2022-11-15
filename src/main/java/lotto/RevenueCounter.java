package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RevenueCounter {

    private Map<WinningCase, Integer> createMatchCase() {
        Map<WinningCase, Integer> matchCase = new HashMap<>();
        matchCase.put(WinningCase.THREE, 5000);
        matchCase.put(WinningCase.FOUR, 50000);
        matchCase.put(WinningCase.FIVE,1500000 );
        matchCase.put(WinningCase.FIVE_BONUS,30000000 );
        matchCase.put(WinningCase.SIX, 2000000000);

        return matchCase;
    }

    private Map<WinningCase, List<Integer>> createMatchRevenue() {
        Map<WinningCase, List<Integer>> matchRevenue = new HashMap<>();
        matchRevenue.put(WinningCase.THREE, List.of(0,0));
        matchRevenue.put(WinningCase.FOUR, List.of(0,0));
        matchRevenue.put(WinningCase.FIVE,List.of(0,0) );
        matchRevenue.put(WinningCase.FIVE_BONUS,List.of(0,0) );
        matchRevenue.put(WinningCase.SIX, List.of(0,0));

        return matchRevenue;
    }

    public Map<WinningCase, List<Integer>> convertToMoney(List<List<Integer>> lottoMatch) {
        Map<WinningCase, Integer> matchCase = createMatchCase();
        Map<WinningCase, List<Integer>> matchRevenue = createMatchRevenue();


        for (List<Integer> match : lottoMatch) {
            if (match.get(0) == 3) {
                matchRevenue.put(WinningCase.THREE, List.of(
                        matchRevenue.get(WinningCase.THREE).get(0) + 1,
                        matchRevenue.get(WinningCase.THREE).get(1) + matchCase.get(WinningCase.THREE)));
            }
            if (match.get(0) == 4) {
                matchRevenue.put(WinningCase.FOUR, List.of(
                        matchRevenue.get(WinningCase.FOUR).get(0) + 1,
                        matchRevenue.get(WinningCase.FOUR).get(1) + matchCase.get(WinningCase.FOUR)));
            }
            if (match.get(0) == 5 && match.get(1) ==0) {
                matchRevenue.put(WinningCase.FIVE, List.of(
                        matchRevenue.get(WinningCase.FIVE).get(0) + 1,
                        matchRevenue.get(WinningCase.FIVE).get(1) + matchCase.get(WinningCase.FIVE)));
            }
            if (match.get(0) == 5 && match.get(1) ==1) {
                matchRevenue.put(WinningCase.FIVE_BONUS, List.of(
                        matchRevenue.get(WinningCase.FIVE_BONUS).get(0) + 1,
                        matchRevenue.get(WinningCase.FIVE_BONUS).get(1) + matchCase.get(WinningCase.FIVE_BONUS)));
            }
            if (match.get(0) == 6) {
                matchRevenue.put(WinningCase.SIX, List.of(
                        matchRevenue.get(WinningCase.SIX).get(0) + 1,
                        matchRevenue.get(WinningCase.SIX).get(1) + matchCase.get(WinningCase.SIX)));
            }




        }
        return matchRevenue;
    }


    public double revenueRateCounter(List<List<Integer>> lottoMatch, int purchaseAmount) {
        double totalRevenue = 0;
        Map<WinningCase, List<Integer>> revenue = convertToMoney(lottoMatch);
        for (WinningCase winningCase : revenue.keySet()) {
            totalRevenue += revenue.get(winningCase).get(1);
        }

        double revenueRate = totalRevenue / purchaseAmount;
        return revenueRate;

    }

}
