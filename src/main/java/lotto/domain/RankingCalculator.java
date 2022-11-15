package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class RankingCalculator {

    public RankingCalculator() {
    }

    public static List<Ranking> getLottoRanking(LottoGenerator lottoGenerator, LottoResult lottoResult) {
        List<Ranking> rankings = new ArrayList<>();
        List<Lotto> lottos = lottoGenerator.getLottos();

        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            Ranking ranking = calculateRanking(lotto, lottoResult);
            rankings.add(ranking);
        }

        return rankings;
    }

    private static Ranking calculateRanking(Lotto lotto, LottoResult lottoResult) {
        List<Integer> winningNumbers = lottoResult.getWinningNumbers();
        int bonusNumber = lottoResult.getBonusNumber();

        int numberOfSameNumbers = countSameNumbers(lotto, winningNumbers);
        boolean existBonusNumber = lotto.getNumbers().contains(bonusNumber);

        return Ranking.getRanking(numberOfSameNumbers, existBonusNumber);
    }

    private static int countSameNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;

        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count += 1;
            }
        }

        return count;
    }
}
