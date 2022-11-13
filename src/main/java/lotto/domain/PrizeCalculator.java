package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.constant.LottoStatistic;
import lotto.constant.PrizeStatistic;

public class PrizeCalculator {
    private long totalPrizeAmount;
    private Map<PrizeStatistic, Integer> prizeCount;

    public PrizeCalculator() {
        this.totalPrizeAmount = 0;
        this.prizeCount = new EnumMap<>(PrizeStatistic.class);
        for (PrizeStatistic prize : PrizeStatistic.values()) {
            prizeCount.put(prize, 0);
        }
    }

    public void getResultForLotto(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchingCount = compareWinningNumbers(lotto, winningNumbers);
        boolean doesBonusMatch = false;
        if (matchingCount == LottoStatistic.NUMBER_OF_LOTTERY_NUMBERS.getValue() - 1) {
            doesBonusMatch = lotto.doesContainNumber(bonusNumber);
        }
        this.totalPrizeAmount += getPrizeAmount(matchingCount, doesBonusMatch);
    }

    public int compareWinningNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : winningNumbers) {
            if (lotto.doesContainNumber(number)) {
                count++;
            }
        }
        return count;
    }

    public long getPrizeAmount(int numberOfMatches, boolean doesBonusMatch) {
        long prizeAmount = 0;
        for (PrizeStatistic prize : PrizeStatistic.values()) {
            if (prize.getMatchingNumbers() == numberOfMatches && prize.geBonus() == doesBonusMatch){
                prizeCount.merge(prize, 1, Integer::sum);
                prizeAmount = prize.getPrizeAmount();
                return prizeAmount;
            }
        }
        return prizeAmount;
    }

    /*public void printPrizeResult() {

    }*/
}
