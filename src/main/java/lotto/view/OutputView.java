package lotto.view;


import lotto.domain.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class OutputView {

    private final String PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String HISTORY = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_HISTORY = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    public void printPurchaseLotto(int ticketCnt) {
        System.out.println(ticketCnt + PURCHASE_COUNT);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinningHistory(Map<Prize, Integer> prizeCntMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<Prize, Integer> prizeEntry: prizeCntMap.entrySet()) {
            System.out.println(printWinningCount(prizeEntry));
        }
    }

    private static String printWinningCount(Map.Entry<Prize, Integer> prizeEntry) {
        if (prizeEntry.getKey().equals(Prize.FAIL)) {
            return "";
        }
        if (prizeEntry.getKey().equals(Prize.SECOND)) {
            return String.format(SECOND_HISTORY,
                    prizeEntry.getKey().binggoCnt(),
                    prizeEntry.getKey().reward(),
                    prizeEntry.getValue());
        }
        return String.format(HISTORY,
                prizeEntry.getKey().binggoCnt(),
                prizeEntry.getKey().reward(),
                prizeEntry.getValue());
    }


}
