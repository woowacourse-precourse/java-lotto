package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoJudge {

    private static int SECOND_THIRD_VALUE = 5;
    private static Map<Integer, LottoRank> ranks = Map.of(
        3, LottoRank.FIFTH,
        4, LottoRank.FOURTH,
        0, LottoRank.THIRD,
        1, LottoRank.SECOND,
        6, LottoRank.FIRST
    );

    private static Map<LottoRank, Double> profit = Map.of(
        LottoRank.FIFTH, 5000.0,
        LottoRank.FOURTH, 50000.0,
        LottoRank.THIRD, 1500000.0,
        LottoRank.SECOND, 30000000.0,
        LottoRank.FIRST, 2000000000.0
    );

    public String profitLotto(List<LottoRank> rankCount, int money) {
        double totalProfit = 0.0;
        String profitPercent;

        for (LottoRank lottoRank : LottoRank.values()) {
            totalProfit += Collections.frequency(rankCount, lottoRank) * profit.get(lottoRank);
        }

        profitPercent = String.format("%.1f", (totalProfit / money) * 100.0);
        return profitPercent;
    }

    public Map<LottoRank, Integer> judgeLotto(ArrayList<List<Integer>> lotteries,
        List<Integer> winningNumbers,
        int bonusNumber) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        ArrayList<List<Integer>> lottoResults = countLotto(lotteries, winningNumbers, bonusNumber);
        LottoRank lottoRank;

        for (int i = 0; i < lottoResults.size(); i++) {

            if (lottoResults.get(i).get(0) == SECOND_THIRD_VALUE) {
                lottoRank = ranks.get(lottoResults.get(i).get(1));
            } else if (!ranks.containsKey(lottoResults.get(i).get(0))) {
                continue;
            } else {
                lottoRank = ranks.get(lottoResults.get(i).get(0));
            }
            rankCount.put(lottoRank, rankCount.getOrDefault(lottoRank, 0) + 1);
        }
        return rankCount;
    }

    public ArrayList<List<Integer>> countLotto(ArrayList<List<Integer>> lotteries,
        List<Integer> winningNumbers,
        int bonusNumber) {
        ArrayList<List<Integer>> lottoResults = new ArrayList<>();

        for (int i = 0; i < lotteries.size(); i++) {
            int lottoCount = lottoAlgorithm(lotteries.get(i), winningNumbers);

            lottoResults.add(List.of(lottoCount, countBonusNumber(lotteries.get(i), bonusNumber)));
        }
        return lottoResults;
    }

    public int countBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    public int lottoAlgorithm(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int lottoCount = 0;

        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (lottoNumbers.contains(winningNumbers.get(i))) {
                lottoCount += 1;
            }
        }

        return lottoCount;
    }
}
