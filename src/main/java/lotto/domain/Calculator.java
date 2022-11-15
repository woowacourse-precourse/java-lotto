package lotto.domain;

import java.util.List;

public class Calculator {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int PERCENT = 100;
    private static final int ROUND_TO_ONE_DECIMAL = 10;
    private static final double ROUND_TO_ONE_DOUBLE = 10.0;

    public static double getEarningRate(List<Integer> result) {
        try {
            double numberOfLotto = result.stream().mapToInt(Integer::intValue).sum();
            return Math.round(getWinningAmount(result) * PERCENT * ROUND_TO_ONE_DECIMAL / numberOfLotto / PRICE_PER_LOTTO) / ROUND_TO_ONE_DOUBLE;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("[ERROR] 잘못된 결과가 전달됐습니다. ");
        }
    }

    private static double getWinningAmount(List<Integer> results) {
        double winningAmount = 0;
        for (int place = 1; place <= 6; place++) {
            winningAmount += results.get(place) * MoneyUnit.getUnit(place);
        }
        return winningAmount;
    }

}
