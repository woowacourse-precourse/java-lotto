package lotto.domain;

import java.util.List;

public class Calculator {
    public static void calRank (List<Integer> result, List<Lotto> lottos, List<Integer> numbers, int bonus) {
        for (Lotto lotto : lottos) {
            lotto.getNumbers().retainAll(numbers);
            Rank rank = Rank.findRank(lotto.getNumbers().size(), lotto.getNumbers().contains(bonus));
            if (rank != null)
                result.set(rank.getIndex(), result.get(rank.getIndex()) + 1);
        }
    }

    public static double calRevenue (List<Integer> result, int amount) {
        double revenue = 0;

        for (int i = 0; i < result.size(); i++) {
            Rank rank = Rank.getRank(i);
            revenue += rank.getWinAmount() * result.get(i);
        }

        return Math.round(revenue / amount * 1000) / 10.0;
    }
}
