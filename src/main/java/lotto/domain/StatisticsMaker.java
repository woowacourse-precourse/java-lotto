package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Constants;

public class StatisticsMaker {

    public StatisticsMaker() {
    }

    public double makeYield(List<Lotto> lottos, Map<Integer, Integer> ranking) {
        double lottoQuantity = lottos.size();
        double totalIncome = 0;

        List<Integer> prizeList = List.of(0, 2000000000, 30000000, 1500000, 50000, 5000);
        for (int rank = 1; rank <= 5; rank++) {
            totalIncome += ranking.get(rank) * prizeList.get(rank);
        }

        return Math.round((totalIncome / (lottoQuantity * Constants.LOTTO_PRICE.getValue()) * 100) * 10) / 10.0;
    }

    public Map<Integer,Integer> makeRankings(WinningLotto winningLotto, List<Lotto> lottos) {
        Map<Integer, Integer> ranking = initRankings();

        List<Integer> winningNumbers = winningLotto.getNumbers();
        int winningBonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lottos) {

            int count = calculateWinningNumbers(winningNumbers, lotto);
            boolean bonusCount = calculateBonusNumber(winningBonusNumber, lotto);

            updateRanking(count, bonusCount, ranking);
        }

        return ranking;
    }


    private boolean calculateBonusNumber(int winningBonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(winningBonusNumber);
    }

    private int calculateWinningNumbers(List<Integer> winningNumbers, Lotto lotto) {
         return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private Map<Integer,Integer> initRankings() {
        Map<Integer, Integer> ranking = new HashMap<>();

        for (int rank = Constants.LOTTO_RANKING_RANGE.getValue(); rank > 0; rank--) {
            ranking.put(rank, 0);
        }

        return ranking;
    }

    private void updateRanking(int count, boolean bonusCount, Map<Integer,Integer> ranking) {
        if (count == 6) {
            int currentCount = ranking.get(1);
            ranking.put(1, ++currentCount);
            return;
        }
        if (count == 5 && bonusCount){
            int currentCount = ranking.get(2);
            ranking.put(2, ++currentCount);
            return;
        }
        if (count == 5) {
            int currentCount = ranking.get(3);
            ranking.put(3, ++currentCount);
            return;
        }
        if (count == 4) {
            int currentCount = ranking.get(4);
            ranking.put(4, ++currentCount);
            return;
        }
        if (count == 3) {
            int currentCount = ranking.get(5);
            ranking.put(5, ++currentCount);
        }
    }
}
