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
        // TODO: 수정해야 할 것 ~ 여기 메서드 내에서가 아니라 따로 map 객체 생성을 해줘야 함.
        Map<Integer, Integer> scoresCount = PrizeTable.setScoreTable();
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