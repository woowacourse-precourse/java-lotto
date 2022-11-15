package lotto.domain.impl;

import lotto.Lotto;
import lotto.PrizeNumber;
import lotto.Rank;
import lotto.domain.Judgment;
import lotto.domain.LottoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.Constants.COUNT_DEFAULT_VALUE;
import static lotto.Constants.RANKS;
import static lotto.Rank.*;

public class LottoServiceImpl implements LottoService {

    private final Judgment judgment = new JudgmentImpl();

    @Override
    public Map<Rank, Integer> compare(List<Lotto> issuedLottos, PrizeNumber prizeNumber) {
        Map<Rank, Integer> results = new HashMap<>();
        List<Integer> prizeNumbers = prizeNumber.getNumbers();
        int bonusNumber = prizeNumber.getBonusNumber();

        for (Lotto userLotto : issuedLottos) {
            List<Integer> userNumbers = userLotto.getNumbers();
            int count = checkPrizeNumber(userNumbers, prizeNumbers);
            boolean hasBonusNumber = checkBonusNumber(userNumbers, bonusNumber);
            updateResults(results, count, hasBonusNumber);
        }

        return results;
    }

    private int checkPrizeNumber(List<Integer> userNumbers, List<Integer> prizeNumbers) {
        return judgment.correctCount(userNumbers, prizeNumbers);
    }

    private boolean checkBonusNumber(List<Integer> userNumbers, int bonusNumber) {
        return judgment.hasBonusNumber(userNumbers, bonusNumber);
    }

    private boolean isRankSecond(int count, boolean hasBonusNumber) {
        return count == 5 && hasBonusNumber;
    }

    private void updateResults(Map<Rank, Integer> results, int count, boolean hasBonusNumber) {
        Rank rank = getRank(count, hasBonusNumber);
        if (isNotNull(rank)) {
            int resultCount = results.getOrDefault(rank, COUNT_DEFAULT_VALUE);
            results.put(rank, resultCount + 1);
        }
    }

    private Rank getRank(int count, boolean hasBonusNumber) {
        if (isRankSecond(count, hasBonusNumber)) {
            return SECOND;
        }
        return RANKS.get(count);
    }

    private boolean isNotNull(Rank rank) {
        return rank != null;
    }

    @Override
    public double calculateRate(Map<Rank, Integer> results, int amount) {
        double totalPrize = getTotalPrize(results);
        return (totalPrize / amount) * 100;
    }

    private double getTotalPrize(Map<Rank, Integer> results) {
        double totalPrize = 0;
        for (Rank rank : results.keySet()) {
            int count = results.get(rank);
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }
}
