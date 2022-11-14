package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WonAnalysis {

    public WonAnalysis() {

    }

    public List<Rank> Result(List<Integer> lotto, List<List<Integer>> buyLottos, int bonusNumber) {

        List<Rank> lottoResult = new ArrayList<>();

        for (List<Integer> numbers : buyLottos) {

            int count = cntMatch(lotto, numbers);

            boolean hasbonusNumber = hasBonus(count, numbers, bonusNumber);

            lottoResult.add(lottoRank(count, hasbonusNumber));
        }

        return lottoResult;
    }

    public int cntMatch(List<Integer> lotto, List<Integer> buyLotto) {
        int count = 0;

        for (int number : buyLotto) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasBonus(int matchNumber, List<Integer> buyLotto, int bonusNumber) {
        if (matchNumber == Rank.SECOND.getRANK_NUMBER()) {
            if (buyLotto.contains(bonusNumber)) {
                return true;
            }
        }
        return false;
    }

    public Rank lottoRank(int count, boolean hasbonusNumber) {
        for (Rank rank : Rank.values()) {
            if (count == rank.getRANK_NUMBER() && hasbonusNumber == rank.getBONUS_NUMBER()) {
                return rank;
            }
        }
        return Rank.BLANK;
    }

    public int totalProfit(List<Rank> lottoResult) {
        int profit = 0;

        for (Rank rank : lottoResult) {
            profit += rank.getPROFIT();
        }
        return profit;
    }

    public String totalPercent(List<Rank> lottoResult) {
        long profit = totalProfit(lottoResult);
        int inputMoney = lottoResult.size() * 1000;

        double result = (profit * 100) / (double) inputMoney;

        String percent = String.format("%.1f", result);

        return percent;
    }
}
