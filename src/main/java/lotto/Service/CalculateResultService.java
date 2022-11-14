package lotto.Service;

import lotto.Model.Lotto;
import lotto.Model.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CalculateResultService {
    Map<Rank, Integer> lottoCount = new TreeMap<>();

    public Map<Rank, Integer> compare(List<Integer> winningNumberList, Integer bonusNumber, List<Lotto> lottoSheetsList) {
        for (Lotto lottoSheet : lottoSheetsList) {
            List<Integer> lottoSheetNumber = lottoSheet.getNumbers();
            long winningCount = lottoSheetNumber.stream()
                    .filter(winningNumberList::contains)
                    .count();
            int bonus = isBonus(winningCount, bonusNumber, lottoSheetNumber);

            add(Rank.getRank((int) winningCount, bonus));
        }
        return lottoCount;
    }

    public int isBonus(long winningCount, Integer bonusNumber, List<Integer> lottoNumber) {
        if (winningCount != 5) {
            return 0;
        }
        if (lottoNumber.contains(bonusNumber)) {
            return 1;
        } else {
            return 0;
        }
    }

    public void add(Rank rank) {
        lottoCount.merge(rank, 1, (value, putValue) -> value + 1);
    }

    public double getYield(Integer lottoSheetsAmount, Map<Rank, Integer> lottoResult) {
        Integer profit = calculateProfit(lottoResult);
        double yield = ((double) profit / (double) lottoSheetsAmount) * 100;
        return Math.round(yield * 100) / 100.0;
    }

    public Integer calculateProfit(Map<Rank, Integer> lottoResult) {
        Integer profit = 0;
        for (Rank rank : Rank.values()) {
            if (lottoResult.get(rank) == null) {
                continue;
            }
            profit += lottoResult.get(rank) * rank.getPrizeMoney();
        }
        return profit;
    }
}
