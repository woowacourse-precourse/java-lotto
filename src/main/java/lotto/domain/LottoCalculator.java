package lotto.domain;

import java.util.List;

public class LottoCalculator {

    public static Money sumAllPrize(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream()
                .map(LottoPrize::getReward)
                .reduce(Integer::sum)
                .map(Money::of)
                .orElse(Money.empty());
    }

    public static double getProfitRate(User user, List<LottoPrize> lottoPrizes) {
        Money reward = sumAllPrize(lottoPrizes);
        Money money = user.getMoney();

        return reward.divide(money);
    }
}
