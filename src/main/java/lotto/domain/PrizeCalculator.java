package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.constant.GameMessage;
import lotto.constant.LottoStatistic;
import lotto.constant.PrizeStatistic;
import lotto.userinterface.Output;

public class PrizeCalculator {
    private long totalPrizeAmount;
    private final Map<PrizeStatistic, Integer> prizeCount;

    public PrizeCalculator() {
        this.totalPrizeAmount = 0;
        this.prizeCount = new EnumMap<>(PrizeStatistic.class);
        for (PrizeStatistic prizeType : PrizeStatistic.values()) {
            prizeCount.put(prizeType, 0);
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
        for (PrizeStatistic prizeType : PrizeStatistic.values()) {
            if (prizeType.getMatchingNumbers() == numberOfMatches && prizeType.geBonus() == doesBonusMatch){
                recordPrizeResult(prizeType);
                prizeAmount = prizeType.getPrizeAmount();
                return prizeAmount;
            }
        }
        return prizeAmount;
    }

    private void recordPrizeResult(PrizeStatistic prizeType) {
        prizeCount.merge(prizeType, 1, Integer::sum);
    }

    public void printPrizeResult() {
        Output.printMessage(GameMessage.RESULT_HEADER.getMessage());
        for (Map.Entry<PrizeStatistic, Integer> prizeEntry : prizeCount.entrySet()) {
            PrizeStatistic prizeType = prizeEntry.getKey();
            int count = prizeEntry.getValue();
            Output.printMessage(GameMessage.RESULT_BODY.getMessage(prizeType, count));
        }
    }

    public double calculateProfitRate(long initialMoney) {
        return ((double)totalPrizeAmount / (double)initialMoney) * 100;
    }
}
