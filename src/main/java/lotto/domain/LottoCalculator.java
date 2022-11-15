package lotto.domain;

import java.util.Map;

public class LottoCalculator {

    public static Money sumAllPrize(Map<LottoPrize, Integer> lottoPrizes) {
        int sum = lottoPrizes.keySet()
                .stream()
                .mapToInt(lottoPrize -> lottoPrize.getSum(lottoPrizes.get(lottoPrize)))
                .sum();
        return Money.of(sum);
    }

    public static double getProfitRate(User user, Map<LottoPrize, Integer> lottoPrizes) {
        Money reward = sumAllPrize(lottoPrizes);
        Money money = user.getMoney();

        return reward.divide(money) * 100;
    }
}
