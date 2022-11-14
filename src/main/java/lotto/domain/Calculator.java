package lotto.domain;

import java.util.List;

public class Calculator {

    public String getyield(List<Integer> rewardList, int money) {
        double total = totalRewardmoney(rewardList);
        double totalReturn = (total / money) * 100;

        //return (double) Math.round(((total / (double) money) * 100) * 10) / 10.0;
        return String.format("%.1f", totalReturn);

    }

    private double totalRewardmoney(List<Integer> rewardList) {
        int sum = 0;
        for (int money : rewardList) {
            sum += money;
        }
        return sum;
    }

}
