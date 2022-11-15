package lotto.domain.result;

import lotto.domain.ingame.Lotto;
import lotto.domain.ingame.LuckyNumbers;

import java.util.LinkedHashMap;
import java.util.List;

public class Statistic {

    private final List<Lotto> userLotto;
    private final LuckyNumbers luckyNumbers;
    private final LinkedHashMap<Rank, Integer> result = new LinkedHashMap<>();
    private double profitRate;

    public Statistic(List<Lotto> userLotto, LuckyNumbers luckyNumbers,int amount){
        this.userLotto = userLotto;
        this.luckyNumbers = luckyNumbers;

        rankLotto(userLotto);
        computeProfitRate(amount);

    }

    private void rankLotto(List<Lotto> userLotto) {
        for (Lotto lotto : userLotto) {
            List<Integer> luckyBalls = luckyNumbers.getLuckyBalls();
            int bonusBall = luckyNumbers.getBonus();

            Rank rank = Rank.of(lotto.compare(luckyBalls), lotto.contains(bonusBall));
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    private void computeProfitRate(int amount) {

        long sum = 0;
        for (Rank rank : result.keySet()) {
            sum += (long) rank.getPrize() * result.get(rank);
        }

        profitRate = (double) sum / amount * 100;
    }

    public int getRankCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public double getProfitRate() {
        return profitRate;
    }

}
