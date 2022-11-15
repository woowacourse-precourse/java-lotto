package lotto.compareLottoNumber;

import lotto.constant.WinningAmount;

public class PrintResult {
    public float calcPrize(int[] result, int money) {
        float total = 0;

        for (int index = 0; index < 5; index++) {
            total += result[index] * WinningAmount.values()[index].getValue();
        }
        return (total / (money * 1_000)) * 100;
    }

    public void printResult(int[] result, int money) {
        float profit = calcPrize(result, money);
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
