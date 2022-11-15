package lotto.money;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.rank.Rank;

public class Earning {

    public static Money getEarning(Map<Rank, Integer> rankMap) {
        List<Money> winningMoney = new ArrayList<>();
        for (Rank rank : rankMap.keySet()) {
            for (Integer i = 0; i < rankMap.get(rank); i++) {
                winningMoney.add(rank.getWinningMoney());
            }
        }
        return calculateEarning(winningMoney);
    }

    private static Money calculateEarning(List<Money> winningMoney) {
        int earning = 0;
        for (Money money : winningMoney) {
            earning += money.getMoney();
        }
        return new Money(earning);
    }

}
