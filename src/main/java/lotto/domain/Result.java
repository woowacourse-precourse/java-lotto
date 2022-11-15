package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.utils.LottoInfo;
import lotto.utils.Winning;

public class Result {
    private final String FIRST = Winning.FIRST.getLabel();
    private final String SECOND = Winning.SECOND.getLabel();
    private final String THIRD = Winning.THIRD.getLabel();
    private final String FOURTH = Winning.FOURTH.getLabel();
    private final String FIFTH = Winning.FIFTH.getLabel();
    List<List<Integer>> purchasedLotteries;
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>() {
        {
            put(FIFTH, 0);
            put(FOURTH, 0);
            put(THIRD, 0);
            put(SECOND, 0);
            put(FIRST, 0);
        }
    };

    public Result(List<List<Integer>> purchasedLotteries,
                  WinningNumbers winningNumbers,
                  BonusNumber bonusNumber) {
        this.purchasedLotteries = purchasedLotteries;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }

    public void countWinningCase() {
        for (List<Integer> purchasedLotto : purchasedLotteries) {
            int winningCount = winningNumbers.countWinning(purchasedLotto);
            countResultByCount(winningCount);
            countSecondOrThird(winningCount, purchasedLotto);
        }
    }

    public String getProfitRate() {
        int totalWinningPrize = getTotalWinningPrize();
        int purchasePrice = purchasedLotteries.size() * LottoInfo.PRICE.getNumber();
        double profitRate = (double) totalWinningPrize / purchasePrice;
        return String.format("%,.1f", profitRate * 100) + "%";
    }

    private int getTotalWinningPrize() {
        return resultMap.keySet().stream()
                .map(key -> Winning.getPrizeByLabel(key) * resultMap.get(key))
                .reduce(0, Integer::sum);
    }

    private void countResultByCount(int winningCount) {
        if (winningCount == 6) {
            resultMap.put(FIRST, resultMap.get(FIRST) + 1);
        }
        if (winningCount == 4) {
            resultMap.put(FOURTH, resultMap.get(FOURTH) + 1);
        }
        if (winningCount == 3) {
            resultMap.put(FIFTH, resultMap.get(FIFTH) + 1);
        }
    }

    private void countSecondOrThird(int winningCount, List<Integer> purchasedLotto) {
        if (winningCount != 5) {
            return;
        }

        if (isSecond(purchasedLotto)) {
            resultMap.put(SECOND, resultMap.get(SECOND) + 1);
            return;
        }

        resultMap.put(THIRD, resultMap.get(THIRD) + 1);
    }

    private boolean isSecond(List<Integer> purchasedLotto) {
        return bonusNumber.checkContainBonusNumber(purchasedLotto);
    }
}