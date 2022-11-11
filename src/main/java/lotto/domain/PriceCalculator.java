package lotto.domain;

import java.util.Map;

public class PriceCalculator {

    public static float getyield(Map<Rank, Integer> winStatus, int purchaseMoney) {
        int totalPrice = 0;

        for (Rank rank : winStatus.keySet()) {
            int prizemoney = rank.getPrizemoney();
            int count = winStatus.getOrDefault(rank, 0);

            totalPrice += prizemoney * count;
        }

        return (float) totalPrice / (float) purchaseMoney * 100;
    }
}
