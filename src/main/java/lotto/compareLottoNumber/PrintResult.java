package lotto.compareLottoNumber;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import lotto.constant.WinningAmount;

public class PrintResult {
    public String calcPrize(int[] result, int money) {
        long total = 0;

        for (int index = 0; index < 5; index++) {
            total += (long) result[index] * WinningAmount.values()[index].getValue();
        }
        return String.valueOf(Math.round((total / (money * 1000.0) * 100 * 10)) / 10.0);
    }

    public void printResult(int[] result, int money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
        BigDecimal profit = new BigDecimal(calcPrize(result, money));
        String[] fewMatch = {"3개 일치 (", "4개 일치 (", "5개 일치 (", "5개 일치, 보너스 볼 일치 (", "6개 일치 ("};

        System.out.println("당첨 통계");
        System.out.println("---");

        for (int index = 0; index < 5; index++) {
            System.out.println(fewMatch[index] + WinningAmount.values()[index].getValueString()
                    + "원) - " + result[index] + "개");
        }
        System.out.println("총 수익률은 " + decimalFormat.format(profit) + "%입니다.");
    }

}
