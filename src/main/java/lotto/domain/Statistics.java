package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    int num[][] = new int[5][1];
    public void printStatistics(List<Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        findFinalNum(result);

        List<String> winningMoney  = List.of(" (5,000원) ", " (50,000원) ", " (1,500,000원) ", " (30,000,000원) ", " (2,000,000,000원) ");
        for (int i = 0; i < num.length; i++) {
            if (i < 3) {
                System.out.println(i + 3 + "개 일치" + winningMoney.get(i) + "- " + num[i][0] + "개");
            }
            if (i == 3) {
                System.out.println("5개 일치, 보너스 볼 일치" + winningMoney.get(i) + "- " + num[i][0] + "개");
            }
            if (i == 4) {
                System.out.println("6개 일치" + winningMoney.get(i) + "- " + num[i][0] + "개");
            }
        }
    }

    private void findFinalNum(List<Integer> result) {
        for (Integer integer : result) {
            if (integer == 51) {
                num[3][0]++;
            }
            if (integer >= 3 && integer < 6) {
                num[integer-3][0]++;
            }
            if (integer == 6) {
                num[4][0]++;
            }
        }
    }

    public long findProfit() {
        long sum = 0;
        List<Integer> money = List.of(5, 50, 1500, 30000, 2000000);
        for (int i = 0; i < num.length; i++) {
            if (num[i][0] > 0) {
                sum += money.get(i) * 1000;
            }
        }
        return sum;
    }
}
