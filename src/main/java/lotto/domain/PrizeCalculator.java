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
        this.totalPrizeAmount = LottoStatistic.INITIAL_VALUE.getValue();
        this.prizeCount = new EnumMap<>(PrizeStatistic.class);
        for (PrizeStatistic prizeType : PrizeStatistic.values()) {
            prizeCount.put(prizeType, LottoStatistic.INITIAL_VALUE.getValue());
        }
    }

    public void getResultForLotto(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchingCount = compareWinningNumbers(lotto, winningNumbers);
        boolean doesBonusMatch = false;
        if (matchingCount == PrizeStatistic.FIVE_MATCH.getMatchingNumbers()) {
            doesBonusMatch = lotto.doesContainNumber(bonusNumber);
        }
        this.totalPrizeAmount += getPrizeAmount(matchingCount, doesBonusMatch);
    }

    public int compareWinningNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = LottoStatistic.INITIAL_VALUE.getValue();
        for (int number : winningNumbers) {
            if (lotto.doesContainNumber(number)) {
                count++;
            }
        }
        return count;
    }

    public long getPrizeAmount(int numberOfMatches, boolean doesBonusMatch) {
        long prizeAmount = LottoStatistic.INITIAL_VALUE.getValue();
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
        return ((double)totalPrizeAmount / (double)initialMoney) * LottoStatistic.PROFIT_RATE_MULTIPLIER.getValue();
    }
}
