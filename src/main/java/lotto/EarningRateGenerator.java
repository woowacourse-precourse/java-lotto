package lotto;

import java.util.List;

public class EarningRateGenerator {
    public static int printEarningRate(List<Integer> resultNumber) {
        int[] correctMoney = {0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000};

        int totalEarningMoney = 0;
        for(int i=0; i<resultNumber.size(); i++) {
            int add = correctMoney[resultNumber.get(i)];
            totalEarningMoney += add;
        }
        return totalEarningMoney;
    }
}
