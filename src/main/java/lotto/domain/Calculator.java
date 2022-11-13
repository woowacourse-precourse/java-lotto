package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static List<Integer> digit = Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000);

    private static Integer getWinningAmount(List<Integer> results) {
        int winningAmount = 0;
        for(int i=0; i<digit.size(); i++) {
            winningAmount += results.get(i) * digit.get(i);
        }
        return winningAmount;
    }

    public static double getEarningRate(List<Integer> results) {
        return Math.round(getWinningAmount(results) / results.size() * 10) / 10.0;
    }
}
