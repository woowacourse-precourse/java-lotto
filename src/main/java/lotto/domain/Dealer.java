package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dealer {

    private final List<Integer> winNumbers;
    private final int bonusNumber;
    private final List<Integer> result;
    private final float earningRate;

    public Dealer(Publisher publisher, Lotto winNumbers, int bonusNumber) {
        result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0));
        this.winNumbers = winNumbers.getNumbers();
        this.bonusNumber = bonusNumber;
        make(publisher.getLotteries());
        earningRate = calculateEarningRate(publisher.getPurchaseAmount());
    }

    public List<Integer> getResult() {
        return result;
    }

    public float getEarningRate() {
        return earningRate;
    }

    private float calculateEarningRate(int purchaseAmount) {
        long earning = 0;
        for (Ranking ranking : Ranking.values()) {
            earning += (long) result.get(ranking.value()) * ranking.prizeMoney();
        }

        return (float) earning / purchaseAmount * 100;
    }

    private void make(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            int matchingCount = (int) lotto.getNumbers().stream()
                    .filter(i -> winNumbers.contains(i))
                            .count();

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
        return Ranking.second.matchingCount() == matchingCount && winNumbers.contains(bonusNumber);
    }

    private void increaseRankingCount(Ranking ranking) {
        result.set(ranking.value(), result.get(ranking.value()) + 1);
    }
}
