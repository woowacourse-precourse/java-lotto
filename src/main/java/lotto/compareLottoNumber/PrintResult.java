package lotto.compareLottoNumber;

import lotto.constant.WinningAmount;

public class PrintResult {
    public long calcPrize(int[] result, int money) {
        long total = 0L;

        for (int index = 0; index < 5; index++) {
            total += (long) result[index] * WinningAmount.values()[index].getValue();
        }
        return (total / (money * 1000L)) * 100;
    }

    public void printResult(int[] result, int money) {
        long profit = calcPrize(result, money);
        String[] fewMatch = {"3개 일치 (", "4개 일치 (", "5개 일치 (", "5개 일치, 보너스 볼 일치 (", "6개 일치 ("};

        System.out.println("당첨 통계");
        System.out.println("---");

        for (int index = 0; index < 5; index++) {
            System.out.println(fewMatch[index] + WinningAmount.values()[index].getValueString()
                    + "원) - " + result[index] + "개");
        }

        System.out.println("총 수익률은 " + profit + "%입니다.");

    }

}
