package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dealer {

    private final Lotto winNumbers;
    private final Bonus bonusNumber;
    private final List<Integer> result;
    private final float earning;

    public Dealer(List<Lotto> lotteries, Lotto winNumbers, Bonus bonus) {
        result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0));
        this.winNumbers = winNumbers;
        this.bonusNumber = bonus;
        make(lotteries);
        earning = calculateEarning();
    }

    public List<Integer> getResult() {
        return result;
    }

    public float calculateEarningRate(long purchaseAmount) {
        return (float) (earning / purchaseAmount * 100.0);
    }

    private float calculateEarning() {
        long earning = 0;
        for (Ranking ranking : Ranking.values()) {
            earning += (long) result.get(ranking.value()) * ranking.prizeMoney();
        }

        return earning;
    }

    private void make(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            long matchingCount = lotto.countMatchingNumber(winNumbers);

            if (rankingIsSecond(lotto, matchingCount)) {
                increaseRankingCount(Ranking.second);
                continue;
            }
            Arrays.stream(Ranking.values()).filter(ranking -> ranking != Ranking.second)
                    .filter(ranking -> ranking.matchingCount() == matchingCount)
                            .forEach(ranking -> increaseRankingCount(ranking));
        }
    }

    private boolean rankingIsSecond(Lotto lotto, long matchingCount) {
        return Ranking.second.matchingCount() == matchingCount && lotto.contains(bonusNumber);
    }

    private void increaseRankingCount(Ranking ranking) {
        result.set(ranking.value(), result.get(ranking.value()) + 1);
    }
}
