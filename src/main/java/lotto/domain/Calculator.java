package lotto.domain;

import java.util.List;

public class Calculator {
    public static void calRank (List<Integer> result, List<Lotto> lottos, List<Integer> numbers, int bonus) {
        for (Lotto lotto : lottos) {
            int matchBonus = lotto.getNumbers().contains(bonus) ? 1 : 0;
            lotto.getNumbers().retainAll(numbers);
            Rank rank = Rank.findRank(lotto.getNumbers().size(), matchBonus);
            result.set(rank.getIndex(), result.get(rank.getIndex() + 1));
        }
    }

    public static float calRevenue (List<Integer> result, int amount) {
        float totalMoney = 0;

        for (int ret : result) {
            Rank rank = Rank.getRank(result.indexOf(ret));
            totalMoney += rank.getWinAmount() * ret;
        }

        return Math.round(totalMoney / amount * 100 / 100.0);
    }
}
