package lotto.domain;

import java.util.List;

public class Calculator {

    public double df(List<Integer> rewardList, int money) {
        double moneys = money;
        double total = totalRewardmoney(rewardList);

        return (double) Math.round(((total / moneys) * 100) * 10) / 10.0;
    }

    private int totalRewardmoney(List<Integer> rewardList) {
        int sum = 0;
        for (int money : rewardList) {
            sum += money;
        }
        return sum;
    }

}
