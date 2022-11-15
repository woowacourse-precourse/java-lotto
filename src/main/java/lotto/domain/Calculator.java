package lotto.domain;

import java.util.List;

public class Calculator {

    public double getyield(List<Integer> rewardList, int money) {
        long total = totalRewardmoney(rewardList);

        return ((double) total / money) * 100;

    }

    private long totalRewardmoney(List<Integer> rewardList) {
        long sum = 0;
        for (int money : rewardList) {
            sum += money;
        }
        return sum;
    }

}
