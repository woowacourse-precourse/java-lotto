package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.enums.LottoConstants;
import lotto.enums.Prize;
import lotto.enums.Ranking;

public class StatisticsMaker {

    private static final List<Ranking> rankQualifications = Stream.of(Ranking.values()).collect(Collectors.toList());
    private static final List<Integer> prizeList = Stream.of(Prize.values()).map(Prize::getValue).collect(Collectors.toList());


    public double makeYield(List<Lotto> lottos, Map<Integer, Integer> ranking) {
        double lottoQuantity = lottos.size();
        double totalIncome = 0;

        for (int rank = 1; rank <= 5; rank++) {
            totalIncome += ranking.get(rank) * prizeList.get(rank);
        }

        return Math.round((totalIncome / (lottoQuantity * LottoConstants.LOTTO_PRICE.getValue()) * 100) * 10) / 10.0;
    }

    public Map<Integer, Integer> makeRankings(WinningLotto winningLotto, List<Lotto> lottos) {
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

    public Statistics makeStatistics(Map<Integer, Integer> ranking, double yield) {
        return new Statistics(ranking, yield);
    }

    private boolean calculateBonusNumber(int winningBonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(winningBonusNumber);
    }

    private int calculateWinningNumbers(List<Integer> winningNumbers, Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private Map<Integer, Integer> initRankings() {
        Map<Integer, Integer> ranking = new HashMap<>();

        for (int rank = LottoConstants.LOTTO_RANKING_RANGE.getValue(); rank > 0; rank--) {
            ranking.put(rank, 0);
        }

        return ranking;
    }

    private void updateRanking(int count, boolean bonusCount, Map<Integer, Integer> ranking) {
        for (Ranking rankQualification : rankQualifications) {
            if (count == rankQualification.getNumberMatchCount() && bonusCount == rankQualification.getBonusNumberMatchCount()) {
                ranking.compute(rankQualification.getRank(), (key, value) -> value + 1);
                return;
            }
        }

    }
}
