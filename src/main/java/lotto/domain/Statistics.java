package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private Map<Integer, Integer> rankings;
    private double yield;

    public Statistics() {
    }

    public Map<Integer, Integer> getRankings() {
        return rankings;
    }

    public double getYield() {
        return yield;
    }

    public void makeStatistics(WinningLotto winningLotto, List<Lotto> lottos) {
        makeRankings(winningLotto, lottos);
        makeYield(lottos);
    }

    private void makeYield(List<Lotto> lottos) {
        double lottoQuantity = lottos.size();
        double totalIncome = 0;

        List<Integer> prizeList = List.of(0, 2000000000, 30000000, 1500000, 50000, 5000);
        for (int i = 1; i <= 5; i++) {
            totalIncome += rankings.get(i) * prizeList.get(i);
        }

        yield = Math.round((totalIncome / (lottoQuantity * 1000) * 100) * 10) / 10.0;
    }

    private void makeRankings(WinningLotto winningLotto, List<Lotto> lottos) {
        initRankings();

        List<Integer> winningNumbers = winningLotto.getNumbers();
        int winningBonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lottos) {

            int count = calculateWinningNumbers(winningNumbers, lotto);
            boolean bonusCount = calculateBonusNumber(winningBonusNumber, lotto);

            updateRanking(count, bonusCount);
        }
    }


    private boolean calculateBonusNumber(int winningBonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(winningBonusNumber);
    }

    private int calculateWinningNumbers(List<Integer> winningNumbers, Lotto lotto) {
         return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void initRankings() {
        rankings = new HashMap<>();
        for (int i = 5; i > 0; i--) {
            rankings.put(i, 0);
        }
    }
    private void updateRanking(int count, boolean bonusCount) {
        if (count == 6) {
            int currentCount = rankings.get(1);
            rankings.put(1, ++currentCount);
            return;
        }
        if (count == 5 && bonusCount){
            int currentCount = rankings.get(2);
            rankings.put(2, ++currentCount);
            return;
        }
        if (count == 5) {
            int currentCount = rankings.get(3);
            rankings.put(3, ++currentCount);
            return;
        }
        if (count == 4) {
            int currentCount = rankings.get(4);
            rankings.put(4, ++currentCount);
            return;
        }
        if (count == 3) {
            int currentCount = rankings.get(5);
            rankings.put(5, ++currentCount);
        }
    }
}
