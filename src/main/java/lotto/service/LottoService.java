package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class LottoService {
    private static final int SECOND_RANK_MATCH = 7;
    private static final int SECOND_THIRD_RANK_MATCH = 5;
    private static final int NOTHING_MATCH = 0;
    private static final int DEFAULT_MATCH = 1;
    private static final double DECIMAL_PLACE = 100.0f;
    private List<Lotto> lotteries = new ArrayList<>();
    private List<Integer> winnings = new ArrayList<>();
    private Map<Integer, Integer> matches = new HashMap<>();
    private int bonus;
    private double buyMoney;
    private String profitRate;
    private double totalProfit = 0;

    public LottoService() {

    }

    public LottoService(List<Lotto> lotteries, List<Integer> winnings, int bonus, double buyMoney) {
        this.lotteries = lotteries;
        this.winnings = winnings;
        this.bonus = bonus;
        this.buyMoney = buyMoney;
        createMatches();
        this.profitRate = getLottoRate();
    }

    private void createMatches() {
        for (Lotto lotto : lotteries) {
            int win = checkWinningNumber(lotto.getNumbers());
            boolean flag = false;
            flag = checkBonusMatch(win, lotto.getNumbers());
            addProfit(win, flag);
        }
    }

    private boolean checkBonusMatch(int win, List<Integer> lottoNumbers) {
        if (win == SECOND_THIRD_RANK_MATCH && checkBonusNumber(lottoNumbers)) {
            matches.put(SECOND_RANK_MATCH,
                    matches.getOrDefault(SECOND_RANK_MATCH, NOTHING_MATCH) + DEFAULT_MATCH);
            return true;
        }
        matches.put(win, matches.getOrDefault(win, NOTHING_MATCH) + DEFAULT_MATCH);
        return false;
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
        DecimalFormat RateFormat = new DecimalFormat("###,##0.0");
        return RateFormat.format((totalProfit / buyMoney) * DECIMAL_PLACE);
    }

    private void addProfit(int match, boolean flag) {
        if (match == Rank.THIRD_RANK.getMatch() && flag) {
            totalProfit += Rank.SECOND_RANK.getPrize();
            return;
        }
        totalProfit += Rank.findRankByMatch(match).getPrize();
    }

    public String getProfitRate() {
        return profitRate;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public Map<Integer, Integer> getMatches() {
        return matches;
    }
}
