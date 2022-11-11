package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoJudge {

    public String profitLotto(List<LottoRank> rankCount, int money) {
        double totalProfit = 0.0;
        String profitPercent;

        for (LottoRank lottoRank : LottoRank.values()) {
            totalProfit += Collections.frequency(rankCount, lottoRank) * LottoRank.getPrice(lottoRank);
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

        for (List<Integer> lottoResult : lottoResults) {
            lottoRank = LottoRank.valueOf(lottoResult.get(0), lottoResult.get(1));
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
