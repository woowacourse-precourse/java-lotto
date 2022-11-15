package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WonAnalysis {

    public WonAnalysis() {

    }

    public List<Rank> Result(List<Integer> lotto, List<List<Integer>> userLotto) {
        List<Rank> lottoResult = new ArrayList<>();

        for (List<Integer> numbers : userLotto) {
            int count = cntMatchNumber(lotto, numbers);
            boolean bonusNumber = checkBonus(count, numbers);

            lottoResult.add(rankLotto(count, bonusNumber));
        }

        return lottoResult;
    }

    public int cntMatchNumber(List<Integer> lotto, List<Integer> userLotto) {
        int count = 0;

        for (int number : userLotto) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBonus(int matchNumber, List<Integer> userLotto) {
        if (matchNumber == Rank.SECOND.getRANK_NUMBER()) {
            if (userLotto.contains(BonusNumber.BONUS_NUMBER.getNumber())) {
                return true;
            }
        }
        return false;
    }

    public Rank rankLotto(int count, boolean bonusNumber) {
        for (Rank rank : Rank.values()) {

            if (count == rank.getRANK_NUMBER() && bonusNumber == rank.getBONUS_NUMBER()) {
                return rank;
            }
        }

        return Rank.BLANK;
    }

    public int getLottoAmount(int money) {
        int amount = money / 1000;

        return amount;
    }

    public int Profit(List<Rank> lottoResult) {
        int profit = 0;

        for (Rank rank : lottoResult) {
            profit += rank.getPROFIT();
        }

        return profit;
    }

    public String Percent(List<Rank> lottoResult) {
        long profit = Profit(lottoResult);
        int inputMoney = lottoResult.size() * 1000;

        double result = (profit * 100) / (double) inputMoney;

        String percent = String.format("%.1f", result);

        return percent;
    }
}
