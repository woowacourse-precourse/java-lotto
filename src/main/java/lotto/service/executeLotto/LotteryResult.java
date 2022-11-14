package lotto.service.executeLotto;

import lotto.DataTable.PrizeTable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LotteryResult {
    private final List<List<Integer>> userLotteries;
    private final List<Integer> winningNumbers;

    public LotteryResult(List<List<Integer>> userLotteries, List<Integer> winningNumbers) {
        this.userLotteries = userLotteries;
        this.winningNumbers = winningNumbers;
    }

    private static final int BONUS_SCORE_INDEX = 0;

    public Map<Integer, Integer> getScores(int bonusNumber) {
        Map<Integer, Integer> scoresCount = initScoreCount();
        userLotteries.forEach(lotteryTicket -> {
            int count = countSameNumber(lotteryTicket);

            if (count == 5 && hasBonusNumber(lotteryTicket, bonusNumber)) {
                scoresCount.put(BONUS_SCORE_INDEX, scoresCount.get(BONUS_SCORE_INDEX) + 1);
            }
            if (count > 2 && !hasBonusNumber(lotteryTicket, bonusNumber)) {
                scoresCount.put(count, scoresCount.get(count) + 1);
            }
        });
        return scoresCount;
    }

    public double getYield(Map<Integer, Integer> scores) {
        double totalPrize = totalPrize(scores);
        double yield = totalPrize / (userLotteries.size());
        return Math.round(yield * 10) / 100.0;
    }

    private Map<Integer, Integer> initScoreCount() {
        return PrizeTable.setScoreTable();
    }

    private int totalPrize(Map<Integer, Integer> scores) {
        AtomicInteger sum = new AtomicInteger();
        scores.forEach((key, value) -> {
            int prize = value * PrizeTable.valueOfPrize(key);
            sum.addAndGet(prize);
        });
        return sum.get();
    }


    private int countSameNumber(List<Integer> lotteryTicket) {
        return (int) lotteryTicket.stream().filter(winningNumbers::contains).count();
    }

    private boolean hasBonusNumber(List<Integer> lotteryTicket, int bonusNumber) {
        return lotteryTicket.contains(bonusNumber);
    }
}