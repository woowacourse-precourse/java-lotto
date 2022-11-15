package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LottoService {
    private static final double DECIMAL_PLACE = 100.0f;
    private List<Lotto> lotteries = new ArrayList<>();
    private List<Integer> winnings = new ArrayList<>();
    private int bonus;
    private double buyMoney;
    private String profitRate;
    private double totalProfit = 0;

    public LottoService() {

    }

    public void addLotteries(int buyNumber) {
        while (buyNumber != 0) {
            List<Integer> randomNumbers = Lotto.createRandomNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lotteries.add(lotto);
            buyNumber--;
        }
    }

    public void printLotteries() {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
    }

    private int checkWinningNumber(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(number -> winnings.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(number -> number.equals(bonus));
    }

    private String getLottoRate() {
        DecimalFormat RateFormat = new DecimalFormat("###,###.0");
        return RateFormat.format((totalProfit / buyMoney) * DECIMAL_PLACE);
    }

    private void addProfit(int match, boolean flag) {
        if (match == Rank.THIRD_RANK.getMatch() && flag) {
            totalProfit += Rank.SECOND_RANK.getPrize();
            return;
        }
        totalProfit += Rank.findRankByMatch(match).getPrize();
    }
}
