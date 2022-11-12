package lotto.domain;

import java.util.List;

public class Calculator {

    public static double df(List<Integer> rewardList, int money) {
        double moneys = money;
        double total = totalRewardmoney(rewardList);

        return (double) Math.round((total / moneys) * 10000) / 1000;
    }

    private static int totalRewardmoney(List<Integer> rewardList) {
        int sum = 0;
        for (int money : rewardList) {
            sum += money;
        }
        return sum;
    }

}
