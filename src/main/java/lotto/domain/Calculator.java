package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int PERCENT = 100;

    private static List<Integer> digit = Arrays.asList(0, 5000, 50000, 1500000, 30000000, 2000000000);

    private static long getWinningAmount(List<Integer> results) {
        long winningAmount = 0;
        for (int i = 0; i < digit.size(); i++) {
            winningAmount += results.get(i) * digit.get(i);
        }
        return winningAmount;
    }

    public static double getEarningRate(List<Integer> result) {
        try {
            int numberOfLotto = result.stream().mapToInt(Integer::intValue).sum();
            return Math.round(getWinningAmount(result) / numberOfLotto / PRICE_PER_LOTTO * PERCENT * 10) / 10.0;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("[ERROR] 잘못된 결과가 전달됐습니다. ");
        }
    }

}
