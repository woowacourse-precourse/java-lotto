package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoView {
    public static void print(List<Lotto> lottoList) {
        System.out.println();
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Result result) {
        Map winnings = new HashMap<Double, Integer>();
        double[] correctNums = {3, 4, 5, 5.5, 6};
        int[] cash = {5000, 50000, 1500000, 30000000, 2000000000};
        for (int i = 0; i < correctNums.length; i++) {
            winnings.put(correctNums[i], cash[i]);
        }
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println();
        System.out.println("당첨 통계\n---");
        for (double num : correctNums) {
            if (num == 5.5) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", (int) num, formatter.format(winnings.get(num)), result.resultMap.get(num));
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개\n", (int) num, formatter.format(winnings.get(num)), result.resultMap.get(num));
        }
        System.out.println(String.format("총 수익률은 %.1f", result.yield) + "%입니다.");

    }
}
