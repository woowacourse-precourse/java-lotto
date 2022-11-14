package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.enums.LottoRank;

public class LottoJudge {

    private String lottoProfit;
    private List<LottoRank> rankCount;

    public String getLottoProfit() {
        return lottoProfit;
    }

    public List<LottoRank> getRankCount() {
        return rankCount;
    }

    public String profitLotto(List<LottoRank> rankCount, int money) {
        double totalProfit = 0.0;
        String profitPercent;

        for (LottoRank lottoRank : LottoRank.values()) {
            int winningMoney = Integer.parseInt(LottoRank.getPrice(lottoRank).replace(",", ""));
            totalProfit += Collections.frequency(rankCount, lottoRank) * winningMoney;
        }

        profitPercent = String.format("%.1f", (totalProfit / money) * 100.0);
        this.lottoProfit = profitPercent;
        return profitPercent;
    }

    public List<LottoRank> judgeLotto(ArrayList<List<Integer>> lotteries,
        List<Integer> winningNumbers,
        int bonusNumber) {
        List<LottoRank> rankCount = new ArrayList<>();
        ArrayList<List<Integer>> lottoResults = countLotto(lotteries, winningNumbers, bonusNumber);
        LottoRank lottoRank;

        for (List<Integer> lottoResult : lottoResults) {
            lottoRank = LottoRank.valueOf(lottoResult.get(0), lottoResult.get(1));
            rankCount.add(lottoRank);
        }
        this.rankCount = rankCount;
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
