package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Dealer {
    private final Generator generator;
    private final List<Integer> result;
    private final float earningRate;

    public Dealer(Map<Lotto, Bonus> lotteries, int purchaseAmount) {
        result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0));
        generator = new Generator();
        make(lotteries);
        earningRate = calculateEarningRate(purchaseAmount);
    }

    public List<Integer> getResult() {
        return result;
    }

    public float getEarningRate() {
        return earningRate;
    }

    private float calculateEarningRate(int purchaseAmount) {
        long earning = 0;
        for (Ranking ranking: Ranking.values()) {
            earning += (long)result.get(ranking.value()) * ranking.prizeMoney();
        }

        return (float)earning / purchaseAmount * 100;
    }

    private void make(Map<Lotto, Bonus> lotteries) {
        List<Integer> winNumber = generator.getWinNumber();

        for (Lotto lotto: lotteries.keySet()) {
            int bonusNumber = lotteries.get(lotto).getBonusNumber();
            int matchingCount = (int)lotto.getNumbers().stream().filter(i -> winNumber.contains(i)).count();

            if (rankingIsSecond(bonusNumber, matchingCount)) {
                increaseRankingCount(Ranking.second);
                continue;
            }
            Arrays.stream(Ranking.values()).filter(ranking -> ranking != Ranking.second)
                    .filter(ranking -> ranking.matchingCount() == matchingCount)
                            .forEach(ranking -> increaseRankingCount(ranking));
        }
    }

    private boolean rankingIsSecond(int bonusNumber, int matchingCount) {
        return Ranking.second.matchingCount() == matchingCount && generator.getWinNumber().contains(bonusNumber);
    }

    private void increaseRankingCount(Ranking ranking) {
        result.set(ranking.value(), result.get(ranking.value()) + 1);
    }


}
