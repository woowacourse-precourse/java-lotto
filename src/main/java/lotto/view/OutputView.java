package lotto.view;


import lotto.domain.Prize;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class OutputView {

    private static final String PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String HISTORY = "\n%d개 일치 (%s원) - %d개";
    private static final String SECOND_HISTORY = "\n%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PROFIT = "총 수익률은 %.1f%%입니다.";

    public static void printPurchaseLotto(int ticketCnt) {
        System.out.println(ticketCnt + PURCHASE_COUNT);
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinningHistory(Map<Prize, Integer> prizeCntMap) {
        System.out.println("당첨 통계");
        System.out.print("---");
        for (Map.Entry<Prize, Integer> prizeEntry: prizeCntMap.entrySet()) {
            System.out.print(printWinningCount(prizeEntry));
        }
    }

    private static String printWinningCount(Map.Entry<Prize, Integer> prizeEntry) {
        if (prizeEntry.getKey().equals(Prize.FAIL)) {
            return "";
        }
        if (prizeEntry.getKey().equals(Prize.SECOND)) {
            return String.format(SECOND_HISTORY,
                    prizeEntry.getKey().binggoCnt(),
                    commaFormatting(prizeEntry.getKey().reward()),
                    prizeEntry.getValue());
        }
        return String.format(HISTORY,
                prizeEntry.getKey().binggoCnt(),
                commaFormatting(prizeEntry.getKey().reward()),
                prizeEntry.getValue());
    }

    private static String commaFormatting(int reward) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(reward);
    }

    public static void printProfitPercent(double percent) {
        System.out.println();
        String sentence = String.format(PROFIT, percent);
        System.out.println(sentence);
    }


}
