package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.Winnings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoView {
    public static void print(List<Lotto> lottoList) {
        System.out.println();
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printResult(Result result) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("\n당첨 통계\n---");
        for (double num : Winnings.getCorrectNums()) {
            String winnings = formatter.format(Winnings.getWinnings(num));
            int winningsNum = (int) result.resultMap.get(num);
            if (num == 5.5) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", (int) num, winnings, winningsNum);
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개\n", (int) num, winnings, winningsNum);
        }
        System.out.println(String.format("총 수익률은 %.1f", result.yield) + "%입니다.");

    }
}
