package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int PERCENT = 100;

    public static String getEarningRate(List<Integer> result) {
        if (!validateSize(result)) {
            System.out.println("[ERROR] 잘못된 결과가 전달됐습니다. ");
            throw new IllegalArgumentException();
        }

        try {
            double numberOfLotto = result.stream().mapToInt(Integer::intValue).sum();
            return String.format("%.1f", new BigDecimal(getWinningAmount(result) * PERCENT / numberOfLotto / PRICE_PER_LOTTO));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("[ERROR] 잘못된 결과가 전달됐습니다. ");
            throw new IllegalArgumentException();
        }
    }

    private static double getWinningAmount(List<Integer> result) {
        double winningAmount = 0;
        for (int place = 1; place <= 6; place++) {
            winningAmount += result.get(place) * MoneyUnit.getUnit(place);
        }
        return winningAmount;
    }

    private static boolean validateSize(List<Integer> result) {
        return result.size() == 7;
    }

}
