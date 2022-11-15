package Controller;

import Service.JudgeWinningOfLotto;
import Service.ProfitRateCalculator;
import lotto.LottoRankingResults;
import lotto.Ranking;

import java.util.List;
import java.util.Map;

public class ServiceController {
    private static final int RANKIG_SECONDORTHRID = 5;
    private static final int MINIMUMFORRANKING = 3;
    private static Map<Ranking, Integer> rankingResults;
    private static double profitRate;

    private JudgeWinningOfLotto judgeWinningOfLotto = new JudgeWinningOfLotto();
    private LottoRankingResults lottoRankingResults = new LottoRankingResults();
    private ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();

    public ServiceController(int purchaseAmount, List<List<Integer>> randomLottos, List<Integer> winningLotto, int bonusNumber) {
        for (List<Integer> randomLotto : randomLottos) {
            boolean bonusStatus = false;
            int match = judgeWinningOfLotto.compareMatchNumbers(randomLotto, winningLotto);

            if (match == RANKIG_SECONDORTHRID) {
                bonusStatus = judgeWinningOfLotto.isContainBounsNumber(randomLotto, bonusNumber);
            }
            if (match >= MINIMUMFORRANKING) {
                Ranking ranking = judgeWinningOfLotto.findLottoRanking(match, bonusStatus);
                lottoRankingResults.recordTheRanking(ranking);
            }
        }
        this.rankingResults = lottoRankingResults.getRankingResults();
        this.profitRate = profitRateCalculator.calculator(purchaseAmount, rankingResults);
    }

    public Map<Ranking, Integer> getRankingResults() {
        return rankingResults;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
